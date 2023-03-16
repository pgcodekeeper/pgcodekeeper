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

import java.util.List;
import java.util.Objects;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import ru.taximaxim.codekeeper.core.ContextLocation;
import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;

public class PgObjLocation extends ContextLocation {

    private static final long serialVersionUID = 4428608117292420935L;

    public enum LocationType {
        DEFINITION,
        REFERENCE,
        VARIABLE,
        LOCAL_REF
    }

    private DangerStatement danger;

    private final int length;
    private final String action;
    private final String sql;
    private final String alias;
    private final GenericColumn obj;
    private final LocationType locationType;

    private PgObjLocation(String filePath, int offset, int lineNumber,
            int charPositionInLine, GenericColumn obj, String action,
            String sql, String alias, int length, LocationType locationType) {
        super(filePath, offset, lineNumber, charPositionInLine);
        this.obj = obj;
        this.sql = sql;
        this.action = action;
        this.length = length;
        this.locationType = locationType;
        this.alias = alias;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof PgObjLocation) {
            PgObjLocation loc = (PgObjLocation) obj;
            return Objects.equals(loc.getObj(), getObj())
                    && Objects.equals(loc.getSql(), getSql())
                    && Objects.equals(loc.getAction(), getAction());

        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (obj == null ? 0 : obj.hashCode());
        result = prime * result + ((getSql() == null) ? 0 : getSql().hashCode());
        result = prime * result + ((getAction() == null) ? 0 : getAction().hashCode());
        return result;
    }

    public void setWarning(DangerStatement danger) {
        this.danger = danger;
    }

    public boolean isDanger() {
        return danger != null;
    }

    public DangerStatement getDanger() {
        return danger;
    }

    public GenericColumn getObj() {
        return obj;
    }

    public int getObjLength() {
        return length;
    }

    public String getAction() {
        return action;
    }

    public String getSql() {
        return sql;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public boolean isGlobal() {
        return locationType == LocationType.DEFINITION || locationType == LocationType.REFERENCE;
    }

    public String getObjName() {
        return obj != null ? obj.getObjName() : "";
    }

    public String getSchema() {
        return obj == null ? null : obj.schema;
    }

    public String getTable() {
        return obj == null ? null : obj.table;
    }

    public DbObjType getType() {
        return obj == null ? null : obj.type;
    }

    public String getQualifiedName() {
        return obj == null ? null : obj.getQualifiedName();
    }

    /**
     * @return name stripped of arguments for function signatures
     */
    public String getBareName() {
        if (alias != null) {
            return alias;
        }
        String objName = getObjName();
        switch (obj.type) {
            case FUNCTION:
            case PROCEDURE:
            case AGGREGATE:
                break;
            default:
                return objName;
        }
        if (objName.indexOf('(') == -1) {
            return objName;
        }
        SQLParser p = AntlrParser.makeBasicParser(SQLParser.class, objName, "function signature");
        List<ParserRuleContext> ids = ParserAbstract.getIdentifiers(p.function_args_parser().schema_qualified_name());
        return QNameParser.getFirstName(ids);
    }

    public final boolean compare(PgObjLocation loc) {
        if (isGlobal() != loc.isGlobal() || !Objects.equals(alias, loc.alias)) {
            return false;
        }

        GenericColumn col = loc.getObj();
        if (obj == null || col == null) {
            return false;
        }
        return compareTypes(col.type)
                && Objects.equals(obj.schema, col.schema)
                && Objects.equals(obj.column, col.column)
                && Objects.equals(obj.table, col.table);
    }

    private boolean compareTypes(DbObjType objType) {
        DbObjType type = obj.type;
        if (type == objType) {
            return true;
        }

        switch (objType) {
            case TABLE:
            case VIEW:
            case SEQUENCE:
                return type == DbObjType.TABLE || type == DbObjType.VIEW || type == DbObjType.SEQUENCE;
            case FUNCTION:
            case AGGREGATE:
            case PROCEDURE:
                return type == DbObjType.FUNCTION || type == DbObjType.AGGREGATE || type == DbObjType.PROCEDURE;
            case TYPE:
            case DOMAIN:
                return type == DbObjType.TYPE || type == DbObjType.DOMAIN;
            default:
                return false;
        }
    }

    public PgObjLocation copyWithOffset(int offset, int lineOffset,
            int inLineOffset, String filePath) {
        int newCharPosition = getLineNumber() == 1 ? getCharPositionInLine() + inLineOffset : getCharPositionInLine();
        PgObjLocation loc = new PgObjLocation(filePath,
                getOffset() + offset,
                getLineNumber() + lineOffset,
                newCharPosition,
                obj, action, sql, alias, length, locationType);
        loc.setWarning(danger);
        return loc;
    }

    @Override
    public String toString() {
        GenericColumn gc = getObj();
        if (gc != null) {
            return gc.toString();
        }

        return super.toString();
    }

    public static final class Builder {

        private String filePath;
        private String action;
        private String sql;
        private String alias;
        private int offset;
        private int lineNumber;
        private int charPositionInLine;
        private GenericColumn object;
        private ParserRuleContext ctx;
        private ParserRuleContext endCtx;
        private LocationType locationType = LocationType.REFERENCE;

        public Builder setFilePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public Builder setAction(String action) {
            this.action = action;
            return this;
        }

        public Builder setSql(String sql) {
            this.sql = sql;
            return this;
        }

        public Builder setAlias(String alias) {
            this.alias = alias;
            return this;
        }

        public Builder setOffset(int offset) {
            this.offset = offset;
            return this;
        }

        public Builder setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
            return this;
        }

        public Builder setCharPositionInLine(int charPositionInLine) {
            this.charPositionInLine = charPositionInLine;
            return this;
        }

        public Builder setObject(GenericColumn object) {
            this.object = object;
            return this;
        }

        public Builder setCtx(ParserRuleContext ctx) {
            this.ctx = ctx;
            return this;
        }

        public Builder setEndCtx(ParserRuleContext endCtx) {
            this.endCtx = endCtx;
            return this;
        }

        public Builder setLocationType(LocationType locationType) {
            this.locationType = locationType;
            return this;
        }

        public PgObjLocation build() {
            if (ctx != null) {
                Token start = ctx.getStart();
                int offset = start.getStartIndex();
                int line = start.getLine();
                int position = start.getCharPositionInLine();
                Token stop = (endCtx != null ? endCtx : ctx).getStop();
                int length =  stop.getStopIndex() - offset + 1;
                return new PgObjLocation(filePath, offset, line, position,
                        object, action, sql, alias, length, locationType);
            }

            int length =  object == null ? 0 : object.getObjName().length();
            return new PgObjLocation(filePath, offset, lineNumber, charPositionInLine,
                    object, action, sql, alias, length, locationType);
        }
    }
}
