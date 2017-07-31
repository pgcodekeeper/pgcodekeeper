package ru.taximaxim.codekeeper.ui.views;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import ru.taximaxim.codekeeper.ui.differ.DbSource;

public class DepcyStructuredSelection extends StructuredSelection {

    final DbSource dbProject;
    final DbSource dbRemote;

    public DepcyStructuredSelection(DbSource dbProject, DbSource dbRemote, IStructuredSelection sel) {
        super(sel.toList());
        this.dbProject = dbProject;
        this.dbRemote = dbRemote;
    }
}
