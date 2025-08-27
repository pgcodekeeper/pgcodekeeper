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
package ru.taximaxim.codekeeper.ui;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.dialogs.MessageDialogWithLink;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.utils.UiUtils;

/**
 * class for write properties in eclipse.ini file
 */
public final class EclipseIniWriter {

    private static final String ECLIPSE = "eclipse"; //$NON-NLS-1$
    private static final String ECLIPSE_MAC_PATH = "Eclipse.app/Contents/Eclipse/eclipse.ini"; //$NON-NLS-1$
    private static final String LINK_ECLIPSE_INI_INFO = "https://wiki.eclipse.org/Eclipse.ini"; //$NON-NLS-1$
    private static final String VMARGS = "-vmargs"; //$NON-NLS-1$

    public static void write(Shell shell, String property, String newValue, String message) {
        IProduct product = Platform.getProduct();
        String productName = product != null ? product.getName() : ECLIPSE;

        String spec;
        if (productName.toLowerCase(Locale.ROOT).contains(ECLIPSE)) {
            if (UiUtils.isMac()) {
                spec = ECLIPSE_MAC_PATH;
            } else {
                spec = "eclipse.ini"; //$NON-NLS-1$
            }
        } else {
            spec = productName.toLowerCase(Locale.ROOT) + ".ini"; // $NON-NLS-1$
        }

        Path path = null;
        String newLine = property + newValue;
        try {
            path = Paths.get(URI.create(Platform.getInstallLocation().getURL() + spec));
            List<String> lines = Files.readAllLines(path);

            int oldLineIdx = IntStream.range(0, lines.size())
                    .filter(i -> lines.get(i).startsWith(property))
                    .findFirst().orElse(-1);

            if (oldLineIdx == -1) {
                int vmargsLineIdx = IntStream.range(0, lines.size())
                        .filter(i -> VMARGS.equalsIgnoreCase(lines.get(i)))
                        .findFirst().orElse(-1);
                if (vmargsLineIdx != -1) {
                    lines.add(vmargsLineIdx + 1, newLine);
                } else {
                    lines.add(VMARGS);
                    lines.add(newLine);
                }
            } else {
                lines.set(oldLineIdx, newLine);
            }

            Files.write(path, lines);
            MessageDialog.openInformation(shell,
                    Messages.EclipseIniWriter_updated + message,
                    Messages.Eclipse_restart_offer);
        } catch (IOException e) {
            Log.log(e);
            String filePath = path != null ? path.toAbsolutePath().toString() : ""; // $NON-NLS-1$
            new MessageDialogWithLink(shell,
                    Messages.EclipseIniWriter_change_manually.formatted(message),
                    Messages.EclipseIniWriter_replace_parameter_msg.formatted(e.getLocalizedMessage(),
                            property, newLine, filePath),
                    MessageDialog.ERROR,
                    Messages.EclipseIniWriter_manual_editing_link,
                    LINK_ECLIPSE_INI_INFO)
                        .open();
        }
    }

    private EclipseIniWriter() {
    }
}