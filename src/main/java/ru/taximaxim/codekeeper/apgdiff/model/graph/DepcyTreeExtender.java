package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.util.HashSet;
import java.util.Set;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;

public class DepcyTreeExtender {
    private HashSet<PgStatement> dependantsOfDeleted = new HashSet<PgStatement>(5);
    /**
     * Набор элементов дерева, которые зависят от удаленных и должны 
     * быть удалены, но не были в первоначальном фильтрованном дереве или были 
     * отмечены как NEW/EDIT
     */
    private HashSet<TreeElement> newlyDeletedDependants;
    
    private DepcyGraph depcySource;
    private DepcyGraph depcyTarget;
    private PgDatabase dbSource;
    private PgDatabase dbTarget;
    /**
     * Root node of filtered tree (should not be modified)
     */
    final private TreeElement root;
    /**
     * Copy of root, including those dependant from DELETED
     */
    private TreeElement copy;
    
    public DepcyTreeExtender(PgDatabase dbSource, PgDatabase dbTarget, TreeElement root) {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        this.root = root;
        
        // depcy graphs
        depcySource = new DepcyGraph(dbSource);
        depcyTarget = new DepcyGraph(dbTarget);
        
        newlyDeletedDependants = new HashSet<TreeElement>();
    }
    
    /**
     * Возвращает список объектов, от которых зависят уже выбранные пользователем
     * элементы EDIT/NEW (объекты в TARGET-базе)
     * 
     * @return
     */
    public HashSet<PgStatement> getDependenciesOfNew(){
        // заполнить сет зависимыми элементами, которые надо создать
        HashSet<PgStatement> depcySet = new HashSet<PgStatement>();
        extendNew(root, depcySet);
        return depcySet;
    }
    
    /**
     * Возвращает копию дерева <code>root</code>, дополненную зависимостями
     * 
     * @param filtered
     * @return
     */
    public TreeElement getTreeCopyWithDepcy(){
        copy = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        extendDelete(root);
        
        // скопировать дерево первоначального выбора пользователя, перемещая 
        // налево элементы, содержащиеся в сете shouldBeDeleted
        copyFilteredToNew(root, copy);
        
        // так же поместить налево элементы, которые не были в первоначальном 
        // выборе пользователя, но которые надо таки удалить из бд
        addDeleted(copy);

        return copy;
    }

    /**
     * Смотрит на стороне EDIT/NEW по базе TARGET
     * 
     * @param filtered
     * @param copy
     */
    private void extendNew(TreeElement filtered, HashSet<PgStatement> depcySet) {
        PgStatement markedToCreate = null;
        
        // if not a Container and is marked for creation/edit
        if ((filtered.getSide() != DiffSide.LEFT && filtered.getType() != DbObjType.CONTAINER) && 
                (markedToCreate = filtered.getPgStatement(dbTarget)) != null){
            PgDiff.getDependenciesSet(markedToCreate, depcySet, depcyTarget.getGraph());
        }
        
        for(TreeElement sub : filtered.getChildren()) {
            extendNew(sub, depcySet);
        }
    }

    /**
     * Дополняет дерево <code>copy</code> зависимостями, которые должны быть
     * удалены, но не были в первоначальном фильтрованном дереве
     * 
     * @param copy
     */
    private void addDeleted(TreeElement copy) {
        for (PgStatement toBeAdded : dependantsOfDeleted) {
            if (toBeAdded instanceof PgColumn){
                continue;
            }
            PgStatement emptyWithDeleted = getDbWithStatement(toBeAdded);
            while (!(emptyWithDeleted instanceof PgDatabase)) {
                emptyWithDeleted = emptyWithDeleted.getParent();
            }
            // Пустое дерево, содержащее только один объект, который надо удалить
            TreeElement tree = DiffTree.create((PgDatabase) emptyWithDeleted, new PgDatabase());

            TreeElement tee = tree;
            TreeElement tee_root = copy;
            while (tee_root != null) {
                tee = getEmptyTreeChild(tee, DiffSide.LEFT);

                if(tee == null){
                    if (tee_root.getSide() != DiffSide.LEFT){
                        // TODO удалить/рефакторить дебаг эксепшен
                        throw new IllegalStateException("Какой-то левый объект в"
                                + " дереве при добавлении удаляемых зависимостей:"
                                + " объект не с левой стороны");
                    }
                    newlyDeletedDependants.add(tee_root);
                    tee_root = null;
                    continue;
                }
                TreeElement tree_root_2 = null;
                if ((tree_root_2 = tee_root.getChild(tee.getName(),
                        tee.getType())) == null) {
                    break;
                }
                tee_root = tree_root_2;
            }
            // пройтись вниз до конца дерева tree, копируя все листья в tee_root
            while (tee != null) {
                DiffSide side = tee.getSide();
                // special case: default "public" schema
                if (tee.getType() == DbObjType.SCHEMA
                        && tee.getName().equals("public")) {
                    side = DiffSide.BOTH;
                }
                tee_root.addChild(new TreeElement(tee.getName(), tee.getType(),
                        tee.getContainerType(), side));
                tee_root = tee_root.getChild(tee.getName());
                if (tee.getChildren().isEmpty()){
                    newlyDeletedDependants.add(tee);
                }
                tee = getEmptyTreeChild(tee, DiffSide.LEFT);
            }

        }
    }
    
    /**
     * На вход получает дерево tree, которое должно быть пустым деревом с одной
     * добавленной ветвью (дерево-представление пустой бд с единственным 
     * добавлененым объектом, например, вьюхой)
     * 
     * @param tree
     * @param right 
     * @param side
     * @return
     */
    private TreeElement getEmptyTreeChild(TreeElement tree, DiffSide side){
        for (TreeElement e : tree.getChildren()){
            if (e.getSide() == side && !e.getChildren().isEmpty()){
                return e;
            }
        }
        return tree.getChildren().isEmpty() ? null : tree.getChild(0);
    }

    /**
     * Рекурсивный метод, возвращающий новую пустую БД, содержащую только 
     * shallow-копии элементов до shallow-копии <code>toBeAdded</code>, включительно.
     * Важно: пустая БД обязательно содержит трех потомков Database (different, 
     * source only, target only) 
     * 
     * @param toBeAdded
     */
    public PgStatement getDbWithStatement(PgStatement toBeAdded) {
        
        if (toBeAdded instanceof PgDatabase){
            return new PgDatabase();
        }

        PgStatement parent = getDbWithStatement(toBeAdded.getParent());
        PgStatement copy = toBeAdded.shallowCopy();
        if (copy instanceof PgFunction){
            ((PgSchema)parent).addFunction((PgFunction)copy);
        }else if (copy instanceof PgView){
            ((PgSchema)parent).addView((PgView)copy);
        }else if (copy instanceof PgTable){
            ((PgSchema)parent).addTable((PgTable)copy);
        }else if (copy instanceof PgSequence){
            ((PgSchema)parent).addSequence((PgSequence)copy);
        }else if (copy instanceof PgSchema){
            if (copy.getName().equals("public")){
                copy = ((PgDatabase)parent).getSchema("public");
            }else{
                ((PgDatabase)parent).addSchema((PgSchema)copy);
            }
        }else if (copy instanceof PgConstraint){
            ((PgTable)parent).addConstraint((PgConstraint)copy);
        }else if (copy instanceof PgIndex){
            ((PgTable)parent).addIndex((PgIndex)copy);
        }else if (copy instanceof PgTrigger){
            ((PgTable)parent).addTrigger((PgTrigger)copy);
        }else if (copy instanceof PgColumn){
            ((PgTable)parent).addColumn((PgColumn)copy);
        } 
        return copy;
    }
    
    /**
     * Копирует дерево в copy. Если находится объект, который есть в списке 
     * зависимостей на удаление, то копирует его и всех его потомков по дереву со стороной LEFT
     * 
     * @param filtered
     * @param copy
     */
    private void copyFilteredToNew(TreeElement filtered, TreeElement copy) {
        for (TreeElement child : filtered.getChildren()){
            PgStatement zisInSource = null;
            TreeElement childCopy = null;
            DiffSide side = child.getSide();
            boolean sideChanged = false;
            // если это уже выбранный пользователем элемент на УДАЛЕНИЕ
            if (child.getSide() == DiffSide.LEFT){
                zisInSource = child.getPgStatement(depcySource.getDb());
                dependantsOfDeleted.remove(zisInSource);
            }
            // иначе если это элемент, который не надо было удалять (EDIT)
            else if (child.getSide() == DiffSide.BOTH && (zisInSource = child.getPgStatement(depcySource.getDb())) != null && dependantsOfDeleted.contains(zisInSource)){
                side = DiffSide.LEFT;
                dependantsOfDeleted.remove(zisInSource);
                sideChanged = true;
            }
            
            childCopy = new TreeElement(child.getName(), child.getType(), child.getContainerType(), side);
            copy.addChild(childCopy);
            if(sideChanged){
                newlyDeletedDependants.add(childCopy);
            }
            copyFilteredToNew(child, childCopy);
        }
    }

    /**
     * Заполняет сет dependantsOfDeleted элементами, зависимыми от элементов в 
     * отфильтрованном дереве, отмеченными на удаление
     * 
     * @param filtered
     */
    private void extendDelete(TreeElement filtered) {
        PgStatement markedToDelete = null;
        
        // if not a Container and is marked for deletion
        if ((filtered.getSide() == DiffSide.LEFT && filtered.getType() != DbObjType.CONTAINER) && 
                (markedToDelete = filtered.getPgStatement(dbSource)) != null){
            PgDiff.getDependantsSet(markedToDelete, dependantsOfDeleted, depcySource.getGraph());
        }
        
        for(TreeElement sub : filtered.getChildren()) {
            extendDelete(sub);
        }
    }
    
    public TreeElement getCorrespondingTreeElement(TreeElement element, TreeElement sourceTree) {
        if (element == null){
            return null;
        }
        
        TreeElement pi = getCorrespondingTreeElement(element.getParent(), sourceTree);
        if (pi != null){
            return pi.getChild(element.getName(), element.getType());
        }else{
            return sourceTree;
        }
    }
    
    public PgDatabase getDepcyTargetDb() { 
        return depcyTarget.getDb();
    }
    
    /**
     * Вспомогательный метод для генерации набора элементов, которые являются 
     * объектами и могут быть выбраны пользователем.
     * <br><br>Копия метода DiffTableViewer.generateFlatElementsMap
     * @return
     */
    public void generateFlatElementsSet (TreeElement subtree,  Set<TreeElement> elements){
        if (subtree.hasChildren()) {
            for (TreeElement child : subtree.getChildren()) {
                generateFlatElementsSet(child, elements);
            }
        }
        
        boolean doNotInclude = 
                (subtree.getSide() == DiffSide.BOTH && subtree.getParent() != null 
                && subtree.getParent().getSide() != DiffSide.BOTH)
                || subtree.getType() == DbObjType.CONTAINER
                || subtree.getType() == DbObjType.DATABASE;
        if (doNotInclude) {
            return;
        }
        if ((subtree.getSide() == DiffSide.BOTH && 
                subtree.getPgStatement(dbSource).compare(
                        subtree.getPgStatement(dbTarget)))) {
            return;
        }
        elements.add(subtree);
    }

    /**
     * Добавляет к существующим зависимостям (зависимым от DELETE-элементов)
     * копии элементов из набора <code>elementsDepcyNEW</code>, являющиеся 
     * потомками <code>copy</code><br>
     * Входной набор <code>elementsDepcyNEW</code> может не быть набором потомков <code>copy</code>
     * 
     * @param elementsDepcyNEW
     * @return
     */
    public HashSet<TreeElement> sumAllDepcies(HashSet<TreeElement> elementsDepcyNEW) {
        if (copy == null){
            throw new IllegalStateException("Root (filtered) tree has not been "
                    + "copyed yet and no DELETED dependants 've been found! "
                    + "Call getTreeCopyWithDepcy() first.");
        }
        HashSet<TreeElement> sumNewAndDelete = new HashSet<TreeElement>();
        sumNewAndDelete.addAll(newlyDeletedDependants);

        // переместить объекты (НЕ потомки filtered_with_new_and_delete) из elementsDepcyNEW в 
        // соответствующие объекты, но уже потомки filtered_with_new_and_delete
        for(TreeElement el : elementsDepcyNEW){
            sumNewAndDelete.add(getCorrespondingTreeElement(el, copy));
        }
        
        return sumNewAndDelete;
    }
}