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
package ru.taximaxim.codekeeper.core.loader.callables;

import java.sql.PreparedStatement;
import java.sql.Statement;

import ru.taximaxim.codekeeper.core.Consts;

public class QueryCallable extends StatementCallable<String> {

    public QueryCallable(PreparedStatement st) {
        super(st, null);
    }

    public QueryCallable(Statement st, String script) {
        super(st, script);
    }

    @Override
    public String call() throws Exception {
        if (st instanceof PreparedStatement) {
            ((PreparedStatement)st).execute();
        } else {
            st.execute(script);
        }
        return Consts.JDBC_SUCCESS;
    }
}
