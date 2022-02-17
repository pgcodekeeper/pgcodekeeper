package ru.taximaxim.codekeeper.ui.libraries;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;

import cz.startnet.utils.pgdiff.libraries.PgLibrary;
import cz.startnet.utils.pgdiff.xmlstore.DependenciesXmlStore;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;

public class LibraryUtils {

    public static final Path META_PATH = Paths.get(Platform.getStateLocation(
            Activator.getContext().getBundle()).append("dependencies").toString()); //$NON-NLS-1$

    public static RootLibrary create(IProject proj) throws IOException, CoreException {
        DependenciesXmlStore xml = new DependenciesXmlStore(
                Paths.get(proj.getLocation().toString())
                .resolve(DependenciesXmlStore.FILE_NAME));
        List<PgLibrary> libs = xml.readObjects();
        return new UiLibraryLoader(proj.getName(), proj.hasNature(NATURE.MS), xml.readLoadNestedFlag())
                .load(libs);
    }

    public static String getDescription(AbstractLibrary lib) {
        if (lib == null || lib instanceof RootLibrary) {
            return ""; //$NON-NLS-1$
        }

        StringBuilder sb = new StringBuilder(lib.getName());

        AbstractLibrary parent = lib.getParent();
        while (parent != null && !(parent instanceof RootLibrary)) {
            sb.insert(0, '/');
            sb.insert(0, parent.getName());
            parent = parent.getParent();
        }

        sb.append(AbstractLibrary.CONCAT_STRING).append(lib.getPath());

        return sb.toString();
    }

    private LibraryUtils() {
        // only statics
    }
}
