package ru.taximaxim.codekeeper.apgdiff.model.difftree;

public class ElementMetaInfo {
    private String gitUser;
    private String dbUser;
    private boolean isChanged;

    public void setGitUser(final String gitUser) {
        this.gitUser = gitUser;
    }

    public void setDbUser(final String dbUser) {
        this.dbUser = dbUser;
    }

    public void setChanged() {
        isChanged = true;
    }

    public String getGitUser() {
        String a = gitUser == null ? "" : gitUser;
        return isChanged ?  "*" + a : a;
    }

    public String getDbUser() {
        return dbUser == null ? "" : dbUser;
    }
}
