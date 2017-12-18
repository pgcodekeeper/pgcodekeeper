package ru.taximaxim.codekeeper.ui.differ;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;

/**
 * Contains information of code search
 *
 * @since 4.1.2.
 * @author galiev_mr
 *
 */
public class CodeFilter {

    private String pattern = ""; //$NON-NLS-1$
    private boolean useRegEx;

    public void update(String pattern, boolean useRegEx) {
        this.pattern = pattern;
        this.useRegEx = useRegEx;
    }

    public String getPattern() {
        return pattern;
    }

    public boolean isUseRegex() {
        return useRegEx;
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
