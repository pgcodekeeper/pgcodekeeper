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
    private boolean ansiNulls;
    private boolean quotedIdentified = true;

    public SimpleMsTable(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    protected void convertTable(StringBuilder sb) {
        // no implements
    }

    @Override
    protected void appendName(StringBuilder sbSQL) {
        sbSQL.append("SET QUOTED_IDENTIFIER ").append(quotedIdentified ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(ansiNulls ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');

        super.appendName(sbSQL);
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, StringBuilder sbOption) {
        sbSQL.append("(\n");

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
            sbSQL.append(" ON ").append(MsDiffUtils.quoteName(tablespace)).append("\n");
        }

        if (getTextImage() != null) {
            sbSQL.append("TEXTIMAGE_ON ").append(MsDiffUtils.quoteName(getTextImage())).append("\n");
        }

        if (getFileStream() != null) {
            sbSQL.append("FILESTREAM_ON ").append(MsDiffUtils.quoteName(getFileStream())).append("\n");
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
    protected boolean isNeedRecreate(PgTable newTable) {
        return  !(newTable instanceof SimpleMsTable)
                || !Objects.equals(((SimpleMsTable)newTable).getTablespace(), getTablespace())
                || !Objects.equals(((SimpleMsTable)newTable).getTextImage(), getTextImage())
                || !Objects.equals(((SimpleMsTable)newTable).getFileStream(), getFileStream());
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
        table.setQuotedIdentified(isQuotedIdentified());
        table.setAnsiNulls(isAnsiNulls());
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
                    && Objects.equals(fileStream, table.getFileStream())
                    && Objects.equals(quotedIdentified, table.isQuotedIdentified())
                    && Objects.equals(ansiNulls, table.isAnsiNulls());
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
        sb.append(MsDiffUtils.quoteName(getName()));
        return sb.toString();
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(getTextImage());
        hasher.put(getFileStream());
        hasher.put(isQuotedIdentified());
        hasher.put(isAnsiNulls());
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

    public void setAnsiNulls(boolean ansiNulls) {
        this.ansiNulls = ansiNulls;
        resetHash();
    }

    public boolean isAnsiNulls() {
        return ansiNulls;
    }

    public void setQuotedIdentified(boolean quotedIdentified) {
        this.quotedIdentified = quotedIdentified;
        resetHash();
    }

    public boolean isQuotedIdentified() {
        return quotedIdentified;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }
}
