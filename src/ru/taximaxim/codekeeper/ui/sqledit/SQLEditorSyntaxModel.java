package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.RGB;

public class SQLEditorSyntaxModel {
    
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
                type.getPrefName() + ".Color");
        bold = prefStore.getBoolean(type.getPrefName() + ".Bold");
        italic = prefStore.getBoolean(type.getPrefName() + ".Italic");
        strikethrough = prefStore.getBoolean(type.getPrefName() + ".strikethrough");
        underline = prefStore.getBoolean(type.getPrefName() + ".underline");
        return this;
    }
    
    @Override
    public String toString() {
        return type.toString();
    }
    
    public void setDefault() {
        PreferenceConverter.setDefault(prefStore, type.getPrefName() + ".Color", color);
        prefStore.setDefault(type.getPrefName() + ".Bold", bold);
        prefStore.setDefault(type.getPrefName() + ".Italic", italic);
        prefStore.setDefault(type.getPrefName() + ".strikethrough", strikethrough);
        prefStore.setDefault(type.getPrefName() + ".underline", underline);
    }
    
    public SQLEditorSyntaxModel loadDefault() {
        color = PreferenceConverter.getDefaultColor(prefStore,
                type.getPrefName() + ".Color");
        bold = prefStore.getDefaultBoolean(type.getPrefName() + ".Bold");
        italic = prefStore.getDefaultBoolean(type.getPrefName() + ".Italic");
        strikethrough = prefStore.getDefaultBoolean(type.getPrefName() + ".strikethrough");
        underline = prefStore.getDefaultBoolean(type.getPrefName() + ".underline");
        return this;
    }
    
    public void store() {
        PreferenceConverter.setValue(prefStore, type.getPrefName() + ".Color", color);
        prefStore.setValue(type.getPrefName() + ".Bold", bold);
        prefStore.setValue(type.getPrefName() + ".Italic", italic);
        prefStore.setValue(type.getPrefName() + ".strikethrough", strikethrough);
        prefStore.setValue(type.getPrefName() + ".underline", underline);
    }
}
