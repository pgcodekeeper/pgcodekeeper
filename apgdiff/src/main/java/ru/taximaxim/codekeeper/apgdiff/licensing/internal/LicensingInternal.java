package ru.taximaxim.codekeeper.apgdiff.licensing.internal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.bouncycastle.openpgp.PGPException;
import org.osgi.framework.Bundle;

import com.verhas.licensor.License;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.Activator;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

public final class LicensingInternal {

    private static final String PUBKEY_RES = "key"; //$NON-NLS-1$
    private static final byte[] PUBKEY_DIGEST = new byte[] {
            (byte)0x1A,
            (byte)0x25, (byte)0xEB, (byte)0x13, (byte)0x38, (byte)0x80, (byte)0x5E, (byte)0xD5, (byte)0xD7,
            (byte)0x61, (byte)0x1A, (byte)0xAF, (byte)0x9D, (byte)0xFE, (byte)0x3E, (byte)0x33, (byte)0x98,
            (byte)0xA8, (byte)0x15, (byte)0xE9, (byte)0x1A, (byte)0xE1, (byte)0xF9, (byte)0x08, (byte)0x6F,
            (byte)0xA5, (byte)0xDE, (byte)0x8F, (byte)0x7C, (byte)0xAD, (byte)0x4B, (byte)0x2A, (byte)0x4A,
            (byte)0xD6, (byte)0x7E, (byte)0xA1, (byte)0x10, (byte)0xC2, (byte)0x62, (byte)0xD5, (byte)0xEA,
            (byte)0xF4, (byte)0xF3, (byte)0x3C, (byte)0x7A, (byte)0x8E, (byte)0x69, (byte)0x78, (byte)0x7C,
            (byte)0x5A, (byte)0x8B, (byte)0xBF, (byte)0x08, (byte)0x77, (byte)0x40, (byte)0x16, (byte)0x32,
            (byte)0x6B, (byte)0x49, (byte)0x2D, (byte)0x4E, (byte)0x8C, (byte)0xEB, (byte)0xBE,
    };
    private static final long PUBKEY_ID = 6359029032252458994L;

    // INFO FIELDS
    private static final String EDITION = "EDITION"; //$NON-NLS-1$
    private static final String ISSUED_ON = "ISSUED_ON"; //$NON-NLS-1$
    private static final String ISSUED_TO = "ISSUED_TO"; //$NON-NLS-1$
    private static final String EMAIL = "EMAIL"; //$NON-NLS-1$
    private static final String VERSION = "VERSION"; //$NON-NLS-1$
    // VALIDATION FIELDS
    private static final String CAPS = "CAPS"; //$NON-NLS-1$
    private static final String UI_CLI = "UI_CLI"; //$NON-NLS-1$
    private static final String UI_GUI = "UI_GUI"; //$NON-NLS-1$
    private static final String VALID_UNTIL = "VALID_UNTIL"; //$NON-NLS-1$
    private static final String VALID_SINCE = "VALID_SINCE"; //$NON-NLS-1$
    private static final String MAX_SCHEMA_SIZE = "MAX_SCHEMA_SIZE"; //$NON-NLS-1$

    private static final SimpleDateFormat VALID_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd"); //$NON-NLS-1$
    private static final String MAINAPP_BUNDLE = "ru.taximaxim.codekeeper.mainapp"; //$NON-NLS-1$
    private static final String UI_BUNDLE = "ru.taximaxim.codekeeper.ui"; //$NON-NLS-1$

    private enum LicenseCaps {
        UI_CLI, UI_GUI;
    }

    /**
     * This method also accepts URLs to enable java-resource licenses in tests.
     */
    public static License loadLicense(String filename) throws IOException, LicenseException {
        InputStream stream;
        try {
            stream = new URL(filename).openStream();
        } catch (IOException ex) {
            stream = new FileInputStream(filename);
        }
        try (InputStream s = stream) {
            return loadLicense(s);
        }
    }

    public static License loadLicense(InputStream licenseStream) throws IOException, LicenseException {
        try {
            License l = new License();
            l.loadKeyRing(LicensingInternal.class.getResourceAsStream(PUBKEY_RES), PUBKEY_DIGEST);
            l.setLicenseEncoded(licenseStream);
            return l;
        } catch (PGPException ex) {
            throw new LicenseException(ex.getLocalizedMessage(), ex);
        }
    }

    /**
     * @see {@link MessageFormat}, {@link MessageFormat#format(String, Object...)}
     */
    private static void badLicense(String errorFormat, Object... vals) throws LicenseException {
        throw new LicenseException(Messages.LicensingInternal_current_license +
                MessageFormat.format(errorFormat, vals));
    }

    private static void malformedLicense(Exception ex) throws LicenseException {
        throw new LicenseException(Messages.LicensingInternal_malformed_license
                + ex.getLocalizedMessage(), ex);
    }

    public static void verifyValidity(License license, boolean isGui) throws LicenseException {
        try {
            List<LicenseCaps> caps = Arrays.asList(getCaps(license.getFeature(CAPS)));
            boolean uiPresent = isUiPresent();
            if (!caps.contains(LicenseCaps.UI_GUI)) {
                if (isGui) {
                    badLicense(Messages.LicensingInternal_no_gui);
                }
                if (uiPresent) {
                    badLicense(Messages.LicensingInternal_no_gui_but_module_present);
                }
            } else if (!caps.contains(LicenseCaps.UI_CLI)) {
                if (!isGui) {
                    badLicense(Messages.LicensingInternal_no_cli);
                }
                if (!uiPresent) {
                    badLicense(Messages.LicensingInternal_no_cli_but_no_gui_present);
                }
            }

            long now = System.currentTimeMillis();
            String since = license.getFeature(VALID_SINCE);
            if (now < VALID_DATE_FORMAT.parse(since).getTime()) {
                badLicense(Messages.LicensingInternal_inactive, since);
            }
            String until = license.getFeature(VALID_UNTIL);
            if (now >= VALID_DATE_FORMAT.parse(until).getTime()) {
                badLicense(Messages.LicensingInternal_expired, until);
            }
        } catch (LicenseException ex) {
            throw ex;
        } catch (Exception ex) {
            malformedLicense(ex);
        }
    }

    private static LicenseCaps[] getCaps(String capabilities) {
        String[] caps = capabilities.split(","); //$NON-NLS-1$
        LicenseCaps licenseCaps[] = new LicenseCaps[caps.length];
        for (int i = 0; i < caps.length; ++i) {
            LicenseCaps lr;
            switch (caps[i]) {
            case UI_CLI:
                lr = LicenseCaps.UI_CLI;
                break;
            case UI_GUI:
                lr = LicenseCaps.UI_GUI;
                break;
            default:
                throw new IllegalArgumentException("invalid " + CAPS); //$NON-NLS-1$
            }
            licenseCaps[i] = lr;
        }
        return licenseCaps;
    }

    private static boolean isUiPresent() {
        for (Bundle b : Activator.getContext().getBundles()) {
            if (UI_BUNDLE.equals(b.getSymbolicName())) {
                return true;
            }
        }
        return false;
    }

    public static void verifyDb(License license, PgDatabase db) throws LicenseException {
        try {
            int i = 0;
            final int maxObjects = Integer.valueOf(license.getFeature(MAX_SCHEMA_SIZE));
            for (PgSchema s : db.getSchemas()) {
                i += s.getDomains().size();
                i += s.getFunctions().size();
                i += s.getTables().size();
                i += s.getViews().size();
                i += s.getTypes().size();
            }

            if (i > maxObjects) {
                badLicense(Messages.LicensingInternal_schema_objects_exceeded, maxObjects, i);
            }
        } catch (LicenseException ex) {
            throw ex;
        } catch (Exception ex) {
            malformedLicense(ex);
        }
    }

    public static void fillLicenseInfo(License license,
            ru.taximaxim.codekeeper.apgdiff.licensing.License licenseContainer) {
        licenseContainer.setEdition(license.getFeature(EDITION));
        licenseContainer.setIssuedOn(license.getFeature(ISSUED_ON));
        licenseContainer.setIssuedTo(license.getFeature(ISSUED_TO));
        licenseContainer.setEmail(license.getFeature(EMAIL));
        licenseContainer.setVersion(license.getFeature(VERSION));
        for (LicenseCaps r : getCaps(license.getFeature(CAPS))) {
            switch (r) {
            case UI_CLI:
                licenseContainer.setUiCli(true);
                break;
            case UI_GUI:
                licenseContainer.setUiGui(true);
                break;
            }
        }
        licenseContainer.setValidUntil(license.getFeature(VALID_UNTIL));
        licenseContainer.setValidSince(license.getFeature(VALID_SINCE));
        licenseContainer.setMaxSchemaSize(license.getFeature(MAX_SCHEMA_SIZE));
    }

    private LicensingInternal() {
    }
}
