/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgDiffArguments {

    private String newSrc;
    private String oldSrc;
    private String newSrcFormat;
    private String oldSrcFormat;
    private String inCharsetName = ApgdiffConsts.UTF_8;
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
    private boolean msSql;
    private boolean ignoreConcurrentModification;
    private boolean simplifyView;
    private boolean ignoreErrors;
    private boolean ignoreColumnOrder;
    private boolean formatOption;
    private FormatConfiguration formatConfiguration = new FormatConfiguration();

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

    public boolean isMsSql() {
        return msSql;
    }

    public void setMsSql(boolean msSql) {
        this.msSql = msSql;
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

    public boolean isFormatOption() {
        return formatOption;
    }

    public void setFormatOption(boolean formatOption) {
        this.formatOption = formatOption;
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

    public boolean isSimplifyView() {
        return simplifyView;
    }

    public void setSimplifyView(boolean simplifyView) {
        this.simplifyView = simplifyView;
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
        arg.msSql = isMsSql();
        arg.ignoreConcurrentModification = isIgnoreConcurrentModification();
        arg.simplifyView = isSimplifyView();
        arg.ignoreErrors = isIgnoreErrors();
        arg.ignoreColumnOrder = isIgnoreColumnOrder();
        arg.formatOption = isFormatOption();
        arg.formatConfiguration = formatConfiguration.copy();
        return arg;
    }
}
