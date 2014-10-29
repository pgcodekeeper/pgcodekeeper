package ru.taximaxim.codekeeper.ui.prefs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;

public class SQLEditorSytaxColoring extends FieldEditorPreferencePage implements
        IWorkbenchPreferencePage {

    enum statementsTypes {
        FUNCTIONS("prefsFunction"),
        PREDICATES("prefsPredicates"),
        RESERVED_WORDS("prefsReservedWords"),
        UN_RESERVED_WORDS("prefsUnReservedWords"),
        TYPES("prefsTypes"),
        CONSTANTS("prefsConstants"),
        SINGLE_LINE_COMMENTS("prefsSingleLineComments"),
        GLOBAL_VARIABLES("prefsGlobalVariables");
        
        private String name;
        private statementsTypes(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    }
    
    private ListViewer listIgnoredObjs;

    public SQLEditorSytaxColoring() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        composite.setLayout(gridLayout);
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        listIgnoredObjs = new ListViewer(composite);
        listIgnoredObjs.getList().setLayoutData(new GridData(GridData.FILL_BOTH));

        listIgnoredObjs.setContentProvider(new ArrayContentProvider());
        listIgnoredObjs.setLabelProvider(new LabelProvider());
        listIgnoredObjs.setSorter(new ViewerSorter());
        
        Group group = new Group(composite, SWT.NONE);
        group.setLayoutData(new GridData(GridData.FILL_BOTH));
        group.setText("Font and color preference");
        
        return composite;
    }

    @Override
    protected void createFieldEditors() {
        // TODO Auto-generated method stub
        
    }
    /**
     * A syntax item object
     * 
     * @author renj
     */
    class SyntaxItem {
        private Pattern pattern = Pattern.compile("(\\d)\\,(\\d)\\,(\\d)\\,(\\d)\\,(\\d)\\,(\\d{1,3})\\,(\\d{1,3})\\,(\\d{1,3})");

        private Boolean _boldKey = Boolean.FALSE;
        private Boolean _italicKey = Boolean.FALSE;
        private Boolean _strikethroughKey = Boolean.FALSE;
        private Boolean _underlineKey = Boolean.FALSE;
        private Boolean _systemDefault = Boolean.FALSE;
        private RGB _color = new RGB(0, 0, 0);

        public SyntaxItem(String preferenceCodes) {
            if (preferenceCodes != null && !preferenceCodes.equals("")) {
                Matcher m = pattern.matcher(preferenceCodes);
                if (m.matches()) {
                    _boldKey = Boolean.valueOf(m.group(1).equals("1") ? true : false);
                    _italicKey = Boolean.valueOf(m.group(2).equals("1") ? true : false);
                    _strikethroughKey = Boolean.valueOf(m.group(3).equals("1") ? true : false);
                    _underlineKey = Boolean.valueOf(m.group(4).equals("1") ? true : false);
                    _systemDefault = Boolean.valueOf(m.group(5).equals("1") ? true : false);
                    _color = new RGB(Integer.parseInt(m.group(6)), Integer.parseInt(m.group(7)), Integer.parseInt(m.group(8)));
                }
            }
        }

        public SyntaxItem(boolean bk, boolean ik, boolean sk, boolean uk, boolean sys, RGB rgb) {
            _boldKey = Boolean.valueOf(bk);
            _italicKey = Boolean.valueOf(ik);
            _strikethroughKey = Boolean.valueOf(sk);
            _underlineKey = Boolean.valueOf(uk);
            _systemDefault = Boolean.valueOf(sys);
            _color = rgb;
        }

        public void setBoldKey(boolean bk) {
            _boldKey = Boolean.valueOf(bk);
        }

        public void setItalicKey(boolean ik) {
            _italicKey = Boolean.valueOf(ik);
        }

        public void setStrikethroughKey(boolean sk) {
            _strikethroughKey = Boolean.valueOf(sk);
        }

        public void setUnderlineKey(boolean uk) {
            _underlineKey = Boolean.valueOf(uk);
        }

        public void setSystemDefault(boolean sys) {
            _systemDefault = Boolean.valueOf(sys);
        }

        public void setColor(RGB rgb) {
            _color = rgb;
        }

        public boolean isBold() {
            return _boldKey.booleanValue();
        }

        public boolean isItalic() {
            return _italicKey.booleanValue();
        }

        public boolean isStrikethrough() {
            return _strikethroughKey.booleanValue();
        }

        public boolean isUnderline() {
            return _underlineKey.booleanValue();
        }

        public boolean isSystemDefault() {
            return _systemDefault.booleanValue();
        }

        public RGB getColor() {
            return _color;
        }

        public String toString() {
            String preferenceCodes = (_boldKey.booleanValue() ? "1" : "0") + "," + (_italicKey.booleanValue() ? "1" : "0") + "," + (_strikethroughKey.booleanValue() ? "1" : "0") + ","
                    + (_underlineKey.booleanValue() ? "1" : "0") + "," + (_systemDefault.booleanValue() ? "1" : "0") + "," + _color.red + "," + _color.green + "," + _color.blue;
            return preferenceCodes;
        }
    }
}
