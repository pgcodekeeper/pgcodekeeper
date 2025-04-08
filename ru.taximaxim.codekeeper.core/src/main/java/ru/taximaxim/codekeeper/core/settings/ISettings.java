package ru.taximaxim.codekeeper.core.settings;

import java.util.Collection;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.SourceFormat;
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

    boolean isLibSafeMode();

    boolean isIgnoreErrors();

    boolean isDisableCheckFunctionBodies();

    boolean isUsingTypeCastOff();

    String getInCharsetName();

    String getTimeZone();

    String getNewSrc();

    String getOldSrc();

    String getIgnoreSchemaList();

    FormatConfiguration getFormatConfiguration();

    SourceFormat getNewSrcFormat();

    SourceFormat getOldSrcFormat();

    Collection<DbObjType> getAllowedTypes();

    Collection<String> getIgnoreLists();

    Collection<String> getTargetLibXmls();

    Collection<String> getTargetLibs();

    Collection<String> getTargetLibsWithoutPriv();

    Collection<String> getSourceLibXmls();

    Collection<String> getSourceLibs();

    Collection<String> getSourceLibsWithoutPriv();

    Collection<String> getPreFilePath();

    Collection<String> getPostFilePath();

    void setIsAddTransaction(boolean isAddTransaction);

    void setIgnorePrivileges(boolean isIgnorePriv);

    void setInCharsetName(String charset);

    ISettings copy();
}
