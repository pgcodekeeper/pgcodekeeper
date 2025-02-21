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
package ru.taximaxim.codekeeper.ui.comparetools;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.Objects;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.structuremergeviewer.DiffNode;
import org.eclipse.core.runtime.IProgressMonitor;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.PgOverride;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class CompareInput extends CompareEditorInput {

    private static final String TITLE = "Compare (''{0}'' - ''{1}'')"; //$NON-NLS-1$

    private CompareItem left;
    private CompareItem right;
    private final DiffNode diffNode ;

    public CompareInput(PgOverride override) {
        super(new CompareConfiguration());

        PgStatement oldStatement = override.getOldStatement();
        PgStatement newStatement = override.getNewStatement();

        String oldPath = oldStatement.getLocation().getFilePath();
        String newPath = newStatement.getLocation().getFilePath();

        diffNode = getFormattedContents(oldPath, newPath, oldStatement, newStatement);

        getCompareConfiguration().setLeftLabel(oldPath);
        getCompareConfiguration().setRightLabel(newPath);

        setTitle(MessageFormat.format(TITLE, oldPath, newPath));
    }

    public CompareInput(String name, DbObjType type, PgStatement project, PgStatement remote) {
        super(new CompareConfiguration());

        getCompareConfiguration().setLeftLabel(Messages.database);
        getCompareConfiguration().setRightLabel(Messages.DiffPaneViewer_project);

        diffNode = getFormattedContents(name, name, project, remote);

        setTitle("Compare " + type + ' ' + name); //$NON-NLS-1$
    }

    private DiffNode getFormattedContents(String oldPath, String newPath, PgStatement project, PgStatement remote) {
        String contentsLeft = project == null ? "" : project.getSQL(true); //$NON-NLS-1$
        String contentsRight = remote == null ? "" : remote.getSQL(true); //$NON-NLS-1$

        if (Objects.equals(contentsLeft, contentsRight)) {
            left = new CompareItem(oldPath, project == null ? "" : project.getSQL(false)); //$NON-NLS-1$
            right = new CompareItem(newPath, remote == null ? "" : remote.getSQL(false)); //$NON-NLS-1$
        } else {
            left = new CompareItem(oldPath, contentsLeft);
            right =  new CompareItem(newPath, contentsRight);
        }

        return new DiffNode(left, right);
    }

    @Override
    protected Object prepareInput(IProgressMonitor monitor)
            throws InvocationTargetException, InterruptedException {
        return diffNode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof CompareInput val) {
            return left.equals(val.left)
                    && right.equals(val.right);
        }

        return false;
    }
}
