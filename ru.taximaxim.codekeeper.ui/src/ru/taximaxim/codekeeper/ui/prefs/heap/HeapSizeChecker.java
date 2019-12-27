package ru.taximaxim.codekeeper.ui.prefs.heap;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.stream.Stream;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IStartup;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.dialogs.HeapSizeCheckerDialog;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * It checks the heap size every time it starts
 * (it starts working immediately after the pgCodeKeeper starts and
 * could be turned on or off in the main preferences).
 */
public class HeapSizeChecker implements IStartup {

    private static final int RECOMMENDED_SIZE_GB = 2;
    private static final double EMPIRICAL_RECOMMENDED_SIZE_GB = 1.7;
    public static final String XMX_HEAP_PARAMETER = "Xmx"; //$NON-NLS-1$

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    @Override
    public void earlyStartup() {
        UiSync.exec(Display.getDefault(), () -> {
            if (mainPrefs.getBoolean(PREF.HEAP_SIZE_WARNING) && isHeapLessThanNecessary()) {
                Shell shell = Display.getDefault().getActiveShell();

                MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(
                        shell, Messages.HeapSizeChecker_heap_size_warning_title,
                        MessageFormat.format(Messages.HeapSizeChecker_heap_size_warning,
                                RECOMMENDED_SIZE_GB),
                        Messages.HeapSizeChecker_do_not_ask_again,
                        false, null, null);

                mainPrefs.setValue(PREF.HEAP_SIZE_WARNING, !dialog.getToggleState());

                if (IDialogConstants.YES_ID == dialog.getReturnCode()) {
                    new HeapSizeCheckerDialog(shell).open();
                }
            }
        });
    }

    private boolean isHeapLessThanNecessary() {
        try (Stream<String> lineStream = Files.lines(
                Paths.get(System.getProperty("eclipse.launcher")) //$NON-NLS-1$
                .getParent().resolve("eclipse.ini"), StandardCharsets.UTF_8)) { //$NON-NLS-1$
            String xmxLine = lineStream.filter(l -> l.contains(XMX_HEAP_PARAMETER))
                    .findAny().orElse(null);

            if (xmxLine == null) {
                Log.log(Log.LOG_WARNING,
                        "There is no 'Xmx' property in eclipse.ini file."); //$NON-NLS-1$
                return isEmpiricalLessThanJvmAttemptsToUse();
            }

            double eclipseIniHeapSizeGb = 0;
            String unit = xmxLine.substring(xmxLine.length() - 1).toUpperCase(Locale.ROOT);
            int xmxValueBeginIdx = xmxLine.indexOf(XMX_HEAP_PARAMETER) + 3;
            String valueStr = xmxLine.substring(xmxValueBeginIdx, xmxLine.length() - 1);
            switch (unit) {
            case "G":
                eclipseIniHeapSizeGb = Double.parseDouble(valueStr);
                break;
            case "M":
                eclipseIniHeapSizeGb = Double.parseDouble(valueStr) / 1024;
                break;
            case "K":
                eclipseIniHeapSizeGb = Double.parseDouble(valueStr) / 1024 / 1024;
                break;
            default:
                if (!Character.isDigit(unit.charAt(0))) {
                    Log.log(Log.LOG_ERROR, MessageFormat.format(
                            "'{0}' has incorrect unit of 'Xmx' property" //$NON-NLS-1$
                            + " in eclipse.ini file", xmxLine)); //$NON-NLS-1$
                    return isEmpiricalLessThanJvmAttemptsToUse();
                }
                valueStr = xmxLine.substring(xmxValueBeginIdx, xmxLine.length());
                eclipseIniHeapSizeGb = Double.parseDouble(valueStr) / 1024 / 1024 / 1024;
                break;
            }
            return RECOMMENDED_SIZE_GB > eclipseIniHeapSizeGb;
        } catch (IOException e) {
            return isEmpiricalLessThanJvmAttemptsToUse();
        }
    }

    private boolean isEmpiricalLessThanJvmAttemptsToUse() {
        // 'Runtime.getRuntime().maxMemory()' - shows the size 2 times bigger
        // than it is, therefore division by 2 is used
        return EMPIRICAL_RECOMMENDED_SIZE_GB > Runtime.getRuntime().maxMemory() / 1024 / 1024 / 1024 / 2;
    }
}
