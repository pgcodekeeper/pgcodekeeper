package ru.taximaxim.codekeeper.core.settings;

import java.util.Collection;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public interface ISettings {

    DatabaseType getDbType();

    boolean isConcurrentlyMode();

    boolean isAddTransaction();

    boolean isGenerateExists();

    boolean isConstraintNotValid();

    boolean isGenerateExistDoBlock();

    boolean isPrintUsing();

    boolean isKeepNewlines();

    boolean isCommentsToEnd();

    boolean isAutoFormatObjectCode();

    boolean isIgnorePrivileges();

    boolean isIgnoreColumnOrder();

    boolean isEnableFunctionBodiesDependencies();

    boolean isDataMovementMode();

    boolean isDropBeforeCreate();

    boolean isStopNotAllowed();

    boolean isSelectedOnly();

    boolean isIgnoreConcurrentModification();

    boolean isSimplifyView();

    String getInCharsetName();

    String getTimeZone();

    Collection<DbObjType> getAllowedTypes();

    FormatConfiguration getFormatConfiguration();

    void setIgnorePrivileges(boolean isIgnorePriv);

    void setInCharsetName(String charset);

    ISettings copy();
}
