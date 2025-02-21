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

public final class MonitorCancelledRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1305941709453867664L;

    public MonitorCancelledRuntimeException() {
        super();
    }

    public MonitorCancelledRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MonitorCancelledRuntimeException(String message) {
        super(message);
    }

    public MonitorCancelledRuntimeException(Throwable cause) {
        super(cause);
    }
}