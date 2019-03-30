package com.esotericsoftware.spine;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.esotericsoftware.spine.attachments.Attachment;
import java.util.Iterator;

public class Skin {
    private static final Key lookup = new Key();
    final ObjectMap<Key, Attachment> attachments = new ObjectMap();
    final String name;

    static class Key {
        int hashCode;
        String name;
        int slotIndex;

        Key() {
        }

        public void set(int slotName, String name) {
            if (name == null) {
                throw new IllegalArgumentException("name cannot be null.");
            }
            this.slotIndex = slotName;
            this.name = name;
            this.hashCode = ((name.hashCode() + 31) * 31) + this.slotIndex;
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            Key other = (Key) object;
            if (this.slotIndex == other.slotIndex && this.name.equals(other.name)) {
                return true;
            }
            return false;
        }

        public String toString() {
            return this.slotIndex + ":" + this.name;
        }
    }

    public Skin(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null.");
        }
        this.name = name;
    }

    public void addAttachment(int slotIndex, String name, Attachment attachment) {
        if (attachment == null) {
            throw new IllegalArgumentException("attachment cannot be null.");
        } else if (slotIndex < 0) {
            throw new IllegalArgumentException("slotIndex must be >= 0.");
        } else {
            Key key = new Key();
            key.set(slotIndex, name);
            this.attachments.put(key, attachment);
        }
    }

    public Attachment getAttachment(int slotIndex, String name) {
        if (slotIndex < 0) {
            throw new IllegalArgumentException("slotIndex must be >= 0.");
        }
        lookup.set(slotIndex, name);
        return (Attachment) this.attachments.get(lookup);
    }

    public void findNamesForSlot(int slotIndex, Array<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("names cannot be null.");
        } else if (slotIndex < 0) {
            throw new IllegalArgumentException("slotIndex must be >= 0.");
        } else {
            Iterator it = this.attachments.keys().iterator();
            while (it.hasNext()) {
                Key key = (Key) it.next();
                if (key.slotIndex == slotIndex) {
                    names.add(key.name);
                }
            }
        }
    }

    public void findAttachmentsForSlot(int slotIndex, Array<Attachment> attachments) {
        if (attachments == null) {
            throw new IllegalArgumentException("attachments cannot be null.");
        } else if (slotIndex < 0) {
            throw new IllegalArgumentException("slotIndex must be >= 0.");
        } else {
            Iterator it = this.attachments.entries().iterator();
            while (it.hasNext()) {
                Entry<Key, Attachment> entry = (Entry) it.next();
                if (((Key) entry.key).slotIndex == slotIndex) {
                    attachments.add((Attachment) entry.value);
                }
            }
        }
    }

    public void clear() {
        this.attachments.clear();
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    void attachAll(Skeleton skeleton, Skin oldSkin) {
        Iterator it = oldSkin.attachments.entries().iterator();
        while (it.hasNext()) {
            Entry<Key, Attachment> entry = (Entry) it.next();
            int slotIndex = ((Key) entry.key).slotIndex;
            Slot slot = (Slot) skeleton.slots.get(slotIndex);
            if (slot.attachment == entry.value) {
                Attachment attachment = getAttachment(slotIndex, ((Key) entry.key).name);
                if (attachment != null) {
                    slot.setAttachment(attachment);
                }
            }
        }
    }
}
