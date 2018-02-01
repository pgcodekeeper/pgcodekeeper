package ru.taximaxim.codekeeper.ui.differ.filters;

import java.util.Set;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

/**
 * Contains information of search by container
 *
 * @since 4.2.0.
 * @author galiev_mr
 */
public class SchemaFilter extends AbstractFilter {

    @Override
    public boolean checkElement(TreeElement el, Set<TreeElement> elements,
            PgDatabase dbProject, PgDatabase dbRemote) {

        String container = el.getContainerQName();
        if (!container.isEmpty()) {
            return searchMatches(container.toLowerCase());
        } else if (el.getType() == DbObjType.SCHEMA) {
            return searchMatches(el.getName().toLowerCase());
        }

        return false;
    }
}