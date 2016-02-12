package ru.taximaxim.codekeeper.ui.prefs;

import java.io.IOException;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import ru.taximaxim.codekeeper.apgdiff.licensing.License;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;

public class LicensePrefs {

    private static final String INTERNAL_LICENSE = "lic"; //$NON-NLS-1$

    public static void setLicense(PgDiffArguments args) throws LicenseException, IOException {
        args.setLicense(new License(Activator.getDefault().getPreferenceStore()
                .getString(PREF.LICENSE_PATH), true));
    }
}
