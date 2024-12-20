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
package ru.taximaxim.codekeeper.core.parsers.antlr.exception;

import org.antlr.v4.runtime.Token;

public class MisplacedObjectException extends UnresolvedReferenceException {

    private static final long serialVersionUID = -8377509522524043609L;

    public MisplacedObjectException(Token errorToken) {
        super(errorToken);
    }

    public MisplacedObjectException(Throwable cause, Token errorToken) {
        super(cause, errorToken);
    }

    public MisplacedObjectException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace, Token errorToken) {
        super(message, cause, enableSuppression, writableStackTrace, errorToken);
    }

    public MisplacedObjectException(String format, Token errToken) {
        super(format, errToken);
    }
}
