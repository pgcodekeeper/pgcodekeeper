/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;

public final class GpExternalTable extends AbstractPgTable implements PgForeignOptionContainer {

    private boolean isWritable;
    private boolean isWeb;
    private int rejectLimit;
    private String distribution;
    private List<String> urLocation = new ArrayList<>();
    private String exLocation = "ON ALL";
    private String command;
    private String formatType;
    private String formateOptions;
    private String encoding;
    private boolean isRowReject = true;
    private boolean isLogErrors;

    public GpExternalTable(String name) {
        super(name);
    }

    @Override
    public void compareOptions(PgOptionContainer newContainer, StringBuilder sb) {
        // no impl
    }

    @Override
    protected void appendName(StringBuilder sbSQL) {
        sbSQL.append("CREATE ");
        if (isWritable()) {
            sbSQL.append("WRITABLE ");
        }
        sbSQL.append("EXTERNAL ");
        if (isWeb) {
            sbSQL.append("WEB ");
        }
        sbSQL.append("TABLE ").append(getQualifiedName());
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, StringBuilder sbOption) {
        sbSQL.append(" (");
        for (AbstractColumn column : columns) {
            sbSQL.append("\n\t").append(column.getName()).append(" ")
            .append(column.getType()).append(",");
        }

        if (!columns.isEmpty()) {
            sbSQL.setLength(sbSQL.length() - 1);
        }
        sbSQL.append("\n)");
    }

    @Override
    public void appendOptions(StringBuilder sbSQL) {
        sbSQL.append("\n");

        if (command != null) {
            sbSQL.append("EXECUTE ").append(command).append(" ").append(exLocation);
        } else if (!urLocation.isEmpty()) {
            sbSQL.append("LOCATION (");
            for (String loc : urLocation) {
                sbSQL.append("\n").append(loc).append(",");
            }
            sbSQL.setLength(sbSQL.length() - 1);
            sbSQL.append("\n)");
            if (!"ON ALL".equals(exLocation)) {
                sbSQL.append(" ").append(exLocation);
            }
        }

        sbSQL.append("\n").append("FORMAT ").append(formatType);
        if (formateOptions != null) {
            sbSQL.append(" ( ").append(formateOptions).append(" )");
        }

        if (!options.isEmpty()) {
            sbSQL.append("\n");
            PgForeignOptionContainer.super.appendOptions(sbSQL);
        }

        if (encoding != null) {
            sbSQL.append("\n").append("ENCODING ").append(encoding);
        }

        if (rejectLimit > 0) {
            sbSQL.append("\n");
            if (isLogErrors) {
                sbSQL.append("LOG ERRORS ");
            }

            sbSQL.append("SEGMENT REJECT LIMIT ").append(rejectLimit)
            .append(isRowReject ? " ROWS" : " PERCENT");
        }

        if (isWritable && distribution != null) {
            sbSQL.append("\n").append(distribution);
        }

        sbSQL.append(";");
    }


    @Override
    protected void appendAlterOptions(StringBuilder sbSQL) {
        // no impl
    }

    @Override
    protected boolean isNeedRecreate(AbstractTable newTable) {
        return super.isNeedRecreate(newTable)
                || !this.getClass().equals(newTable.getClass())
                || !Objects.equals(getOptions(), newTable.getOptions())
                || !compareExternalOptions((GpExternalTable) newTable);
    }

    @Override
    protected void compareTableTypes(AbstractPgTable newTable, StringBuilder sb) {
        // untransformable
    }

    @Override
    public String getAlterHeader() {
        throw new IllegalStateException("Unsupported operation for EXTERNAL TABLE");
    }

    @Override
    protected String getAlterTable(boolean nextLine, boolean only) {
        StringBuilder sb = new StringBuilder();
        if (nextLine) {
            sb.append("\n\n");
        }
        return sb.append("ALTER EXTERNAL TABLE ").append(getQualifiedName()).toString();
    }

    @Override
    protected AbstractTable getTableCopy() {
        return new GpExternalTable(name);
    }

    @Override
    protected String getTypeName() {
        return "EXTERNAL TABLE";
    }

    public void setWritable(boolean isWritable) {
        this.isWritable = isWritable;
        resetHash();
    }

    public boolean isWritable() {
        return isWritable;
    }

    public void setWeb(boolean isWeb) {
        this.isWeb = isWeb;
        resetHash();
    }

    public boolean isWeb() {
        return isWeb;
    }

    public void setRejectLimit(int rejectLimit) {
        this.rejectLimit = rejectLimit;
        resetHash();
    }

    public int getRejectLimit() {
        return rejectLimit;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
        resetHash();
    }

    public String getDistribution() {
        return distribution;
    }

    public void setUrLocation(List<String> urLocation) {
        this.urLocation = urLocation;
        resetHash();
    }

    public void addUrLocation(String location) {
        urLocation.add(location);
        resetHash();
    }

    public List<String> getUrLocation() {
        return urLocation;
    }

    public void setExLocation(String exLocation) {
        this.exLocation = exLocation;
        resetHash();
    }

    public String getExLocation() {
        return exLocation;
    }

    public void setCommand(String command) {
        this.command = command;
        resetHash();
    }

    public String getCommand() {
        return command;
    }

    public void setFormatType(String formatType) {
        this.formatType = formatType;
        resetHash();
    }

    public String getFormatType() {
        return formatType;
    }

    public void setFormatOptions(String formatOptions) {
        this.formateOptions = formatOptions;
        resetHash();
    }

    public String getFormatOptions() {
        return formateOptions;
    }

    public void setRowReject(boolean isRowReject) {
        this.isRowReject = isRowReject;
        resetHash();
    }

    public boolean isRowReject() {
        return isRowReject;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
        resetHash();
    }

    public String getEncoding() {
        return encoding;
    }

    public void setIsLogErrors(boolean isLogErrors) {
        this.isLogErrors = isLogErrors;
        resetHash();
    }

    public boolean isLogErrors() {
        return isLogErrors;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof GpExternalTable && super.compare(obj)) {
            GpExternalTable table = (GpExternalTable) obj;
            return compareExternalOptions(table);
        }

        return false;
    }

    private boolean compareExternalOptions(GpExternalTable table) {
        return isWritable == table.isWritable()
                && isWeb == table.isWeb()
                && rejectLimit == table.getRejectLimit()
                && Objects.equals(distribution, table.getDistribution())
                && Objects.equals(urLocation, table.getUrLocation())
                && Objects.equals(exLocation, table.getExLocation())
                && Objects.equals(command, table.getCommand())
                && Objects.equals(formatType, table.getFormatType())
                && Objects.equals(formateOptions, table.getFormatOptions())
                && Objects.equals(encoding, table.getEncoding())
                && isRowReject == table.isRowReject()
                && isLogErrors == table.isLogErrors();
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(isWritable);
        hasher.put(isWeb);
        hasher.put(rejectLimit);
        hasher.put(distribution);
        hasher.put(urLocation);
        hasher.put(exLocation);
        hasher.put(command);
        hasher.put(formatType);
        hasher.put(formateOptions);
        hasher.put(encoding);
        hasher.put(isRowReject);
        hasher.put(isLogErrors);
    }

    @Override
    public AbstractTable shallowCopy() {
        GpExternalTable copy = (GpExternalTable) super.shallowCopy();
        copy.setWritable(isWritable());
        copy.setWeb(isWeb());
        copy.setRejectLimit(getRejectLimit());
        copy.setDistribution(getDistribution());
        copy.setUrLocation(getUrLocation());
        copy.setExLocation(getExLocation());
        copy.setCommand(getCommand());
        copy.setFormatType(getFormatType());
        copy.setFormatOptions(getFormatOptions());
        copy.setEncoding(getEncoding());
        copy.setRowReject(isRowReject());
        copy.setIsLogErrors(isLogErrors());
        return copy;
    }

}
