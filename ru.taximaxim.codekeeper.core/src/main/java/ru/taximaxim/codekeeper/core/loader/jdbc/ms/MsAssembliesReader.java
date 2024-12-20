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
package ru.taximaxim.codekeeper.core.loader.jdbc.ms;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.AbstractStatementReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReaderException;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsAssembly;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsAssembly;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;

public class MsAssembliesReader extends AbstractStatementReader {

    private final MsDatabase db;

    public MsAssembliesReader(JdbcLoaderBase loader, MsDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet res) throws SQLException, XmlReaderException {
        String name = res.getString("name");
        loader.setCurrentObject(new GenericColumn(name, DbObjType.ASSEMBLY));

        MsAssembly ass = new MsAssembly(name);
        for (XmlReader bin : XmlReader.readXML(res.getString("binaries"))) {
            ass.addBinary(CreateMsAssembly.formatBinary(bin.getString("b")));
        }

        ass.setVisible(res.getBoolean("is_visible"));

        int i = res.getInt("permission_set");
        if (i == 2) {
            ass.setPermission("EXTERNAL_ACCESS");
        } else if (i == 3) {
            ass.setPermission("UNSAFE");
        }

        loader.setOwner(ass, res.getString("owner"));
        loader.setPrivileges(ass, XmlReader.readXML(res.getString("acl")));

        db.addAssembly(ass);
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addMsPriviligesPart(builder);
        addMsBinariesPart(builder);
        addMsOwnerPart(builder);

        builder
        .column("res.name")
        .column("res.is_visible")
        .column("res.permission_set")
        .from("sys.assemblies res WITH (NOLOCK)")
        .where("res.is_user_defined = 1");
    }

    private void addMsBinariesPart(QueryBuilder builder) {
        QueryBuilder binaries = new QueryBuilder()
                .column("convert(varchar(max), af.content, 1) b")
                .from("sys.assembly_files af WITH (NOLOCK)")
                .where("res.assembly_id = af.assembly_id")
                .where("af.assembly_id > 65535")
                .postAction("FOR XML RAW, ROOT");

        builder.column("bb.binaries");
        builder.join("CROSS APPLY", binaries, "bb (binaries)");
    }

    @Override
    protected QueryBuilder formatMsPriviliges(QueryBuilder privileges) {
        return privileges
                .where("major_id = res.assembly_id")
                .where("perm.class = 5");
    }
}
