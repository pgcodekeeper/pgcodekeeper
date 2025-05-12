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
package ru.taximaxim.codekeeper.core.parsers.antlr;

import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class CustomAntlrErrorListener extends BaseErrorListener {

    private static final Logger LOG = LoggerFactory.getLogger(CustomAntlrErrorListener.class);

    private final String parsedObjectName;
    private final List<Object> errors;
    private final int offset;
    private final int lineOffset;
    private final int inLineOffset;

    CustomAntlrErrorListener(String parsedObjectName, List<Object> errors,
            int offset, int lineOffset, int inLineOffset) {
        this.parsedObjectName = parsedObjectName;
        this.errors = errors;
        this.offset = offset;
        this.lineOffset = lineOffset;
        this.inLineOffset = inLineOffset;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
            int line, int charPositionInLine, String msg, RecognitionException e) {
        Token token = offendingSymbol instanceof Token t ? t : null;
        AntlrError error = new AntlrError(token, parsedObjectName, line, charPositionInLine, msg)
            .copyWithOffset(offset, lineOffset, inLineOffset);

        LOG.warn("ANTLR Error:\n{}", error);
        if (errors != null) {
            errors.add(error);
        }
    }
}