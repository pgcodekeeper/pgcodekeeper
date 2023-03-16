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
import java.util.Collection;
import java.util.stream.Collectors;

import ru.taximaxim.codekeeper.core.schema.PgOverride;

public class LibraryObjectDuplicationException extends RuntimeException {

    private static final String ENTRY = "{0} {1} in {2} conflicts with object in {3}"; //$NON-NLS-1$

    private static final long serialVersionUID = -4197153074585872486L;

    public LibraryObjectDuplicationException() {
        super();
    }

    public LibraryObjectDuplicationException(String message) {
        super(message);
    }

    public LibraryObjectDuplicationException(Throwable cause) {
        super(cause);
    }

    public LibraryObjectDuplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryObjectDuplicationException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public LibraryObjectDuplicationException(Collection<PgOverride> overrides) {
        super("Library conflicts:\n" + overrides.stream() //$NON-NLS-1$
        .map(o -> MessageFormat.format(ENTRY, o.getType(), o.getName(), o.getOldPath(), o.getNewPath()))
        .collect(Collectors.joining("\n"))); //$NON-NLS-1$
    }
}