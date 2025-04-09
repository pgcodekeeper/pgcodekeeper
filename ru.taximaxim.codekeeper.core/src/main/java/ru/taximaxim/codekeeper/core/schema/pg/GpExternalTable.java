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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.IForeignTable;
import ru.taximaxim.codekeeper.core.schema.IOptionContainer;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public final class GpExternalTable extends AbstractPgTable implements PgForeignOptionContainer, IForeignTable {

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
    public void compareOptions(IOptionContainer newContainer, SQLScript script) {
        // no impl
    }

    @Override
    protected void appendName(StringBuilder sbSQL, ISettings settings) {
        sbSQL.append("CREATE ");
        if (isWritable) {
            sbSQL.append("WRITABLE ");
        }
        sbSQL.append("EXTERNAL ");
        if (isWeb) {
            sbSQL.append("WEB ");
        }
        sbSQL.append("TABLE ").append(getQualifiedName());
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, SQLScript script) {
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
    }


    @Override
    protected void appendAlterOptions(SQLScript script) {
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
    protected void compareTableTypes(AbstractPgTable newTable, SQLScript script) {
        // untransformable
    }

    @Override
    public String getAlterHeader() {
        throw new IllegalStateException("Unsupported operation for EXTERNAL TABLE");
    }

    @Override
    public String getAlterTable(boolean only) {
        return "ALTER EXTERNAL TABLE " + getQualifiedName();
    }

    @Override
    protected AbstractTable getTableCopy() {
        return new GpExternalTable(name);
    }

    @Override
    public String getTypeName() {
        return "EXTERNAL TABLE";
    }

    public void setWritable(boolean isWritable) {
        this.isWritable = isWritable;
        resetHash();
    }

    public void setWeb(boolean isWeb) {
        this.isWeb = isWeb;
        resetHash();
    }

    public void setRejectLimit(int rejectLimit) {
        this.rejectLimit = rejectLimit;
        resetHash();
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
        resetHash();
    }

    public void setUrLocation(List<String> urLocation) {
        this.urLocation = urLocation;
        resetHash();
    }

    public void addUrLocation(String location) {
        urLocation.add(location);
        resetHash();
    }

    public void setExLocation(String exLocation) {
        this.exLocation = exLocation;
        resetHash();
    }

    public void setCommand(String command) {
        this.command = command;
        resetHash();
    }

    public void setFormatType(String formatType) {
        this.formatType = formatType;
        resetHash();
    }

    public void setFormatOptions(String formatOptions) {
        this.formateOptions = formatOptions;
        resetHash();
    }

    public void setRowReject(boolean isRowReject) {
        this.isRowReject = isRowReject;
        resetHash();
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
        resetHash();
    }

    public void setIsLogErrors(boolean isLogErrors) {
        this.isLogErrors = isLogErrors;
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof GpExternalTable table && super.compare(obj)) {
            return compareExternalOptions(table);
        }

        return false;
    }

    private boolean compareExternalOptions(GpExternalTable table) {
        return isWritable == table.isWritable
                && isWeb == table.isWeb
                && rejectLimit == table.rejectLimit
                && Objects.equals(distribution, table.distribution)
                && Objects.equals(urLocation, table.urLocation)
                && Objects.equals(exLocation, table.exLocation)
                && Objects.equals(command, table.command)
                && Objects.equals(formatType, table.formatType)
                && Objects.equals(formateOptions, table.formateOptions)
                && Objects.equals(encoding, table.encoding)
                && isRowReject == table.isRowReject
                && isLogErrors == table.isLogErrors;
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
        copy.setWritable(isWritable);
        copy.setWeb(isWeb);
        copy.setRejectLimit(rejectLimit);
        copy.setDistribution(distribution);
        copy.setUrLocation(urLocation);
        copy.setExLocation(exLocation);
        copy.setCommand(command);
        copy.setFormatType(formatType);
        copy.setFormatOptions(formateOptions);
        copy.setEncoding(encoding);
        copy.setRowReject(isRowReject);
        copy.setIsLogErrors(isLogErrors);
        return copy;
    }

    @Override
    public void appendMoveDataSql(PgStatement newCondition, SQLScript script, String tblTmpBareName,
            List<String> identityCols) {
        // no impl
    }
}
