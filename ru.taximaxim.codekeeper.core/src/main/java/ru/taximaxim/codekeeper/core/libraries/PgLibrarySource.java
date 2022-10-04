package ru.taximaxim.codekeeper.core.libraries;

import java.net.URI;
import java.net.URISyntaxException;

public enum PgLibrarySource {
    LOCAL,
    JDBC,
    URL;

    public static PgLibrarySource getSource(String libPath) {
        if (libPath.startsWith("jdbc:")) {
            return PgLibrarySource.JDBC;
        }
        try {
            URI uri = new URI(libPath);
            if (uri.getScheme() != null) {
                return PgLibrarySource.URL;
            }
        } catch (URISyntaxException e) {
            // not URI, try to folder or file
        }
        return PgLibrarySource.LOCAL;
    }
}
