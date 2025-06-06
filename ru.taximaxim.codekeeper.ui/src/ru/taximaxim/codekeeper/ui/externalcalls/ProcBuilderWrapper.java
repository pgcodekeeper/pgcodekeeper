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
package ru.taximaxim.codekeeper.ui.externalcalls;

final class ProcBuilderWrapper {

    private final ProcessBuilder pb;

    public ProcBuilderWrapper(ProcessBuilder pb) {
        this.pb = pb;
    }

    public void addEnv(String variable, String value) {
        if (value != null && !value.isEmpty()) {
            pb.environment().put(variable, value);
        }
    }

    public void addEnv(String variable, int value) {
        if (value != 0) {
            pb.environment().put(variable, String.valueOf(value));
        }
    }
}
