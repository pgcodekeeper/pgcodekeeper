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
package ru.taximaxim.codekeeper.core;

import java.io.Serializable;
import java.util.Objects;

public abstract class ContextLocation implements Serializable {

    private static final long serialVersionUID = -7001017512350210951L;

    private final String filePath;
    private final int offset;
    private final int lineNumber;
    private final int charPositionInLine;

    protected ContextLocation(String filePath, int offset, int lineNumber, int charPositionInLine) {
        this.filePath = filePath;
        this.offset = offset;
        this.lineNumber = lineNumber;
        this.charPositionInLine = charPositionInLine;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getOffset() {
        return offset;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getCharPositionInLine() {
        return charPositionInLine;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContextLocation loc) {
            return Objects.equals(loc.getFilePath(), getFilePath())
                    && getOffset() == loc.getOffset()
                    && getLineNumber() == loc.getLineNumber()
                    && getCharPositionInLine() == loc.getCharPositionInLine();

        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + getOffset();
        result = prime * result + getLineNumber();
        result = prime * result + getCharPositionInLine();
        return result;
    }
}
