package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import cz.startnet.utils.pgdiff.PgCodekeeperException;
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
    private final Set<PgStatement> dependantsOfDeleted = new HashSet<>();
    /**
     * Набор элементов дерева, которые зависят от удаленных и должны 
     * быть удалены, но не были в первоначальном фильтрованном дереве или были 
     * отмечены как NEW/EDIT
     */
    private final Set<TreeElement> newlyDeletedDependants = new HashSet<>();
    private final Set<TreeElement> conflictingDeletedElements = new HashSet<>();
    
    private final DepcyGraph depcySource;
    private final DepcyGraph depcyTarget;
    private final PgDatabase dbSource;
    private final PgDatabase dbTarget;
    /**
     * Root node of filtered tree (should not be modified)
     */
    private final TreeElement root;
    /**
     * Copy of root, extended by dependent from DELETED elements
     */
    private TreeElement copy;
    
    public DepcyTreeExtender(PgDatabase dbSource, PgDatabase dbTarget, TreeElement root) 
            throws PgCodekeeperException {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        this.root = root;
        
        // depcy graphs
        depcySource = new DepcyGraph(dbSource);
        depcyTarget = new DepcyGraph(dbTarget);
    }
    
    /**
     * Возвращает список объектов, от которых зависят уже выбранные пользователем
     * элементы EDIT/NEW (объекты в TARGET-базе)
     * 
     * @return
     */
    public Set<PgStatement> getDependenciesOfNew(){
        // заполнить сет зависимыми элементами, которые надо создать
        Set<PgStatement> depcySet = new HashSet<>();
        fillInDependenciesOfNew(root, depcySet);
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
        fillInDependantsOfDeleted(root);
        
        // скопировать дерево первоначального выбора пользователя, перемещая 
        // налево элементы, содержащиеся в сете shouldBeDeleted
        copyFilteredToNew(root, copy);
        
        // так же поместить налево элементы, которые не были в первоначальном 
        // выборе пользователя, но которые надо таки удалить из бд
        extendTreeByNewlyDeleted(copy);

        return copy;
    }

    /**
     * Смотрит на стороне EDIT/NEW по базе TARGET
     * 
     * @param filtered
     * @param copy
     */
    private void fillInDependenciesOfNew(TreeElement filtered, Set<PgStatement> depcySet) {
        PgStatement markedToCreate = null;
        
        // if not a Container and is marked for creation/edit
        if (filtered.getSide() != DiffSide.LEFT && 
                filtered.getType() != DbObjType.CONTAINER && 
                (markedToCreate = filtered.getPgStatement(dbTarget)) != null){
            PgDiff.getDependenciesSet(markedToCreate, depcySet, false, depcyTarget.getGraph());
        }
        
        for(TreeElement child : filtered.getChildren()) {
            fillInDependenciesOfNew(child, depcySet);
        }
    }

    /**
     * Заполняет сет dependantsOfDeleted элементами, зависимыми от элементов в 
     * отфильтрованном дереве, отмеченными на удаление
     * 
     * @param filtered
     */
    private void fillInDependantsOfDeleted(TreeElement filtered) {
        PgStatement markedToDelete = null;
        
        // if not a Container and is marked for deletion
        if (filtered.getSide() == DiffSide.LEFT && 
                filtered.getType() != DbObjType.CONTAINER && 
                filtered.getType() != DbObjType.SEQUENCE && 
                (markedToDelete = filtered.getPgStatement(dbSource)) != null){
            PgDiff.getDependantsSet(markedToDelete, dependantsOfDeleted, depcySource);
        }
        
        for(TreeElement child : filtered.getChildren()) {
            fillInDependantsOfDeleted(child);
        }
    }

    /**
     * Дополняет дерево <code>copy</code> зависимостями, которые должны быть
     * удалены, но не были в первоначальном фильтрованном дереве
     * 
     * @param copy
     */
    private void extendTreeByNewlyDeleted(TreeElement copy) {
        for (PgStatement toBeAdded : dependantsOfDeleted) {
            if (toBeAdded instanceof PgColumn){
                continue;
            }
            
            PgStatement emptyWithDeleted = getDbWithStatement(toBeAdded);
            while (!(emptyWithDeleted instanceof PgDatabase)) {
                emptyWithDeleted = emptyWithDeleted.getParent();
            }
            
            // Пустое дерево, содержащее только один объект, который надо удалить
            TreeElement elementInEmptyTree = DiffTree.create((PgDatabase) emptyWithDeleted, new PgDatabase());

            TreeElement elementInCopy = copy;
            TreeElement childElement = copy;
            while (childElement != null) {
                elementInCopy = childElement;
                elementInEmptyTree = getEmptyTreeChild(elementInEmptyTree, DiffSide.LEFT);

                if(elementInEmptyTree == null){
                    if (elementInCopy.getSide() != DiffSide.LEFT){
                        throw new IllegalStateException("Какой-то странный объект в"
                                + " дереве при добавлении удаляемых зависимостей:"
                                + " объект не с левой стороны");
                    }
                    break;
                }
                
                childElement = elementInCopy.getChild(elementInEmptyTree.getName(),
                        elementInEmptyTree.getType());
            }
            
            // пройтись вниз до конца дерева tree, копируя все листья в tee_root
            while (elementInEmptyTree != null) {
                DiffSide side = elementInEmptyTree.getSide();
                List<TreeElement> children = elementInEmptyTree.getChildren();
                
                // special case: default public schema
                if (elementInEmptyTree.getType() == DbObjType.SCHEMA
                        && elementInEmptyTree.getName().equals(ApgdiffConsts.PUBLIC) &&
                        !children.isEmpty()) {
                    side = DiffSide.BOTH;
                }
                TreeElement child = new TreeElement(elementInEmptyTree.getName(),
                        elementInEmptyTree.getType(), elementInEmptyTree.getContainerType(), side);
                elementInCopy.addChild(child);
                elementInCopy = child;
                
                elementInEmptyTree = getEmptyTreeChild(elementInEmptyTree, DiffSide.LEFT);
            }
            newlyDeletedDependants.add(elementInCopy);
        }
    }
    
    /**
     * На вход получает дерево tree, которое должно быть пустым деревом 
     * (или его потомком) с одной добавленной ветвью (дерево-представление 
     * пустой бд с единственным добавлененым объектом, например, вьюхой).
     * Возвращает следующего потомка, расположенного на стороне <code>side</code>,
     * либо потомка на любой стороне, если он единственный
     */
    private TreeElement getEmptyTreeChild(TreeElement tree, DiffSide side){
        List<TreeElement> children = tree.getChildren();
        for (TreeElement e : children){
            if (e.getSide() == side /*&& !e.getChildren().isEmpty()*/){
                return e;
            }
        }
        
        return children.size() == 1 ? children.get(0) : null;
    }

    /**
     * Возвращает shallow-копию <code>toBeAdded</code> в составе новой пустой БД,
     * содержащей только shallow-копии элементов вплоть до возвращаемого объекта.
     */
    private PgStatement getDbWithStatement(PgStatement toBeAdded) {
        
        if (toBeAdded instanceof PgDatabase){
            return new PgDatabase();
        }

        PgStatement parent = getDbWithStatement(toBeAdded.getParent());
        PgStatement stCopy = toBeAdded.shallowCopy();
        if (stCopy instanceof PgFunction){
            ((PgSchema)parent).addFunction((PgFunction)stCopy);
        }else if (stCopy instanceof PgView){
            ((PgSchema)parent).addView((PgView)stCopy);
        }else if (stCopy instanceof PgTable){
            ((PgSchema)parent).addTable((PgTable)stCopy);
        }else if (stCopy instanceof PgSequence){
            ((PgSchema)parent).addSequence((PgSequence)stCopy);
        }else if (stCopy instanceof PgSchema){
            if (stCopy.getName().equals(ApgdiffConsts.PUBLIC)){
                stCopy = ((PgDatabase)parent).getSchema(ApgdiffConsts.PUBLIC);
            }else{
                ((PgDatabase)parent).addSchema((PgSchema)stCopy);
            }
        }else if (stCopy instanceof PgConstraint){
            ((PgTable)parent).addConstraint((PgConstraint)stCopy);
        }else if (stCopy instanceof PgIndex){
            ((PgTable)parent).addIndex((PgIndex)stCopy);
        }else if (stCopy instanceof PgTrigger){
            ((PgTable)parent).addTrigger((PgTrigger)stCopy);
        }else if (stCopy instanceof PgColumn){
            ((PgTable)parent).addColumn((PgColumn)stCopy);
        } 
        return stCopy;
    }
    
    /**
     * Копирует дерево в copy. Если находится объект, который есть в списке 
     * зависимостей на удаление, то копирует его со стороной LEFT
     * 
     * @param filtered
     * @param copy
     */
    private void copyFilteredToNew(TreeElement filtered, TreeElement copy) {
        for (TreeElement child : filtered.getChildren()){
            PgStatement objectInSourceDb = null;
            boolean sideChanged = false;
            // если это уже выбранный пользователем элемент на УДАЛЕНИЕ
            if (child.getSide() == DiffSide.LEFT){
                dependantsOfDeleted.remove(child.getPgStatement(depcySource.getDb()));
            }
            // иначе если это элемент, который не надо было удалять (EDIT)
            else if (child.getSide() == DiffSide.BOTH &&
                    (objectInSourceDb = child.getPgStatement(depcySource.getDb())) != null &&
                    dependantsOfDeleted.remove(objectInSourceDb)){
                sideChanged = true;
                copy.addChild(new TreeElement(child.getName(), child.getType(),
                        child.getContainerType(), DiffSide.LEFT));
            }
            
            TreeElement childCopy = new TreeElement(child.getName(), child.getType(),
                    child.getContainerType(), child.getSide());
            copy.addChild(childCopy);
            if(sideChanged){
                conflictingDeletedElements.add(childCopy);
            }
            copyFilteredToNew(child, childCopy);
        }
    }

    private TreeElement getCorrespondingTreeElement(TreeElement element, TreeElement sourceTree) {
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
     * Добавляет к существующим зависимостям (зависимым от DELETE-элементов)
     * копии элементов из набора <code>elementsDepcyNew</code>, являющиеся 
     * потомками <code>copy</code><br>
     * Входной набор <code>elementsDepcyNew</code> может не быть набором потомков <code>copy</code>
     * 
     * @param elementsDepcyNew
     * @return
     */
    public Set<TreeElement> sumAllDepcies(Set<TreeElement> elementsDepcyNew) {
        if (copy == null){
            throw new IllegalStateException("Root (filtered) tree has not been "
                    + "copyed yet and no DELETED dependants 've been found! "
                    + "Call getTreeCopyWithDepcy() first.");
        }
        Set<TreeElement> sumNewAndDelete = new HashSet<>();
        sumNewAndDelete.addAll(newlyDeletedDependants);
        sumNewAndDelete.addAll(conflictingDeletedElements);
        // переместить объекты (НЕ потомки filtered_with_new_and_delete) из elementsDepcyNEW в 
        // соответствующие объекты, но уже потомки filtered_with_new_and_delete
        for(TreeElement el : elementsDepcyNew){
            sumNewAndDelete.add(getCorrespondingTreeElement(el, copy));
        }
        
        return sumNewAndDelete;
    }
    
    public Set<TreeElement> getConflicting(){
        return conflictingDeletedElements;
    }

    /**
     * 
     * Возвращает поднабор элементов из набора <code>elements</code>, для которых 
     * существует объект бд в базе данных <code>db</code> и если этот объект 
     * так же присутствует в наборе <code>dependencies</code>. 
     * <br>
     * Ожидается, что <code>db</code> не содержит в себе элементы, которые отмечены 
     * как удаляемые (иными словами, она target).
     */
    public Set<TreeElement> getDepcyElementsContainedInDb(Set<TreeElement> elements,
            Set<PgStatement> dependencies, PgDatabase db) {
        Set<TreeElement> result = new HashSet<>();
        for (TreeElement element : elements){
            if (element.getSide() == DiffSide.LEFT){
                continue;
            }
            PgStatement elementInDb = element.getPgStatement(db);
            if (elementInDb != null && dependencies.contains(elementInDb)){
                result.add(element);
            }
        }
        return result;
    }
}