package cz.startnet.utils.pgdiff.schema;

import java.util.Map.Entry;
import java.util.Objects;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;

/**
 * Base MS SQL table class
 *
 * @author galiev_mr
 *
 */
public class SimpleMsTable extends RegularPgTable {

    private String textImage;
    private String fileStream;

    public SimpleMsTable(String name, String rawStatement) {
        super(name, rawStatement);
        setPostgres(false);
    }

    @Override
    public String getQualifiedName() {
        return MsDiffUtils.getQuotedName(getContainingSchema().getName()) + '.' + MsDiffUtils.getQuotedName(name);
    }

    @Override
    protected void convertTable(StringBuilder sb) {
        // no implements
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, StringBuilder sbOption) {
        sbSQL.append("\n(\n");

        int start = sbSQL.length();
        for (PgColumn column : columns) {
            writeColumn(column, sbSQL, sbOption);
        }

        if (start != sbSQL.length()) {
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append('\n');
        }

        sbSQL.append(')');
    }

    @Override
    protected void appendOptions(StringBuilder sbSQL) {
        if (tablespace != null) {
            sbSQL.append("ON ").append(tablespace).append("\n");
        }

        if (getTextImage() != null) {
            sbSQL.append("TEXTIMAGE_ON ").append(getTextImage()).append("\n");
        }

        if (getFileStream() != null) {
            sbSQL.append("FILESTREAM_ON ").append(getFileStream()).append("\n");
        }

        StringBuilder sb = new StringBuilder();
        for (Entry <String, String> entry : options.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            sb.append(key);
            if (!value.isEmpty()) {
                sb.append('=').append(value);
            }
            sb.append(", ");
        }

        if (sb.length() > 0){
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nWITH (").append(sb).append(")");
        }


        sbSQL.append(GO);
    }


    @Override
    protected void compareTableTypes(PgTable newTable, StringBuilder sb) {
        // no implements
    }

    @Override
    protected SimpleMsTable getTableCopy() {
        SimpleMsTable table = new SimpleMsTable(name, getRawStatement());
        table.setFileStream(getFileStream());
        table.setTextImage(getTextImage());
        return table;
    }

    @Override
    public String getDropSQL() {
        return "DROP TABLE " + getQualifiedName() + GO;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof SimpleMsTable && super.compare(obj)) {
            SimpleMsTable table = (SimpleMsTable) obj;
            return Objects.equals(textImage, table.getTextImage())
                    && Objects.equals(fileStream, table.getFileStream());
        }

        return false;
    }

    @Override
    protected String getAlterTable(boolean nextLine, boolean only) {
        StringBuilder sb = new StringBuilder();
        if (nextLine) {
            sb.append("\n\n");
        }
        sb.append("ALTER TABLE ");
        sb.append(MsDiffUtils.getQuotedName(getName()));
        return sb.toString();
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(getTextImage());
        hasher.put(getFileStream());
    }

    public String getFileStream() {
        return fileStream;
    }

    public void setFileStream(String fileStream) {
        this.fileStream = fileStream;
        resetHash();
    }

    public String getTextImage() {
        return textImage;
    }

    public void setTextImage(String textImage) {
        this.textImage = textImage;
        resetHash();
    }
}
