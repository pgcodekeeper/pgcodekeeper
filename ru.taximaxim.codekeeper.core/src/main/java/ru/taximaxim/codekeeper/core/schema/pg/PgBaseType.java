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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractType;
import ru.taximaxim.codekeeper.core.schema.ICompressOptionContainer;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class PgBaseType extends AbstractType implements ICompressOptionContainer {

    private String inputFunction;
    private String outputFunction;
    private String receiveFunction;
    private String sendFunction;
    private String typmodInputFunction;
    private String typmodOutputFunction;
    private String analyzeFunction;
    private String subscriptFunction;
    private String internalLength;
    private boolean passedByValue;
    private String alignment;
    private String storage;
    private String likeType;
    private String category;
    private String preferred;
    private String defaultValue;
    private String element;
    private String delimiter;
    private String collatable;

    // greenplum type fields
    private String compressType = DEFAULT_COMPESS_TYPE;
    private int compressLevel = DEFAULT_COMPESS_LEVEL;
    private int blockSize = DEFAULT_BLOCK_SIZE;

    public PgBaseType(String name) {
        super(name);
    }

    @Override
    protected void appendDef(StringBuilder sb) {
        sb.append(" (")
        .append("\n\tINPUT = ").append(inputFunction)
        .append(",\n\tOUTPUT = ").append(outputFunction);
        appendStringOption(sb, "RECEIVE", receiveFunction);
        appendStringOption(sb, "SEND", sendFunction);
        appendStringOption(sb, "TYPMOD_IN", typmodInputFunction);
        appendStringOption(sb, "TYPMOD_OUT", typmodOutputFunction);
        appendStringOption(sb, "ANALYZE", analyzeFunction);
        appendStringOption(sb, "SUBSCRIPT", subscriptFunction);
        appendStringOption(sb, "INTERNALLENGTH", internalLength);
        if (passedByValue) {
            sb.append(",\n\tPASSEDBYVALUE");
        }
        appendStringOption(sb, "ALIGNMENT", alignment);
        appendStringOption(sb, "STORAGE", storage);
        appendStringOption(sb, "LIKE", likeType);
        appendStringOption(sb, "CATEGORY", category);
        appendStringOption(sb, "PREFERRED", preferred);
        appendStringOption(sb, "DEFAULT", defaultValue);
        appendStringOption(sb, "ELEMENT", element);
        appendStringOption(sb, "DELIMITER", delimiter);
        appendStringOption(sb, "COLLATABLE", collatable);
        sb.append("\n)");
    }

    @Override
    protected void compareType(AbstractType newType, AtomicBoolean isNeedDepcies, SQLScript script) {
        PgBaseType newBaseType = (PgBaseType) newType;
        if (!Objects.equals(newBaseType.compressType, compressType)
                || newBaseType.compressLevel != compressLevel
                || newBaseType.blockSize != blockSize) {
            script.addStatement(appendGreenplumOptions(newBaseType));
        }
    }

    @Override
    protected void appendOptions(SQLScript script) {
        if (checkGreenplumOptions()) {
            script.addStatement(appendGreenplumOptions(this));
        }
    }

    private boolean checkGreenplumOptions() {
        return compressLevel != DEFAULT_COMPESS_LEVEL
                || blockSize != DEFAULT_BLOCK_SIZE
                || !Objects.equals(DEFAULT_COMPESS_TYPE, compressType);
    }

    private StringBuilder appendGreenplumOptions(PgBaseType type) {
        StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("ALTER TYPE ").append(getQualifiedName())
        .append(" SET DEFAULT ENCODING (")
        .append("COMPRESSTYPE = ").append(type.compressType).append(", ")
        .append("COMPRESSLEVEL = ").append(type.compressLevel).append(", ")
        .append("BLOCKSIZE = ").append(type.blockSize)
        .append(")");
        return sbSQL;
    }

    public void setInputFunction(String inputFunction) {
        this.inputFunction = inputFunction;
        resetHash();
    }

    public void setOutputFunction(String outputFunction) {
        this.outputFunction = outputFunction;
        resetHash();
    }

    public void setReceiveFunction(String receiveFunction) {
        this.receiveFunction = receiveFunction;
        resetHash();
    }

    public void setSendFunction(String sendFunction) {
        this.sendFunction = sendFunction;
        resetHash();
    }

    public void setTypmodInputFunction(String typmodInputFunction) {
        this.typmodInputFunction = typmodInputFunction;
        resetHash();
    }

    public void setTypmodOutputFunction(String typmodOutputFunction) {
        this.typmodOutputFunction = typmodOutputFunction;
        resetHash();
    }

    public void setAnalyzeFunction(String analyzeFunction) {
        this.analyzeFunction = analyzeFunction;
        resetHash();
    }

    public void setSubscriptFunction(String subscriptFunction) {
        this.subscriptFunction = subscriptFunction;
        resetHash();
    }

    public void setInternalLength(String internalLength) {
        this.internalLength = internalLength;
        resetHash();
    }

    public void setPassedByValue(boolean passedByValue) {
        this.passedByValue = passedByValue;
        resetHash();
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
        resetHash();
    }

    public void setStorage(String storage) {
        this.storage = storage;
        resetHash();
    }

    public void setLikeType(String likeType) {
        this.likeType = likeType;
        resetHash();
    }

    public void setCategory(String category) {
        this.category = category;
        resetHash();
    }

    public void setPreferred(String preferred) {
        this.preferred = preferred;
        resetHash();
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        resetHash();
    }

    public void setElement(String element) {
        this.element = element;
        resetHash();
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        resetHash();
    }

    public void setCollatable(String collatable) {
        this.collatable = collatable;
        resetHash();
    }

    @Override
    public void setCompressType(String compressType) {
        this.compressType = compressType;
        resetHash();
    }

    @Override
    public void setCompressLevel(int compressLvl) {
        this.compressLevel = compressLvl;
        resetHash();
    }

    @Override
    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
        resetHash();
    }

    @Override
    protected AbstractType getTypeCopy() {
        PgBaseType copy = new PgBaseType(name);
        copy.setInputFunction(inputFunction);
        copy.setOutputFunction(outputFunction);
        copy.setReceiveFunction(receiveFunction);
        copy.setSendFunction(sendFunction);
        copy.setTypmodInputFunction(typmodInputFunction);
        copy.setTypmodOutputFunction(typmodOutputFunction);
        copy.setAnalyzeFunction(analyzeFunction);
        copy.setSubscriptFunction(subscriptFunction);
        copy.setInternalLength(internalLength);
        copy.setPassedByValue(passedByValue);
        copy.setAlignment(alignment);
        copy.setStorage(storage);
        copy.setLikeType(likeType);
        copy.setCategory(category);
        copy.setPreferred(preferred);
        copy.setDefaultValue(defaultValue);
        copy.setElement(element);
        copy.setDelimiter(delimiter);
        copy.setCollatable(collatable);
        copy.setCompressType(compressType);
        copy.setCompressLevel(compressLevel);
        copy.setBlockSize(blockSize);
        return copy;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgBaseType type) {
            return super.compare(type)
                    && compareUnalterable(type)
                    && Objects.equals(compressType, type.compressType)
                    && compressLevel == type.compressLevel
                    && blockSize == type.blockSize;
        }
        return false;
    }

    @Override
    protected boolean compareUnalterable(AbstractType newType) {
        PgBaseType type = (PgBaseType) newType;
        return Objects.equals(inputFunction, type.inputFunction)
                && Objects.equals(outputFunction, type.outputFunction)
                && Objects.equals(receiveFunction, type.receiveFunction)
                && Objects.equals(sendFunction, type.sendFunction)
                && Objects.equals(typmodInputFunction, type.typmodInputFunction)
                && Objects.equals(typmodOutputFunction, type.typmodOutputFunction)
                && Objects.equals(analyzeFunction, type.analyzeFunction)
                && Objects.equals(subscriptFunction, type.subscriptFunction)
                && Objects.equals(internalLength, type.internalLength)
                && passedByValue == type.passedByValue
                && Objects.equals(alignment, type.alignment)
                && Objects.equals(storage, type.storage)
                && Objects.equals(likeType, type.likeType)
                && Objects.equals(category, type.category)
                && Objects.equals(preferred, type.preferred)
                && Objects.equals(defaultValue, type.defaultValue)
                && Objects.equals(element, type.element)
                && Objects.equals(delimiter, type.delimiter)
                && Objects.equals(collatable, type.collatable);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(inputFunction);
        hasher.put(outputFunction);
        hasher.put(receiveFunction);
        hasher.put(sendFunction);
        hasher.put(typmodInputFunction);
        hasher.put(typmodOutputFunction);
        hasher.put(analyzeFunction);
        hasher.put(subscriptFunction);
        hasher.put(internalLength);
        hasher.put(passedByValue);
        hasher.put(alignment);
        hasher.put(storage);
        hasher.put(likeType);
        hasher.put(category);
        hasher.put(preferred);
        hasher.put(defaultValue);
        hasher.put(element);
        hasher.put(delimiter);
        hasher.put(collatable);
        hasher.put(compressType);
        hasher.put(compressLevel);
        hasher.put(blockSize);
    }
}
