package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.ImageResolver;
import com.badlogic.gdx.maps.ImageResolver.AssetManagerImageResolver;
import com.badlogic.gdx.maps.ImageResolver.DirectImageResolver;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.io.IOException;
import java.util.Iterator;

public class TmxMapLoader extends BaseTmxMapLoader<Parameters> {

    public static class Parameters extends com.badlogic.gdx.maps.tiled.BaseTmxMapLoader.Parameters {
    }

    public TmxMapLoader() {
        super(new InternalFileHandleResolver());
    }

    public TmxMapLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    public TiledMap load(String fileName) {
        return load(fileName, new Parameters());
    }

    public TiledMap load(String fileName, Parameters parameters) {
        try {
            this.convertObjectToTileSpace = parameters.convertObjectToTileSpace;
            FileHandle tmxFile = resolve(fileName);
            this.root = this.xml.parse(tmxFile);
            ObjectMap<String, Texture> textures = new ObjectMap();
            Iterator i$ = loadTilesets(this.root, tmxFile).iterator();
            while (i$.hasNext()) {
                FileHandle textureFile = (FileHandle) i$.next();
                Texture texture = new Texture(textureFile, parameters.generateMipMaps);
                texture.setFilter(parameters.textureMinFilter, parameters.textureMagFilter);
                textures.put(textureFile.path(), texture);
            }
            TiledMap map = loadTilemap(this.root, tmxFile, new DirectImageResolver(textures));
            map.setOwnedResources(textures.values().toArray());
            return map;
        } catch (IOException e) {
            throw new GdxRuntimeException("Couldn't load tilemap '" + fileName + "'", e);
        }
    }

    public void loadAsync(AssetManager manager, String fileName, FileHandle tmxFile, Parameters parameter) {
        this.map = null;
        if (parameter != null) {
            this.convertObjectToTileSpace = parameter.convertObjectToTileSpace;
        } else {
            this.convertObjectToTileSpace = false;
        }
        try {
            this.map = loadTilemap(this.root, tmxFile, new AssetManagerImageResolver(manager));
        } catch (Exception e) {
            throw new GdxRuntimeException("Couldn't load tilemap '" + fileName + "'", e);
        }
    }

    public TiledMap loadSync(AssetManager manager, String fileName, FileHandle file, Parameters parameter) {
        return this.map;
    }

    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle tmxFile, Parameters parameter) {
        Array<AssetDescriptor> dependencies = new Array();
        try {
            this.root = this.xml.parse(tmxFile);
            boolean generateMipMaps = parameter != null ? parameter.generateMipMaps : false;
            AssetLoaderParameters texParams = new TextureParameter();
            texParams.genMipMaps = generateMipMaps;
            if (parameter != null) {
                texParams.minFilter = parameter.textureMinFilter;
                texParams.magFilter = parameter.textureMagFilter;
            }
            Iterator i$ = loadTilesets(this.root, tmxFile).iterator();
            while (i$.hasNext()) {
                dependencies.add(new AssetDescriptor((FileHandle) i$.next(), Texture.class, texParams));
            }
            return dependencies;
        } catch (IOException e) {
            throw new GdxRuntimeException("Couldn't load tilemap '" + fileName + "'", e);
        }
    }

    protected TiledMap loadTilemap(Element root, FileHandle tmxFile, ImageResolver imageResolver) {
        TiledMap map = new TiledMap();
        String mapOrientation = root.getAttribute("orientation", null);
        int mapWidth = root.getIntAttribute("width", 0);
        int mapHeight = root.getIntAttribute("height", 0);
        int tileWidth = root.getIntAttribute("tilewidth", 0);
        int tileHeight = root.getIntAttribute("tileheight", 0);
        String mapBackgroundColor = root.getAttribute("backgroundcolor", null);
        MapProperties mapProperties = map.getProperties();
        if (mapOrientation != null) {
            mapProperties.put("orientation", mapOrientation);
        }
        mapProperties.put("width", Integer.valueOf(mapWidth));
        mapProperties.put("height", Integer.valueOf(mapHeight));
        mapProperties.put("tilewidth", Integer.valueOf(tileWidth));
        mapProperties.put("tileheight", Integer.valueOf(tileHeight));
        if (mapBackgroundColor != null) {
            mapProperties.put("backgroundcolor", mapBackgroundColor);
        }
        this.mapTileWidth = tileWidth;
        this.mapTileHeight = tileHeight;
        this.mapWidthInPixels = mapWidth * tileWidth;
        this.mapHeightInPixels = mapHeight * tileHeight;
        Element properties = root.getChildByName("properties");
        if (properties != null) {
            loadProperties(map.getProperties(), properties);
        }
        Iterator i$ = root.getChildrenByName("tileset").iterator();
        while (i$.hasNext()) {
            Element element = (Element) i$.next();
            loadTileSet(map, element, tmxFile, imageResolver);
            root.removeChild(element);
        }
        int j = root.getChildCount();
        for (int i = 0; i < j; i++) {
            element = root.getChild(i);
            String name = element.getName();
            if (name.equals("layer")) {
                loadTileLayer(map, element);
            } else if (name.equals("objectgroup")) {
                loadObjectGroup(map, element);
            }
        }
        return map;
    }

    protected Array<FileHandle> loadTilesets(Element root, FileHandle tmxFile) throws IOException {
        Array<FileHandle> images = new Array();
        Iterator it = root.getChildrenByName("tileset").iterator();
        while (it.hasNext()) {
            Element tileset = (Element) it.next();
            String source = tileset.getAttribute("source", null);
            Iterator i$;
            if (source != null) {
                FileHandle tsxFile = BaseTmxMapLoader.getRelativeFileHandle(tmxFile, source);
                tileset = this.xml.parse(tsxFile);
                if (tileset.getChildByName("image") != null) {
                    images.add(BaseTmxMapLoader.getRelativeFileHandle(tsxFile, tileset.getChildByName("image").getAttribute("source")));
                } else {
                    i$ = tileset.getChildrenByName("tile").iterator();
                    while (i$.hasNext()) {
                        images.add(BaseTmxMapLoader.getRelativeFileHandle(tsxFile, ((Element) i$.next()).getChildByName("image").getAttribute("source")));
                    }
                }
            } else if (tileset.getChildByName("image") != null) {
                images.add(BaseTmxMapLoader.getRelativeFileHandle(tmxFile, tileset.getChildByName("image").getAttribute("source")));
            } else {
                i$ = tileset.getChildrenByName("tile").iterator();
                while (i$.hasNext()) {
                    images.add(BaseTmxMapLoader.getRelativeFileHandle(tmxFile, ((Element) i$.next()).getChildByName("image").getAttribute("source")));
                }
            }
        }
        return images;
    }

    protected void loadTileSet(TiledMap map, Element element, FileHandle tmxFile, ImageResolver imageResolver) {
        if (element.getName().equals("tileset")) {
            Element imageElement;
            Iterator i$;
            Element tileElement;
            Element properties;
            String name = element.get("name", null);
            int firstgid = element.getIntAttribute("firstgid", 1);
            int tilewidth = element.getIntAttribute("tilewidth", 0);
            int tileheight = element.getIntAttribute("tileheight", 0);
            int spacing = element.getIntAttribute("spacing", 0);
            int margin = element.getIntAttribute("margin", 0);
            String source = element.getAttribute("source", null);
            int offsetX = 0;
            int offsetY = 0;
            String imageSource = "";
            int imageWidth = 0;
            int imageHeight = 0;
            FileHandle image = null;
            Element offset;
            if (source != null) {
                FileHandle tsx = BaseTmxMapLoader.getRelativeFileHandle(tmxFile, source);
                try {
                    element = this.xml.parse(tsx);
                    name = element.get("name", null);
                    tilewidth = element.getIntAttribute("tilewidth", 0);
                    tileheight = element.getIntAttribute("tileheight", 0);
                    spacing = element.getIntAttribute("spacing", 0);
                    margin = element.getIntAttribute("margin", 0);
                    offset = element.getChildByName("tileoffset");
                    if (offset != null) {
                        offsetX = offset.getIntAttribute("x", 0);
                        offsetY = offset.getIntAttribute("y", 0);
                    }
                    imageElement = element.getChildByName("image");
                    if (imageElement != null) {
                        imageSource = imageElement.getAttribute("source");
                        imageWidth = imageElement.getIntAttribute("width", 0);
                        imageHeight = imageElement.getIntAttribute("height", 0);
                        image = BaseTmxMapLoader.getRelativeFileHandle(tsx, imageSource);
                    }
                } catch (IOException e) {
                    throw new GdxRuntimeException("Error parsing external tileset.");
                }
            }
            offset = element.getChildByName("tileoffset");
            if (offset != null) {
                offsetX = offset.getIntAttribute("x", 0);
                offsetY = offset.getIntAttribute("y", 0);
            }
            imageElement = element.getChildByName("image");
            if (imageElement != null) {
                imageSource = imageElement.getAttribute("source");
                imageWidth = imageElement.getIntAttribute("width", 0);
                imageHeight = imageElement.getIntAttribute("height", 0);
                image = BaseTmxMapLoader.getRelativeFileHandle(tmxFile, imageSource);
            }
            TiledMapTileSet tileset = new TiledMapTileSet();
            tileset.setName(name);
            tileset.getProperties().put("firstgid", Integer.valueOf(firstgid));
            TiledMapTile staticTiledMapTile;
            if (image != null) {
                TextureRegion texture = imageResolver.getImage(image.path());
                MapProperties props = tileset.getProperties();
                props.put("imagesource", imageSource);
                props.put("imagewidth", Integer.valueOf(imageWidth));
                props.put("imageheight", Integer.valueOf(imageHeight));
                props.put("tilewidth", Integer.valueOf(tilewidth));
                props.put("tileheight", Integer.valueOf(tileheight));
                props.put("margin", Integer.valueOf(margin));
                props.put("spacing", Integer.valueOf(spacing));
                int stopWidth = texture.getRegionWidth() - tilewidth;
                int stopHeight = texture.getRegionHeight() - tileheight;
                int id = firstgid;
                int y = margin;
                while (y <= stopHeight) {
                    int x = margin;
                    int id2 = id;
                    while (x <= stopWidth) {
                        staticTiledMapTile = new StaticTiledMapTile(new TextureRegion(texture, x, y, tilewidth, tileheight));
                        staticTiledMapTile.setId(id2);
                        staticTiledMapTile.setOffsetX((float) offsetX);
                        staticTiledMapTile.setOffsetY((float) (-offsetY));
                        id = id2 + 1;
                        tileset.putTile(id2, staticTiledMapTile);
                        x += tilewidth + spacing;
                        id2 = id;
                    }
                    y += tileheight + spacing;
                    id = id2;
                }
            } else {
                i$ = element.getChildrenByName("tile").iterator();
                while (i$.hasNext()) {
                    tileElement = (Element) i$.next();
                    imageElement = tileElement.getChildByName("image");
                    if (imageElement != null) {
                        imageSource = imageElement.getAttribute("source");
                        imageWidth = imageElement.getIntAttribute("width", 0);
                        imageHeight = imageElement.getIntAttribute("height", 0);
                        image = BaseTmxMapLoader.getRelativeFileHandle(tmxFile, imageSource);
                    }
                    staticTiledMapTile = new StaticTiledMapTile(imageResolver.getImage(image.path()));
                    staticTiledMapTile.setId(tileElement.getIntAttribute("id") + firstgid);
                    staticTiledMapTile.setOffsetX((float) offsetX);
                    staticTiledMapTile.setOffsetY((float) (-offsetY));
                    tileset.putTile(staticTiledMapTile.getId(), staticTiledMapTile);
                }
            }
            Array<Element> tileElements = element.getChildrenByName("tile");
            Array<AnimatedTiledMapTile> animatedTiles = new Array();
            i$ = tileElements.iterator();
            while (i$.hasNext()) {
                tileElement = (Element) i$.next();
                TiledMapTile tile = tileset.getTile(firstgid + tileElement.getIntAttribute("id", 0));
                if (tile != null) {
                    Element animationElement = tileElement.getChildByName("animation");
                    if (animationElement != null) {
                        Array<StaticTiledMapTile> staticTiles = new Array();
                        IntArray intervals = new IntArray();
                        Iterator i$2 = animationElement.getChildrenByName("frame").iterator();
                        while (i$2.hasNext()) {
                            Element frameElement = (Element) i$2.next();
                            staticTiles.add((StaticTiledMapTile) tileset.getTile(frameElement.getIntAttribute("tileid") + firstgid));
                            intervals.add(frameElement.getIntAttribute("duration"));
                        }
                        AnimatedTiledMapTile animatedTile = new AnimatedTiledMapTile(intervals, (Array) staticTiles);
                        animatedTile.setId(tile.getId());
                        animatedTiles.add(animatedTile);
                        tile = animatedTile;
                    }
                    String terrain = tileElement.getAttribute("terrain", null);
                    if (terrain != null) {
                        tile.getProperties().put("terrain", terrain);
                    }
                    String probability = tileElement.getAttribute("probability", null);
                    if (probability != null) {
                        tile.getProperties().put("probability", probability);
                    }
                    properties = tileElement.getChildByName("properties");
                    if (properties != null) {
                        loadProperties(tile.getProperties(), properties);
                    }
                }
            }
            i$ = animatedTiles.iterator();
            while (i$.hasNext()) {
                AnimatedTiledMapTile tile2 = (AnimatedTiledMapTile) i$.next();
                tileset.putTile(tile2.getId(), tile2);
            }
            properties = element.getChildByName("properties");
            if (properties != null) {
                loadProperties(tileset.getProperties(), properties);
            }
            map.getTileSets().addTileSet(tileset);
        }
    }
}
