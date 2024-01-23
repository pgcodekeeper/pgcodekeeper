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
package ru.taximaxim.codekeeper.ui.differ;

public class ElementMetaInfo {
    private String gitUser;
    private String dbUser;
    private String libLocation;
    private boolean isChanged;

    public void setGitUser(final String gitUser) {
        this.gitUser = gitUser;
    }

    public void setDbUser(final String dbUser) {
        this.dbUser = dbUser;
    }

    public void setChanged() {
        isChanged = true;
    }

    public boolean isChanged() {
        return isChanged;
    }

    public String getGitUser() {
        String a = gitUser == null ? "" : gitUser; //$NON-NLS-1$
        return isChanged ?  "*" + a : a; //$NON-NLS-1$
    }

    public String getDbUser() {
        return dbUser == null ? "" : dbUser; //$NON-NLS-1$
    }

    public void setLibLocation(String libLocation) {
        this.libLocation = libLocation;
    }

    public String getLibLocation() {
        return libLocation;
    }
}
