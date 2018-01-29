package ru.taximaxim.codekeeper.ui.differ.filters;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.dialogs.FilterDialog;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;

/**
 * Base implementation of  project editor filter
 *
 * @since 4.2.0.
 * @author galiev_mr
 * @see ProjectEditorDiffer
 * @see FilterDialog
 */
public abstract class AbstractFilter {

    protected String pattern = ""; //$NON-NLS-1$
    protected boolean useRegEx;
    protected Pattern regExPattern;

    public void update(String pattern, boolean useRegEx) {
        this.pattern = pattern;
        this.useRegEx = useRegEx;
        if (useRegEx) {
            try {
                regExPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
            } catch (PatternSyntaxException e) {
                regExPattern = null;
            }
        } else {
            regExPattern = null;
        }

    }

    public String getPattern() {
        return pattern;
    }

    public boolean isUseRegex() {
        return useRegEx;
    }

    public abstract boolean find(TreeElement el, Set<TreeElement> elements,
            PgDatabase dbProject, PgDatabase dbRemote);

    protected boolean checkCode(String code) {
        if (regExPattern != null) {
            Matcher matcher = regExPattern.matcher(code);
            return matcher.find();
        }
        return code.indexOf(pattern.toLowerCase()) > -1;
    }
}
