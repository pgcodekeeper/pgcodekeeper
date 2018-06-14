package cz.startnet.utils.pgdiff.hashers;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import ru.taximaxim.codekeeper.apgdiff.Log;

public class ShaHasher implements Hasher {

    private static final byte[] TRUE;
    private static final byte[] FALSE;
    private static final byte[] EMPTY;

    private static final String ALGORITHM = "SHA-256";

    static {
        ByteBuffer b = ByteBuffer.allocate(2);
        b.putShort(0, HashConstant.TRUE);
        TRUE = b.array().clone();
        b.putShort(0, HashConstant.FALSE);
        FALSE = b.array().clone();

        byte[] empty;
        try {
            byte[] zero = { 0 };
            empty = MessageDigest.getInstance(ALGORITHM).digest(zero);
        } catch (NoSuchAlgorithmException ex) {
            empty = new byte[256/8];
            Log.log(ex);
        }
        EMPTY = empty;
    }

    private final ByteBuffer bb;
    private MessageDigest md;

    public ShaHasher() {
        this(ByteBuffer.allocate(8));
    }

    private ShaHasher(ShaHasher parent) {
        this(parent.bb);
    }

    private ShaHasher(ByteBuffer bb) {
        this.bb = bb;
        try {
            md = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            Log.log(ex);
        }
    }

    @Override
    public void put(boolean b) {
        md.update(b ? TRUE : FALSE);
    }

    @Override
    public void put(Boolean b) {
        if (b == null) {
            md.update((byte)0);
        } else {
            md.update(b ? TRUE : FALSE);
        }
    }

    @Override
    public void put(String s) {
        if (s == null) {
            md.update((byte)0);
        } else {
            md.update(s.getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override
    public void put(int i) {
        bb.putInt(0, i);
        md.update(bb.array(), 0, 4);
    }

    @Override
    public void put(Integer i) {
        if (i == null) {
            md.update((byte)0);
        } else {
            put(i.intValue());
        }
    }

    @Override
    public void put(IHashable hashable) {
        putHashable(hashable, md);
    }

    @Override
    public void put(Enum<?> en) {
        if (en == null) {
            md.update((byte)0);
        } else {
            ShaHasher child = new ShaHasher(this);
            child.put(en.name());
            child.put(en.ordinal());
            md.update(child.getArray());
        }
    }

    @Override
    public void put(Map<String, String> map) {
        try {
            byte[] sum = EMPTY.clone();
            for (Entry<String, String> entry : map.entrySet()) {

                ShaHasher first = new ShaHasher(this);
                first.put(entry.getKey());

                ShaHasher second = new ShaHasher(this);
                second.put(entry.getValue());

                MessageDigest child = MessageDigest.getInstance(ALGORITHM);
                child.update(first.getArray());
                child.update(second.getArray());
                xorByteArrays(sum, child.digest());
            }
            md.update(sum);

        } catch (NoSuchAlgorithmException ex) {
            Log.log(ex);
        }
    }

    @Override
    public void putOrderedStrings(Collection<String> col) {
        ShaHasher child = new ShaHasher(this);
        for (String s : col) {
            child.put(s);
        }
        md.update(child.getArray());
    }

    @Override
    public void putUnorderedStrings(Collection<String> col) {
        byte[] sum = EMPTY.clone();
        for (String s : col) {
            try {
                MessageDigest child = MessageDigest.getInstance(ALGORITHM);
                byte[] second = child.digest(s.getBytes(StandardCharsets.UTF_8));
                xorByteArrays(sum, second);
            } catch (NoSuchAlgorithmException e) {
                Log.log(e);
            }
        }
        md.update(sum);
    }

    @Override
    public void putOrdered(Collection<? extends IHashable> col) {
        try {
            MessageDigest child = MessageDigest.getInstance(ALGORITHM);
            for (IHashable hashable : col) {
                putHashable(hashable, child);
            }
            md.update(child.digest());
        } catch (NoSuchAlgorithmException ex) {
            Log.log(ex);
        }
    }

    @Override
    public void putUnordered(Collection<? extends IHashable> col) {
        byte[] sum = EMPTY.clone();
        for (IHashable hashable : col) {
            ShaHasher child = new ShaHasher(this);
            hashable.computeHash(child);
            byte[] second = child.getArray();
            xorByteArrays(sum, second);
        }
        md.update(sum);
    }

    public byte[] getArray() {
        return md.digest();
    }

    public void putHashable(IHashable hashable, MessageDigest md) {
        if (hashable == null) {
            md.update((byte)0);
        } else {
            ShaHasher child = new ShaHasher(this);
            hashable.computeHash(child);
            md.update(child.getArray());
        }
    }

    private byte[] xorByteArrays(byte[] first, byte[] second) {
        for (int i = 0; i < first.length; i++) {
            first[i] ^= second[i];
        }
        return first;
    }
}
