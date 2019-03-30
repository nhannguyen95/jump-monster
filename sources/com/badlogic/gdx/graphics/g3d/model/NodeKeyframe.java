package com.badlogic.gdx.graphics.g3d.model;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

public class NodeKeyframe {
    public float keytime;
    public final Quaternion rotation = new Quaternion();
    public final Vector3 scale = new Vector3(1.0f, 1.0f, 1.0f);
    public final Vector3 translation = new Vector3();
}
