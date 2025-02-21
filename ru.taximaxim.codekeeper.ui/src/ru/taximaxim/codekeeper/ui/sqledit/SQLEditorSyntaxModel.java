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

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;

public class SQLEditorSyntaxModel {
    
    public static final String PREF_COLOR = ".Color"; //$NON-NLS-1$
    public static final String PREF_UNDERLINE = ".underline"; //$NON-NLS-1$
    public static final String PREF_STRIKETHROUGH = ".strikethrough"; //$NON-NLS-1$
    public static final String PREF_ITALIC = ".Italic"; //$NON-NLS-1$
    public static final String PREF_BOLD = ".Bold"; //$NON-NLS-1$

    public SQLEditorSyntaxModel(SQLEditorStatementTypes type, IPreferenceStore prefStore) {
        this.type = type;
        this.prefStore = prefStore;
    }
    public RGB getColor() {
        return color;
    }
    public void setColor(RGB color) {
        this.color = color;
    }
    public void setBold(boolean bold) {
        this.bold = bold;
    }
    public void setItalic(boolean italic) {
        this.italic = italic;
    }
    public void setStrikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
    }
    public void setUnderline(boolean underline) {
        this.underline = underline;
    }
    public boolean isBold() {
        return bold;
    }
    public boolean isItalic() {
        return italic;
    }
    public boolean isStrikethrough() {
        return strikethrough;
    }
    public boolean isUnderline() {
        return underline;
    }
    public SQLEditorStatementTypes getType() {
        return type;
    }
    public String getPrefName() {
        return type.getPrefName();
    }

    private SQLEditorStatementTypes type;
    private RGB color;
    private boolean bold;
    private boolean italic;
    private boolean strikethrough;
    private boolean underline;
    private IPreferenceStore prefStore;
    
    public SQLEditorSyntaxModel load() {
        color = StringConverter.asRGB(prefStore.getString(
                type.getPrefName() + PREF_COLOR));
        bold = prefStore.getBoolean(type.getPrefName() + PREF_BOLD);
        italic = prefStore.getBoolean(type.getPrefName() + PREF_ITALIC);
        strikethrough = prefStore.getBoolean(type.getPrefName() + PREF_STRIKETHROUGH);
        underline = prefStore.getBoolean(type.getPrefName() + PREF_UNDERLINE);
        return this;
    }
    
    @Override
    public String toString() {
        return type.toString();
    }
    
    public void setDefault() {
        prefStore.setDefault(type.getPrefName() + PREF_COLOR, StringConverter.asString(color));
        prefStore.setDefault(type.getPrefName() + PREF_BOLD, bold);
        prefStore.setDefault(type.getPrefName() + PREF_ITALIC, italic);
        prefStore.setDefault(type.getPrefName() + PREF_STRIKETHROUGH, strikethrough);
        prefStore.setDefault(type.getPrefName() + PREF_UNDERLINE, underline);
    }
    
    public SQLEditorSyntaxModel loadDefault() {
        color = StringConverter.asRGB(prefStore.getDefaultString(
                type.getPrefName()+ PREF_COLOR));
        bold = prefStore.getDefaultBoolean(type.getPrefName() + PREF_BOLD);
        italic = prefStore.getDefaultBoolean(type.getPrefName() + PREF_ITALIC);
        strikethrough = prefStore.getDefaultBoolean(type.getPrefName() + PREF_STRIKETHROUGH);
        underline = prefStore.getDefaultBoolean(type.getPrefName() + PREF_UNDERLINE);
        return this;
    }
    
    public void store() {
        prefStore.setValue(type.getPrefName() + PREF_COLOR, StringConverter.asString(color));
        prefStore.setValue(type.getPrefName() + PREF_BOLD, bold);
        prefStore.setValue(type.getPrefName() + PREF_ITALIC, italic);
        prefStore.setValue(type.getPrefName() + PREF_STRIKETHROUGH, strikethrough);
        prefStore.setValue(type.getPrefName() + PREF_UNDERLINE, underline);
    }
}
