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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public class PgDiffArguments {

    private String newSrc;
    private String oldSrc;
    private String newSrcFormat;
    private String oldSrcFormat;
    private String inCharsetName = Consts.UTF_8;
    private boolean ignorePrivileges;
    private boolean keepNewlines;
    private boolean addTransaction;
    private boolean disableCheckFunctionBodies;
    private boolean enableFunctionBodiesDependencies;
    private String timeZone;
    private boolean usingTypeCastOff;
    private boolean selectedOnly;
    private boolean dataMovementMode;
    private boolean concurrentlyMode;
    private boolean constraintNotValid;
    private final List<DbObjType> allowedTypes = new ArrayList<>();
    private boolean stopNotAllowed;
    private final List<String> ignoreLists = new ArrayList<>();
    private String ignoreSchemaList;
    private final List<String> sourceLibs = new ArrayList<>();
    private final List<String> sourceLibXmls = new ArrayList<>();
    private final List<String> sourceLibsWithoutPriv = new ArrayList<>();
    private final List<String> targetLibXmls = new ArrayList<>();
    private final List<String> targetLibs = new ArrayList<>();
    private final List<String> targetLibsWithoutPriv = new ArrayList<>();
    private boolean libSafeMode;
    private DatabaseType dbType = DatabaseType.PG;
    private boolean ignoreConcurrentModification;
    private boolean simplifyView;
    private boolean ignoreErrors;
    private boolean ignoreColumnOrder;
    private boolean projUpdate;
    private boolean autoFormatObjectCode;
    private FormatConfiguration formatConfiguration = new FormatConfiguration();
    private boolean generateExists;
    private boolean dropBeforeCreate;
    private boolean commentsToEnd;
    private List<String> preFilePath = new ArrayList<>();
    private List<String> postFilePath = new ArrayList<>();

    public Collection<String> getPreFilePath() {
        return Collections.unmodifiableCollection(preFilePath);
    }

    public void setPreFilePath(List<String> preFilePath) {
        this.preFilePath = preFilePath;
    }

    public Collection<String> getPostFilePath() {
        return Collections.unmodifiableCollection(postFilePath);
    }

    public void setPostFilePath(List<String> postFilePath) {
        this.postFilePath = postFilePath;
    }

    public boolean isDropBeforeCreate() {
        return dropBeforeCreate;
    }

    public void setDropBeforeCreate(boolean dropBeforeCreate) {
        this.dropBeforeCreate = dropBeforeCreate;
    }

    public boolean isCommentsToEnd() {
        return commentsToEnd;
    }

    public void setCommentsToEnd(boolean commentsToEnd) {
        this.commentsToEnd = commentsToEnd;
    }

    public boolean isGenerateExists() {
        return generateExists;
    }

    public void setGenerateExists(boolean generateExists) {
        this.generateExists = generateExists;
    }

    public void setNewSrc(final String newSrc) {
        this.newSrc = newSrc;
    }

    public String getNewSrc() {
        return newSrc;
    }

    public void setOldSrc(final String oldSrc) {
        this.oldSrc = oldSrc;
    }

    public String getOldSrc() {
        return this.oldSrc;
    }

    public void setNewSrcFormat(final String newSrcFormat) {
        this.newSrcFormat = newSrcFormat;
    }

    public String getNewSrcFormat() {
        return this.newSrcFormat;
    }

    public void setOldSrcFormat(final String oldSrcFormat) {
        this.oldSrcFormat = oldSrcFormat;
    }

    public String getOldSrcFormat() {
        return this.oldSrcFormat;
    }

    public void setAddTransaction(final boolean addTransaction) {
        this.addTransaction = addTransaction;
    }

    public boolean isAddTransaction() {
        return addTransaction;
    }

    public boolean isStopNotAllowed() {
        return stopNotAllowed;
    }

    public void setStopNotAllowed(boolean stopNotAllowed) {
        this.stopNotAllowed = stopNotAllowed;
    }

    public Collection<String> getIgnoreLists() {
        return Collections.unmodifiableCollection(ignoreLists);
    }

    public String getIgnoreSchemaList() {
        return ignoreSchemaList;
    }

    public Collection<String> getSourceLibXmls() {
        return Collections.unmodifiableCollection(sourceLibXmls);
    }

    public Collection<String> getSourceLibs() {
        return Collections.unmodifiableCollection(sourceLibs);
    }

    public Collection<String> getSourceLibsWithoutPriv() {
        return Collections.unmodifiableCollection(sourceLibsWithoutPriv);
    }

    public Collection<String> getTargetLibXmls() {
        return Collections.unmodifiableCollection(targetLibXmls);
    }

    public Collection<String> getTargetLibs() {
        return Collections.unmodifiableCollection(targetLibs);
    }

    public Collection<String> getTargetLibsWithoutPriv() {
        return Collections.unmodifiableCollection(targetLibsWithoutPriv);
    }

    public boolean isLibSafeMode() {
        return libSafeMode;
    }

    public void setLibSafeMode(boolean libSafeMode) {
        this.libSafeMode = libSafeMode;
    }

    public DatabaseType getDbType() {
        return dbType;
    }

    public void setDbType(DatabaseType dbType) {
        this.dbType = dbType;
    }

    public boolean isIgnoreConcurrentModification() {
        return ignoreConcurrentModification;
    }

    public void setIgnoreConcurrentModification(boolean ignoreConcurrentModification) {
        this.ignoreConcurrentModification = ignoreConcurrentModification;
    }

    public boolean isIgnoreErrors() {
        return ignoreErrors;
    }

    public void setIgnoreErrors(boolean ignoreErrors) {
        this.ignoreErrors = ignoreErrors;
    }

    public boolean isIgnoreColumnOrder() {
        return ignoreColumnOrder;
    }

    public void setIgnoreColumnOrder(boolean ignoreColumnOrder) {
        this.ignoreColumnOrder = ignoreColumnOrder;
    }

    public boolean isAutoFormatObjectCode() {
        return autoFormatObjectCode;
    }

    public void setAutoFormatObjectCode(boolean autoFormatObjectCode) {
        this.autoFormatObjectCode = autoFormatObjectCode;
    }

    public void setFormatConfiguration(FormatConfiguration formatConfiguration) {
        this.formatConfiguration = formatConfiguration;
    }

    public FormatConfiguration getFormatConfiguration() {
        return formatConfiguration;
    }

    public String getInCharsetName() {
        return inCharsetName;
    }

    public void setInCharsetName(final String inCharsetName) {
        this.inCharsetName = inCharsetName;
    }

    public void setDisableCheckFunctionBodies(boolean disableCheckFunctionBodies) {
        this.disableCheckFunctionBodies = disableCheckFunctionBodies;
    }

    public boolean isDisableCheckFunctionBodies() {
        return disableCheckFunctionBodies;
    }

    public boolean isEnableFunctionBodiesDependencies() {
        return enableFunctionBodiesDependencies;
    }

    public void setEnableFunctionBodiesDependencies(boolean enableFunctionBodiesDependencies) {
        this.enableFunctionBodiesDependencies = enableFunctionBodiesDependencies;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setIgnorePrivileges(boolean ignorePrivilleges) {
        this.ignorePrivileges = ignorePrivilleges;
    }

    public boolean isIgnorePrivileges() {
        return ignorePrivileges;
    }

    public void setKeepNewlines(boolean keepNewlines) {
        this.keepNewlines = keepNewlines;
    }

    public boolean isKeepNewlines() {
        return keepNewlines;
    }

    public Collection<DbObjType> getAllowedTypes() {
        return Collections.unmodifiableCollection(allowedTypes);
    }

    public boolean isUsingTypeCastOff() {
        return usingTypeCastOff;
    }

    public void setUsingTypeCastOff(boolean usingTypeCastOff) {
        this.usingTypeCastOff = usingTypeCastOff;
    }

    public boolean isSelectedOnly() {
        return selectedOnly;
    }

    public void setSelectedOnly(boolean selectedOnly) {
        this.selectedOnly = selectedOnly;
    }

    public boolean isDataMovementMode() {
        return dataMovementMode;
    }

    public void setDataMovementMode(boolean dataMovementMode) {
        this.dataMovementMode = dataMovementMode;
    }

    public boolean isConcurrentlyMode() {
        return concurrentlyMode;
    }

    public void setConcurrentlyMode(boolean concurrentlyMode) {
        this.concurrentlyMode = concurrentlyMode;
    }

    public boolean isConstraintNotValid() {
        return constraintNotValid;
    }

    public void setConstraintNotValid(boolean constraintNotValid) {
        this.constraintNotValid = constraintNotValid;
    }

    public boolean isSimplifyView() {
        return simplifyView;
    }

    public void setSimplifyView(boolean simplifyView) {
        this.simplifyView = simplifyView;
    }

    public boolean isProjUpdate() {
        return projUpdate;
    }

    public void setProjUpdate(boolean projUpdate) {
        this.projUpdate = projUpdate;
    }

    public PgDiffArguments copy() {
        PgDiffArguments arg = new PgDiffArguments();
        arg.newSrc = getNewSrc();
        arg.oldSrc = getOldSrc();
        arg.newSrcFormat = getNewSrcFormat();
        arg.oldSrcFormat = getOldSrcFormat();
        arg.inCharsetName = getInCharsetName();
        arg.ignorePrivileges = isIgnorePrivileges();
        arg.keepNewlines = isKeepNewlines();
        arg.addTransaction = isAddTransaction();
        arg.disableCheckFunctionBodies = isDisableCheckFunctionBodies();
        arg.enableFunctionBodiesDependencies = isEnableFunctionBodiesDependencies();
        arg.timeZone = getTimeZone();
        arg.usingTypeCastOff = isUsingTypeCastOff();
        arg.selectedOnly = isSelectedOnly();
        arg.dataMovementMode = isDataMovementMode();
        arg.concurrentlyMode = isConcurrentlyMode();
        arg.constraintNotValid = isConstraintNotValid();
        arg.allowedTypes.addAll(getAllowedTypes());
        arg.stopNotAllowed = isStopNotAllowed();
        arg.ignoreLists.addAll(getIgnoreLists());
        arg.ignoreSchemaList = getIgnoreSchemaList();
        arg.sourceLibs.addAll(getSourceLibs());
        arg.sourceLibXmls.addAll(getSourceLibXmls());
        arg.sourceLibsWithoutPriv.addAll(getSourceLibsWithoutPriv());
        arg.targetLibXmls.addAll(getTargetLibXmls());
        arg.targetLibs.addAll(getTargetLibs());
        arg.targetLibsWithoutPriv.addAll(getTargetLibsWithoutPriv());
        arg.libSafeMode = isLibSafeMode();
        arg.dbType = getDbType();
        arg.ignoreConcurrentModification = isIgnoreConcurrentModification();
        arg.simplifyView = isSimplifyView();
        arg.ignoreErrors = isIgnoreErrors();
        arg.ignoreColumnOrder = isIgnoreColumnOrder();
        arg.projUpdate = isProjUpdate();
        arg.autoFormatObjectCode = isAutoFormatObjectCode();
        arg.formatConfiguration = formatConfiguration.copy();
        arg.generateExists = isGenerateExists();
        arg.dropBeforeCreate = isDropBeforeCreate();
        arg.commentsToEnd = isCommentsToEnd();
        arg.preFilePath.addAll(getPreFilePath());
        arg.postFilePath.addAll(getPostFilePath());
        return arg;
    }
}
