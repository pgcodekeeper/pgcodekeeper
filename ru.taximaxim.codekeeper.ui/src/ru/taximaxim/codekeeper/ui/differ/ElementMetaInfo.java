package ru.taximaxim.codekeeper.ui.differ;

public class ElementMetaInfo {
    private String gitUser;
    private String dbUser;
    private String libLocation;
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

    public boolean isChanged() {
        return isChanged;
    }

    public String getGitUser() {
        String a = gitUser == null ? "" : gitUser; //$NON-NLS-1$
        return isChanged ?  "*" + a : a; //$NON-NLS-1$
    }

    public String getDbUser() {
        return dbUser == null ? "" : dbUser; //$NON-NLS-1$
    }

    public void setLibLocation(String libLocation) {
        this.libLocation = libLocation;
    }

    public String getLibLocation() {
        return libLocation;
    }
}
