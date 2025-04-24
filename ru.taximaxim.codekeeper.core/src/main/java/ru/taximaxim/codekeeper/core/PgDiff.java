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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.CompareTree;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.model.difftree.TreeFlattener;
import ru.taximaxim.codekeeper.core.model.graph.ActionsToScriptConverter;
import ru.taximaxim.codekeeper.core.model.graph.DepcyResolver;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLActionType;
import ru.taximaxim.codekeeper.core.script.SQLScript;
import ru.taximaxim.codekeeper.core.settings.ISettings;

/**
 * Creates diff of two database schemas.
 *
 * @author fordfrog
 */
public class PgDiff {

    public static final Logger LOG = LoggerFactory.getLogger(PgDiff.class);
    protected final ISettings settings;
    protected final List<Object> errors = new ArrayList<>();

    public PgDiff(ISettings settings) {
        this.settings = settings;
    }

    public List<Object> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public String diff(AbstractDatabase oldDbFull, AbstractDatabase newDbFull, IgnoreList ignoreList)
            throws InterruptedException, IOException {
        TreeElement root = DiffTree.create(oldDbFull, newDbFull);
        root.setAllChecked();

        return switch (settings.getDbType()) {
            case MS -> diffMs(root, oldDbFull, newDbFull, null, null, ignoreList);
            case PG -> diffPg(root, oldDbFull, newDbFull, null, null, ignoreList);
            case CH -> diffCh(root, oldDbFull, newDbFull, null, null, ignoreList);
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + settings.getDbType());
        };
    }

    /**
     * Делает то же, что и метод выше, однако принимает TreeElement - как
     * элементы нужные для наката
     */
    public String diffDatabaseSchemasAdditionalDepcies(TreeElement root,
            AbstractDatabase oldDbFull, AbstractDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget) throws IOException {
        return switch (settings.getDbType()) {
            case MS -> diffMs(root, oldDbFull, newDbFull, additionalDepciesSource, additionalDepciesTarget, null);
            case PG -> diffPg(root, oldDbFull, newDbFull, additionalDepciesSource, additionalDepciesTarget, null);
            case CH -> diffCh(root, oldDbFull, newDbFull, additionalDepciesSource, additionalDepciesTarget, null);
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + settings.getDbType());
        };
    }

    private String diffPg(
            TreeElement root, AbstractDatabase oldDbFull, AbstractDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget,
            IgnoreList ignoreList) throws IOException {
        SQLScript script = new SQLScript(settings);

        for (String preFilePath : settings.getPreFilePath()) {
            addPrePostPath(script, preFilePath, SQLActionType.PRE);
        }

        if (settings.getTimeZone() != null) {
            script.addStatement("SET TIMEZONE TO " + PgDiffUtils.quoteString(settings.getTimeZone()),
                    SQLActionType.BEGIN);
        }

        if (settings.isDisableCheckFunctionBodies()) {
            script.addStatement("SET check_function_bodies = false", SQLActionType.BEGIN); //$NON-NLS-1$
        }

        if (settings.isAddTransaction()) {
            script.addStatement("START TRANSACTION", SQLActionType.BEGIN);
        }

        DepcyResolver depRes = new DepcyResolver(oldDbFull, newDbFull, settings);
        List<TreeElement> selected = getSelectedElements(root, ignoreList);
        createScript(depRes, selected, oldDbFull, newDbFull, additionalDepciesSource, additionalDepciesTarget);

        if (!depRes.getActions().isEmpty()) {
            script.addStatement("SET search_path = pg_catalog", SQLActionType.BEGIN); //$NON-NLS-1$
        }

        new ActionsToScriptConverter(script, depRes.getActions(), oldDbFull, newDbFull).fillScript(selected);

        if (settings.isAddTransaction()) {
            script.addStatement("COMMIT TRANSACTION", SQLActionType.END);
        }

        for (String postFilePath : settings.getPostFilePath()) {
            addPrePostPath(script, postFilePath, SQLActionType.POST);
        }
        return script.getFullScript();
    }

    private void addPrePostPath(SQLScript script, String scriptPath, SQLActionType actionType) throws IOException {
        Path path = Paths.get(scriptPath);
        addPrePostPath(script, path, actionType);
    }

    private void addPrePostPath(SQLScript script, Path path, SQLActionType actionType) throws IOException {
        if (Files.isRegularFile(path)) {
            addPrePostScript(script, path, actionType);
            return;
        }
        Stream<Path> stream = Files.list(path).sorted();
        for (Path child : PgDiffUtils.sIter(stream)) {
            addPrePostPath(script, child, actionType);
        }
    }

    private void addPrePostScript(SQLScript script, Path fileName, SQLActionType actionType) throws IOException {
        try {
            String prePostScript = new String(Files.readAllBytes(fileName), StandardCharsets.UTF_8);
            prePostScript = "-- " + fileName + "\n\n" + prePostScript; //$NON-NLS-1$ //$NON-NLS-2$
            script.addStatementWithoutSeparator(prePostScript, actionType);
        } catch (IOException e) {
            throw new IOException(Messages.PgDiff_read_error + e.getLocalizedMessage(), e);
        }
    }

    private String diffMs(
            TreeElement root, AbstractDatabase oldDbFull, AbstractDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget,
            IgnoreList ignoreList) {
        SQLScript script = new SQLScript(settings);

        if (settings.isAddTransaction()) {
            script.addStatement("BEGIN TRANSACTION", SQLActionType.BEGIN);
        }

        DepcyResolver depRes = new DepcyResolver(oldDbFull, newDbFull, settings);
        List<TreeElement> selected = getSelectedElements(root, ignoreList);
        createScript(depRes, selected, oldDbFull, newDbFull, additionalDepciesSource, additionalDepciesTarget);
        new ActionsToScriptConverter(script, depRes.getActions(), depRes.getToRefresh(), oldDbFull,
                newDbFull).fillScript(selected);

        if (settings.isAddTransaction()) {
            script.addStatement("COMMIT", SQLActionType.END);
        }

        return script.getFullScript();
    }

    private String diffCh(
            TreeElement root, AbstractDatabase oldDbFull, AbstractDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget,
            IgnoreList ignoreList) {
        SQLScript script = new SQLScript(settings);

        DepcyResolver depRes = new DepcyResolver(oldDbFull, newDbFull, settings);
        List<TreeElement> selected = getSelectedElements(root, ignoreList);
        createScript(depRes, selected, oldDbFull, newDbFull, additionalDepciesSource, additionalDepciesTarget);
        new ActionsToScriptConverter(script, depRes.getActions(), oldDbFull, newDbFull).fillScript(selected);

        return script.getFullScript();
    }

    protected List<TreeElement> getSelectedElements(TreeElement root, IgnoreList ignoreList) {
        return new TreeFlattener(settings)
                .onlySelected()
                .useIgnoreList(ignoreList)
                .onlyTypes(settings.getAllowedTypes())
                .flatten(root);
    }

    private void createScript(DepcyResolver depRes, List<TreeElement> selected,
            AbstractDatabase oldDbFull, AbstractDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget) {
        if (additionalDepciesSource != null) {
            depRes.addCustomDepciesToOld(additionalDepciesSource);
        }
        if (additionalDepciesTarget != null) {
            depRes.addCustomDepciesToNew(additionalDepciesTarget);
        }

        //TODO----------КОСТЫЛЬ колонки добавляются как выбранные если выбрана таблица-----------
        addColumnsAsElements(oldDbFull, newDbFull, selected);
        // ---КОСТЫЛЬ-----------

        Collections.sort(selected, new CompareTree());
        for (TreeElement st : selected) {
            switch (st.getSide()) {
            case LEFT:
                depRes.addDropStatements(st.getPgStatement(oldDbFull));
                break;
            case BOTH:
                depRes.addAlterStatements(st.getPgStatement(oldDbFull), st.getPgStatement(newDbFull));
                break;
            case RIGHT:
                depRes.addCreateStatements(st.getPgStatement(newDbFull));
                break;
            }
        }
        depRes.recreateDrops();
        depRes.removeExtraActions();
    }

    /**
     * После реализации колонок как подэлементов таблицы выпилить метод!
     */
    @Deprecated
    private void addColumnsAsElements(AbstractDatabase oldDbFull, AbstractDatabase newDbFull,
            List<TreeElement> selected) {
        List<TreeElement> tempColumns = new ArrayList<>();
        for (TreeElement el : selected) {
            if (el.getType() == DbObjType.TABLE && el.getSide() == DiffSide.BOTH) {
                AbstractTable oldTbl = (AbstractTable) el.getPgStatement(oldDbFull);
                AbstractTable newTbl = (AbstractTable) el.getPgStatement(newDbFull);
                DiffTree.addColumns(oldTbl.getColumns(), newTbl.getColumns(), el, tempColumns);
            }
        }
        selected.addAll(tempColumns);
    }
}
