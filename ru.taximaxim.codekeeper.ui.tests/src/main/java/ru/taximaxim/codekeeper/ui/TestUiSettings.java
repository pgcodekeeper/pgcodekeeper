package ru.taximaxim.codekeeper.ui;

import java.util.Collection;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public class TestUiSettings implements ISettings {

    private DatabaseType dbType = DatabaseType.PG;

    @Override
    public DatabaseType getDbType() {
        return dbType;
    }

    @Override
    public boolean isConcurrentlyMode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isAddTransaction() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isGenerateExists() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isConstraintNotValid() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isGenerateExistDoBlock() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isPrintUsing() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isKeepNewlines() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isCommentsToEnd() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isAutoFormatObjectCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isIgnorePrivileges() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isIgnoreColumnOrder() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEnableFunctionBodiesDependencies() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDataMovementMode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDropBeforeCreate() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isStopNotAllowed() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSelectedOnly() {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    @Override
    public String getInCharsetName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getTimeZone() {
        throw new UnsupportedOperationException();
    }

    @Override
    public FormatConfiguration getFormatConfiguration() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<DbObjType> getAllowedTypes() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<String> getPreFilePath() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<String> getPostFilePath() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setIgnorePrivileges(boolean isIgnorePriv) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setInCharsetName(String charset) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ISettings copy() {
        return new TestUiSettings();
    }
}
