package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IPageChangingListener;
import org.eclipse.jface.dialogs.PageChangingEvent;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.DepcyFromPSQLOutput;

public class DiffWizard extends Wizard implements IPageChangingListener {

    private PageDiff pageDiff;
    private PagePartial pagePartial;
    private PageResult pageResult;
    
    private TreeDiffer treediffer;
    private Differ differ;
    private String timezone;
    private String encoding;

    private final PgDbProject proj;

    private final IPreferenceStore mainPrefs;

    public DiffWizard(PgDbProject proj, IPreferenceStore mainPrefs) {
        setWindowTitle(Messages.diffWizard_Diff);
        setNeedsProgressMonitor(true);
        
        this.proj = proj;
        this.mainPrefs = mainPrefs;
        setDefaultPageImageDescriptor(ImageDescriptor.createFromURL(Activator.getContext()
                .getBundle().getResource(FILE.ICONAPPBIG)));
    }

    @Override
    public void addPages() {
        pageDiff = new PageDiff(Messages.diffWizard_diff_parameters, proj, mainPrefs);
        pagePartial = new PagePartial(Messages.diffWizard_diff_tree, mainPrefs, pageDiff);
        pageResult = new PageResult(Messages.diffWizard_diff_result, pagePartial);

        addPage(pageDiff);
        addPage(pagePartial);//
        addPage(pageResult);
    }

    @Override
    public void createPageControls(Composite pageContainer) {
        super.createPageControls(pageContainer);

        getShell().addShellListener(new ShellAdapter() {

            @Override
            public void shellActivated(ShellEvent e) {
                getShell().removeShellListener(this);

                getShell().pack();
            }
        });

        ((WizardDialog) getContainer()).addPageChangingListener(this);
    };

    private DbSource dbSource, dbTarget;
    @Override
    public void handlePageChanging(PageChangingEvent e) {
        try {
            if (e.getCurrentPage() == pageDiff && e.getTargetPage() == pagePartial) {
                treediffer = new TreeDiffer(
                        pageDiff.getSourceDb(true), pageDiff.getSourceDb(false), false);

                try {
                    getContainer().run(true, true, treediffer);
                }  catch (InvocationTargetException ex) {
                    e.doit = false;
                    ExceptionNotifier.notifyDefault(Messages.error_in_differ_thread, ex);
                    return;
                } catch (InterruptedException ex) {
                    // cancelled
                    e.doit = false;
                    return;
                }
                dbSource = treediffer.getDbSource();
                dbTarget = treediffer.getDbTarget();
                timezone = pageDiff.getTimezoneSource();
                encoding = pageDiff.getEncodingSource();

                pagePartial.setData(dbSource.getOrigin(), dbTarget.getOrigin(),
                        treediffer);
                pagePartial.layout();
                pageResult.setEncoding(encoding);
            } else if (e.getCurrentPage() == pagePartial && e.getTargetPage() == pageResult) {
                TreeElement filtered = treediffer.getDiffTree();

               // IEclipsePreferences pref = proj.getPrefs();
                differ = new Differ(dbSource.getDbObject(), dbTarget.getDbObject(),
                        filtered, true,
                        timezone,
                        true);
                try {
                    getContainer().run(true, true, differ);
                } catch (InvocationTargetException ex) {
                    e.doit = false;
                    ExceptionNotifier.notifyDefault(Messages.error_in_differ_thread, ex);
                    return;
                } catch (InterruptedException ex) {
                    // cancelled
                    e.doit = false;
                    return;
                }

                pageResult.setData(dbSource.getOrigin(), dbTarget.getOrigin(),
                        differ.getDiffDirect(), differ.getDiffReverse());
                pageResult.layout();
            }
        } catch(PgCodekeeperUIException e1) {
            e.doit = false;
            ExceptionNotifier.notifyDefault(Messages.DiffWizard_unexpected_error, e1);
            return;
        }
    }

    @Override
    public boolean canFinish() {
        if (getContainer().getCurrentPage() != pageResult) {
            return false;
        }
        return super.canFinish();
    }

    @Override
    public boolean performFinish() {
            List<PgStatement> list = new LinkedList<>(PgDatabase.listPgObjects(dbSource.getDbObject()).values());
            boolean isSrc2Trg = pageResult.isSrc2Trg();
            DepcyFromPSQLOutput input = new DepcyFromPSQLOutput(differ, null,
                    list, isSrc2Trg);
            try {
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .openEditor(input, EDITOR.ROLLON);
            } catch (PartInitException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return true;
    }
}

class PageDiff extends WizardPage implements Listener {

    public enum DiffTargetType {
        DB, DUMP, JDBC, PROJ
    }

    private final IPreferenceStore mainPrefs;
    private final PgDbProject proj;

    private Composite container;
    private Combo cmbEncodingSource;
    private Combo cmbTimezoneSource;
    private Combo cmbEncodingTarget;
    private Combo cmbTimezoneTarget;
    private DbStorePicker storePickerSource, storePickerTarget;
    
    public PageDiff(String pageName, PgDbProject proj, IPreferenceStore mainPrefs) {
        super(pageName, pageName, null);

        this.mainPrefs = mainPrefs;
        this.proj = proj;
        setDescription(Messages.diffwizard_diffpage_select);
    }

    public DiffTargetType getTargetType(DbStorePicker store) throws PgCodekeeperUIException {
        if (store.getDbInfo() != null){
            return DiffTargetType.JDBC;
        } else if (store.getPathOfFile() != null){
            return DiffTargetType.DUMP;
        } else if (store.getPathOfProject() != null){
            return DiffTargetType.PROJ;
        }
        throw new PgCodekeeperUIException(Messages.diffWizard_no_target_type_selection_found);
    }

    public String getEncodingSource() {
        return cmbEncodingSource.getText();
    }

    public String getTimezoneSource() {
        return cmbTimezoneSource.getText();
    }
    
    public String getEncodingTarget() {
        return cmbEncodingSource.getText();
    }

    public String getTimezoneTarget() {
        return cmbTimezoneSource.getText();
    }
    
    public DbSource getSourceDb(boolean isSource) throws PgCodekeeperUIException {
        DbStorePicker storePicker = isSource ? storePickerSource : storePickerTarget;
        String encoding = isSource ? cmbEncodingSource.getText() : cmbEncodingTarget.getText();
        String timezone = isSource ? cmbTimezoneSource.getText() : cmbTimezoneTarget.getText();
        DbSource dbs = null;
        switch (getTargetType(storePicker)) {
        case DUMP:
            dbs = DbSource.fromFile(true,
                    storePicker.getPathOfFile(), encoding, timezone);
            break;
            
        case JDBC:
            boolean isPgDump = mainPrefs.getBoolean(PREF.PGDUMP_SWITCH);
            if (isPgDump){
                dbs = DbSource.fromDb(true,
                        mainPrefs.getString(PREF.PGDUMP_EXE_PATH),
                        mainPrefs.getString(PREF.PGDUMP_CUSTOM_PARAMS),
                        storePicker.getDbInfo().getDbhost(),
                        storePicker.getDbInfo().getDbport(), 
                        storePicker.getDbInfo().getDbuser(),
                        storePicker.getDbInfo().getDbpass(), 
                        storePicker.getDbInfo().getDbname(),
                        encoding,
                        timezone);
            } else {
                dbs = DbSource.fromJdbc(
                        storePicker.getDbInfo().getDbhost(),
                        storePicker.getDbInfo().getDbport(), 
                        storePicker.getDbInfo().getDbuser(),
                        storePicker.getDbInfo().getDbpass(), 
                        storePicker.getDbInfo().getDbname(),
                        encoding,
                        timezone,
                        true);
            }
            break;
        
        case PROJ:
            dbs = DbSource.fromDirTree(true, storePicker.getPathOfProject(), encoding, timezone);
            break;
        default:
            throw new PgCodekeeperUIException(Messages.diffWizard_unexpected_target_type_value);
        }
        return dbs;
    }

    @Override
    public void createControl(Composite parent) {
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(2, true));
        
        //Source column
        Group sourceComp = new Group(container, SWT.BORDER);
        sourceComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout gLayout = new GridLayout();
        gLayout.marginWidth = gLayout.marginHeight = 0;
        sourceComp.setLayout(gLayout);
        sourceComp.setText(Messages.diffWizard_source);
        
        storePickerSource = new DbStorePicker(sourceComp, SWT.NONE, false, mainPrefs, true);

        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        storePickerSource.setLayoutData(gd);
        
        final Text sourceInfo = new Text(sourceComp, SWT.NONE);
        sourceInfo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        storePickerSource.addListenerToCombo(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                getWizard().getContainer().updateButtons();
                sourceInfo.setText(storePickerSource.getInfo());
            }
        });
        
        Composite grpEncodingSource = new Composite(sourceComp, SWT.NONE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpEncodingSource.setLayoutData(gd);
        grpEncodingSource.setLayout(new GridLayout(2, false));

        new Label(grpEncodingSource, SWT.NONE).setText(Messages.diffWizard_target_encoding);

        cmbEncodingSource = new Combo(grpEncodingSource,  SWT.BORDER | SWT.READ_ONLY | SWT.DROP_DOWN);
        //Set<String> charsets = Charset.availableCharsets().keySet();
        //cmbEncodingSource.setItems(charsets.toArray(new String[charsets.size()]));
        String[] charsets = ApgdiffConsts.ENCODINGS;
        Arrays.sort(charsets);
        cmbEncodingSource.setItems(charsets);
        try {
            cmbEncodingSource.select(
                    cmbEncodingSource.indexOf(proj!= null ? proj.getProjectCharset() : ApgdiffConsts.UTF_8));
        } catch (CoreException e1) {
            setErrorMessage(Messages.DiffWizard_project_charset_error);
            Log.log(Log.LOG_ERROR, "Cannot get project charset", e1); //$NON-NLS-1$
            cmbEncodingSource.select(
                    cmbEncodingSource.indexOf(ApgdiffConsts.UTF_8));
        }

        new Label(grpEncodingSource, SWT.NONE).setText(Messages.diffWizard_target_timezone);

        /* 
         * Combo.setItem is very slow on gtk3
         * Поэтому пока что мы добавляем ограниченное число временных зон. В дальнейшем если эта проблема 
         * будет пофикшена, то можно будет вернуть весь список.
         * Eclipse 4.5.2
         */
        //String[] availableTimezones = TimeZone.getAvailableIDs();
        String[] availableTimezones = ApgdiffConsts.TIME_ZONES;
        Arrays.sort(availableTimezones);
        cmbTimezoneSource = new Combo(grpEncodingSource, SWT.BORDER | SWT.READ_ONLY | SWT.DROP_DOWN);
        cmbTimezoneSource.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbTimezoneSource.setItems(availableTimezones);
        cmbTimezoneSource.select(cmbTimezoneSource.indexOf(proj != null ?
                proj.getPrefs().get(PROJ_PREF.TIMEZONE, ApgdiffConsts.UTC) : ApgdiffConsts.UTC));
        
        //Target column
        Group targetComp = new Group(container, SWT.BORDER);
        targetComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        targetComp.setLayout(gLayout);
        targetComp.setText(Messages.diffWizard_target);
        
        storePickerTarget = new DbStorePicker(targetComp, SWT.NONE, false, mainPrefs, true);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        storePickerTarget.setLayoutData(gd);
        
        final Text targetInfo = new Text(targetComp, SWT.NONE);
        targetInfo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        storePickerTarget.addListenerToCombo(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                getWizard().getContainer().updateButtons();
                targetInfo.setText(storePickerTarget.getInfo());
            }
        });
        
        if (proj != null){
            storePickerSource.select(proj.getProjectName());
            storePickerTarget.select(proj.getProjectName());
            sourceInfo.setText(storePickerSource.getInfo());
            targetInfo.setText(storePickerSource.getInfo());
        }
        
        Composite grpEncodingTarget = new Composite(targetComp, SWT.NONE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpEncodingTarget.setLayoutData(gd);
        grpEncodingTarget.setLayout(new GridLayout(2, false));

        new Label(grpEncodingTarget, SWT.NONE).setText(Messages.diffWizard_target_encoding);

        cmbEncodingTarget = new Combo(grpEncodingTarget,  SWT.BORDER | SWT.READ_ONLY | SWT.DROP_DOWN);
        //cmbEncodingTarget.setItems(charsets.toArray(new String[charsets.size()]));
        cmbEncodingTarget.setItems(charsets);
        cmbEncodingTarget.select(cmbEncodingTarget.indexOf(ApgdiffConsts.UTF_8));

        new Label(grpEncodingTarget, SWT.NONE).setText(Messages.diffWizard_target_timezone);
        
        cmbTimezoneTarget = new Combo(grpEncodingTarget, SWT.BORDER | SWT.READ_ONLY | SWT.DROP_DOWN);
        cmbTimezoneTarget.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbTimezoneTarget.setItems(availableTimezones);
        cmbTimezoneTarget.select(cmbTimezoneTarget.indexOf(ApgdiffConsts.UTC));
        
        setControl(container);
    }

    @Override
    public boolean isPageComplete() {
        
        if (storePickerSource.getDbInfo() != null || storePickerSource.getPathOfFile() != null || storePickerSource.getPathOfProject() != null){
            setErrorMessage(null);
        } else {
            setErrorMessage(Messages.diffwizard_diffpage_source_warning);
            return false;
        }
        
        if (storePickerTarget.getDbInfo() != null || storePickerTarget.getPathOfFile() != null || storePickerTarget.getPathOfProject() != null){
            setErrorMessage(null);
        } else {
            setErrorMessage(Messages.diffwizard_diffpage_target_warning);
            return false;
        }
        
        if (storePickerSource.equals(storePickerTarget)){
            return true;
        }
        
        return true;
    }

    @Override
    public void handleEvent(Event event) {
        getWizard().getContainer().updateButtons();
        getWizard().getContainer().updateMessage();
    }
}

class PagePartial extends WizardPage {

    private Composite container;
    private IPreferenceStore mainPrefs;
    private final IWizardPage prevPage;

    private Label lblSource, lblTarget;

    private DiffTableViewer diffTree;

    public void setData(String source, String target, TreeDiffer treeDiffer) {
        lblSource.setText(source);
        lblTarget.setText(target);
        diffTree.setInput(treeDiffer, true);
    }

    public DiffTableViewer getDiffTree() {
        return diffTree;
    }

    public PagePartial(String pageName, IPreferenceStore mainPrefs, IWizardPage prevPage) {
        super(pageName, pageName, null);
        this.mainPrefs = mainPrefs;
        this.prevPage = prevPage;
        setDescription(Messages.diffwizard_pagepartial_description);
    }

    public void layout() {
        container.layout(true);
    }

    @Override
    public void createControl(Composite parent) {
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout());
        
        Composite labelComp = new Composite(container, SWT.NONE);
        labelComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout labelLayout = new GridLayout(2, true);
        labelLayout.marginWidth = labelLayout.marginHeight = 0;
        labelComp.setLayout(labelLayout);

        new Label(labelComp, SWT.NONE).setText(Messages.diffWizard_source);
        
        Label l = new Label(labelComp, SWT.NONE);
        l.setText(Messages.diffWizard_target);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 600;
        l.setLayoutData(gd);

        lblSource = new Label(labelComp, SWT.WRAP);
        lblSource.setLayoutData(gd);

        lblTarget = new Label(labelComp, SWT.WRAP);
        lblTarget.setLayoutData(gd);

        diffTree = new DiffTableViewer(container, SWT.NONE, mainPrefs, null, false);
        gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 12;
        diffTree.setLayoutData(gd);

        setControl(container);
    }

    @Override
    public IWizardPage getPreviousPage() {
        return prevPage;
    }
}

class PageResult extends WizardPage {

    private Composite container;
    private TabFolder tabs;
    private Label lblSource, lblTarget;
    private final IWizardPage prevPage;
    private String encoding;

    private Text txtDirect, txtReverse;

    public void setData(String source, String target, String direct, String reverse) {
        lblSource.setText(source);
        lblTarget.setText(target);
        txtDirect.setText(direct);
        txtReverse.setText(reverse);
    }

    public PageResult(String pageName, IWizardPage prevPage) {
        super(pageName, pageName, null);
        this.prevPage = prevPage;
        setDescription(Messages.diffwizard_pageresult_description);
    }

    public void layout() {
        container.layout(true);
    }

    @Override
    public void createControl(Composite parent) {
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout());

        Composite labelComp = new Composite(container, SWT.NONE);
        labelComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout labelLayout = new GridLayout(2, true);
        labelLayout.marginWidth = labelLayout.marginHeight = 0;
        labelComp.setLayout(labelLayout);
        
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 600;
        
        new Label(labelComp, SWT.NONE).setText(Messages.diffWizard_source);
        
        Label l = new Label(labelComp, SWT.NONE);
        l.setText(Messages.diffWizard_target);
        l.setLayoutData(gd);

        lblSource = new Label(labelComp, SWT.WRAP);
        lblSource.setLayoutData(gd);

        lblTarget = new Label(labelComp, SWT.WRAP);
        lblTarget.setLayoutData(gd);

        tabs = new TabFolder(container, SWT.NONE);
        gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 12;
        gd.widthHint = 600;
        tabs.setLayoutData(gd);
        tabs.setLayout(new GridLayout());

        txtDirect = new Text(tabs, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
                | SWT.READ_ONLY | SWT.MULTI);
        txtDirect.setLayoutData(new GridData(GridData.FILL_BOTH));
        txtDirect.setBackground(getShell().getDisplay().getSystemColor(
                SWT.COLOR_LIST_BACKGROUND));
        txtDirect.setFont(JFaceResources.getTextFont());

        TabItem tabDirect = new TabItem(tabs, SWT.NONE);
        tabDirect.setText(Messages.diffWizard_source_target);
        tabDirect.setControl(txtDirect);

        txtReverse = new Text(tabs, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
                | SWT.READ_ONLY | SWT.MULTI);
        txtReverse.setLayoutData(new GridData(GridData.FILL_BOTH));
        txtReverse.setBackground(getShell().getDisplay().getSystemColor(
                SWT.COLOR_LIST_BACKGROUND));
        txtReverse.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));

        TabItem tabReverse = new TabItem(tabs, SWT.NONE);
        tabReverse.setText(Messages.diffWizard_target_source);
        tabReverse.setControl(txtReverse);

        Button btnSave = new Button(container, SWT.PUSH);
        btnSave.setText(Messages.diffWizard_save);
        gd = new GridData(GridData.HORIZONTAL_ALIGN_END);
        gd.verticalIndent = 12;
        btnSave.setLayoutData(gd);
        btnSave.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog saveDialog = new FileDialog(getShell(), SWT.SAVE);
                saveDialog.setText(MessageFormat.format(
                        Messages.diffWizard_save__,
                        tabs.getSelection()[0].getText()));
                saveDialog.setOverwrite(true);
                saveDialog.setFilterExtensions(new String[] { "*.sql", "*" }); //$NON-NLS-1$ //$NON-NLS-2$
                saveDialog.setFilterPath(System.getProperty("user.home"));
                String saveTo = saveDialog.open();
                if (saveTo != null) {
                    saveScript(saveTo);
                }
            }
        });
        setControl(container);
    }
    
    public boolean isSrc2Trg(){
        if (tabs.getItem(tabs.getSelectionIndex()).getText().equals(Messages.diffWizard_source_target)){
            return true;
        } else if (tabs.getItem(tabs.getSelectionIndex()).getText().equals(Messages.diffWizard_target_source)){
            return false;
        }
        return true;
    }
    
    public void setEncoding(String encoding){
        this.encoding = encoding;
    }

    private void saveScript(String saveTo) {
        try (PrintWriter encodedWriter = new UnixPrintWriter(
                // TODO save to proj encoding can be incorrect.
                // Consider saving to unicode if proj and PageDiff encodings differ
                new OutputStreamWriter(new FileOutputStream(saveTo),
                        encoding))) {
            Text txtDiff = (Text) tabs.getSelection()[0].getControl();
            encodedWriter.println(txtDiff.getText());
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            ExceptionNotifier.notifyDefault(
                    Messages.diffWizard_unexpected_error_while_saving_diff, ex);
        }
    }

    @Override
    public IWizardPage getPreviousPage() {
        return prevPage;
    }
}
