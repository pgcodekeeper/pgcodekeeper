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
package ru.taximaxim.codekeeper.core.settings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public final class TestCoreSettings implements ISettings {

    private DatabaseType dbType = DatabaseType.PG;
    private boolean isEnableFunctionBodiesDependencies;
    private boolean isIgnorePriv;
    private boolean isDataMovementMode;
    private boolean isKeepNewlines;
    private boolean isCommentsToEnd;
    private boolean isGenerateExistDoBlock;
    private boolean isAddTransaction;
    private String inCharsetName = Consts.UTF_8;
    private final List<DbObjType> allowedTypes = new ArrayList<>();
    private List<String> preFilePath = new ArrayList<>();
    private List<String> postFilePath = new ArrayList<>();

    public void setDbType(DatabaseType dbType) {
        this.dbType = dbType;
    }

    @Override
    public DatabaseType getDbType() {
        return dbType;
    }

    @Override
    public boolean isConcurrentlyMode() {
        return false;
    }

    @Override
    public boolean isAddTransaction() {
        return isAddTransaction;
    }

    @Override
    public boolean isGenerateExists() {
        return false;
    }

    @Override
    public boolean isConstraintNotValid() {
        return false;
    }

    public void setGenerateExistDoBlock(boolean isGenerateExistDoBlock) {
        this.isGenerateExistDoBlock = isGenerateExistDoBlock;
    }

    @Override
    public boolean isGenerateExistDoBlock() {
        return isGenerateExistDoBlock;
    }

    @Override
    public boolean isPrintUsing() {
        return true;
    }

    public void setKeepNewlines(boolean isKeepNewlines) {
        this.isKeepNewlines = isKeepNewlines;
    }

    @Override
    public boolean isKeepNewlines() {
        return isKeepNewlines;
    }

    public void setCommentsToEnd(boolean isCommentsToEnd) {
        this.isCommentsToEnd = isCommentsToEnd;
    }

    @Override
    public boolean isCommentsToEnd() {
        return isCommentsToEnd;
    }

    @Override
    public boolean isAutoFormatObjectCode() {
        return false;
    }

    @Override
    public boolean isIgnorePrivileges() {
        return isIgnorePriv;
    }

    public void setIgnorePrivileges(boolean isIgnorePriv) {
        this.isIgnorePriv = isIgnorePriv;
    }

    @Override
    public boolean isIgnoreColumnOrder() {
        return false;
    }

    public void setEnableFunctionBodiesDependencies(boolean isEnableFunctionBodiesDependencies) {
        this.isEnableFunctionBodiesDependencies = isEnableFunctionBodiesDependencies;
    }

    @Override
    public boolean isEnableFunctionBodiesDependencies() {
        return isEnableFunctionBodiesDependencies;
    }

    public void setDataMovementMode(boolean isDataMovementMode) {
        this.isDataMovementMode = isDataMovementMode;
    }

    @Override
    public boolean isDataMovementMode() {
        return isDataMovementMode;
    }

    @Override
    public boolean isDropBeforeCreate() {
        return false;
    }

    @Override
    public boolean isStopNotAllowed() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSelectedOnly() {
        return false;
    }

    @Override
    public boolean isIgnoreConcurrentModification() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSimplifyView() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDisableCheckFunctionBodies() {
        return false;
    }

    @Override
    public String getInCharsetName() {
        return inCharsetName;
    }

    public void setInCharsetName(String inCharsetName) {
        this.inCharsetName = inCharsetName;
    }

    @Override
    public String getTimeZone() {
        return null;
    }

    @Override
    public FormatConfiguration getFormatConfiguration() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<DbObjType> getAllowedTypes() {
        return allowedTypes;
    }

    @Override
    public Collection<String> getPreFilePath() {
        return preFilePath;
    }

    @Override
    public Collection<String> getPostFilePath() {
        return postFilePath;
    }

    public void setAddTransaction(boolean isAddTransaction) {
        this.isAddTransaction = isAddTransaction;
    }

    private TestCoreSettings copy() {
        var settings = new TestCoreSettings();
        settings.dbType = dbType;
        settings.isEnableFunctionBodiesDependencies = isEnableFunctionBodiesDependencies;
        settings.isIgnorePriv = isIgnorePriv;
        settings.isDataMovementMode = isDataMovementMode;
        settings.isKeepNewlines = isKeepNewlines;
        settings.isCommentsToEnd = isCommentsToEnd;
        settings.isGenerateExistDoBlock = isGenerateExistDoBlock;
        settings.inCharsetName = inCharsetName;
        return settings;
    }

    @Override
    public ISettings copy(boolean isIgnorePriv) {
        var settings = copy();
        settings.isIgnorePriv = isIgnorePriv;
        return settings;
    }

    @Override
    public ISettings copy(String inCharsetName) {
        var settings = copy();
        settings.inCharsetName = inCharsetName;
        return settings;
    }
}
