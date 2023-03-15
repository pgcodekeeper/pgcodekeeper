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
package ru.taximaxim.codekeeper.core.parsers.antlr.exception;

import java.text.MessageFormat;

import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class ObjectCreationException extends RuntimeException {

    private static final String WITHOUT_PARENT = "{0} {1} already exists"; //$NON-NLS-1$
    private static final String WITH_PARENT = "{0} {1} already exists for {2} {3}"; //$NON-NLS-1$

    private static final long serialVersionUID = -8514537124804597343L;

    public ObjectCreationException() {
        super();
    }

    public ObjectCreationException(String message) {
        super(message);
    }

    public ObjectCreationException(Throwable cause) {
        super(cause);
    }

    public ObjectCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectCreationException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ObjectCreationException(PgStatement st) {
        super(MessageFormat.format(WITHOUT_PARENT, st.getStatementType(), st.getName()));
    }

    public ObjectCreationException(PgStatement st, PgStatement parent) {
        super(MessageFormat.format(WITH_PARENT, st.getStatementType(), st.getName(),
                parent.getStatementType(), parent.getName()));
    }
}
