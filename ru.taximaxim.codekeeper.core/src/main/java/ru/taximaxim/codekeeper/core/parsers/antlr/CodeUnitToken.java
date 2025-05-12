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

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Pair;

public class CodeUnitToken extends CommonToken {

    private static final long serialVersionUID = -7656354484680429471L;

    private int codeUnitStart;
    private int codeUnitStop;
    private int codeUnitPositionInLine;

    public CodeUnitToken(Pair<TokenSource, CharStream> source, int type, int channel, int start, int stop,
            int codeUnitStart, int codeUnitStop, int codeUnitPositionInLine) {
        super(source, type, channel, start, stop);
        this.codeUnitStart = codeUnitStart;
        this.codeUnitStop = codeUnitStop;
        this.codeUnitPositionInLine = codeUnitPositionInLine;
    }

    public CodeUnitToken(CodeUnitToken oldToken) {
        super(oldToken);
        this.codeUnitStart = oldToken.codeUnitStart;
        this.codeUnitStop = oldToken.codeUnitStop;
        this.codeUnitPositionInLine = oldToken.codeUnitPositionInLine;
    }

    public int getCodeUnitStart() {
        return codeUnitStart;
    }

    public int getCodeUnitStop() {
        return codeUnitStop;
    }

    public int getCodeUnitPositionInLine() {
        return codeUnitPositionInLine;
    }

    public void setCodeUnitStart(int codeUnitStart) {
        this.codeUnitStart = codeUnitStart;
    }

    public void setCodeUnitStop(int codeUnitStop) {
        this.codeUnitStop = codeUnitStop;
    }

    public void setCodeUnitPositionInLine(int codeUnitPositionInLine) {
        this.codeUnitPositionInLine = codeUnitPositionInLine;
    }
}