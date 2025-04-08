package ru.taximaxim.codekeeper.core.settings;

import java.util.Collection;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.SourceFormat;
import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public class CliSettings implements ISettings {

    private PgDiffArguments args;

    public CliSettings(PgDiffArguments args) {
        this.args = args;
    }

    @Override
    public DatabaseType getDbType() {
        return args.getDbType();
    }

    @Override
    public boolean isPrintUsing() {
        return !args.isUsingTypeCastOff();
    }

    @Override
    public boolean isConcurrentlyMode() {
        return args.isConcurrentlyMode();
    }

    @Override
    public boolean isAddTransaction() {
        return args.isConcurrentlyMode();
    }

    @Override
    public boolean isGenerateExists() {
        return args.isGenerateExists();
    }

    @Override
    public boolean isConstraintNotValid() {
        return args.isConstraintNotValid();
    }

    @Override
    public boolean isGenerateExistDoBlock() {
        return args.isGenerateExistDoBlock();
    }

    @Override
    public boolean isKeepNewlines() {
        return args.isKeepNewlines();
    }

    @Override
    public boolean isCommentsToEnd() {
        return args.isCommentsToEnd();
    }

    @Override
    public boolean isAutoFormatObjectCode() {
        return args.isAutoFormatObjectCode();
    }

    @Override
    public FormatConfiguration getFormatConfiguration() {
        return args.getFormatConfiguration();
    }

    @Override
    public boolean isIgnorePrivileges() {
        return args.isIgnorePrivileges();
    }

    @Override
    public boolean isIgnoreColumnOrder() {
        return args.isIgnoreColumnOrder();
    }

    @Override
    public boolean isEnableFunctionBodiesDependencies() {
        return args.isEnableFunctionBodiesDependencies();
    }

    @Override
    public boolean isDataMovementMode() {
        return args.isDataMovementMode();
    }

    @Override
    public boolean isDropBeforeCreate() {
        return args.isDropBeforeCreate();
    }

    @Override
    public boolean isStopNotAllowed() {
        return args.isStopNotAllowed();
    }

    @Override
    public boolean isSelectedOnly() {
        return args.isSelectedOnly();
    }

    @Override
    public boolean isIgnoreConcurrentModification() {
        return args.isIgnoreConcurrentModification();
    }

    @Override
    public boolean isSimplifyView() {
        return args.isSimplifyView();
    }

    @Override
    public String getInCharsetName() {
        return args.getInCharsetName();
    }

    @Override
    public String getTimeZone() {
        return args.getTimeZone();
    }

    @Override
    public Collection<DbObjType> getAllowedTypes() {
        return args.getAllowedTypes();
    }

    @Override
    public void setIgnorePrivileges(boolean isIgnorePriv) {
        args.setIgnoreConcurrentModification(isIgnorePriv);
    }

    @Override
    public void setInCharsetName(String charset) {
        args.setInCharsetName(charset);
    }

    @Override
    public ISettings copy() {
        return new CliSettings(args.copy());
    }

    @Override
    public void setIsAddTransaction(boolean isAddTransaction) {
        args.setAddTransaction(isAddTransaction);
    }

    @Override
    public boolean isLibSafeMode() {
        return args.isLibSafeMode();
    }

    @Override
    public boolean isIgnoreErrors() {
        return args.isIgnoreErrors();
    }

    @Override
    public boolean isDisableCheckFunctionBodies() {
        return args.isDisableCheckFunctionBodies();
    }

    @Override
    public String getNewSrc() {
        return args.getNewSrc();
    }

    @Override
    public String getOldSrc() {
        return args.getOldSrc();
    }

    @Override
    public String getIgnoreSchemaList() {
        return args.getIgnoreSchemaList();
    }

    @Override
    public SourceFormat getNewSrcFormat() {
        return args.getNewSrcFormat();
    }

    @Override
    public SourceFormat getOldSrcFormat() {
        return args.getOldSrcFormat();
    }

    @Override
    public Collection<String> getIgnoreLists() {
        return args.getIgnoreLists();
    }

    @Override
    public Collection<String> getTargetLibXmls() {
        return args.getTargetLibXmls();
    }

    @Override
    public Collection<String> getTargetLibs() {
        return args.getTargetLibs();
    }

    @Override
    public Collection<String> getTargetLibsWithoutPriv() {
        return args.getTargetLibsWithoutPriv();
    }

    @Override
    public Collection<String> getSourceLibXmls() {
        return args.getSourceLibXmls();
    }

    @Override
    public Collection<String> getSourceLibs() {
        return args.getSourceLibs();
    }

    @Override
    public Collection<String> getSourceLibsWithoutPriv() {
        return args.getSourceLibsWithoutPriv();
    }

    @Override
    public Collection<String> getPreFilePath() {
        return args.getPreFilePath();
    }

    @Override
    public Collection<String> getPostFilePath() {
        return args.getPostFilePath();
    }

    @Override
    public boolean isUsingTypeCastOff() {
        return args.isUsingTypeCastOff();
    }
}

