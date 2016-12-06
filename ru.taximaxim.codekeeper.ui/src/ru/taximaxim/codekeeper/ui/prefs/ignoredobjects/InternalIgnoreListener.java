package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;

public interface InternalIgnoreListener {

    void internalListUpdated(IgnoreList newList);
}
