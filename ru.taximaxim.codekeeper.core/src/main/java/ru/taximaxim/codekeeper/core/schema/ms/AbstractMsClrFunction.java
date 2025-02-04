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
package ru.taximaxim.codekeeper.core.schema.ms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractFunction;
import ru.taximaxim.codekeeper.core.schema.Argument;

public abstract class AbstractMsClrFunction extends AbstractFunction {

    protected final List<String> options = new ArrayList<>();
    protected final String assembly;
    protected final String assemblyClass;
    protected final String assemblyMethod;

    protected AbstractMsClrFunction(String name, String assembly, String assemblyClass,
            String assemblyMethod) {
        super(name);
        this.assembly = assembly;
        this.assemblyClass = assemblyClass;
        this.assemblyMethod = assemblyMethod;
    }

    protected abstract String getDeclaration(Argument arg,
            boolean includeDefaultValue, boolean includeArgName);

    public void addOption(final String option) {
        options.add(option);
        resetHash();
    }

    @Override
    protected boolean compareUnalterable(AbstractFunction function) {
        if (function instanceof AbstractMsClrFunction func && super.compareUnalterable(function)) {
            return Objects.equals(assembly, func.assembly)
                    && Objects.equals(assemblyClass, func.assemblyClass)
                    && Objects.equals(assemblyMethod, func.assemblyMethod)
                    && options.equals(func.options);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(options);
        hasher.put(assembly);
        hasher.put(assemblyClass);
        hasher.put(assemblyMethod);
    }

    @Override
    public AbstractMsClrFunction shallowCopy() {
        AbstractMsClrFunction functionDst = (AbstractMsClrFunction) super.shallowCopy();
        functionDst.options.addAll(options);
        return functionDst;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }
}
