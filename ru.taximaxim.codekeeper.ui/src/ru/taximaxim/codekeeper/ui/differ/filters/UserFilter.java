package ru.taximaxim.codekeeper.ui.differ.filters;

import java.util.Map;
import java.util.function.Function;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.differ.ElementMetaInfo;

public class UserFilter extends AbstractFilter {

    private final Function<ElementMetaInfo, String> getter;

    public UserFilter(Function<ElementMetaInfo, String> getter) {
        this.getter = getter;
    }

    @Override
    public boolean checkElement(TreeElement el, Map<TreeElement, ElementMetaInfo> elementInfoMap,
            PgDatabase dbProject, PgDatabase dbRemote) {
        ElementMetaInfo meta = elementInfoMap.get(el);

        if (meta != null) {
            if (searchMatches(getter.apply(meta))) {
                return true;
            }

            if (DiffTableViewer.isSubElement(el)) {
                ElementMetaInfo parent = elementInfoMap.get(el.getParent());
                if (parent != null) {
                    return searchMatches(getter.apply(parent));
                }
            }

            if (DiffTableViewer.isContainer(el)) {
                return el.getChildren().stream().filter(elementInfoMap::containsKey)
                        .map(e -> elementInfoMap.get(e))
                        .anyMatch(s -> s != null && searchMatches(getter.apply(s)));
            }
        }

        return false;
    }
}
