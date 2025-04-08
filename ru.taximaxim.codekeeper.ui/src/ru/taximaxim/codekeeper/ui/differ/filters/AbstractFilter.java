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
package ru.taximaxim.codekeeper.ui.differ.filters;

import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.settings.ISettings;
import ru.taximaxim.codekeeper.ui.dialogs.FilterDialog;
import ru.taximaxim.codekeeper.ui.differ.ElementMetaInfo;
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
     * @param elementInfoMap - full collection of elements with meta information
     * @param dbProject - project database
     * @param dbRemote - remote database
     * @return true if element meets the conditions
     */
    public abstract boolean checkElement(TreeElement el, Map<TreeElement, ElementMetaInfo> elementInfoMap,
            AbstractDatabase dbProject, AbstractDatabase dbRemote, ISettings settings);

    /**
     * Looks for matches in a given string by filter pattern
     *
     * @param string - string in which you want to check for matches
     * @return true if find matches
     */
    protected boolean searchMatches(String string) {
        if (regExPattern != null) {
            Matcher matcher = regExPattern.matcher(string);
            return matcher.find();
        }
        return string.toLowerCase(Locale.ROOT).indexOf(pattern.toLowerCase(Locale.ROOT)) > -1;
    }
}
