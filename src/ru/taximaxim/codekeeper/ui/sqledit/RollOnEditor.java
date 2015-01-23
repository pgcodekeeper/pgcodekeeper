package ru.taximaxim.codekeeper.ui.sqledit;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.XmlHistory;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.HELP;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.XML_TAGS;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PreferenceInitializer;

public class RollOnEditor extends SQLEditor {

    public static final String ID = "ru.taximaxim.codekeeper.ui.RollOnEditor";
    
    private static final Pattern PATTERN_ERROR = Pattern.compile(
            "^.*(ERROR|ОШИБКА):.+$"); //$NON-NLS-1$
    private static final Pattern PATTERN_DROP_CASCADE = Pattern.compile(
            "^(HINT|ПОДСКАЗКА):.+(DROP \\.\\.\\. CASCADE).+$",  //$NON-NLS-1$
            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE); 
    
    private static final String SCRIPT_PLACEHOLDER = "%script"; //$NON-NLS-1$
    private static final String DB_HOST_PLACEHOLDER = "%host"; //$NON-NLS-1$
    private static final String DB_PORT_PLACEHOLDER = "%port"; //$NON-NLS-1$
    private static final String DB_NAME_PLACEHOLDER = "%db"; //$NON-NLS-1$
    private static final String DB_USER_PLACEHOLDER = "%user"; //$NON-NLS-1$
    private static final String DB_PASS_PLACEHOLDER = "%pass"; //$NON-NLS-1$
    
    private static final String RUN_SCRIPT_LABEL =  Messages.sqlScriptDialog_run_script;
    private static final String STOP_SCRIPT_LABEL = Messages.sqlScriptDialog_stop_script;
    private static final String[] BUTTONS = new String[] {
        RUN_SCRIPT_LABEL, Messages.sqlScriptDialog_save_as, IDialogConstants.CLOSE_LABEL }; 
    

    private static final String LINE_SEP = System.lineSeparator();
    
    private final XmlHistory history;
    private Differ differ;
    private List<Entry<String, String>> addDepcy;
    private List<Entry<PgStatement, PgStatement>> oldDepcy;
    private List<PgStatement> objList;
    private IPreferenceStore mainPrefs;
    private Color colorPink;
    
    private String dbHost;
    private String dbPort;
    private String dbName;
    private String dbUser;
    private String dbPass;
    
    private SqlSourceViewerExtender sqlEditor;
    private Text txtCommand;
    private Combo cmbScript;
    private Button btnJdbcToggle;
    private Button btnHidePicker;
    private DbPicker picker;
    
    private volatile boolean isRunning;
    private Thread scriptThread;
    private String title;
    private String message;
    private int type;
    private String scriptFileEncoding;
    private String connectionTimezone;
    
    public RollOnEditor() {
        this.history = new XmlHistory.Builder(XML_TAGS.DDL_UPDATE_COMMANDS_MAX_STORED, 
                FILE.DDL_UPDATE_COMMANDS_HIST_FILENAME, 
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ROOT, 
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ELEMENT).build();
    }
    @Override
    protected ISourceViewer createSourceViewer(Composite parent,
            IVerticalRuler ruler, int styles) {
        Layout gl = new GridLayout(1, false);        
        parent.setLayout(gl);
        parent.setLayoutData(new GridData());
        
        createDialogArea(parent);
        
        SourceViewer sw = (SourceViewer) super.createSourceViewer(parent, ruler, styles);
        sw.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
        return sw;
    }
    
    private Control createMessageArea(Composite composite) {
        // create composite
        // create image
        Image image = composite.getDisplay().getSystemImage(type);
        Composite comp = new Composite(composite, SWT.FILL);
        Layout layout = new GridLayout(2, false);
        comp.setLayout(layout);
        
        if (image != null) {
            Label imageLabel = new Label(comp, SWT.NULL);
            image.setBackground(imageLabel.getBackground());
            imageLabel.setImage(image);
            GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.BEGINNING)
                    .applyTo(imageLabel);
        }
        // create message
        if (message != null) {
            Label messageLabel = new Label(comp, SWT.WRAP);
            messageLabel.setText(message);
            GridDataFactory
                    .fillDefaults()
                    .align(SWT.FILL, SWT.BEGINNING)
                    .grab(true, false)
                    .hint(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH,
                            SWT.DEFAULT)
                    .applyTo(messageLabel);
        }
        return composite;
    }
    
    protected Control createDialogArea(final Composite parent) {
        GridLayout lay = new GridLayout();
        parent.setLayout(lay);
        
        createMessageArea(parent);
        
        Composite buttons = new Composite(parent, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);;
        buttons.setLayoutData(gd);
        
        GridLayout gl = new GridLayout(2, false);
        gl.marginHeight = gl.marginWidth = 0;
        buttons.setLayout(gl);
        
        btnJdbcToggle = new Button(buttons, SWT.CHECK);
        btnJdbcToggle.setText(Messages.sqlScriptDialog_use_jdbc_for_ddl_update);
        boolean isDdlUpdateOverJdbc = 
                Activator.getDefault().getPreferenceStore().getBoolean(PREF.IS_DDL_UPDATE_OVER_JDBC);
        btnJdbcToggle.setSelection(isDdlUpdateOverJdbc);
        
        btnHidePicker = new Button(buttons, SWT.CHECK); 
        btnHidePicker.setText(Messages.sqlScriptDialog_hide_picker);
        btnHidePicker.setSelection(false);
        btnHidePicker.addSelectionListener(new SelectionAdapter() {
        
            @Override
            public void widgetSelected(SelectionEvent e) {
                picker.setVisible(!btnHidePicker.getSelection());
                ((GridData)picker.getLayoutData()).exclude = btnHidePicker.getSelection();
                parent.layout();
            }
        });
        // picker
        picker = new DbPicker(parent, SWT.BORDER, mainPrefs, false);
        picker.setText(Messages.SqlScriptDialog_jdbc_connection_details);
        
        picker.getTxtDbName().setText(dbName == null ? "" : dbName); //$NON-NLS-1$
        picker.getTxtDbUser().setText(dbUser == null ? "" : dbUser); //$NON-NLS-1$
        picker.getTxtDbHost().setText(dbHost == null ? "" : dbHost); //$NON-NLS-1$
        picker.getTxtDbPort().setText(dbPort == null || dbPort.isEmpty() ? "0" : dbPort); //$NON-NLS-1$
        
        gd = new GridData(SWT.FILL, SWT.FILL, true, false);
        gd.exclude = !isDdlUpdateOverJdbc;
        gd.heightHint = 230;
        gd.minimumHeight = 230;
        picker.setLayoutData(gd);
        picker.setVisible(isDdlUpdateOverJdbc);
        
        final Composite notJdbc = new Composite(parent, SWT.NONE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.exclude = isDdlUpdateOverJdbc;
        notJdbc.setLayoutData(gd);
        notJdbc.setVisible(!isDdlUpdateOverJdbc);
        
        gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        notJdbc.setLayout(gl);
        
        Label l = new Label(notJdbc, SWT.NONE);
        l.setText(Messages.sqlScriptDialog_Enter_cmd_to_update_ddl_with_sql_script
                + SCRIPT_PLACEHOLDER + ' '
                + DB_NAME_PLACEHOLDER + ' '
                + DB_HOST_PLACEHOLDER + ' ' + DB_PORT_PLACEHOLDER + ' '
                + DB_USER_PLACEHOLDER + ' ' + DB_PASS_PLACEHOLDER + ')' + ':');
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        l.setLayoutData(gd);
        
        cmbScript = new Combo(notJdbc, SWT.DROP_DOWN);
        cmbScript.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbScript.setToolTipText(DB_NAME_PLACEHOLDER + '=' +dbName + LINE_SEP +
                DB_HOST_PLACEHOLDER + '=' + dbHost + LINE_SEP + 
                DB_PORT_PLACEHOLDER + '=' + dbPort + LINE_SEP + 
                DB_USER_PLACEHOLDER + '=' + dbUser + LINE_SEP + 
                DB_PASS_PLACEHOLDER + '=' + dbPass);

        List<String> prev;
        try {
            prev = history.getHistory();
        } catch (IOException e1) {
            ExceptionNotifier.showErrorDialog(Messages.SqlScriptDialog_error_loading_command_history, e1);
            prev = new ArrayList<>();
        }
        if (prev != null && !prev.isEmpty()) {
            for (String el : prev) {
                cmbScript.add(el);
            }
            cmbScript.select(0);
        }
        
        cmbScript.addModifyListener(new ModifyListener() {
            
            @Override
            public void modifyText(ModifyEvent e) {
                txtCommand.setText(getReplacedString());
            }
        });
        
        l = new Label(notJdbc, SWT.NONE);
        l.setText(Messages.SqlScriptDialog_command_to_execute + SCRIPT_PLACEHOLDER
                + Messages.SqlScriptDialog_will_be_replaced);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        l.setLayoutData(gd);
        
        txtCommand = new Text(notJdbc, SWT.BORDER | SWT.READ_ONLY);
        txtCommand.setText(getReplacedString());
//        txtCommand.setBackground(getShell().getDisplay()
//                .getSystemColor(SWT.COLOR_LIST_BACKGROUND));
        txtCommand.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
//        getShell().addListener(SWT.Activate, new Listener() {
//            
//            @Override
//            public void handleEvent(Event event) {
//                getShell().removeListener(SWT.Activate, this);
//                try {
//                    if (checkDangerDdl()) {
//                        if (showDangerWarning() == SWT.OK) {
//                            sqlEditor.getTextWidget().setBackground(colorPink);
//                        } else {
//                            close();
//                        }
//                    }
//                } catch (PgCodekeeperUIException e) {
//                    ExceptionNotifier.showErrorDialog(Messages.SqlScriptDialog_error_get_script, e);
//                }
//            }
//        });
        
//        colorPink = new Color(getShell().getDisplay(), new RGB(0xff, 0xe1, 0xff));
        parent.addDisposeListener(new DisposeListener() {
            
            @Override
            public void widgetDisposed(DisposeEvent e) {
//                colorPink.dispose();
            }
        });
        
        btnJdbcToggle.addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean isJdbc = btnJdbcToggle.getSelection();
                notJdbc.setVisible(!isJdbc);
                ((GridData)notJdbc.getLayoutData()).exclude = isJdbc;
                
                picker.setVisible(isJdbc && !btnHidePicker.getSelection());
                ((GridData)picker.getLayoutData()).exclude = !isJdbc || btnHidePicker.getSelection();
                
                btnHidePicker.setVisible(isJdbc);
                ((GridData)btnHidePicker.getLayoutData()).exclude = !isJdbc;
                
                parent.layout();
                
                PreferenceInitializer.savePreference(Activator.getDefault().getPreferenceStore(), 
                        PREF.IS_DDL_UPDATE_OVER_JDBC, String.valueOf(btnJdbcToggle.getSelection()));
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        
//        PlatformUI.getWorkbench().getHelpSystem().setHelp(getShell(), HELP.SQL_SCRIPT_DIALOG);
        return parent;
    }
    
//    private boolean checkDangerDdl() throws PgCodekeeperUIException {
//        return differ.getScript().isDangerDdl(
//                !mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_TABLE_STATEMENT), 
//                !mainPrefs.getBoolean(DB_UPDATE_PREF.ALTER_COLUMN_STATEMENT),
//                !mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_COLUMN_STATEMENT));
//    }
    
//    private int showDangerWarning() {
//        MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING
//                | SWT.OK | SWT.CANCEL);
//        mb.setText(Messages.sqlScriptDialog_warning);
//        mb.setMessage(Messages.sqlScriptDialog_script_contains_statements_that_may_modify_data);
//        return mb.open();
//    }
    
    private String getReplacedString() {
        String s = cmbScript.getText();
        if (dbHost != null) {
            s = s.replace(DB_HOST_PLACEHOLDER, dbHost);
        }
        if (dbName != null) {
            s = s.replace(DB_NAME_PLACEHOLDER, dbName);
        }
        if (dbUser != null) {
            s = s.replace(DB_USER_PLACEHOLDER, dbUser);
        }
        if (dbPass != null) {
            s = s.replace(DB_PASS_PLACEHOLDER, dbPass);
        }
        if (dbPort != null) {
            s = s.replace(DB_PORT_PLACEHOLDER, dbPort);
        }
        return s;
    }
}
