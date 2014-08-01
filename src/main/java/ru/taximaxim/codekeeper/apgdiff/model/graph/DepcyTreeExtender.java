package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
    private HashSet<PgStatement> shouldBeDeleted = new HashSet<PgStatement>(5);
    private HashSet<PgStatement> shouldBeNew = new HashSet<PgStatement>(5);
    
    private DepcyGraph depcySource;
    private DepcyGraph depcyTarget;
    private PgDatabase dbSource;
    private PgDatabase dbTarget;
    private TreeElement diffTree;
    private HashSet<TreeElement> seeeet;
    /**
     * Root node of filtered tree (should not be modified)
     */
    final private TreeElement root;
    
    public DepcyTreeExtender(PgDatabase dbSource, PgDatabase dbTarget, TreeElement root, TreeElement diffTree) {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        this.diffTree = diffTree;
        
        // depcy graphs
        depcySource = new DepcyGraph(dbSource);
        depcyTarget = new DepcyGraph(dbTarget);
        seeeet = new HashSet<TreeElement>();
        this.root = root;
    }
    
    /**
     * Возвращает список объектов, от которых зависят уже выбранные пользователем элементы EDIT/NEW
     * (объекты в TARGET-базе)
     * 
     * @return
     */
    public HashSet<PgStatement> getNew(){
        // заполнить сет shouldBeNew зависимыми элементами, которые надо создать
        extendNew(root);
        return shouldBeNew;
    }
    
    /**
     * Возвращает копию дерева filtered, дополненную зависимостями
     * 
     * @param filtered
     * @return
     */
    public TreeElement getCopyWithDepcy(){
        TreeElement copy = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        // заполнить сет shouldBeDeleted зависимыми элементами, отмеченными на удаление
        extendDelete(root, copy);
        
        // скопировать дерево первоначального выбора пользователя, перемещая 
        // налево элементы, содержащиеся в сете shouldBeDeleted
        copyFilteredToNew(root, copy);
        
        // так же поместить налево элементы, которые не были в первоначальном 
        // выборе пользователя, но которые надо таки удалить из бд
        addDeleted(copy);

        return copy;
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

    private void addNew(TreeElement copy) {
        
        List reversed = Arrays.asList(shouldBeNew.toArray());
        Collections.reverse(reversed);
        for (Object aaa : reversed) {
            PgStatement toBeAdded = (PgStatement) aaa;
            PgStatement emptyWithNew = getDbWithStatement(toBeAdded);
            while (!(emptyWithNew instanceof PgDatabase)) {
                emptyWithNew = emptyWithNew.getParent();
            }
            // Пустое дерево, содержащее только обин объект, который надо создать
            TreeElement tree = DiffTree.create(new PgDatabase(), (PgDatabase) emptyWithNew);

            TreeElement tee = tree;
            TreeElement tee_root = copy;
            while (tee_root != null) {
                tee = getEmptyTreeChild(tee, DiffSide.RIGHT);

                TreeElement tree_root_2 = null;
                if ((tree_root_2 = tee_root.getChild(tee.getName(),
                        tee.getType())) == null) {
                    break;
                }
                tee_root = tree_root_2;
            }

            // пройтись вниз до конца дерева tree, копируя все листья в tee_root
/*            while (tee != null) {
                DiffSide side = tee.getSide();
                // special case: default "public" schema
                if (tee.getType() == DbObjType.SCHEMA
                        && tee.getName().equals("public")) {
                    side = DiffSide.BOTH;
                }
                tee_root.addChild(new TreeElement(tee.getName(), tee.getType(),
                        tee.getContainerType(), side));
                tee_root = tee_root.getChild(tee.getName());
                tee = getEmptyTreeChild(tee, DiffSide.RIGHT);
            }*/

        }
    }

    /**
     * Смотрит на стороне EDIT/NEW по базе TARGET
     * 
     * @param filtered
     * @param copy
     */
    private void extendNew(TreeElement filtered) {
        PgStatement markedToCreate = null;
        
        // if not a Container and is marked for creation/edit
        if ((filtered.getSide() != DiffSide.LEFT && filtered.getType() != DbObjType.CONTAINER) && 
                (markedToCreate = filtered.getPgStatement(dbTarget)) != null){
            HashSet<PgStatement> sese = new HashSet<PgStatement>(5);
            PgDiff.getDependenciesSet(markedToCreate, shouldBeNew, depcyTarget.getGraph());
        }
        
        for(TreeElement sub : filtered.getChildren()) {
            extendNew(sub);
        }
    }

    private void addDeleted(TreeElement copy) {
        for (PgStatement toBeAdded : shouldBeDeleted) {
            PgStatement emptyWithDeleted = getDbWithStatement(toBeAdded);
            while (!(emptyWithDeleted instanceof PgDatabase)) {
                emptyWithDeleted = emptyWithDeleted.getParent();
            }
            // Пустое дерево, содержащее только обин объект, который надо удалить
            TreeElement tree = DiffTree.create((PgDatabase) emptyWithDeleted, new PgDatabase());

            TreeElement tee = tree;
            TreeElement tee_root = copy;
            while (tee_root != null) {
                tee = getEmptyTreeChild(tee, DiffSide.LEFT);

                TreeElement tree_root_2 = null;
                if ((tree_root_2 = tee_root.getChild(tee.getName(),
                        tee.getType())) == null) {
                    break;
                }
                tee_root = tree_root_2;
            }
            seeeet.add(tee);
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
    
    private void copyFilteredToNew(TreeElement filtered, TreeElement copy) {
        for (TreeElement child : filtered.getChildren()){
            PgStatement zisInSource = child.getPgStatement(depcySource.getDb());
            DiffSide side = child.getSide();
            if (zisInSource != null && shouldBeDeleted.contains(zisInSource)){
                side = DiffSide.LEFT;
                TreeElement childCopy = new TreeElement(child.getName(), child.getType(), child.getContainerType(), side);
                shouldBeDeleted.remove(zisInSource);
                seeeet.add(childCopy);
                addChildrenToSide(child, childCopy, side);
                copy.addChild(childCopy);
            }else{
                TreeElement childCopy = new TreeElement(child.getName(), child.getType(), child.getContainerType(), side);
                copy.addChild(childCopy);
                copyFilteredToNew(child, childCopy);
            }
        }
    }
        
    /**
     * Помещает копии всех потомков child'a в childCopy, при этом задавая сторону LEFT
     * 
     * TODO Перемещать всю ветку в Source only (пока кладется туда, где было изначально)
     *  
     * @param child
     * @param childCopy
     */
    private void addChildrenToSide(TreeElement child, TreeElement childCopy, DiffSide side) {
        for(TreeElement chichi : child.getChildren()){
            TreeElement chichiCopy = new TreeElement(chichi.getName(), chichi.getType(), chichi.getContainerType(), side);
            childCopy.addChild(chichiCopy);
            addChildrenToSide(chichi, chichiCopy, side);
        }
    }

    private TreeElement extendDelete(TreeElement filtered, TreeElement copy) {
        PgStatement markedToDelete = null;
        
        // if not a Container and is marked for deletion
        if ((filtered.getSide() == DiffSide.LEFT && filtered.getType() != DbObjType.CONTAINER) && 
                (markedToDelete = filtered.getPgStatement(dbSource)) != null){
            PgDiff.getDependantsSet(markedToDelete, shouldBeDeleted, depcySource.getGraph());
        }
        
        for(TreeElement sub : filtered.getChildren()) {
            extendDelete(sub, copy);
        }
        return copy;
    }
    
    /**
     * Returns the side of <code>object</code> in <code>tree</code>, if it is present there.
     * 
     * @param object DB object that we want to know the side of
     * @param tree Diff tree, in which the search for object equivalent is performed 
     * @param db Parent database for <code>object</code>
     * @return
     */
    @Deprecated
    private DiffSide getObjectSide(PgStatement object, TreeElement tree, PgDatabase db){
        if (object.equals(tree.getPgStatement(db))){
            return tree.getSide();
        }
        for (TreeElement e : tree.getChildren()){
            DiffSide side = getObjectSide(object, e, db);
            if (side != null){
                return side;
            }
        }
        return null;
    }
    
    @Deprecated
    private TreeElement addDeletedRecur(PgStatement toBeAdded, TreeElement copy){
        PgStatement emptyWithDeleted = getDbWithStatement(toBeAdded);
        while(!(emptyWithDeleted instanceof PgDatabase)){
            emptyWithDeleted = emptyWithDeleted.getParent();
        }
        // Пустое дерево, содержащее только обин объект, который надо удалить
        TreeElement tree = DiffTree.create((PgDatabase)emptyWithDeleted, new PgDatabase());
        
        TreeElement tee = tree;
        TreeElement tee_root = copy;
        while (tee_root != null){
            tee = getEmptyTreeChild(tee, DiffSide.LEFT);
            
            TreeElement tree_root_2 = null;
            if ((tree_root_2 = tee_root.getChild(tee.getName(), tee.getType())) == null){
                break;
            }
            tee_root = tree_root_2;
        }
        
        /*
         * Кусок кода, который находит пересечение двух деревьев при проходе снизу вверх.
         * Это неправильно, так как может найти одинаковые контейнеры но с разными парентами
         *  
        TreeElement corresponding = getCorrespondingTreeElement(tree, toBeAdded, DiffSide.LEFT);
        
        TreeElement correspondingHere = hasLeaf(root, corresponding, DiffSide.LEFT); 
        while (correspondingHere == null){
            corresponding = corresponding.getParent();
            correspondingHere = hasLeaf(root, corresponding, DiffSide.LEFT);
        }
        
        // пройтись вниз до конца дерева tree, копируя все листья в correspondingHere
        while (corresponding.getChild(0) != null){
            corresponding = corresponding.getChild(0);
            DiffSide side = corresponding.getSide();
            // special case: default "public" schema
            if (corresponding.getType() == DbObjType.SCHEMA && corresponding.getName().equals("public")){
                side = DiffSide.BOTH;
            }
            correspondingHere.addChild(new TreeElement(corresponding.getName(), corresponding.getType(), corresponding.getContainerType(), side));
            correspondingHere = correspondingHere.getChild(corresponding.getName());
        }
        */
        
        // пройтись вниз до конца дерева tree, копируя все листья в correspondingHere
        while (tee != null){
            DiffSide side = tee.getSide();
            // special case: default "public" schema
            if (tee.getType() == DbObjType.SCHEMA && tee.getName().equals("public")){
                side = DiffSide.BOTH;
            }
            tee_root.addChild(new TreeElement(tee.getName(), tee.getType(), tee.getContainerType(), side));
            tee_root = tee_root.getChild(tee.getName());
            tee = getEmptyTreeChild(tee, DiffSide.LEFT);
        }//
        return null;
    }
    
    /**
     * Returns <code>root</code>'s leaf, that is equal to <code>corresponding</code>.
     * Returns null, if no such leaf exists.
     * 
     * @param corresponding
     * @param left
     * @return
     */
    @Deprecated
    private TreeElement hasLeaf(TreeElement root, TreeElement corresponding, DiffSide left) {
        if (root.getName().equals(corresponding.getName()) && 
                root.getSide() == corresponding.getSide() && 
                root.getContainerType() == corresponding.getContainerType() && 
                root.getSide() == corresponding.getSide() &&
                root.getParent().getName().equals(corresponding.getParent().getName())){
            return root;
        }else{
            for(TreeElement ele : root.getChildren()){
                TreeElement ele2 = hasLeaf(ele, corresponding, left);
                if (ele2 != null){
                    return ele2;
                }
            }
        }
        return null;
    }

    /**
     * Возвращает элемент дерева (потомок <code>inputTree</code> со стороны <code>side</code>), 
     * который соответствует объекту <code>sta</code>, если тот либо его копия 
     * представлены в <code>source</code>.
     * 
     * @param inputTree
     * @param sta
     * @return
     */
    private TreeElement getCorrespondingTreeElement(TreeElement inputTree, PgStatement sta, DiffSide side){
        PgStatement stasta = inputTree.getPgStatement(dbSource);
        // check whether we are on the correct side
        if (inputTree.getType() == DbObjType.CONTAINER && inputTree.getContainerType() != DbObjType.DATABASE && inputTree.getSide() != side){
            return null;
        }
        if (stasta.getName().equals(sta.getName()) && stasta.getClass() == sta.getClass()){
            return inputTree;
        }else{
            for(TreeElement chi : inputTree.getChildren()){
                TreeElement te = getCorrespondingTreeElement (chi, sta, side); 
                if (te != null)
                    return te;
            }
        }
        return null;
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
    
    public HashSet<TreeElement> getDeletedElements(){
        return seeeet;
    }

}
