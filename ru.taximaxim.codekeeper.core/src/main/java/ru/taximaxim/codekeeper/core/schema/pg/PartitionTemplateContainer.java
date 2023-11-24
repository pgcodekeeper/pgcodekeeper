package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.hashers.IHashable;
import ru.taximaxim.codekeeper.core.hashers.JavaHasher;

public class PartitionTemplateContainer implements IHashable {

    private static final String SET_SUBPARTITION = "\nSET SUBPARTITION TEMPLATE (";

    private String partitionName;
    private final List<String> subElements = new ArrayList<>();
    private final List<String> normalizedSubElements = new ArrayList<>();

    public void setSubElems(String subElement, String normalizedSubElement) {
        this.subElements.add(subElement);
        this.normalizedSubElements.add(normalizedSubElement);
    }

    public PartitionTemplateContainer(String partitionName) {
        this.partitionName = partitionName;
    }

    public String getPartitionName() {
        return partitionName;
    }

    public boolean hasSubElements() {
        return !subElements.isEmpty();
    }

    public void appendCreateSQL(StringBuilder sb) {
        appendPartitionName(sb);
        sb.append(SET_SUBPARTITION).append("\n");
        appendTemplateOptions(sb);
    }

    public void appendDropSql(StringBuilder sb) {
        appendPartitionName(sb);
        sb.append(SET_SUBPARTITION).append(");");
    }

    private void appendPartitionName(StringBuilder sbSQL) {
        if (partitionName != null) {
            sbSQL.append(" ALTER PARTITION ").append(partitionName);
        }
    }

    protected void appendTemplateOptions(StringBuilder sbSQL) {
        for (var elem : subElements) {
            sbSQL.append("  ").append(elem).append(",").append("\n");
        }
        sbSQL.setLength(sbSQL.length() - 2);
        sbSQL.append("\n");
        sbSQL.append(");");
    }

    @Override
    public int hashCode() {
        JavaHasher hasher = new JavaHasher();
        computeHash(hasher);
        return hasher.getResult();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(partitionName);
        hasher.put(normalizedSubElements);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PartitionTemplateContainer) {
            PartitionTemplateContainer template = (PartitionTemplateContainer) obj;
            return Objects.equals(partitionName, template.partitionName)
                    && PgDiffUtils.setlikeEquals(normalizedSubElements, template.normalizedSubElements);
        }

        return false;
    }
}
