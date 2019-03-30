package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gn;
import com.google.android.gms.tagmanager.DataLayer.C0369a;
import com.google.android.gms.tagmanager.DataLayer.C0372c;
import com.google.android.gms.tagmanager.DataLayer.C0372c.C0371a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.tagmanager.v */
class C0846v implements C0372c {
    private static final String XB = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    private gl Wv;
    private final Executor XC;
    private C0419a XD;
    private int XE;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.v$a */
    class C0419a extends SQLiteOpenHelper {
        final /* synthetic */ C0846v XH;

        C0419a(C0846v c0846v, Context context, String str) {
            this.XH = c0846v;
            super(context, str, null, 1);
        }

        /* renamed from: a */
        private void m1485a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        /* renamed from: a */
        private boolean m1486a(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        bh.m1388z("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                bh.m1388z("Error querying for table " + str);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.XH.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public void onCreate(SQLiteDatabase db) {
            ak.m1368G(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (m1486a("datalayer", db)) {
                m1485a(db);
            } else {
                db.execSQL(C0846v.XB);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v$b */
    private static class C0420b {
        final byte[] XK;
        final String Xy;

        C0420b(String str, byte[] bArr) {
            this.Xy = str;
            this.XK = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.Xy + " serialized hash = " + Arrays.hashCode(this.XK);
        }
    }

    public C0846v(Context context) {
        this(context, gn.ft(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    C0846v(Context context, gl glVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.Wv = glVar;
        this.XE = i;
        this.XC = executor;
        this.XD = new C0419a(this, this.mContext, str);
    }

    /* renamed from: L */
    private SQLiteDatabase m2540L(String str) {
        try {
            return this.XD.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.m1388z(str);
            return null;
        }
    }

    /* renamed from: b */
    private List<C0369a> m2545b(List<C0420b> list) {
        List<C0369a> arrayList = new ArrayList();
        for (C0420b c0420b : list) {
            arrayList.add(new C0369a(c0420b.Xy, m2550j(c0420b.XK)));
        }
        return arrayList;
    }

    /* renamed from: b */
    private synchronized void m2546b(List<C0420b> list, long j) {
        try {
            long currentTimeMillis = this.Wv.currentTimeMillis();
            m2552u(currentTimeMillis);
            cb(list.size());
            m2548c(list, currentTimeMillis + j);
            kv();
        } catch (Throwable th) {
            kv();
        }
    }

    private void by(String str) {
        SQLiteDatabase L = m2540L("Error opening database for clearKeysWithPrefix.");
        if (L != null) {
            try {
                bh.m1387y("Cleared " + L.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                bh.m1388z("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                kv();
            }
        }
    }

    /* renamed from: c */
    private List<C0420b> m2547c(List<C0369a> list) {
        List<C0420b> arrayList = new ArrayList();
        for (C0369a c0369a : list) {
            arrayList.add(new C0420b(c0369a.Xy, m2551j(c0369a.Xz)));
        }
        return arrayList;
    }

    /* renamed from: c */
    private void m2548c(List<C0420b> list, long j) {
        SQLiteDatabase L = m2540L("Error opening database for writeEntryToDatabase.");
        if (L != null) {
            for (C0420b c0420b : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", c0420b.Xy);
                contentValues.put("value", c0420b.XK);
                L.insert("datalayer", null, contentValues);
            }
        }
    }

    private void cb(int i) {
        int ku = (ku() - this.XE) + i;
        if (ku > 0) {
            List cc = cc(ku);
            bh.m1386x("DataLayer store full, deleting " + cc.size() + " entries to make room.");
            m2549g((String[]) cc.toArray(new String[0]));
        }
    }

    private List<String> cc(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            bh.m1388z("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase L = m2540L("Error opening database for peekEntryIds.");
        if (L == null) {
            return arrayList;
        }
        try {
            query = L.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    bh.m1388z("Error in peekEntries fetching entryIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            bh.m1388z("Error in peekEntries fetching entryIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* renamed from: g */
    private void m2549g(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase L = m2540L("Error opening database for deleteEntries.");
            if (L != null) {
                try {
                    L.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    bh.m1388z("Error deleting entries " + Arrays.toString(strArr));
                }
            }
        }
    }

    /* renamed from: j */
    private Object m2550j(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream.readObject();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = objectInputStream2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    /* renamed from: j */
    private byte[] m2551j(Object obj) {
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private List<C0369a> ks() {
        try {
            m2552u(this.Wv.currentTimeMillis());
            List<C0369a> b = m2545b(kt());
            return b;
        } finally {
            kv();
        }
    }

    private List<C0420b> kt() {
        SQLiteDatabase L = m2540L("Error opening database for loadSerialized.");
        List<C0420b> arrayList = new ArrayList();
        if (L == null) {
            return arrayList;
        }
        Cursor query = L.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new C0420b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int ku() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase L = m2540L("Error opening database for getNumStoredEntries.");
        if (L != null) {
            try {
                cursor = L.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.m1388z("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private void kv() {
        try {
            this.XD.close();
        } catch (SQLiteException e) {
        }
    }

    /* renamed from: u */
    private void m2552u(long j) {
        SQLiteDatabase L = m2540L("Error opening database for deleteOlderThan.");
        if (L != null) {
            try {
                bh.m1387y("Deleted " + L.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                bh.m1388z("Error deleting old entries.");
            }
        }
    }

    /* renamed from: a */
    public void mo2232a(final C0371a c0371a) {
        this.XC.execute(new Runnable(this) {
            final /* synthetic */ C0846v XH;

            public void run() {
                c0371a.mo2235a(this.XH.ks());
            }
        });
    }

    /* renamed from: a */
    public void mo2233a(List<C0369a> list, final long j) {
        final List c = m2547c(list);
        this.XC.execute(new Runnable(this) {
            final /* synthetic */ C0846v XH;

            public void run() {
                this.XH.m2546b(c, j);
            }
        });
    }

    public void bx(final String str) {
        this.XC.execute(new Runnable(this) {
            final /* synthetic */ C0846v XH;

            public void run() {
                this.XH.by(str);
            }
        });
    }
}
