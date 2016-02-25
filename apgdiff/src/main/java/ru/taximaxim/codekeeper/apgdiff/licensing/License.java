package ru.taximaxim.codekeeper.apgdiff.licensing;

import static ru.taximaxim.codekeeper.apgdiff.licensing.internal.LicensingInternal.fillLicenseInfo;
import static ru.taximaxim.codekeeper.apgdiff.licensing.internal.LicensingInternal.loadLicense;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.licensing.internal.LicensingInternal;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

public class License {

    private final com.verhas.licensor.License license;

    private String edition, issuedOn, issuedTo, email, /*version,*/ validUntil,
    validSince, maxSchemaSize;
    private boolean uiCli, uiGui;

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setIssuedOn(String issuedOn) {
        this.issuedOn = issuedOn;
    }

    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /*
    public void setVersion(String version) {
        this.version = version;
    }
     */
    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public void setValidSince(String validSince) {
        this.validSince = validSince;
    }

    public void setMaxSchemaSize(String maxSchemaSize) {
        this.maxSchemaSize = maxSchemaSize;
    }

    public void setUiCli(boolean uiCli) {
        this.uiCli = uiCli;
    }

    public void setUiGui(boolean uiGui) {
        this.uiGui = uiGui;
    }

    /**
     * This method also accepts URLs to enable java-resource licenses in tests.
     */
    public License(String filename) throws IOException, LicenseException {
        this(loadLicense(filename));
    }

    public License(InputStream licenseStream) throws IOException, LicenseException {
        this(loadLicense(licenseStream));
    }

    private License(com.verhas.licensor.License license) throws LicenseException {
        this.license = license;
        fillLicenseInfo(license, this);
    }

    public void verify(boolean isGui) throws LicenseException {
        LicensingInternal.verifyValidity(license, isGui);
    }

    public void verifyDb(PgDatabase db) throws LicenseException {
        LicensingInternal.verifyDb(license, db);
    }

    public String getDescription() {
        String caps;
        if (uiCli && uiGui) {
            caps = Messages.License_caps_full;
        } else {
            caps = ""; //$NON-NLS-1$
            if (uiCli) {
                caps = "CLI;"; //$NON-NLS-1$
            }
            if (uiGui) {
                caps += "GUI;"; //$NON-NLS-1$
            }
            if (caps.isEmpty()) {
                caps = Messages.License_caps_none;
            }
        }
        return MessageFormat.format(Messages.License_descr_template,
                edition, issuedOn, issuedTo, email, Messages.License_version_any,
                caps, validUntil, validSince, maxSchemaSize);
    }
}
