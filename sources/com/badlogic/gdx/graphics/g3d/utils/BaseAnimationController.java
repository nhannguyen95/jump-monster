package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.NodeKeyframe;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pool.Poolable;
import java.util.Iterator;

public class BaseAnimationController {
    private static final Transform tmpT = new Transform();
    private static final ObjectMap<Node, Transform> transforms = new ObjectMap();
    private boolean applying = false;
    public final ModelInstance target;
    private final Pool<Transform> transformPool = new C04831();

    /* renamed from: com.badlogic.gdx.graphics.g3d.utils.BaseAnimationController$1 */
    class C04831 extends Pool<Transform> {
        C04831() {
        }

        protected Transform newObject() {
            return new Transform();
        }
    }

    public static final class Transform implements Poolable {
        public final Quaternion rotation = new Quaternion();
        public final Vector3 scale = new Vector3(1.0f, 1.0f, 1.0f);
        public final Vector3 translation = new Vector3();

        public Transform idt() {
            this.translation.set(0.0f, 0.0f, 0.0f);
            this.rotation.idt();
            this.scale.set(1.0f, 1.0f, 1.0f);
            return this;
        }

        public Transform set(Vector3 t, Quaternion r, Vector3 s) {
            this.translation.set(t);
            this.rotation.set(r);
            this.scale.set(s);
            return this;
        }

        public Transform set(Transform other) {
            return set(other.translation, other.rotation, other.scale);
        }

        public Transform lerp(Transform target, float alpha) {
            return lerp(target.translation, target.rotation, target.scale, alpha);
        }

        public Transform lerp(Vector3 targetT, Quaternion targetR, Vector3 targetS, float alpha) {
            this.translation.lerp(targetT, alpha);
            this.rotation.slerp(targetR, alpha);
            this.scale.lerp(targetS, alpha);
            return this;
        }

        public Matrix4 toMatrix4(Matrix4 out) {
            return out.set(this.translation, this.rotation, this.scale);
        }

        public void reset() {
            idt();
        }
    }

    public BaseAnimationController(ModelInstance target) {
        this.target = target;
    }

    protected void begin() {
        if (this.applying) {
            throw new GdxRuntimeException("You must call end() after each call to being()");
        }
        this.applying = true;
    }

    protected void apply(Animation animation, float time, float weight) {
        if (this.applying) {
            applyAnimation(transforms, this.transformPool, weight, animation, time);
            return;
        }
        throw new GdxRuntimeException("You must call begin() before adding an animation");
    }

    protected void end() {
        if (this.applying) {
            Iterator i$ = transforms.entries().iterator();
            while (i$.hasNext()) {
                Entry<Node, Transform> entry = (Entry) i$.next();
                ((Transform) entry.value).toMatrix4(((Node) entry.key).localTransform);
                this.transformPool.free(entry.value);
            }
            transforms.clear();
            this.target.calculateTransforms();
            this.applying = false;
            return;
        }
        throw new GdxRuntimeException("You must call begin() first");
    }

    protected void applyAnimation(Animation animation, float time) {
        if (this.applying) {
            throw new GdxRuntimeException("Call end() first");
        }
        applyAnimation(null, null, 1.0f, animation, time);
        this.target.calculateTransforms();
    }

    protected void applyAnimations(Animation anim1, float time1, Animation anim2, float time2, float weight) {
        if (anim2 == null || weight == 0.0f) {
            applyAnimation(anim1, time1);
        } else if (anim1 == null || weight == 1.0f) {
            applyAnimation(anim2, time2);
        } else if (this.applying) {
            throw new GdxRuntimeException("Call end() first");
        } else {
            begin();
            apply(anim1, time1, 1.0f);
            apply(anim2, time2, weight);
            end();
        }
    }

    protected static void applyAnimation(ObjectMap<Node, Transform> out, Pool<Transform> pool, float alpha, Animation animation, float time) {
        Iterator i$;
        if (out != null) {
            i$ = out.keys().iterator();
            while (i$.hasNext()) {
                ((Node) i$.next()).isAnimated = false;
            }
        }
        i$ = animation.nodeAnimations.iterator();
        while (i$.hasNext()) {
            NodeAnimation nodeAnim = (NodeAnimation) i$.next();
            Node node = nodeAnim.node;
            node.isAnimated = true;
            int n = nodeAnim.keyframes.size - 1;
            int first = 0;
            int second = -1;
            int i = 0;
            while (i < n) {
                if (time >= ((NodeKeyframe) nodeAnim.keyframes.get(i)).keytime && time <= ((NodeKeyframe) nodeAnim.keyframes.get(i + 1)).keytime) {
                    first = i;
                    second = i + 1;
                    break;
                }
                i++;
            }
            Transform transform = tmpT;
            NodeKeyframe firstKeyframe = (NodeKeyframe) nodeAnim.keyframes.get(first);
            transform.set(firstKeyframe.translation, firstKeyframe.rotation, firstKeyframe.scale);
            if (second > first) {
                NodeKeyframe secondKeyframe = (NodeKeyframe) nodeAnim.keyframes.get(second);
                float t = (time - firstKeyframe.keytime) / (secondKeyframe.keytime - firstKeyframe.keytime);
                transform.lerp(secondKeyframe.translation, secondKeyframe.rotation, secondKeyframe.scale, t);
            }
            if (out == null) {
                transform.toMatrix4(node.localTransform);
            } else {
                Transform t2 = (Transform) out.get(node, null);
                if (t2 != null) {
                    if (alpha > 0.999999f) {
                        t2.set(transform);
                    } else {
                        t2.lerp(transform, alpha);
                    }
                } else if (alpha > 0.999999f) {
                    out.put(node, ((Transform) pool.obtain()).set(transform));
                } else {
                    out.put(node, ((Transform) pool.obtain()).set(node.translation, node.rotation, node.scale).lerp(transform, alpha));
                }
            }
        }
        if (out != null) {
            i$ = out.entries().iterator();
            while (i$.hasNext()) {
                Entry<Node, Transform> e = (Entry) i$.next();
                if (!((Node) e.key).isAnimated) {
                    ((Node) e.key).isAnimated = true;
                    ((Transform) e.value).lerp(((Node) e.key).translation, ((Node) e.key).rotation, ((Node) e.key).scale, alpha);
                }
            }
        }
    }

    protected void removeAnimation(Animation animation) {
        Iterator i$ = animation.nodeAnimations.iterator();
        while (i$.hasNext()) {
            ((NodeAnimation) i$.next()).node.isAnimated = false;
        }
    }
}
