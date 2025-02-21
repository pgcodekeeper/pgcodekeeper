/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.search;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.DecoratingStyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.search.ui.text.AbstractTextSearchViewPage;
import org.eclipse.search.ui.text.Match;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.libraries.LibraryStorage;
import ru.taximaxim.codekeeper.ui.libraries.LibraryUtils;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class ReferenceResultPage extends AbstractTextSearchViewPage {

    private ReferenceContentProvider contentProvider;

    @Override
    protected void elementsChanged(Object[] objects) {
        contentProvider.inputChanged(getViewer(), null, getInput());
        getViewer().refresh();
    }

    @Override
    protected void clear() {
        // no impl
    }

    @Override
    protected void configureTreeViewer(TreeViewer viewer) {
        viewer.setLabelProvider(new DecoratingStyledCellLabelProvider(new ReferenceLabelProvider(),
                PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator(), null));

        contentProvider = new ReferenceContentProvider();
        viewer.setContentProvider(contentProvider);
        viewer.setComparator(new ViewerComparator() {

            @Override
            public int compare(Viewer viewer, Object e1, Object e2) {
                if (e1 instanceof PgObjLocation firstLoc && e2 instanceof PgObjLocation secondLoc) {
                    int x = firstLoc.getOffset();
                    int y = secondLoc.getOffset();
                    return Integer.compare(x, y);
                }

                return super.compare(viewer, e1, e2);
            }
        });
    }

    @Override
    protected void showMatch(Match match, int offset, int length, boolean activate) throws PartInitException {
        PgObjLocation loc = (PgObjLocation) match.getElement();

        String filePath = loc.getFilePath();
        if (filePath.contains(LibraryUtils.META_PATH.toString())) {
            var lib = LibraryStorage.getLibrary(filePath);
            if (lib != null) {
                var project = lib.getProject();
                var dbType = OpenProjectUtils
                    .getDatabaseType(ResourcesPlugin.getWorkspace().getRoot().getProject(project));
                FileUtilsUi.openFileInSqlEditor(loc, project, dbType, true);
            }
            return;
        }

        IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(loc.getFilePath()));

        if (file == null) {
            return;
        }

        IWorkbenchPage page = getSite().getPage();
        IEditorPart editor;
        if (offset >= 0 && length != 0) {
            editor = openAndSelect(page, file, offset, length, activate);
        } else {
            editor = open(page, file, activate);
        }
        if (editor instanceof SQLEditor sqlEditor) {
            sqlEditor.refreshReferences();
        }
    }

    @Override
    protected void configureTableViewer(TableViewer viewer) {
        throw new IllegalStateException("Doesn't support table mode."); //$NON-NLS-1$
    }
}