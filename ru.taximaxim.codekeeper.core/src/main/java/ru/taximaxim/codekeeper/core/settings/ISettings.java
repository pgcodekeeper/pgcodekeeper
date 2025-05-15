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

    boolean isDisableCheckFunctionBodies();

    String getInCharsetName();

    String getTimeZone();

    FormatConfiguration getFormatConfiguration();

    Collection<DbObjType> getAllowedTypes();

    Collection<String> getPreFilePath();

    Collection<String> getPostFilePath();

    ISettings copy(boolean isIgnorePriv);

    ISettings copy(String inCharsetName);
}
