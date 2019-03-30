package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

public abstract class BaseTmxMapLoader<P extends AssetLoaderParameters<TiledMap>> extends AsynchronousAssetLoader<TiledMap, P> {
    protected static final int FLAG_FLIP_DIAGONALLY = 536870912;
    protected static final int FLAG_FLIP_HORIZONTALLY = Integer.MIN_VALUE;
    protected static final int FLAG_FLIP_VERTICALLY = 1073741824;
    protected static final int MASK_CLEAR = -536870912;
    protected boolean convertObjectToTileSpace;
    protected TiledMap map;
    protected int mapHeightInPixels;
    protected int mapTileHeight;
    protected int mapTileWidth;
    protected int mapWidthInPixels;
    protected Element root;
    protected XmlReader xml = new XmlReader();

    public static class Parameters extends AssetLoaderParameters<TiledMap> {
        public boolean convertObjectToTileSpace = false;
        public boolean generateMipMaps = false;
        public TextureFilter textureMagFilter = TextureFilter.Nearest;
        public TextureFilter textureMinFilter = TextureFilter.Nearest;
    }

    public BaseTmxMapLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    protected void loadTileLayer(TiledMap map, Element element) {
        if (element.getName().equals("layer")) {
            String name = element.getAttribute("name", null);
            int width = element.getIntAttribute("width", 0);
            int height = element.getIntAttribute("height", 0);
            int tileWidth = element.getParent().getIntAttribute("tilewidth", 0);
            int tileHeight = element.getParent().getIntAttribute("tileheight", 0);
            boolean visible = element.getIntAttribute("visible", 1) == 1;
            float opacity = element.getFloatAttribute("opacity", 1.0f);
            TiledMapTileLayer layer = new TiledMapTileLayer(width, height, tileWidth, tileHeight);
            layer.setVisible(visible);
            layer.setOpacity(opacity);
            layer.setName(name);
            int[] ids = getTileIds(element, width, height);
            TiledMapTileSets tilesets = map.getTileSets();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int id = ids[(y * width) + x];
                    boolean flipHorizontally = (FLAG_FLIP_HORIZONTALLY & id) != 0;
                    boolean flipVertically = (FLAG_FLIP_VERTICALLY & id) != 0;
                    boolean flipDiagonally = (536870912 & id) != 0;
                    TiledMapTile tile = tilesets.getTile(536870911 & id);
                    if (tile != null) {
                        Cell cell = createTileLayerCell(flipHorizontally, flipVertically, flipDiagonally);
                        cell.setTile(tile);
                        layer.setCell(x, (height - 1) - y, cell);
                    }
                }
            }
            Element properties = element.getChildByName("properties");
            if (properties != null) {
                loadProperties(layer.getProperties(), properties);
            }
            map.getLayers().add(layer);
        }
    }

    protected void loadObjectGroup(TiledMap map, Element element) {
        if (element.getName().equals("objectgroup")) {
            String name = element.getAttribute("name", null);
            MapLayer layer = new MapLayer();
            layer.setName(name);
            Element properties = element.getChildByName("properties");
            if (properties != null) {
                loadProperties(layer.getProperties(), properties);
            }
            Iterator i$ = element.getChildrenByName("object").iterator();
            while (i$.hasNext()) {
                loadObject(layer, (Element) i$.next());
            }
            map.getLayers().add(layer);
        }
    }

    protected void loadObject(MapLayer layer, Element element) {
        if (element.getName().equals("object")) {
            MapObject mapObject = null;
            float scaleX = this.convertObjectToTileSpace ? 1.0f / ((float) this.mapTileWidth) : 1.0f;
            float scaleY = this.convertObjectToTileSpace ? 1.0f / ((float) this.mapTileHeight) : 1.0f;
            float x = element.getFloatAttribute("x", 0.0f) * scaleX;
            float y = (((float) this.mapHeightInPixels) - element.getFloatAttribute("y", 0.0f)) * scaleY;
            float width = element.getFloatAttribute("width", 0.0f) * scaleX;
            float height = element.getFloatAttribute("height", 0.0f) * scaleY;
            if (element.getChildCount() > 0) {
                Element child = element.getChildByName("polygon");
                String[] points;
                float[] vertices;
                int i;
                String[] point;
                if (child != null) {
                    points = child.getAttribute("points").split(" ");
                    vertices = new float[(points.length * 2)];
                    for (i = 0; i < points.length; i++) {
                        point = points[i].split(",");
                        vertices[i * 2] = Float.parseFloat(point[0]) * scaleX;
                        vertices[(i * 2) + 1] = (-Float.parseFloat(point[1])) * scaleY;
                    }
                    Polygon polygon = new Polygon(vertices);
                    polygon.setPosition(x, y);
                    mapObject = new PolygonMapObject(polygon);
                } else {
                    child = element.getChildByName("polyline");
                    if (child != null) {
                        points = child.getAttribute("points").split(" ");
                        vertices = new float[(points.length * 2)];
                        for (i = 0; i < points.length; i++) {
                            point = points[i].split(",");
                            vertices[i * 2] = Float.parseFloat(point[0]) * scaleX;
                            vertices[(i * 2) + 1] = (-Float.parseFloat(point[1])) * scaleY;
                        }
                        Polyline polyline = new Polyline(vertices);
                        polyline.setPosition(x, y);
                        mapObject = new PolylineMapObject(polyline);
                    } else if (element.getChildByName("ellipse") != null) {
                        mapObject = new EllipseMapObject(x, y - height, width, height);
                    }
                }
            }
            if (mapObject == null) {
                mapObject = new RectangleMapObject(x, y - height, width, height);
            }
            mapObject.setName(element.getAttribute("name", null));
            String rotation = element.getAttribute("rotation", null);
            if (rotation != null) {
                mapObject.getProperties().put("rotation", Float.valueOf(Float.parseFloat(rotation)));
            }
            String type = element.getAttribute("type", null);
            if (type != null) {
                mapObject.getProperties().put("type", type);
            }
            int gid = element.getIntAttribute("gid", -1);
            if (gid != -1) {
                mapObject.getProperties().put("gid", Integer.valueOf(gid));
            }
            mapObject.getProperties().put("x", Float.valueOf(x * scaleX));
            mapObject.getProperties().put("y", Float.valueOf((y - height) * scaleY));
            mapObject.setVisible(element.getIntAttribute("visible", 1) == 1);
            Element properties = element.getChildByName("properties");
            if (properties != null) {
                loadProperties(mapObject.getProperties(), properties);
            }
            layer.getObjects().add(mapObject);
        }
    }

    protected void loadProperties(MapProperties properties, Element element) {
        if (element != null && element.getName().equals("properties")) {
            Iterator i$ = element.getChildrenByName("property").iterator();
            while (i$.hasNext()) {
                Element property = (Element) i$.next();
                String name = property.getAttribute("name", null);
                String value = property.getAttribute("value", null);
                if (value == null) {
                    value = property.getText();
                }
                properties.put(name, value);
            }
        }
    }

    protected Cell createTileLayerCell(boolean flipHorizontally, boolean flipVertically, boolean flipDiagonally) {
        Cell cell = new Cell();
        if (!flipDiagonally) {
            cell.setFlipHorizontally(flipHorizontally);
            cell.setFlipVertically(flipVertically);
        } else if (flipHorizontally && flipVertically) {
            cell.setFlipHorizontally(true);
            cell.setRotation(3);
        } else if (flipHorizontally) {
            cell.setRotation(3);
        } else if (flipVertically) {
            cell.setRotation(1);
        } else {
            cell.setFlipVertically(true);
            cell.setRotation(3);
        }
        return cell;
    }

    public static int[] getTileIds(Element element, int width, int height) {
        Element data = element.getChildByName("data");
        String encoding = data.getAttribute("encoding", null);
        if (encoding == null) {
            throw new GdxRuntimeException("Unsupported encoding (XML) for TMX Layer Data");
        }
        int[] ids = new int[(width * height)];
        if (encoding.equals("csv")) {
            String[] array = data.getText().split(",");
            for (int i = 0; i < array.length; i++) {
                ids[i] = (int) Long.parseLong(array[i].trim());
            }
        } else if (encoding.equals("base64")) {
            try {
                InputStream is;
                String compression = data.getAttribute("compression", null);
                byte[] bytes = Base64Coder.decode(data.getText());
                if (compression == null) {
                    is = new ByteArrayInputStream(bytes);
                } else if (compression.equals("gzip")) {
                    is = new GZIPInputStream(new ByteArrayInputStream(bytes), bytes.length);
                } else if (compression.equals("zlib")) {
                    is = new InflaterInputStream(new ByteArrayInputStream(bytes));
                } else {
                    throw new GdxRuntimeException("Unrecognised compression (" + compression + ") for TMX Layer Data");
                }
                byte[] temp = new byte[4];
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        int read = is.read(temp);
                        while (read < temp.length) {
                            int curr = is.read(temp, read, temp.length - read);
                            if (curr == -1) {
                                break;
                            }
                            read += curr;
                        }
                        if (read != temp.length) {
                            throw new GdxRuntimeException("Error Reading TMX Layer Data: Premature end of tile data");
                        }
                        ids[(y * width) + x] = ((unsignedByteToInt(temp[0]) | (unsignedByteToInt(temp[1]) << 8)) | (unsignedByteToInt(temp[2]) << 16)) | (unsignedByteToInt(temp[3]) << 24);
                    }
                }
                StreamUtils.closeQuietly(is);
            } catch (IOException e) {
                throw new GdxRuntimeException("Error Reading TMX Layer Data - IOException: " + e.getMessage());
            } catch (Throwable th) {
                StreamUtils.closeQuietly(null);
            }
        } else {
            throw new GdxRuntimeException("Unrecognised encoding (" + encoding + ") for TMX Layer Data");
        }
        return ids;
    }

    protected static int unsignedByteToInt(byte b) {
        return b & 255;
    }

    protected static FileHandle getRelativeFileHandle(FileHandle file, String path) {
        StringTokenizer tokenizer = new StringTokenizer(path, "\\/");
        FileHandle result = file.parent();
        while (tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken();
            if (token.equals("..")) {
                result = result.parent();
            } else {
                result = result.child(token);
            }
        }
        return result;
    }
}
