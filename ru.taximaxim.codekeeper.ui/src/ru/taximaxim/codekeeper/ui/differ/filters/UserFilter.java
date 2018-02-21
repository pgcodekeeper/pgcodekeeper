package ru.taximaxim.codekeeper.ui.differ.filters;

import java.util.Set;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

public class UserFilter extends AbstractFilter {

    @Override
    public boolean checkElement(TreeElement el, Set<TreeElement> elements,
            PgDatabase dbProject, PgDatabase dbRemote) {
        return false;
    }
}
