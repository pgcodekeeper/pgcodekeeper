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
package ru.taximaxim.codekeeper.ui.propertytests;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.pgcodekeeper.core.model.difftree.DbObjType;

import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class MockDataPropertyTester extends PropertyTester {

    @Override
    public boolean test(Object receiver, String property, Object[] args,
            Object expectedValue) {
        IFile file = (IFile) receiver;
        return PgDbParser.getParser(file)
                .getDefsForPath(file.getLocation().toOSString())
                .stream()
                .anyMatch(e -> e.getStatementType() == DbObjType.TABLE);
    }
}