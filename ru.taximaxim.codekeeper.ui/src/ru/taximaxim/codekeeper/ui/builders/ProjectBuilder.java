/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.builders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.UIProjectLoader;
import ru.taximaxim.codekeeper.ui.views.navigator.PgDecorator;

public class ProjectBuilder extends IncrementalProjectBuilder {

    @Override
    protected IProject[] build(int kind, Map<String, String> args,
            IProgressMonitor monitor) throws CoreException {
        IProject proj = getProject();
        if (!proj.hasNature(NATURE.ID) ||
                !OpenProjectUtils.checkVersion(proj, new StringBuilder())) {
            return null;
        }

        try {
            int[] buildType = { kind };
            PgDbParser parser = PgDbParser.getParserForBuilder(proj, buildType);
            switch (buildType[0]) {
            case IncrementalProjectBuilder.AUTO_BUILD:
            case IncrementalProjectBuilder.INCREMENTAL_BUILD:
                IResourceDelta delta = getDelta(proj);
                buildIncrement(delta, parser, monitor, OpenProjectUtils.getDatabaseType(proj));
                break;

            case IncrementalProjectBuilder.FULL_BUILD:
                if (!parser.deserialize(proj.getName())) {
                    parser.getFullDBFromPgDbProject(proj, monitor);
                }
                break;
            default:
                throw new IllegalStateException("Unknown build type!"); //$NON-NLS-1$
            }
            parser.serialize(proj.getName());
        } catch (InterruptedException ex) {
            throw new OperationCanceledException();
        } catch (IOException | IllegalStateException ex) {
            throw new CoreException(PgDbParser.getLoadingErroStatus(ex));
        } finally {
            // update decorators if any kind of build was run
            PgDecorator.update();
            SubMonitor.done(monitor);
        }
        return new IProject[] { proj };
    }

    @Override
    protected void clean(IProgressMonitor monitor) throws CoreException {
        PgDbParser.clean(getProject().getName());
    }

    private void buildIncrement(IResourceDelta delta, PgDbParser parser,
            IProgressMonitor monitor, DatabaseType dbType)
                    throws CoreException, InterruptedException, IOException {
        List<IFile> files = new ArrayList<>();
        delta.accept(d -> {
            if (UIProjectLoader.isInProject(d, dbType)) {
                IResource res = d.getResource();
                if (res.getType() == IResource.FILE) {
                    int kind = d.getKind();
                    if (IResourceDelta.REMOVED == kind || IResourceDelta.REMOVED_PHANTOM == kind) {
                        parser.removeResFromRefs(res);
                    } else {
                        files.add((IFile) res);
                    }
                }
            }
            return true;
        });
        parser.getObjFromProjFiles(files, monitor, dbType);
    }
}
