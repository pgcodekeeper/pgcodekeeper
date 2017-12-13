package ru.taximaxim.codekeeper.ui.differ;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class CodeFilter {

    private static final String EMPTY_STRING = ""; //$NON-NLS-1$

    private String pattern = EMPTY_STRING;
    private boolean useRegEx;

    private Text text;
    private Button btnRegEx;

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout(2, false);
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        container.setLayout(layout);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

        Label txtFilter = new Label(container, SWT.NONE);
        txtFilter.setText(Messages.CodeFilter_search_by_code);
        txtFilter.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

        text = new Text(container, SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
        text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        text.setText(pattern);

        btnRegEx = new Button(container, SWT.CHECK);
        btnRegEx.setText(Messages.diffTableViewer_use_regular_expressions);
        btnRegEx.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        btnRegEx.setSelection(useRegEx);
    }

    public void clear() {
        text.setText(EMPTY_STRING);
        btnRegEx.setSelection(false);
    }

    public void update() {
        pattern = text.getText();
        useRegEx = btnRegEx.getSelection();
    }

    public String getPattern() {
        return pattern;
    }

    public boolean findCode(TreeElement el, Set<TreeElement> elements,
            PgDatabase dbProject, PgDatabase dbRemote) {
        Pattern regExPattern = null;

        if (useRegEx) {
            try {
                regExPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
            } catch (PatternSyntaxException e) {
                regExPattern = null;
            }
        }

        if (el.getSide() != DiffSide.RIGHT && checkSide(el, regExPattern, dbProject, elements)) {
            return true;
        }

        if (el.getSide() != DiffSide.LEFT) {
            return checkSide(el, regExPattern, dbRemote, elements);
        }

        return false;
    }

    private boolean checkSide(TreeElement el, Pattern regExPattern, PgDatabase db, Set<TreeElement> elements) {
        PgStatement statement = el.getPgStatement(db);
        if (statement != null) {
            if (checkCode(regExPattern, getCode(statement))) {
                return true;
            }

            if (DiffTableViewer.isSubElement(el)) {
                PgStatement parent = el.getParent().getPgStatement(db);
                if (parent != null) {
                    return checkCode(regExPattern, getCode(parent));
                }
            }

            if (DiffTableViewer.isContainer(el)) {
                return el.getChildren().stream().filter(elements::contains)
                        .map(e -> e.getPgStatement(db))
                        .filter(s -> s != null && checkCode(regExPattern, getCode(s)))
                        .count() > 0;
            }
        }

        return false;
    }

    private String getCode(PgStatement statement) {
        return statement.getCreationSQL().toLowerCase();
    }

    private boolean checkCode(Pattern regExPattern, String code) {
        if (useRegEx && regExPattern != null) {
            Matcher matcher = regExPattern.matcher(code);
            if (matcher.find()) {
                return true;
            }
        } else if (code.indexOf(pattern.toLowerCase()) > -1) {
            return true;
        }
        return false;
    }
}
