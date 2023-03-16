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

import java.text.MessageFormat;

public interface ICast extends IStatement {

    String CAST_NAME = "{0} AS {1}";

    /**
     * Indicates what contexts the cast can be invoked in.
     */
    public enum CastContext {
        /**
         * explicit cast (using CAST or :: syntax)
         */
        EXPLICIT,
        /**
         * used implicitly in assignment to a target column, as well as explicitly
         */
        ASSIGNMENT,
        /**
         * used implicitly in expressions, as well as the other cases
         */
        IMPLICIT;
    }

    String getSource();
    String getTarget();
    CastContext getContext();

    static String getSimpleName(String source, String target) {
        return MessageFormat.format(CAST_NAME, source, target);
    }
}
