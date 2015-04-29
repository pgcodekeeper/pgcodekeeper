package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
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
        color = PreferenceConverter.getColor(prefStore,
                type.getPrefName() + PREF_COLOR);
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
        PreferenceConverter.setDefault(prefStore, type.getPrefName() + PREF_COLOR, color);
        prefStore.setDefault(type.getPrefName() + PREF_BOLD, bold);
        prefStore.setDefault(type.getPrefName() + PREF_ITALIC, italic);
        prefStore.setDefault(type.getPrefName() + PREF_STRIKETHROUGH, strikethrough);
        prefStore.setDefault(type.getPrefName() + PREF_UNDERLINE, underline);
    }
    
    public SQLEditorSyntaxModel loadDefault() {
        color = PreferenceConverter.getDefaultColor(prefStore,
                type.getPrefName() + PREF_COLOR);
        bold = prefStore.getDefaultBoolean(type.getPrefName() + PREF_BOLD);
        italic = prefStore.getDefaultBoolean(type.getPrefName() + PREF_ITALIC);
        strikethrough = prefStore.getDefaultBoolean(type.getPrefName() + PREF_STRIKETHROUGH);
        underline = prefStore.getDefaultBoolean(type.getPrefName() + PREF_UNDERLINE);
        return this;
    }
    
    public void store() {
        PreferenceConverter.setValue(prefStore, type.getPrefName() + PREF_COLOR, color);
        prefStore.setValue(type.getPrefName() + PREF_BOLD, bold);
        prefStore.setValue(type.getPrefName() + PREF_ITALIC, italic);
        prefStore.setValue(type.getPrefName() + PREF_STRIKETHROUGH, strikethrough);
        prefStore.setValue(type.getPrefName() + PREF_UNDERLINE, underline);
    }
}
