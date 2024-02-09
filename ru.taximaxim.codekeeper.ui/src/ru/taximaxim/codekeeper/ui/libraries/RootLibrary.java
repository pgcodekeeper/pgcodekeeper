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
package ru.taximaxim.codekeeper.ui.libraries;

import org.eclipse.swt.graphics.Image;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class RootLibrary extends AbstractLibrary {

    RootLibrary() {
        super(null, null, Messages.LibraryContainer_root);
    }

    @Override
    public Image getImage() {
        return Activator.getRegisteredImage(ProjectIcon.LIB);
    }

    @Override
    protected String getDescriptionRecursive() {
        return ""; //$NON-NLS-1$
    }
}
