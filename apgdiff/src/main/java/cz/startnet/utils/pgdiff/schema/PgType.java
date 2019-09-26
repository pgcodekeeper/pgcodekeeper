package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;

public class PgType extends AbstractType {

    public enum PgTypeForm {
        COMPOSITE, ENUM, RANGE, BASE, SHELL
    }

    private final PgTypeForm form;

    // attributes (fields) for composite type
    private final List<AbstractColumn> attrs = new ArrayList<>();
    // enum labels for enum type
    private final List<String> enums = new ArrayList<>();

    // range type fields
    private String subtype;
    private String subtypeOpClass;
    private String collation;
    private String canonical;
    private String subtypeDiff;

    // base type fields
    private String inputFunction;
    private String outputFunction;
    private String receiveFunction;
    private String sendFunction;
    private String typmodInputFunction;
    private String typmodOutputFunction;
    private String analyzeFunction;
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

    public PgTypeForm getForm() {
        return form;
    }

    public List<AbstractColumn> getAttrs() {
        return Collections.unmodifiableList(attrs);
    }

    public AbstractColumn getAttr(String name) {
        for (AbstractColumn att : attrs) {
            if (att.getName().equals(name)) {
                return att;
            }
        }
        return null;
    }

    public void addAttr(AbstractColumn attr) {
        attrs.add(attr);
        attr.setParent(this);
        resetHash();
    }

    public List<String> getEnums() {
        return Collections.unmodifiableList(enums);
    }

    public void addEnum(String value) {
        enums.add(value);
        resetHash();
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
        resetHash();
    }

    public String getSubtypeOpClass() {
        return subtypeOpClass;
    }

    public void setSubtypeOpClass(String subtypeOpClass) {
        this.subtypeOpClass = subtypeOpClass;
        resetHash();
    }

    public String getCollation() {
        return collation;
    }

    public void setCollation(String collation) {
        this.collation = collation;
        resetHash();
    }

    public String getCanonical() {
        return canonical;
    }

    public void setCanonical(String canonical) {
        this.canonical = canonical;
        resetHash();
    }

    public String getSubtypeDiff() {
        return subtypeDiff;
    }

    public void setSubtypeDiff(String subtypeDiff) {
        this.subtypeDiff = subtypeDiff;
        resetHash();
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

    public PgType(String name, PgTypeForm form) {
        super(name);
        this.form = form;
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder("CREATE TYPE ")
                .append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.')
                .append(PgDiffUtils.getQuotedName(getName()));

        switch(form) {
        case COMPOSITE:
            sb.append(" AS (");
            appendCompositeDef(sb);
            break;

        case ENUM:
            sb.append(" AS ENUM (");
            appendEnumDef(sb);
            break;

        case RANGE:
            sb.append(" AS RANGE (");
            appendRangeDef(sb);
            break;

        case BASE:
            sb.append(" (");
            appendBaseDef(sb);
            break;

        case SHELL:
            break;
        }
        if (form != PgTypeForm.SHELL) {
            sb.append("\n)");
        }
        sb.append(';');

        appendOwnerSQL(sb);
        appendPrivileges(sb);

        if (PgDiffUtils.isStringNotEmpty(comment)) {
            sb.append("\n\n");
            appendCommentSql(sb);
        }

        if (form == PgTypeForm.COMPOSITE) {
            for (AbstractColumn c : attrs) {
                if (PgDiffUtils.isStringNotEmpty(c.getComment())) {
                    sb.append("\n\n");
                    c.appendCommentSql(sb);
                }
            }
        }

        return sb.toString();
    }

    private void appendCompositeDef(StringBuilder sb) {
        boolean bFirst = true;
        for (AbstractColumn attr : attrs) {
            if (bFirst) {
                bFirst = false;
            } else {
                sb.append(',');
            }
            sb.append("\n\t").append(attr.getName()).append(' ').append(attr.getType());

            if (attr.getCollation() != null) {
                sb.append(" COLLATE ").append(attr.getCollation());
            }

        }
    }

    private void appendEnumDef(StringBuilder sb) {
        boolean bFirst = true;
        for (String enum_ : enums) {
            if (bFirst) {
                bFirst = false;
            } else {
                sb.append(',');
            }
            sb.append("\n\t").append(enum_);
        }
    }

    private void appendRangeDef(StringBuilder sb) {
        // lowercase keywords follow pg_dump format here
        sb.append("\n\tsubtype = ").append(subtype);
        if (subtypeOpClass != null && !subtypeOpClass.isEmpty()) {
            sb.append(",\n\tsubtype_opclass = ").append(subtypeOpClass);
        }
        if (collation != null && !collation.isEmpty()) {
            sb.append(",\n\tcollation = ").append(collation);
        }
        if (canonical != null && !canonical.isEmpty()) {
            sb.append(",\n\tcanonical = ").append(canonical);
        }
        if (subtypeDiff != null && !subtypeDiff.isEmpty()) {
            sb.append(",\n\tsubtype_diff = ").append(subtypeDiff);
        }
    }

    private void appendBaseDef(StringBuilder sb) {
        sb.append("\n\tINPUT = ").append(inputFunction);
        sb.append(",\n\tOUTPUT = ").append(outputFunction);
        if (PgDiffUtils.isStringNotEmpty(receiveFunction)) {
            sb.append(",\n\tRECEIVE = ").append(receiveFunction);
        }
        if (PgDiffUtils.isStringNotEmpty(sendFunction)) {
            sb.append(",\n\tSEND = ").append(sendFunction);
        }
        if (PgDiffUtils.isStringNotEmpty(typmodInputFunction)) {
            sb.append(",\n\tTYPMOD_IN = ").append(typmodInputFunction);
        }
        if (PgDiffUtils.isStringNotEmpty(typmodOutputFunction)) {
            sb.append(",\n\tTYPMOD_OUT = ").append(typmodOutputFunction);
        }
        if (PgDiffUtils.isStringNotEmpty(analyzeFunction)) {
            sb.append(",\n\tANALYZE = ").append(analyzeFunction);
        }
        if (PgDiffUtils.isStringNotEmpty(internalLength)) {
            sb.append(",\n\tINTERNALLENGTH = ").append(internalLength);
        }
        if (passedByValue) {
            sb.append(",\n\tPASSEDBYVALUE");
        }
        if (PgDiffUtils.isStringNotEmpty(alignment)) {
            sb.append(",\n\tALIGNMENT = ").append(alignment);
        }
        if (PgDiffUtils.isStringNotEmpty(storage)) {
            sb.append(",\n\tSTORAGE = ").append(storage);
        }
        if (PgDiffUtils.isStringNotEmpty(likeType)) {
            sb.append(",\n\tLIKE = ").append(likeType);
        }
        if (PgDiffUtils.isStringNotEmpty(category)) {
            sb.append(",\n\tCATEGORY = ").append(category);
        }
        if (PgDiffUtils.isStringNotEmpty(preferred)) {
            sb.append(",\n\tPREFERRED = ").append(preferred);
        }
        if (PgDiffUtils.isStringNotEmpty(defaultValue)) {
            sb.append(",\n\tDEFAULT = ").append(defaultValue);
        }
        if (PgDiffUtils.isStringNotEmpty(element)) {
            sb.append(",\n\tELEMENT = ").append(element);
        }
        if (PgDiffUtils.isStringNotEmpty(delimiter)) {
            sb.append(",\n\tDELIMITER = ").append(delimiter);
        }
        if (PgDiffUtils.isStringNotEmpty(collatable)) {
            sb.append(",\n\tCOLLATABLE = ").append(collatable);
        }
    }

    @Override
    public String getDropSQL() {
        return "DROP TYPE " + PgDiffUtils.getQuotedName(getContainingSchema().getName()) + '.'
                + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgType newType = (PgType) newCondition;

        if (!equals(newType) && !canAlter(newType)) {
            isNeedDepcies.set(true);
            return true;
        }

        compareAttr(newType, sb, isNeedDepcies);
        columnsComments(newType, sb);
        compareEnums(newType.getEnums(), getEnums(), sb);

        if (!Objects.equals(getOwner(), newType.getOwner())) {
            newType.appendOwnerSQL(sb);
        }
        alterPrivileges(newType, sb);
        if (!Objects.equals(getComment(), newType.getComment())) {
            sb.append("\n\n");
            newType.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    private void compareAttr(PgType newType, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        StringBuilder attrSb = new StringBuilder();
        for (AbstractColumn attr : newType.getAttrs()) {
            AbstractColumn oldAttr = getAttr(attr.getName());
            if (oldAttr == null) {
                isNeedDepcies.set(true);
                attrSb.append("\n\tADD ATTRIBUTE ")
                .append(attr.getName()).append(' ').append(attr.getType());

                if (attr.getCollation() != null) {
                    attrSb.append(" COLLATE ").append(attr.getCollation());
                }

                attrSb.append(", ");
            } else if (!oldAttr.getType().equals(attr.getType()) ||
                    !Objects.equals(attr.getCollation(), oldAttr.getCollation())) {
                isNeedDepcies.set(true);
                attrSb.append("\n\tALTER ATTRIBUTE ")
                .append(PgDiffUtils.getQuotedName(attr.getName()))
                .append(" TYPE ")
                .append(attr.getType());
                if (attr.getCollation() != null) {
                    attrSb.append(" COLLATE ")
                    .append(attr.getCollation());
                }
                attrSb.append(", ");
            }
        }

        for (AbstractColumn attr : getAttrs()) {
            if (newType.getAttr(attr.getName()) == null) {
                isNeedDepcies.set(true);
                attrSb.append("\n\tDROP ATTRIBUTE ")
                .append(PgDiffUtils.getQuotedName(attr.getName()))
                .append(", ");
            }
        }

        if (attrSb.length() > 0) {
            // remove last comma
            attrSb.setLength(attrSb.length() - 2);
            sb.append("\n\nALTER TYPE ")
            .append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.')
            .append(PgDiffUtils.getQuotedName(newType.getName()))
            .append(attrSb).append(';');
        }
    }

    private void compareEnums(List<String> newEnums, List<String> oldEnums,
            StringBuilder sb) {
        for (int i = 0; i < newEnums.size(); ++i) {
            String value = newEnums.get(i);
            if (!oldEnums.contains(value)) {
                sb.append("\n\nALTER TYPE ")
                .append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.')
                .append(PgDiffUtils.getQuotedName(getName()))
                .append("\n\tADD VALUE ").append(value);
                if (i == 0) {
                    sb.append(" BEFORE ").append(oldEnums.get(0));
                } else {
                    sb.append(" AFTER ").append(newEnums.get(i - 1));
                }
                sb.append(';');
            }
        }
    }

    private void columnsComments(PgType newType, StringBuilder sb) {
        for (AbstractColumn newAttr : newType.getAttrs()) {
            AbstractColumn oldAttr = getAttr(newAttr.getName());
            if (oldAttr != null) {
                if (!Objects.equals(oldAttr.getComment(), newAttr.getComment())) {
                    sb.append("\n\n");
                    newAttr.appendCommentSql(sb);
                }
            } else if (PgDiffUtils.isStringNotEmpty(newAttr.getComment())) {
                sb.append("\n\n");
                newAttr.appendCommentSql(sb);
            }
        }
    }

    /**
     * This method assumes that its arguments are not equal.
     */
    private boolean canAlter(PgType newType) {
        if (getForm() != newType.getForm()) {
            return false;
        }
        switch (getForm()) {
        case ENUM:
            Iterator<String> oi = getEnums().iterator();
            Iterator<String> ni = newType.getEnums().iterator();
            while (oi.hasNext()) {
                if (!ni.hasNext()) {
                    // some old members were removed in new, can't alter
                    return false;
                }
                String oldEnum = oi.next();
                if (!oldEnum.equals(ni.next())) {
                    // iterate over new enums until old enum is met or end is reached
                    boolean found = false;
                    while (ni.hasNext()) {
                        if (oldEnum.equals(ni.next())) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        return false; // oldEnum is not in the new list
                    }
                    // order changes will fail this test as they should
                    // consider old:(e1, e2), new:(e2, e1)
                    // we will go over new.e2 while iterating for old.e1
                    // thus we will fail to find new.e2 while iterating for old.e2
                }
            }
            // old list is exhausted at this point and we always return true
            // since we can create new enum members
            return true;
        case COMPOSITE:
            return true;
        default:
            return false;
        }
    }

    @Override
    protected AbstractType getTypeCopy() {
        PgType copy = new PgType(getName(), getForm());
        for (AbstractColumn attr : attrs) {
            copy.addAttr((AbstractColumn) attr.deepCopy());
        }
        copy.enums.addAll(enums);
        copy.setSubtype(getSubtype());
        copy.setSubtypeOpClass(getSubtypeOpClass());
        copy.setCollation(getCollation());
        copy.setCanonical(getCanonical());
        copy.setSubtypeDiff(getSubtypeDiff());
        copy.setInputFunction(getInputFunction());
        copy.setOutputFunction(getOutputFunction());
        copy.setReceiveFunction(getReceiveFunction());
        copy.setSendFunction(getSendFunction());
        copy.setTypmodInputFunction(getTypmodInputFunction());
        copy.setTypmodOutputFunction(getTypmodOutputFunction());
        copy.setAnalyzeFunction(getAnalyzeFunction());
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
        return copy;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgType) {
            PgType type = (PgType) obj;

            return super.compare(type)
                    && form == type.getForm()
                    && attrs.equals(type.attrs)
                    && enums.equals(type.enums)
                    && Objects.equals(subtype, type.getSubtype())
                    && Objects.equals(subtypeOpClass, type.getSubtypeOpClass())
                    && Objects.equals(collation, type.getCollation())
                    && Objects.equals(canonical, type.getCanonical())
                    && Objects.equals(subtypeDiff, type.getSubtypeDiff())
                    && Objects.equals(inputFunction, type.getInputFunction())
                    && Objects.equals(outputFunction, type.getOutputFunction())
                    && Objects.equals(receiveFunction, type.getReceiveFunction())
                    && Objects.equals(sendFunction, type.getSendFunction())
                    && Objects.equals(typmodInputFunction, type.getTypmodInputFunction())
                    && Objects.equals(typmodOutputFunction, type.getTypmodOutputFunction())
                    && Objects.equals(analyzeFunction, type.getAnalyzeFunction())
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

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(form);
        hasher.putOrdered(attrs);
        hasher.put(enums);
        hasher.put(subtype);
        hasher.put(subtypeOpClass);
        hasher.put(collation);
        hasher.put(canonical);
        hasher.put(subtypeDiff);
        hasher.put(inputFunction);
        hasher.put(outputFunction);
        hasher.put(receiveFunction);
        hasher.put(sendFunction);
        hasher.put(typmodInputFunction);
        hasher.put(typmodOutputFunction);
        hasher.put(analyzeFunction);
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
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) this.getParent();
    }
}
