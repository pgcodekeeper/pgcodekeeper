package ru.taximaxim.codekeeper.ui.libraries;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;

import ru.taximaxim.codekeeper.core.libraries.PgLibrary;
import ru.taximaxim.codekeeper.core.xmlstore.DependenciesXmlStore;
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

    private LibraryUtils() {
        // only statics
    }
}
