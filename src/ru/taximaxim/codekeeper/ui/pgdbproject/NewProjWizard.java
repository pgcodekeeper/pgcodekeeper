package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.Set;

import org.eclipse.jface.dialogs.IPageChangingListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.PageChangingEvent;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;

public class NewProjWizard extends Wizard implements IPageChangingListener {

	private PageDb pageDb;
	private PageSvn pageSvn;
	private PageMisc pageMisc;
	
	final IPreferenceStore mainPrefStore;
	
	private PgDbProject props;
	
	public NewProjWizard(IPreferenceStore mainPrefStore) {
		setWindowTitle("New PgDbProject");
		setNeedsProgressMonitor(true);
		
		this.mainPrefStore = mainPrefStore;
	}
	
	public PgDbProject getProject() {
		return props;
	}
	
	@Override
	public void addPages() {
        pageSvn = new PageSvn("SVN settings");
        addPage(pageSvn);
		pageDb = new PageDb("Schema Source Settings");
		addPage(pageDb);
		pageMisc = new PageMisc("Miscellaneous");
		addPage(pageMisc);
	}
	
	@Override
	public void createPageControls(Composite pageContainer) {
	    super.createPageControls(pageContainer);
	    
	    ((WizardDialog) getContainer()).addPageChangingListener(this);
	}
	
	@Override
	public void handlePageChanging(PageChangingEvent event) {
	    if(event.getCurrentPage() == pageSvn && event.getTargetPage() == pageDb) {
	        boolean isInit = pageSvn.isDoInit();
	        
	        if(isInit && pageDb.isSourceNone()) {
                pageDb.setSourceDb();
	        }

            pageDb.setSourceNoneEnabled(!isInit);
	    }
	}
	
	@Override
	public boolean canFinish() {
	    if(getContainer().getCurrentPage() == pageSvn && pageSvn.isDoInit()) {
	        return false;
	    }
	    return super.canFinish();
	}

	@Override
	public boolean performFinish() {
		props = new PgDbProject(pageSvn.getProjectPath());
		
		props.setValue(UIConsts.PROJ_PREF_ENCODING, pageMisc.getEncoding());
		
		String src;
		if(pageDb.isSourceDb()) {
		    src = UIConsts.PROJ_SOURCE_TYPE_DB;
		} else if(pageDb.isSourceDump()) {
		    src = UIConsts.PROJ_SOURCE_TYPE_DUMP;
		} else if(pageDb.isSourceNone()) {
		    src = UIConsts.PROJ_SOURCE_TYPE_NONE;
		} else {
		    throw new IllegalStateException("No Schema Source selected.");
		}
		props.setValue(UIConsts.PROJ_PREF_SOURCE, src);
		
		props.setValue(UIConsts.PROJ_PREF_DB_NAME, pageDb.getDbName());
		props.setValue(UIConsts.PROJ_PREF_DB_USER, pageDb.getDbUser());
		props.setValue(UIConsts.PROJ_PREF_DB_PASS, pageDb.getDbPass());
		props.setValue(UIConsts.PROJ_PREF_DB_HOST, pageDb.getDbHost());
		props.setValue(UIConsts.PROJ_PREF_DB_PORT, pageDb.getDbPort());
		
		props.setValue(UIConsts.PROJ_PREF_SVN_URL, pageSvn.getSvnUrl());
		props.setValue(UIConsts.PROJ_PREF_SVN_USER, pageSvn.getSvnUser());
		props.setValue(UIConsts.PROJ_PREF_SVN_PASS, pageSvn.getSvnPass());
		
		try {
			props.save();
		} catch(IOException ex) {
			throw new IllegalStateException(
					"Error while saving project properties", ex);
		}
		
		ProjectCreator creator = new ProjectCreator(
				mainPrefStore, props, pageDb.getDumpPath(), pageSvn.isDoInit());
		try {
			getContainer().run(true, false, creator);
		} catch(InvocationTargetException ex) {
			throw new IllegalStateException(
					"Error in the project creator thread", ex);
		} catch(InterruptedException ex) {
			// assume run() was called as non cancelable
			throw new IllegalStateException(
					"Project creator thread cancelled. Shouldn't happen!", ex);
		}
		
		return true;
	}
}

class PageSvn extends WizardPage implements Listener {
    
    private Composite container;
    
    private Text txtSvnUrl, txtSvnUser, txtSvnPass, txtProjectPath;
    
    private Button btnDoInit;
    
    private boolean checkOverwrite = true;
    
    private CLabel lblWarnPass, lblWarnInit;

    public String getSvnUrl() {
        return txtSvnUrl.getText();
    }
    
    public String getSvnUser() {
        return txtSvnUser.getText();
    }
    
    public String getSvnPass() {
        return txtSvnPass.getText();
    }
    
    public String getProjectPath() {
        return txtProjectPath.getText();
    }
    
    public boolean isDoInit() {
        return btnDoInit.getSelection();
    }
    
    PageSvn(String pageName) {
        super(pageName, pageName, null);
    }

    @Override
    public void createControl(final Composite parent) {
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(2, false));
        
        Group grpSvn = new Group(container, SWT.NONE);
        grpSvn.setText("SVN Settings");
        grpSvn.setLayout(new GridLayout(2, false));
        grpSvn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));

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
                GridData gd = (GridData)lblWarnPass.getLayoutData();
                
                if((txtSvnPass.getText().isEmpty() && !gd.exclude)
                        || (!txtSvnPass.getText().isEmpty() && gd.exclude)) {
                    gd.exclude = !gd.exclude;
                    lblWarnPass.setVisible(!lblWarnPass.getVisible());
                    
                    Shell sh = parent.getShell();
                    int width = sh.getSize().x;
                    int newht = sh.computeSize(width, SWT.DEFAULT).y;
                    sh.setSize(width, newht);
                    
                    container.layout(false);
                }
            }
        });
        
        lblWarnPass = new CLabel(grpSvn, SWT.NONE);
        lblWarnPass.setImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        UIConsts.FILENAME_ICONWARNING)).createImage());
        lblWarnPass.setText("Warning:\n"
                + "Providing password here is insecure!"
                + " This password WILL show up in logs!\n"
                + "Consider using SVN password store instead.");
        GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
        gd.exclude = true;
        lblWarnPass.setLayoutData(gd);
        lblWarnPass.setVisible(false);
        
        btnDoInit = new Button(container, SWT.CHECK);
        btnDoInit.setText("Init repository from Schema Source");
        gd = new GridData();
        gd.horizontalSpan = 2;
        btnDoInit.setLayoutData(gd);
        btnDoInit.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                GridData gd = (GridData) lblWarnInit.getLayoutData();
                
                gd.exclude = !btnDoInit.getSelection();
                lblWarnInit.setVisible(btnDoInit.getSelection());
                
                Shell sh = parent.getShell();
                int width = sh.getSize().x;
                int newht = sh.computeSize(width, SWT.DEFAULT).y;
                sh.setSize(width, newht);
                
                container.layout(false);
            }
        });
        btnDoInit.addListener(SWT.Selection, this);
        
        lblWarnInit = new CLabel(container, SWT.NONE);
        lblWarnInit.setImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        UIConsts.FILENAME_ICONWARNING)).createImage());
        lblWarnInit.setText("Warning:\n"
                + "This will delete SVN contents and recreate them from Schema Source"
                + " (next page).");
        gd = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
        gd.exclude = true;
        lblWarnInit.setLayoutData(gd);
        lblWarnInit.setVisible(false);
        
        
        Label l = new Label(container, SWT.NONE);
        l.setText("Project Directory (settings storage, SVN cache, etc):");
        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.verticalIndent = 12;
        l.setLayoutData(gd);
        
        txtProjectPath = new Text(container, SWT.BORDER);
        txtProjectPath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtProjectPath.addModifyListener(new ModifyListener() {
            
            @Override
            public void modifyText(ModifyEvent e) {
                checkOverwrite = true;
            }
        });
        txtProjectPath.addListener(SWT.Modify, this);
        
        Button btnBrowseProj = new Button(container, SWT.PUSH);
        btnBrowseProj.setText("Browse...");
        btnBrowseProj.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DirectoryDialog dialog = 
                        new DirectoryDialog(container.getShell());
                String path = dialog.open();
                if(path != null) {
                    txtProjectPath.setText(path);
                }
            }
        });
        
        setControl(container);
    }
    
    @Override
    public boolean isPageComplete() {
        String errMsg = null;
        if(txtSvnUrl.getText().isEmpty()) {
            errMsg = "Enter SVN Repo URL!";
        } else if(txtProjectPath.getText().isEmpty()
                || !new File(txtProjectPath.getText()).isDirectory()) {
            errMsg = "Select Project Directory!";
        }
        
        if(checkOverwrite) {
            File proj = new File(txtProjectPath.getText(),
                    UIConsts.FILENAME_PROJ_PREF_STORE);
            if(proj.isFile()) {
                if(MessageDialog.openQuestion(getShell(), "Overwrite existing?",
                        "Overwrite existing project?\n"
                                    + txtProjectPath.getText())) {
                    checkOverwrite = false;
                } else {
                    txtProjectPath.setText("");
                    return false;
                }
            }
        }
        
        setErrorMessage(errMsg);
        return errMsg == null;
    }

    @Override
    public void handleEvent(Event event) {
        getWizard().getContainer().updateButtons();
        getWizard().getContainer().updateMessage();
    }
}

class PageDb extends WizardPage implements Listener {
	
	private Composite container;
	
	private Button radioDb, radioDump, radioNone;
	
	private DbPicker grpDb;
	private Group grpDump;
	
	private Label lblNoSource;
	
	private Text txtDumpPath;
	
	public boolean isSourceDb() {
		return radioDb.getSelection();
	}
	
	public void setSourceDb() {
	    radioDump.setSelection(false);
	    radioNone.setSelection(false);
	    radioDb.setSelection(true);
	    radioDb.notifyListeners(SWT.Selection, new Event());
	}
	
	public boolean isSourceDump() {
		return radioDump.getSelection();
	}
	
	public boolean isSourceNone() {
	    return radioNone.getSelection();
	}
	
	public void setSourceNoneEnabled(boolean enabled) {
	    radioNone.setEnabled(enabled);
	}
	
	public String getDbName() {
		return grpDb.txtDbName.getText();
	}
	
	public String getDbUser() {
		return grpDb.txtDbUser.getText();
	}
	
	public String getDbPass() {
		return grpDb.txtDbPass.getText();
	}
	
	public String getDbHost() {
		return grpDb.txtDbHost.getText();
	}
	
	public int getDbPort() {
		try {
			return Integer.parseInt(grpDb.txtDbPort.getText());
		} catch(NumberFormatException ex) {
			return 0;
		}
	}
	
	public String getDumpPath() {
		return txtDumpPath.getText();
	}

	PageDb(String pageName) {
		super(pageName, pageName, null);
	}

	@Override
	public void createControl(final Composite parent) {
		container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));

		Group radioGrp = new Group(container, SWT.NONE);
		radioGrp.setText("Schema Source");
		radioGrp.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		radioGrp.setLayout(new GridLayout(3, false));
		
		radioDb = new Button(radioGrp, SWT.RADIO);
		radioDb.setText("DB");
		
		radioDb.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			    if(radioDb.getSelection()) {
    				grpDump.setVisible(false);
                    lblNoSource.setVisible(false);
    				grpDb.setVisible(true);
    				
    				((GridData)grpDump.getLayoutData()).exclude = true;
                    ((GridData)lblNoSource.getLayoutData()).exclude = true;
    				((GridData)grpDb.getLayoutData()).exclude = false;
    				
    				container.layout(false);
			    }
			}
		});
		radioDb.addListener(SWT.Selection, this);
		
		radioDump = new Button(radioGrp, SWT.RADIO);
		radioDump.setText("Dump File");
		
		radioDump.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			    if(radioDump.getSelection()) {
    				grpDb.setVisible(false);
                    lblNoSource.setVisible(false);
    				grpDump.setVisible(true);
    				
    				((GridData)grpDb.getLayoutData()).exclude = true;
                    ((GridData)lblNoSource.getLayoutData()).exclude = true;
    				((GridData)grpDump.getLayoutData()).exclude = false;
    				
    				container.layout(false);
			    }
			}
		});
		radioDb.addListener(SWT.Selection, this);
		
		radioNone = new Button(radioGrp, SWT.RADIO);
		radioNone.setText("None");
		radioNone.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        grpDb.setVisible(false);
                grpDump.setVisible(false);
                lblNoSource.setVisible(true);
                
                ((GridData)grpDb.getLayoutData()).exclude = true;
                ((GridData)grpDump.getLayoutData()).exclude = true;
                ((GridData)lblNoSource.getLayoutData()).exclude = false;
                
                container.layout(false);
		    }
        });
		radioNone.addListener(SWT.Selection, this);
		radioNone.setSelection(true);
		
		grpDb = new DbPicker(container, SWT.NONE);
		grpDb.setText("DB Source Settings");
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		gd.exclude = true;
		gd.verticalIndent = 12;
		grpDb.setLayoutData(gd);
		grpDb.setVisible(false);
		
		grpDb.txtDbPort.addListener(SWT.Modify, this);
		
		grpDump = new Group(container, SWT.NONE);
		grpDump.setText("Dump File Source Settings");
		gd = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		gd.exclude = true;
		gd.verticalIndent = 12;
		grpDump.setLayoutData(gd);
		grpDump.setLayout(new GridLayout(2, false));
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
		
		lblNoSource = new Label(container, SWT.NONE);
		lblNoSource.setText("No Schema Source selected.");

		setControl(container);
	}
	
	@Override
	public boolean isPageComplete() {
		String errMsg = null;
		if(radioDump.getSelection() &&
				(txtDumpPath.getText().isEmpty()
						|| !new File(txtDumpPath.getText()).isFile())) {
			errMsg = "Select a readable DB dump file!";
		} else if(radioDb.getSelection() && !grpDb.txtDbPort.getText().isEmpty()) {
			try {
				Integer.parseInt(grpDb.txtDbPort.getText());
			} catch (NumberFormatException ex) {
				errMsg = "Port must be a number!";
			}
		}

		setErrorMessage(errMsg);
		return errMsg == null;
	}

	@Override
	public void handleEvent(Event event) {
		getWizard().getContainer().updateButtons();
		getWizard().getContainer().updateMessage();
	}
}

class PageMisc extends WizardPage {
	
	private Combo cmbEncoding;
	
	public String getEncoding() {
		return cmbEncoding.getText();
	}
	
	PageMisc(String pageName) {
		super(pageName, pageName, null);
	}
	
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		
		new Label(container, SWT.NONE).setText(
				"Project encoding (used for all supporting operaions):");
		
		cmbEncoding = new Combo(container, SWT.BORDER | SWT.DROP_DOWN
				| SWT.READ_ONLY);
		Set<String> charsets = Charset.availableCharsets().keySet();
		cmbEncoding.setItems(charsets.toArray(new String[charsets.size()]));
		cmbEncoding.select(cmbEncoding.indexOf("UTF-8"));
		
		setControl(container);
	}
}