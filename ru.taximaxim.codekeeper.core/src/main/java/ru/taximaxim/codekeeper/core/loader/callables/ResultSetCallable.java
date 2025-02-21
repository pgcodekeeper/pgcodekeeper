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
package ru.taximaxim.codekeeper.core.loader.callables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetCallable extends StatementCallable<ResultSet> {

    public ResultSetCallable(PreparedStatement st) {
        super(st, null);
    }

    public ResultSetCallable(Statement st, String script) {
        super(st, script);
    }

    @Override
    public ResultSet call() throws Exception {
        if (st instanceof PreparedStatement ps) {
            return ps.executeQuery();
        }

        return st.executeQuery(script);
    }
}
