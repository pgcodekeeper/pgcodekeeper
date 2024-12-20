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
package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.templates.GlobalTemplateVariables;
import org.eclipse.jface.text.templates.TemplateContextType;

import ru.taximaxim.codekeeper.ui.UIConsts;

public class SQLEditorTemplateContextType extends TemplateContextType {

    public static final String CONTEXT_TYPE_PG
    = UIConsts.PLUGIN_ID.THIS + ".sqlEditorContextTypePg"; //$NON-NLS-1$

    public static final String CONTEXT_TYPE_MS
    = UIConsts.PLUGIN_ID.THIS + ".sqlEditorContextTypeMs"; //$NON-NLS-1$

    public static final String CONTEXT_TYPE_CH
    = UIConsts.PLUGIN_ID.THIS + ".sqlEditorContextTypeCh"; //$NON-NLS-1$

    public static final String CONTEXT_TYPE_COMMON
    = UIConsts.PLUGIN_ID.THIS + ".sqlEditorContextTypeCommon"; //$NON-NLS-1$

    public SQLEditorTemplateContextType() {
        addResolver(new GlobalTemplateVariables.Cursor());
        addResolver(new GlobalTemplateVariables.WordSelection());
        addResolver(new GlobalTemplateVariables.LineSelection());
    }
}
