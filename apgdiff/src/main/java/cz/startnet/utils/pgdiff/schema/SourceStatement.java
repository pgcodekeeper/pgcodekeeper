package cz.startnet.utils.pgdiff.schema;

/**
 * A statement that is represented only by its full source code
 * separated in two parts by CREATE ZZZZ schema.name
 */
public interface SourceStatement extends ISearchPath {

    String getFirstPart();
    void setFirstPart(String firstPart);
    String getSecondPart();
    void setSecondPart(String secondPart);

    /**
     * Assembles entire statement from source parts
     * @param isCreate do CREATE or ALTER
     */
    default StringBuilder appendSourceStatement(boolean isCreate, StringBuilder sb) {
        sb.append(getFirstPart())
        .append(isCreate ? "CREATE " : "ALTER ")
        .append(getStatementType())
        .append(' ');
        appendName(sb)
        .append(getSecondPart());
        return sb;
    }

    /**
     * Appends the only normalized statement part: its name and location,
     * always qualifies and quotes.
     */
    default StringBuilder appendName(StringBuilder sb) {
        return sb.append(getQualifiedName());
    }
}
