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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Objects;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractView;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class MaterializedPgView extends AbstractPgView {

    private String distribution;
    private String method = Consts.HEAP;
    private String tablespace;
    private boolean isWithData;

    public MaterializedPgView(String name) {
        super(name);
    }

    @Override
    protected void appendOptions(StringBuilder sbSQL) {
        if (!Consts.HEAP.equals(method)) {
            sbSQL.append("\nUSING ").append(PgDiffUtils.getQuotedName(method));
        }

        super.appendOptions(sbSQL);

        if (tablespace != null) {
            sbSQL.append("\nTABLESPACE ").append(tablespace);
        }

        sbSQL.append(" AS\n\t");
        sbSQL.append(query);

        sbSQL.append("\nWITH ");
        if (!isWithData) {
            sbSQL.append("NO ");
        }
        sbSQL.append("DATA");

        if (distribution != null) {
            sbSQL.append("\n").append(distribution);
        }
    }

    @Override
    protected void alterViewOptions(SQLScript script, AbstractPgView newView) {
        MaterializedPgView newMatView = (MaterializedPgView) newView;

        String newSpace = newMatView.tablespace;
        if (!Objects.equals(tablespace, newSpace)) {
            StringBuilder sql = new StringBuilder();
            sql.append(ALTER_TABLE).append(newMatView.getQualifiedName()).append("\n\tSET TABLESPACE ");
            sql.append(newSpace == null ? Consts.PG_DEFAULT : newSpace);
            script.addStatement(sql);
        }

        if (!Objects.equals(isWithData, newMatView.isWithData)) {
            StringBuilder sql = new StringBuilder();
            sql.append("REFRESH MATERIALIZED VIEW ").append(newMatView.getQualifiedName());
            if (!newMatView.isWithData) {
                sql.append(" WITH NO DATA");
            }
            script.addStatement(sql);
        }
    }

    @Override
    protected boolean needDrop(final AbstractPgView newView) {
        if (super.needDrop(newView)) {
            return true;
        }

        var newMatView = (MaterializedPgView) newView;
        return !Objects.equals(method, newMatView.method)
                || !Objects.equals(distribution, newMatView.distribution);
    }

    public void setMethod(String using) {
        this.method = using;
        resetHash();
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
        resetHash();
    }

    @Override
    public String getTypeName() {
        return "MATERIALIZED VIEW";
    }

    public void setIsWithData(final Boolean isWithData) {
        this.isWithData = isWithData;
        resetHash();
    }

    public void setTablespace(final String tablespace) {
        this.tablespace = tablespace;
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MaterializedPgView view && super.compare(obj)) {
            return Objects.equals(isWithData, view.isWithData)
                    && Objects.equals(tablespace, view.tablespace)
                    && Objects.equals(method, view.method)
                    && Objects.equals(distribution, view.distribution);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(isWithData);
        hasher.put(tablespace);
        hasher.put(method);
        hasher.put(distribution);
    }

    @Override
    protected AbstractView getViewCopy() {
        MaterializedPgView view = new MaterializedPgView(name);
        view.setIsWithData(isWithData);
        view.setMethod(method);
        view.setTablespace(tablespace);
        view.setDistribution(distribution);
        return view;
    }
}
