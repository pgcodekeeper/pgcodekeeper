/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.hashers;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShaHasher implements Hasher {

    private static final Logger LOG = LoggerFactory.getLogger(ShaHasher.class);

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
            LOG.error(ex.getLocalizedMessage(), ex);
        }
        EMPTY = empty;
    }

    private final ByteBuffer bb;
    private final MessageDigest md;

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
            throw new IllegalStateException(ex.getLocalizedMessage());
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
            ShaHasher child = new ShaHasher(this);
            child.put(s.getBytes(StandardCharsets.UTF_8));
            md.update(child.getArray());
        }
    }

    @Override
    public void put(float f) {
        bb.putFloat(0, f);
        md.update(bb.array(), 0, 4);
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
        if (hashable == null) {
            md.update((byte)0);
        } else {
            ShaHasher child = new ShaHasher(this);
            hashable.computeHash(child);
            md.update(child.getArray());
        }
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
        byte[] sum = EMPTY.clone();
        for (Entry<String, String> entry : map.entrySet()) {

            ShaHasher first = new ShaHasher(this);
            first.put(entry.getKey());

            ShaHasher second = new ShaHasher(this);
            second.put(entry.getValue());

            ShaHasher child = new ShaHasher(this);
            child.put(first.getArray());
            child.put(second.getArray());
            xorByteArrays(sum, child.getArray());
        }
        md.update(sum);
    }

    @Override
    public void put(List<String> col) {
        ShaHasher child = new ShaHasher(this);
        for (String s : col) {
            child.put(s);
        }
        md.update(child.getArray());
    }

    @Override
    public void put(Set<String> col) {
        byte[] sum = EMPTY.clone();
        for (String s : col) {
            ShaHasher child = new ShaHasher(this);
            child.put(s);
            xorByteArrays(sum, child.getArray());
        }
        md.update(sum);
    }

    @Override
    public void putOrdered(Collection<? extends IHashable> col) {
        ShaHasher child = new ShaHasher(this);
        for (IHashable hashable : col) {
            child.put(hashable);
        }
        md.update(child.getArray());
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

    @Override
    public void putUnordered(Map<String, ? extends IHashable> map) {
        byte[] sum = EMPTY.clone();
        for (Entry<String, ? extends IHashable> entry : map.entrySet()) {

            ShaHasher first = new ShaHasher(this);
            first.put(entry.getKey());

            ShaHasher second = new ShaHasher(this);
            second.put(entry.getValue());

            ShaHasher child = new ShaHasher(this);
            child.put(first.getArray());
            child.put(second.getArray());
            xorByteArrays(sum, child.getArray());
        }
        md.update(sum);
    }

    public byte[] getArray() {
        return md.digest();
    }

    private byte[] xorByteArrays(byte[] first, byte[] second) {
        for (int i = 0; i < first.length; i++) {
            first[i] ^= second[i];
        }
        return first;
    }

    private void put(byte[] bs) {
        md.update(bs);
    }
}
