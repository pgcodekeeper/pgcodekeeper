package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.List;

public interface IIgnoreList {

    public List<IgnoredObject> getList();

    void add(IgnoredObject rule);

    public void setShow(boolean isShow);
}
