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
package ru.taximaxim.codekeeper.ui;

public class PgCodekeeperUIException extends Exception {

    private static final long serialVersionUID = -1230666490485802474L;

    public PgCodekeeperUIException() {
        super();
    }

    public PgCodekeeperUIException(String message) {
        super(message);
    }

    public PgCodekeeperUIException(Throwable cause) {
        super(cause);
    }

    public PgCodekeeperUIException(String message, Throwable cause) {
        super(message, cause);
    }

    public PgCodekeeperUIException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
