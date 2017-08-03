package ru.taximaxim.codekeeper.ui.views;

import ru.taximaxim.codekeeper.ui.differ.DbSource;

public class DBPair {

    final DbSource dbProject;
    final DbSource dbRemote;

    public DBPair(DbSource dbProject, DbSource dbRemote) {
        this.dbProject = dbProject;
        this.dbRemote = dbRemote;
    }
}
