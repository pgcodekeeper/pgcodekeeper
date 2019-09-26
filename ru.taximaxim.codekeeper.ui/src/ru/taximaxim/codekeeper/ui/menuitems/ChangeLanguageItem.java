package ru.taximaxim.codekeeper.ui.menuitems;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineLayoutData;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import ru.taximaxim.codekeeper.ui.UIConsts.LANGUAGE;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.UIProjectLoader;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class ChangeLanguageItem extends ContributionItem {

    /**
     * Mouse right click event
     */
    private static final int RIGHT_CLICK = 3;
    /**
     * Left and right margin used in CLabel.
     */
    private static final int INDENT = 3 * 2;
    /**
     * Default number of characters that should fit into the item.
     */
    private static final int WIDTH_IN_CHARS = 14;

    private CLabel fLabel;
    private int width = -1;
    private int height = -1;

    private final Action msAction = new Action(LANGUAGE.MS_SQL, IAction.AS_RADIO_BUTTON) {

        @Override
        public void run() {
            editor.changeLanguage(LANGUAGE.MS_SQL);
            updateLabel(LANGUAGE.MS_SQL);
        }
    };
    private final Action pgAction = new Action(LANGUAGE.POSTGRESQL, IAction.AS_RADIO_BUTTON) {

        @Override
        public void run() {
            editor.changeLanguage(LANGUAGE.POSTGRESQL);
            updateLabel(LANGUAGE.POSTGRESQL);
        }
    };

    private SQLEditor editor;

    public ChangeLanguageItem() {
        super("unknown ID"); //$NON-NLS-1$
        setVisible(true);
    }

    public void setActiveEditor(SQLEditor editor) {
        this.editor = editor;
    }

    @Override
    public void fill(Composite parent) {
        Label sep = new Label(parent, SWT.SEPARATOR);
        fLabel = new CLabel(parent, SWT.SHADOW_NONE);

        if (editor != null && !UIProjectLoader.isInProject(editor.getEditorInput())) {
            createContextMenu(fLabel);
            fLabel.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseDown(MouseEvent e) {
                    if (e.button == RIGHT_CLICK) {
                        fLabel.getMenu().setVisible(true);
                    }
                }
            });
        }

        StatusLineLayoutData data = new StatusLineLayoutData();
        data.widthHint = getWidthHint(parent);
        fLabel.setLayoutData(data);

        data = new StatusLineLayoutData();
        data.heightHint = getHeightHint(parent);
        sep.setLayoutData(data);

        if (editor != null) {
            updateLabel(editor.isMsSql() ? LANGUAGE.MS_SQL : LANGUAGE.POSTGRESQL);
        }
    }

    /**
     * Returns the width hint for this label.
     */
    private int getWidthHint(Composite control) {
        if (width < 0) {
            PixelConverter pc = new PixelConverter(control);
            width = pc.convertWidthInCharsToPixels(WIDTH_IN_CHARS) + INDENT;
        }
        return width;
    }

    /**
     * Returns the height hint for this label.
     */
    private int getHeightHint(Composite control) {
        if (height < 0) {
            PixelConverter pc = new PixelConverter(control);
            height = pc.convertHeightInCharsToPixels(8);
        }
        return height;
    }

    private void createContextMenu(Composite control) {
        MenuManager contextMenu = new MenuManager();
        contextMenu.add(pgAction);
        contextMenu.add(msAction);
        control.setMenu(contextMenu.createContextMenu(control));
    }

    private void updateLabel(String text) {
        if (fLabel != null && !fLabel.isDisposed()) {
            fLabel.setForeground(fLabel.getParent().getForeground());
            fLabel.setText(text);
            pgAction.setChecked(!LANGUAGE.MS_SQL.equals(text));
            msAction.setChecked(LANGUAGE.MS_SQL.equals(text));
        }
    }
}
