package ru.taximaxim.codekeeper.ui;
import java.util.Collection;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.SourceFormat;
import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public class TestUiSettings implements ISettings {

    private DatabaseType dbType = DatabaseType.PG;

//    public void setDbType(DatabaseType dbType) {
//        this.dbType = dbType;
//    }

    @Override
    public DatabaseType getDbType() {
        return dbType;
    }

    @Override
    public boolean isConcurrentlyMode() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAddTransaction() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isGenerateExists() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isConstraintNotValid() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isGenerateExistDoBlock() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isPrintUsing() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isKeepNewlines() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCommentsToEnd() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAutoFormatObjectCode() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isIgnorePrivileges() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isIgnoreColumnOrder() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnableFunctionBodiesDependencies() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isDataMovementMode() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isDropBeforeCreate() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isStopNotAllowed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isSelectedOnly() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isIgnoreConcurrentModification() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isSimplifyView() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isDisableCheckFunctionBodies() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isIgnoreErrors() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isLibSafeMode() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getInCharsetName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTimeZone() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getIgnoreSchemaList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getNewSrc() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getOldSrc() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SourceFormat getNewSrcFormat() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SourceFormat getOldSrcFormat() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FormatConfiguration getFormatConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<DbObjType> getAllowedTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<String> getPreFilePath() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<String> getPostFilePath() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<String> getSourceLibs() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<String> getSourceLibsWithoutPriv() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<String> getSourceLibXmls() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<String> getTargetLibs() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<String> getTargetLibsWithoutPriv() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<String> getTargetLibXmls() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<String> getIgnoreLists() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setIgnorePrivileges(boolean isIgnorePriv) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setInCharsetName(String charset) {
        // TODO Auto-generated method stub

    }

    @Override
    public ISettings copy() {
        return new TestUiSettings();
    }

}
