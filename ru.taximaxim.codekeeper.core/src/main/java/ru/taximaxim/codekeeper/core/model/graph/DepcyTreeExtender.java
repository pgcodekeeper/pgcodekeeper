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
package ru.taximaxim.codekeeper.core.model.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.model.difftree.TreeFlattener;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.settings.ISettings;

/**
 * По выбранным элементам в дереве, находит зависимые элементы в дереве,
 * используя мех-м поиска зависимостей
 *
 * @author botov_av
 *
 */
public class DepcyTreeExtender {

    private final AbstractDatabase dbSource;
    private final AbstractDatabase dbTarget;
    private final SimpleDepcyResolver depRes;
    private final TreeElement root;
    /**
     * Элементы выбранные пользователем для наката на Проект
     */
    private final List<TreeElement> userSelection;
    /**
     * Зависимые элементы от создаваемых(содержат выбор пользователя)
     */
    private final List<TreeElement> treeDepcyNewEdit = new ArrayList<>();
    /**
     * Зависимые элементы от удаляемых(содержат выбор пользователя)
     */
    private final List<TreeElement> treeDepcyDelete = new ArrayList<>();

    public DepcyTreeExtender(AbstractDatabase dbSource, AbstractDatabase dbTarget, TreeElement root,
            ISettings settings) {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        this.root = root;
        userSelection = new TreeFlattener().onlySelected().flatten(root, settings);
        depRes = new SimpleDepcyResolver(dbSource, dbTarget, false, settings);
    }

    /**
     * При редактированном состоянии или создаваемом объекте тянет зависимости
     * сверху, для создания,изменения объекта
     */
    private void fillDepcyOfNewEdit() {
        PgStatement markedToCreate;
        Set<PgStatement> newEditDepcy = new HashSet<>();
        for (TreeElement sel : userSelection) {
            if (sel.getSide() != DiffSide.LEFT
                    && (markedToCreate = sel.getPgStatement(dbTarget)) != null){
                newEditDepcy.addAll(depRes.getCreateDepcies(markedToCreate));
            }
        }
        fillTreeDepcies(treeDepcyNewEdit, newEditDepcy);
    }

    /**
     * При удалении объекта тянет зависимости снизу
     */
    private void fillDepcyOfDeleted() {
        PgStatement markedToDelete;
        Set<PgStatement> deleteDepcy = new HashSet<>();
        for (TreeElement sel : userSelection) {
            if (sel.getSide() == DiffSide.LEFT
                    && sel.getType() != DbObjType.SEQUENCE
                    && (markedToDelete = sel.getPgStatement(dbSource)) != null) {
                deleteDepcy.addAll(depRes.getDropDepcies(markedToDelete));
            }
        }
        fillTreeDepcies(treeDepcyDelete, deleteDepcy);
    }

    /**
     * вытаскивает из дерева объект для зависимости
     * @param treeDepcy
     * @param pgDecies
     */
    private void fillTreeDepcies(List<TreeElement> treeDepcy, Collection<PgStatement> pgDecies) {
        for (PgStatement depcy : pgDecies) {
            TreeElement finded = root.findElement(depcy);
            if (finded != null) {
                if (finded.getSide() == DiffSide.BOTH) {
                    if (!finded.getPgStatement(dbSource).compare(finded.getPgStatement(dbTarget))) {
                        treeDepcy.add(finded);
                    }
                } else {
                    treeDepcy.add(finded);
                }
            }
        }
    }
    /**
     * Возвращает все зависимые элементы для показа в нижней части таблицы
     * @return зависимые элементы от выбора
     */
    public Set<TreeElement> getDepcies() {
        Set<TreeElement> res = new HashSet<>();
        fillDepcyOfNewEdit();
        fillDepcyOfDeleted();
        res.addAll(treeDepcyNewEdit);
        res.addAll(treeDepcyDelete);
        // удалить все объекты которые выбрал пользователь
        res.removeAll(userSelection);
        return res;
    }
}
