/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.schema.ms;

import java.util.stream.Collectors;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractFunction;
import ru.taximaxim.codekeeper.core.schema.ArgMode;
import ru.taximaxim.codekeeper.core.schema.Argument;

public class MsClrProcedure extends AbstractMsClrFunction {

    public MsClrProcedure(String name, String assembly, String assemblyClass,
            String assemblyMethod) {
        super(name, assembly, assemblyClass, assemblyMethod);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.PROCEDURE;
    }

    @Override
    protected void appendFunctionFullSQL(StringBuilder sbSQL, boolean isCreate) {
        sbSQL.append("SET QUOTED_IDENTIFIER OFF").append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS OFF").append(GO).append('\n');
        sbSQL.append(isCreate ? "CREATE" : "ALTER");
        sbSQL.append(" PROCEDURE ");
        sbSQL.append(getQualifiedName()).append('\n');

        if (!arguments.isEmpty()) {
            sbSQL.append(arguments.stream().map(arg -> getDeclaration(arg, true, true))
                    .collect(Collectors.joining(",\n"))).append('\n');
        }

        if (!options.isEmpty()) {
            sbSQL.append("WITH ").append(String.join(", ", options)).append('\n');
        }

        sbSQL.append("AS\nEXTERNAL NAME ");
        sbSQL.append(MsDiffUtils.quoteName(getAssembly())).append('.');
        sbSQL.append(MsDiffUtils.quoteName(getAssemblyClass())).append('.');
        sbSQL.append(MsDiffUtils.quoteName(getAssemblyMethod()));
        sbSQL.append(GO);
    }

    @Override
    public boolean needDrop(AbstractFunction newFunction) {
        return newFunction instanceof MsProcedure;
    }

    @Override
    public String getDeclaration(Argument arg, boolean includeDefaultValue,
            boolean includeArgName) {
        final StringBuilder sbString = new StringBuilder();

        String name = arg.getName();
        if (name != null && !name.isEmpty() && includeArgName) {
            sbString.append(name);
            sbString.append(' ');
        }

        sbString.append(arg.getDataType());

        String def = arg.getDefaultExpression();

        if (includeDefaultValue && def != null && !def.isEmpty()) {
            sbString.append(" = ");
            sbString.append(def);
        }

        ArgMode mode = arg.getMode();
        if (ArgMode.IN != mode) {
            sbString.append(' ').append(mode);
        }

        if (arg.isReadOnly()) {
            sbString.append(" READONLY");
        }

        return sbString.toString();
    }

    @Override
    protected MsClrProcedure getFunctionCopy() {
        return new MsClrProcedure(getName(), getAssembly(),
                getAssemblyClass(), getAssemblyMethod());
    }
}
