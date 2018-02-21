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
 * Base implementation of  project editor filter. Subclasses must override
 * checkElement method.
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

    /**
     * Updates filter fields
     *
     * @param pattern - new pattern string
     * @param useRegEx - new value for using regex
     */
    public void updateFields(String pattern, boolean useRegEx) {
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

    public boolean isEmpty() {
        return pattern.isEmpty();
    }

    public boolean isUseRegex() {
        return useRegEx;
    }

    /**
     * Checks if the element meets the conditions
     *
     * @param el - checked element
     * @param elements - full collection of elements
     * @param dbProject - project database
     * @param dbRemote - remote database
     * @return true if element meets the conditions
     */
    public abstract boolean checkElement(TreeElement el, Set<TreeElement> elements,
            PgDatabase dbProject, PgDatabase dbRemote);

    /**
     * Looks for matches in a given string by filter pattern
     *
     * @param string - string in which you want to check for matches
     * @return true if find matches
     */
    public boolean searchMatches(String string) {
        if (regExPattern != null) {
            Matcher matcher = regExPattern.matcher(string);
            return matcher.find();
        }
        return string.indexOf(pattern.toLowerCase()) > -1;
    }
}
