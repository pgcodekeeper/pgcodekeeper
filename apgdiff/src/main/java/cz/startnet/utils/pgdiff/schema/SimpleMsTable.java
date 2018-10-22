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
public class SimpleMsTable extends AbstractRegularTable {

    private String textImage;
    private String fileStream;
    private boolean ansiNulls;
    private Boolean isTracked;

    public SimpleMsTable(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    protected void convertTable(StringBuilder sb) {
        // no implements
    }

    @Override
    protected void appendAlterOptions(StringBuilder sbSQL) {
        if (isTracked != null) {
            enableTracking(sbSQL);
        }
    }

    @Override
    protected void appendName(StringBuilder sbSQL) {
        sbSQL.append("SET QUOTED_IDENTIFIER ON").append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(ansiNulls ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');

        super.appendName(sbSQL);
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, StringBuilder sbOption) {
        sbSQL.append("(\n");

        int start = sbSQL.length();
        for (AbstractColumn column : columns) {
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
        int startLenght = sbSQL.length();
        if (tablespace != null) {
            // tablespace already quoted
            sbSQL.append(" ON ").append(tablespace).append(' ');
        }

        if (getTextImage() != null) {
            sbSQL.append("TEXTIMAGE_ON ").append(MsDiffUtils.quoteName(getTextImage())).append(' ');
        }

        if (getFileStream() != null) {
            sbSQL.append("FILESTREAM_ON ").append(MsDiffUtils.quoteName(getFileStream())).append(' ');
        }

        if (sbSQL.length() > startLenght) {
            sbSQL.setLength(sbSQL.length() - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Entry <String, String> entry : options.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            sb.append(key);
            if (!value.isEmpty()) {
                sb.append(" = ").append(value);
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
    protected boolean isNeedRecreate(AbstractTable newTable) {
        if (newTable instanceof SimpleMsTable) {
            SimpleMsTable smt = (SimpleMsTable) newTable;
            return !Objects.equals(smt.getTablespace(), getTablespace())
                    || !Objects.equals(smt.getOptions(), getOptions())
                    || !Objects.equals(smt.getFileStream(), getFileStream())
                    || (smt.getTextImage() != null && getTextImage() != null
                        && !Objects.equals(smt.getTextImage(), getTextImage()));
        }

        return true;
    }

    @Override
    protected void compareTableTypes(AbstractTable newTable, StringBuilder sb) {
        // no implements
    }

    @Override
    protected void compareTableOptions(AbstractTable table, StringBuilder sb) {
        SimpleMsTable newTable = (SimpleMsTable) table;
        if (!Objects.equals(isTracked, newTable.isTracked())) {
            if (newTable.isTracked() == null) {
                sb.append(getAlterTable(true, false));
                sb.append(" DISABLE CHANGE_TRACKING").append(GO);
            } else if (isTracked == null) {
                newTable.enableTracking(sb);
            } else {
                sb.append(getAlterTable(true, false));
                sb.append(" DISABLE CHANGE_TRACKING").append(GO);
                newTable.enableTracking(sb);
            }
        }
    }

    private void enableTracking(StringBuilder sb) {
        sb.append(getAlterTable(true, false));
        sb.append(" ENABLE CHANGE_TRACKING WITH (TRACK_COLUMNS_UPDATED = ");
        sb.append(isTracked() ? "ON" : "OFF").append(')').append(GO);
    }

    @Override
    protected SimpleMsTable getTableCopy() {
        SimpleMsTable table = new SimpleMsTable(name, getRawStatement());
        table.setFileStream(getFileStream());
        table.setTextImage(getTextImage());
        table.setAnsiNulls(isAnsiNulls());
        table.setTracked(isTracked());
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
                    && Objects.equals(ansiNulls, table.isAnsiNulls())
                    && Objects.equals(isTracked, table.isTracked());
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
        sb.append(getQualifiedName());
        return sb.toString();
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(getTextImage());
        hasher.put(getFileStream());
        hasher.put(isAnsiNulls());
        hasher.put(isTracked());
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

    public Boolean isTracked() {
        return isTracked;
    }

    public void setTracked(final Boolean isTracked) {
        this.isTracked = isTracked;
        resetHash();
    }

    @Override
    public boolean isPostgres() {
        return false;
    }
}
