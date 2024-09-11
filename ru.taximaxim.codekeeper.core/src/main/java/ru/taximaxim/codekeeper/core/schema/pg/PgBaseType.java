/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
        sb.append("\n);");

        if (checkGreenplumOptions()) {
            appendGreenplumOptions(this, sb);
        }
    }

    @Override
    protected void compareType(AbstractType newType, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        PgBaseType newBaseType = (PgBaseType) newType;
        if (!Objects.equals(newBaseType.getCompressType(), getCompressType())
                || newBaseType.getCompressLevel() != getCompressLevel()
                || newBaseType.getBlockSize() != getBlockSize()) {
            appendGreenplumOptions(newBaseType, sb);
        }
    }

    private boolean checkGreenplumOptions() {
        return compressLevel != DEFAULT_COMPESS_LEVEL
                || blockSize != DEFAULT_BLOCK_SIZE
                || !Objects.equals(DEFAULT_COMPESS_TYPE, compressType);
    }

    private void appendGreenplumOptions(PgBaseType type, StringBuilder sb) {
        sb.append("\n\nALTER TYPE ").append(getQualifiedName())
        .append(" SET DEFAULT ENCODING (")
        .append("COMPRESSTYPE = ").append(type.getCompressType()).append(", ")
        .append("COMPRESSLEVEL = ").append(type.getCompressLevel()).append(", ")
        .append("BLOCKSIZE = ").append(type.getBlockSize())
        .append(");");
    }

    public String getInputFunction() {
        return inputFunction;
    }

    public void setInputFunction(String inputFunction) {
        this.inputFunction = inputFunction;
        resetHash();
    }

    public String getOutputFunction() {
        return outputFunction;
    }

    public void setOutputFunction(String outputFunction) {
        this.outputFunction = outputFunction;
        resetHash();
    }

    public String getReceiveFunction() {
        return receiveFunction;
    }

    public void setReceiveFunction(String receiveFunction) {
        this.receiveFunction = receiveFunction;
        resetHash();
    }

    public String getSendFunction() {
        return sendFunction;
    }

    public void setSendFunction(String sendFunction) {
        this.sendFunction = sendFunction;
        resetHash();
    }

    public String getTypmodInputFunction() {
        return typmodInputFunction;
    }

    public void setTypmodInputFunction(String typmodInputFunction) {
        this.typmodInputFunction = typmodInputFunction;
        resetHash();
    }

    public String getTypmodOutputFunction() {
        return typmodOutputFunction;
    }

    public void setTypmodOutputFunction(String typmodOutputFunction) {
        this.typmodOutputFunction = typmodOutputFunction;
        resetHash();
    }

    public String getAnalyzeFunction() {
        return analyzeFunction;
    }

    public void setAnalyzeFunction(String analyzeFunction) {
        this.analyzeFunction = analyzeFunction;
        resetHash();
    }

    public String getSubscriptFunction() {
        return subscriptFunction;
    }

    public void setSubscriptFunction(String subscriptFunction) {
        this.subscriptFunction = subscriptFunction;
        resetHash();
    }

    public String getInternalLength() {
        return internalLength;
    }

    public void setInternalLength(String internalLength) {
        this.internalLength = internalLength;
        resetHash();
    }

    public boolean isPassedByValue() {
        return passedByValue;
    }

    public void setPassedByValue(boolean passedByValue) {
        this.passedByValue = passedByValue;
        resetHash();
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
        resetHash();
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
        resetHash();
    }

    public String getLikeType() {
        return likeType;
    }

    public void setLikeType(String likeType) {
        this.likeType = likeType;
        resetHash();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
        resetHash();
    }

    public String getPreferred() {
        return preferred;
    }

    public void setPreferred(String preferred) {
        this.preferred = preferred;
        resetHash();
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        resetHash();
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
        resetHash();
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        resetHash();
    }

    public String getCollatable() {
        return collatable;
    }

    public void setCollatable(String collatable) {
        this.collatable = collatable;
        resetHash();
    }

    public String getCompressType() {
        return compressType;
    }

    @Override
    public void setCompressType(String compressType) {
        this.compressType = compressType;
        resetHash();
    }

    public int getCompressLevel() {
        return compressLevel;
    }

    @Override
    public void setCompressLevel(int compressLvl) {
        this.compressLevel = compressLvl;
        resetHash();
    }

    public int getBlockSize() {
        return blockSize;
    }

    @Override
    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
        resetHash();
    }

    @Override
    protected AbstractType getTypeCopy() {
        PgBaseType copy = new PgBaseType(getName());
        copy.setInputFunction(getInputFunction());
        copy.setOutputFunction(getOutputFunction());
        copy.setReceiveFunction(getReceiveFunction());
        copy.setSendFunction(getSendFunction());
        copy.setTypmodInputFunction(getTypmodInputFunction());
        copy.setTypmodOutputFunction(getTypmodOutputFunction());
        copy.setAnalyzeFunction(getAnalyzeFunction());
        copy.setSubscriptFunction(getSubscriptFunction());
        copy.setInternalLength(getInternalLength());
        copy.setPassedByValue(isPassedByValue());
        copy.setAlignment(getAlignment());
        copy.setStorage(getStorage());
        copy.setLikeType(getLikeType());
        copy.setCategory(getCategory());
        copy.setPreferred(getPreferred());
        copy.setDefaultValue(getDefaultValue());
        copy.setElement(getElement());
        copy.setDelimiter(getDelimiter());
        copy.setCollatable(getCollatable());
        copy.setCollatable(getCollatable());
        copy.setCompressType(getCompressType());
        copy.setCompressLevel(getCompressLevel());
        copy.setBlockSize(getBlockSize());
        return copy;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgBaseType type) {
            return super.compare(type)
                    && compareUnalterable(type)
                    && Objects.equals(compressType, type.getCompressType())
                    && compressLevel == type.compressLevel
                    && blockSize == type.getBlockSize();
        }
        return false;
    }

    @Override
    protected boolean compareUnalterable(AbstractType newType) {
        PgBaseType type = (PgBaseType) newType;
        return Objects.equals(inputFunction, type.getInputFunction())
                && Objects.equals(outputFunction, type.getOutputFunction())
                && Objects.equals(receiveFunction, type.getReceiveFunction())
                && Objects.equals(sendFunction, type.getSendFunction())
                && Objects.equals(typmodInputFunction, type.getTypmodInputFunction())
                && Objects.equals(typmodOutputFunction, type.getTypmodOutputFunction())
                && Objects.equals(analyzeFunction, type.getAnalyzeFunction())
                && Objects.equals(subscriptFunction, type.getSubscriptFunction())
                && Objects.equals(internalLength, type.getInternalLength())
                && passedByValue == type.isPassedByValue()
                && Objects.equals(alignment, type.getAlignment())
                && Objects.equals(storage, type.getStorage())
                && Objects.equals(likeType, type.getLikeType())
                && Objects.equals(category, type.getCategory())
                && Objects.equals(preferred, type.getPreferred())
                && Objects.equals(defaultValue, type.getDefaultValue())
                && Objects.equals(element, type.getElement())
                && Objects.equals(delimiter, type.getDelimiter())
                && Objects.equals(collatable, type.getCollatable());
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
