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
import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public class CoreSettings implements ISettings {
    private DatabaseType dbType = DatabaseType.PG;
    private String inCharsetName = Consts.UTF_8;
    private List<String> preFilePath = new ArrayList<>();
    private List<String> postFilePath = new ArrayList<>();
    private List<DbObjType> allowedTypes = new ArrayList<>();
    private boolean printUsing = true;
    private String timeZone;
    private boolean ignorePrivileges;
    private boolean keepNewlines;
    private boolean simplifyView;
    private boolean addTransaction;
    private boolean disableCheckFunctionBodies;
    private boolean enableFunctionBodiesDependencies;
    private boolean ignoreColumnOrder;
    private boolean generateConstraintNotValid;
    private boolean dataMovementMode;
    private boolean concurrentlyMode;
    private boolean generateExists;
    private boolean generateExistDoBlock;
    private boolean dropBeforeCreate;
    private boolean commentsToEnd;
    private boolean stopNotAllowed;
    private boolean selectedOnly;
    private boolean ignoreConcurrentModification;

    @Override
    public DatabaseType getDbType() {
        return dbType;
    }

    public void setDbType(DatabaseType dbType) {
        this.dbType = dbType;
    }

    @Override
    public boolean isConcurrentlyMode() {
        return concurrentlyMode;
    }

    @Override
    public boolean isAddTransaction() {
        return addTransaction;
    }

    public void setAddTransaction(boolean addTransaction) {
        this.addTransaction = addTransaction;
    }

    @Override
    public boolean isGenerateExists() {
        return generateExists;
    }

    @Override
    public boolean isConstraintNotValid() {
        return generateConstraintNotValid;
    }

    @Override
    public boolean isGenerateExistDoBlock() {
        return generateExistDoBlock;
    }

    public void setGenerateExistDoBlock(boolean generateExistDoBlock) {
        this.generateExistDoBlock = generateExistDoBlock;
    }

    @Override
    public boolean isPrintUsing() {
        return printUsing;
    }

    public void setPrintUsing(boolean printUsing) {
        this.printUsing = printUsing;
    }

    @Override
    public boolean isKeepNewlines() {
        return keepNewlines;
    }

    public void setKeepNewlines(boolean keepNewlines) {
        this.keepNewlines = keepNewlines;
    }

    @Override
    public boolean isCommentsToEnd() {
        return commentsToEnd;
    }

    public void setCommentsToEnd(boolean commentsToEnd) {
        this.commentsToEnd = commentsToEnd;
    }

    @Override
    public boolean isAutoFormatObjectCode() {
        return false;
    }

    @Override
    public boolean isIgnorePrivileges() {
        return ignorePrivileges;
    }

    @Override
    public void setIgnorePrivileges(boolean ignorePrivileges) {
        this.ignorePrivileges = ignorePrivileges;
    }

    @Override
    public boolean isIgnoreColumnOrder() {
        return ignoreColumnOrder;
    }

    @Override
    public boolean isEnableFunctionBodiesDependencies() {
        return enableFunctionBodiesDependencies;
    }

    public void setEnableFunctionBodiesDependencies(boolean enableFunctionBodiesDependencies) {
        this.enableFunctionBodiesDependencies = enableFunctionBodiesDependencies;
    }

    @Override
    public boolean isDataMovementMode() {
        return dataMovementMode;
    }

    public void setDataMovementMode(boolean dataMovementMode) {
        this.dataMovementMode = dataMovementMode;
    }

    @Override
    public boolean isDropBeforeCreate() {
        return dropBeforeCreate;
    }

    @Override
    public boolean isStopNotAllowed() {
        return stopNotAllowed;
    }

    @Override
    public boolean isSelectedOnly() {
        return selectedOnly;
    }

    @Override
    public boolean isIgnoreConcurrentModification() {
        return ignoreConcurrentModification;
    }

    @Override
    public boolean isSimplifyView() {
        return simplifyView;
    }

    @Override
    public boolean isDisableCheckFunctionBodies() {
        return disableCheckFunctionBodies;
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
        return timeZone;
    }

    @Override
    public FormatConfiguration getFormatConfiguration() {
        return null;
    }

    @Override
    public Collection<DbObjType> getAllowedTypes() {
        return Collections.unmodifiableCollection(allowedTypes);
    }

    @Override
    public Collection<String> getPreFilePath() {
        return Collections.unmodifiableCollection(preFilePath);
    }

    @Override
    public Collection<String> getPostFilePath() {
        return Collections.unmodifiableCollection(postFilePath);
    }

    @Override
    public CoreSettings copy() {
        var settings = new CoreSettings();
        settings.addTransaction = addTransaction;
        settings.allowedTypes = allowedTypes;
        settings.commentsToEnd = commentsToEnd;
        settings.concurrentlyMode = concurrentlyMode;
        settings.dataMovementMode = dataMovementMode;
        settings.dbType = dbType;
        settings.disableCheckFunctionBodies = disableCheckFunctionBodies;
        settings.dropBeforeCreate = dropBeforeCreate;
        settings.enableFunctionBodiesDependencies = enableFunctionBodiesDependencies;
        settings.generateConstraintNotValid = generateConstraintNotValid;
        settings.generateExistDoBlock = generateExistDoBlock;
        settings.generateExists = generateExists;
        settings.ignoreColumnOrder = ignoreColumnOrder;
        settings.ignoreConcurrentModification = ignoreConcurrentModification;
        settings.ignorePrivileges = ignorePrivileges;
        settings.inCharsetName = inCharsetName;
        settings.keepNewlines = keepNewlines;
        settings.postFilePath = postFilePath;
        settings.preFilePath = preFilePath;
        settings.selectedOnly = selectedOnly;
        settings.simplifyView = simplifyView;
        settings.stopNotAllowed = stopNotAllowed;
        settings.timeZone = timeZone;
        settings.printUsing = printUsing;
        return settings;
    }
}