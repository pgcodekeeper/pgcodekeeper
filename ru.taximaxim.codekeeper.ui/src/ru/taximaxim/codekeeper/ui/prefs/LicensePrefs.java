package ru.taximaxim.codekeeper.ui.prefs;

import java.io.IOException;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import ru.taximaxim.codekeeper.apgdiff.licensing.License;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class LicensePrefs extends PreferencePage
implements IWorkbenchPreferencePage {

    private String licensePath;
    private Text txtLicense;
    private Label lblInfo;

    public static void setLicense(PgDiffArguments args) throws LicenseException, IOException {
        License l = new License(Activator.getDefault().getPreferenceStore().getString(PREF.LICENSE_PATH));
        l.verify(true);
        args.setLicense(l);
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout gl = new GridLayout(3, false);
        gl.marginWidth = gl.marginHeight = 0;
        composite.setLayout(gl);

        new Label(composite, SWT.NONE).setText(Messages.LicensePrefs_file);

        txtLicense = new Text(composite, SWT.BORDER);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = PREF_PAGE.WIDTH_HINT_PX - PREF_PAGE.WIDTH_HINT_PX / 6;
        txtLicense.setLayoutData(gd);
        txtLicense.addTraverseListener(new TraverseListener() {

            @Override
            public void keyTraversed(TraverseEvent e) {
                update(txtLicense.getText());
            }
        });

        Button btnBrowse = new Button(composite, SWT.PUSH);
        btnBrowse.setText(Messages.LicensePrefs_browse);
        btnBrowse.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog d = new FileDialog(getShell());
                d.setText(Messages.LicensePrefs_open);
                String path = d.open();
                if (path != null) {
                    setLicense(path);
                }
            }
        });

        Label l = new Label(composite, SWT.NONE);
        l.setText(Messages.LicensePrefs_descr);
        l.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false, 3, 1));

        lblInfo = new Label(composite, SWT.NONE);
        lblInfo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

        setLicense(getPreferenceStore().getString(PREF.LICENSE_PATH));
        return composite;
    }

    private void setLicense(String path) {
        txtLicense.setText(path);
        update(path);
    }

    private void update(String path) {
        try {
            String internalLicense = License.getInternalLicenseUrl().toString();
            if (path.equals(internalLicense)) {
                txtLicense.setText(Messages.LicensePrefs_integrated);
            }
            lblInfo.setText(new License(path).getDescription());
            setErrorMessage(null);
            setValid(true);
            licensePath = path;
        } catch (LicenseException | IOException ex) {
            setErrorMessage(Messages.LicensePrefs_loading_error + ex.getLocalizedMessage());
            setValid(false);
        }
    }

    @Override
    protected void performDefaults() {
        super.performDefaults();
        update(License.getInternalLicenseUrl().toString());
    }

    @Override
    public boolean performOk() {
        // validity should be enforced by setValid calls in update()

        // we do not put bundleresource:// URLs into preferences, as they are runtime-unique
        // and won't be valid after restart
        // instead reset the value to use the default
        // that is set in PreferenceInitializer on each startup
        if (licensePath.equals(License.getInternalLicenseUrl().toString())) {
            getPreferenceStore().setToDefault(PREF.LICENSE_PATH);
        } else {
            getPreferenceStore().setValue(PREF.LICENSE_PATH, licensePath);
        }
        return true;
    }
}
