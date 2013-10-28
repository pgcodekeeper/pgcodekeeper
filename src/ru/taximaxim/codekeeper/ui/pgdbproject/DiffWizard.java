package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;

public class DiffWizard extends Wizard {

    private PageDiff pageDiff;
    
    private PgDbProject proj;
    
    private IPreferenceStore mainPrefs;
    
    public DiffWizard(PgDbProject proj, IPreferenceStore mainPrefs) {
        setWindowTitle("Diff");
        setNeedsProgressMonitor(true);
        
        this.proj = proj;
        this.mainPrefs = mainPrefs;
    }
    
    @Override
    public void addPages() {
        pageDiff = new PageDiff("Diff parameters", proj);
        addPage(pageDiff);
    }
    
    @Override
    public boolean performFinish() {
        
        
        return true;
    }
}

class PageDiff extends WizardPage implements Listener {
    
    public enum DiffTargetType {
        DB, DUMP, SVN
    }
    
    final private PgDbProject proj;
    
    private Composite container;
    
    private Button radioDb, radioDump, radioSvn, radioThis;
    
    private Group currentTargetGrp;
    
    private Group grpDb, grpDump, grpSvn;
    
    private Text txtDbName, txtDbUser, txtDbPass, txtDbHost, txtDbPort,
        txtDumpPath,
        txtSvnUrl, txtSvnUser, txtSvnPass, txtSvnRev;
    
    private CLabel lblWarnDbPass, lblWarnSvnPass;
    
    private Button radioFromThis, radioToThis;
    
    public DiffTargetType getTargetType() {
        if(radioDb.getSelection()) {
            return DiffTargetType.DB;
        }
        if(radioDump.getSelection()) {
            return DiffTargetType.DUMP;
        }
        if(radioSvn.getSelection() || radioThis.getSelection()) {
            return DiffTargetType.SVN;
        }
        
        throw new IllegalStateException("No target type selection found!");
    }
    
    public String getDbName() {
        return txtDbName.getText();
    }
    
    public String getDbUser() {
        return txtDbUser.getText();
    }
    
    public String getDbPass() {
        return txtDbPass.getText();
    }
    
    public String getDbHost() {
        return txtDbHost.getText();
    }
    
    public int getDbPort() {
        try {
            return Integer.parseInt(txtDbPort.getText());
        } catch(NumberFormatException ex) {
            return 0;
        }
    }
    
    public String getDumpPath() {
        return txtDumpPath.getText();
    }
    
    public String getSvnUrl() {
        return txtSvnUrl.getText();
    }
    
    public String getSvnUser() {
        return txtSvnUser.getText();
    }
    
    public String getSvnPass() {
        return txtSvnPass.getText();
    }
    
    public boolean isDirectionFromThis() {
        return radioFromThis.getSelection();
    }
    
    public PageDiff(String pageName, PgDbProject proj) {
        super(pageName, pageName, null);
        
        this.proj = proj;
    }
    
    @Override
    public void createControl(Composite parent) {
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout());
        
        Group grpRadio = new Group(container, SWT.NONE);
        grpRadio.setText("Diff target");
        grpRadio.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        grpRadio.setLayout(new GridLayout(4, false));
        
        radioDb = new Button(grpRadio, SWT.RADIO);
        radioDb.setText("DB Target");
        radioDb.setSelection(true);
        
        radioDb.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                switchTargetGrp(grpDb);
            }
        });
        
        radioDump = new Button(grpRadio, SWT.RADIO);
        radioDump.setText("Dump Target");
        
        radioDump.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                switchTargetGrp(grpDump);
            }
        });
        
        radioSvn = new Button(grpRadio, SWT.RADIO);
        radioSvn.setText("SVN Target");
        
        radioSvn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                switchTargetGrp(grpSvn);

                txtSvnUrl.setEnabled(true);
                txtSvnUser.setEnabled(true);
                txtSvnPass.setEnabled(true);
            }
        });
        
        radioThis = new Button(grpRadio, SWT.RADIO);
        radioThis.setText("This project, different revision");
        
        radioThis.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                switchTargetGrp(grpSvn);
                
                txtSvnUrl.setEnabled(false);
                txtSvnUser.setEnabled(false);
                txtSvnPass.setEnabled(false);
                
                txtSvnUrl.setText(proj.getString(UIConsts.PROJ_PREF_SVN_URL));
                txtSvnUser.setText(proj.getString(UIConsts.PROJ_PREF_SVN_USER));
                txtSvnPass.setText(proj.getString(UIConsts.PROJ_PREF_SVN_PASS));
            }
        });
        
        grpDb = new Group(container, SWT.NONE);
        grpDb.setText("DB Target");
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpDb.setLayoutData(gd);
        grpDb.setLayout(new GridLayout(4, false));
        
        currentTargetGrp = grpDb;
        
        new Label(grpDb, SWT.NONE).setText("DB Name: ");
        
        txtDbName = new Text(grpDb, SWT.BORDER);
        txtDbName.setLayoutData(new GridData(
                SWT.FILL, SWT.CENTER, true, false, 3, 1));
        
        new Label(grpDb, SWT.NONE).setText("DB User: ");
        
        txtDbUser = new Text(grpDb, SWT.BORDER);
        txtDbUser.setLayoutData(new GridData(
                SWT.FILL, SWT.CENTER, true, false, 3, 1));
        
        new Label(grpDb, SWT.NONE).setText("DB Password:");
        
        txtDbPass = new Text(grpDb, SWT.BORDER | SWT.PASSWORD);
        txtDbPass.setLayoutData(new GridData(
                SWT.FILL, SWT.CENTER, true, false, 3, 1));
        txtDbPass.addModifyListener(new ModifyListener() {
            
            @Override
            public void modifyText(ModifyEvent e) {
                GridData gd = (GridData)lblWarnDbPass.getLayoutData();
                
                if((txtDbPass.getText().isEmpty() && !gd.exclude)
                        || (!txtDbPass.getText().isEmpty() && gd.exclude)) {
                    lblWarnDbPass.setVisible(!lblWarnDbPass.getVisible());
                    gd.exclude = !gd.exclude;
                    
                    Shell sh = container.getShell();
                    int width = sh.getSize().x;
                    int newht = sh.computeSize(width, SWT.DEFAULT).y;
                    sh.setSize(width, newht);
                    
                    grpDb.layout(false);
                }
            }
        });
        
        lblWarnDbPass = new CLabel(grpDb, SWT.NONE);
        lblWarnDbPass.setImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        UIConsts.FILENAME_ICONWARNING)).createImage());
        lblWarnDbPass.setText("Warning:\n"
                + "Providing password here is insecure!\n"
                + "Consider using .pgpass file instead.");
        gd = new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1);
        gd.exclude = true;
        lblWarnDbPass.setLayoutData(gd);
        lblWarnDbPass.setVisible(false);
        
        new Label(grpDb, SWT.NONE).setText("DB Host:");
        
        txtDbHost = new Text(grpDb, SWT.BORDER);
        txtDbHost.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        new Label(grpDb, SWT.NONE).setText("Port:");
        
        txtDbPort = new Text(grpDb, SWT.BORDER);
        txtDbPort.addListener(SWT.Modify, this);
        
        grpDump = new Group(container, SWT.NONE);
        grpDump.setText("Dump Target");
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpDump.setLayoutData(gd);
        grpDump.setLayout(new GridLayout(2, false));
        
        gd.exclude = true;
        grpDump.setVisible(false);
        
        Label l = new Label(grpDump, SWT.NONE);
        l.setText("Path to DB Schema Dump:");
        gd = new GridData();
        gd.horizontalSpan = 2;
        l.setLayoutData(gd);
        
        txtDumpPath = new Text(grpDump, SWT.BORDER);
        txtDumpPath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtDumpPath.addListener(SWT.Modify, this);
        
        Button btnBrowseDump = new Button(grpDump, SWT.PUSH);
        btnBrowseDump.setText("Browse...");
        btnBrowseDump.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(container.getShell());
                String filename = dialog.open();
                if(filename != null) {
                    txtDumpPath.setText(filename);
                }
            }
        });

        grpSvn = new Group(container, SWT.NONE);
        grpSvn.setText("SVN Source");
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpSvn.setLayoutData(gd);
        grpSvn.setLayout(new GridLayout(2, false));
        
        gd.exclude = true;
        grpSvn.setVisible(false);
        
        new Label(grpSvn, SWT.NONE).setText("SVN Repo URL:");
        
        txtSvnUrl = new Text(grpSvn, SWT.BORDER);
        txtSvnUrl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtSvnUrl.addListener(SWT.Modify, this);
        
        new Label(grpSvn, SWT.NONE).setText("SVN User:");
        
        txtSvnUser = new Text(grpSvn, SWT.BORDER);
        txtSvnUser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        new Label(grpSvn, SWT.NONE).setText("SVN Password:");
        
        txtSvnPass = new Text(grpSvn, SWT.BORDER | SWT.PASSWORD);
        txtSvnPass.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtSvnPass.addModifyListener(new ModifyListener() {
            
            @Override
            public void modifyText(ModifyEvent e) {
                GridData gd = (GridData)lblWarnSvnPass.getLayoutData();
                
                if((txtSvnPass.getText().isEmpty() && !gd.exclude)
                        || (!txtSvnPass.getText().isEmpty() && gd.exclude)) {
                    gd.exclude = !gd.exclude;
                    lblWarnSvnPass.setVisible(!lblWarnSvnPass.getVisible());
                    
                    Shell sh = container.getShell();
                    int width = sh.getSize().x;
                    int newht = sh.computeSize(width, SWT.DEFAULT).y;
                    sh.setSize(width, newht);
                    
                    grpSvn.layout(false);
                }
            }
        });
        
        lblWarnSvnPass = new CLabel(grpSvn, SWT.NONE);
        lblWarnSvnPass.setImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        UIConsts.FILENAME_ICONWARNING)).createImage());
        lblWarnSvnPass.setText("Warning:\n"
                + "Providing password here is insecure!"
                + " This password WILL show up in logs!\n"
                + "Consider using SVN password store instead.");
        gd = new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1);
        gd.exclude = true;
        lblWarnSvnPass.setLayoutData(gd);
        lblWarnSvnPass.setVisible(false);
        
        new Label(grpSvn, SWT.NONE).setText("SVN Revision:");
        
        txtSvnRev = new Text(grpSvn, SWT.BORDER);
        txtSvnRev.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtSvnRev.addListener(SWT.Modify, this);
        
        Group grpDirection = new Group(container, SWT.NONE);
        grpDirection.setText("Diff direction");
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpDirection.setLayoutData(gd);
        grpDirection.setLayout(new GridLayout());
        
        radioFromThis = new Button(grpDirection, SWT.RADIO);
        radioFromThis.setText("This project -> Target");
        radioFromThis.setSelection(true);
        
        radioToThis = new Button(grpDirection, SWT.RADIO);
        radioToThis.setText("Target -> This project");
        
        setControl(container);
    }
    
    private void switchTargetGrp(Group newActive) {
        currentTargetGrp.setVisible(false);
        newActive.setVisible(true);
        
        ((GridData) currentTargetGrp.getLayoutData()).exclude = true;
        ((GridData) newActive.getLayoutData()).exclude = false;
        
        currentTargetGrp = newActive;
        
        Shell sh = container.getShell();
        int width = sh.getSize().x;
        int newht = sh.computeSize(width, SWT.DEFAULT).y;
        sh.setSize(width, newht);
        
        container.layout(false);
        
        getWizard().getContainer().updateButtons();
        getWizard().getContainer().updateMessage();
    }
    
    @Override
    public boolean isPageComplete() {
        String errMsg = null;
        
        switch(getTargetType()) {
        case DB:
            if(!txtDbPort.getText().isEmpty()) {
                try {
                    Integer.parseInt(txtDbPort.getText());
                } catch(NumberFormatException ex) {
                    errMsg = "Port must be a number!";
                }
            }
            
            break;
            
        case DUMP:
            if(txtDumpPath.getText().isEmpty()
                    || !new File(txtDumpPath.getText()).isFile()) {
                errMsg = "Select a readable DB dump file!";
            }
            
            break;
            
        case SVN:
            if(txtSvnUrl.getText().isEmpty()) {
                errMsg = "Enter URL of SVN Repo!";
            }
            
            break;
        }
        
        setErrorMessage(errMsg);
        
        if(errMsg != null) {
            return false;
        }
        return true;
    }
    
    @Override
    public void handleEvent(Event event) {
        getWizard().getContainer().updateButtons();
        getWizard().getContainer().updateMessage();
    }
}