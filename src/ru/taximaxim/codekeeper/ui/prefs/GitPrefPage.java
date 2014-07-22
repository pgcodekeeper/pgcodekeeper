package ru.taximaxim.codekeeper.ui.prefs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

import com.jcraft.jsch.JSchException;

public class GitPrefPage extends FieldEditorPreferencePage
        implements IWorkbenchPreferencePage {
    
    private Button genKeysButt;
    private Button copyPublicKeyButt;
    private FileFieldEditor editorPrivate;
    
    public GitPrefPage() {
        super(GRID);
    }
    
    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(UIScopedPreferenceStore.get());
    }

    @Override
    protected void createFieldEditors() {
        editorPrivate = new FileFieldEditor(PREF.GIT_KEY_PRIVATE_FILE, 
                Messages.gitPrefPage_private_key, true, FileFieldEditor.VALIDATE_ON_KEY_STROKE,
                getFieldEditorParent());
        addField(editorPrivate);
    }
    
    @Override
    protected Control createContents(final Composite parent) {
        genKeysButt = new Button(parent, SWT.PUSH);
        genKeysButt.setText(Messages.gitPrefPage_generate_keys);
        genKeysButt.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                MessageBox dialog = new MessageBox(getShell(), SWT.OK);
                dialog.setMessage(Messages.gitPrefPage_select_file_to_save_priv_key);
                dialog.open();
                FileDialog fd = new FileDialog(parent.getShell(), SWT.SAVE);
                fd.setText(Messages.gitPrefPage_save_priv_key_to_file);
                fd.setOverwrite(true);
                String privateFileName = fd.open();
                if (privateFileName != null)
                    try {
                        JGitExec.genKeys(privateFileName);
                        editorPrivate.setStringValue(privateFileName);
                    } catch (IOException | JSchException ex) {
                        ExceptionNotifier.notify(
                                Messages.gitPrefPage_error_while_rsa_keys_generation, ex);
                    }
            }
        });
        copyPublicKeyButt = new Button(parent, SWT.PUSH);
        copyPublicKeyButt.setText(Messages.gitPrefPage_copy_public_keys_to_clipboard);
        copyPublicKeyButt.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String publicFileName = editorPrivate.getTextControl(getFieldEditorParent()).getText() + ".pub"; //$NON-NLS-1$
                File publicKey = new File (publicFileName);
                try (BufferedReader reader = new BufferedReader( new FileReader (publicKey))){
                    StringBuilder  sBuilder = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                        sBuilder.append(line + "\n"); //$NON-NLS-1$
                    }
                    Object [] data = new Object [] {sBuilder.toString()};
                    new Clipboard(parent.getDisplay()).setContents (data, new Transfer[]{TextTransfer.getInstance()});
                } catch (IOException ex) {
                    MessageBox mb = new MessageBox(getShell(), SWT.ERROR);
                    mb.setText(Messages.gitPrefPage_file_not_found);
                    mb.setMessage(Messages.gitPrefPage_public_key_file + publicFileName
                            + Messages.gitPrefPage_either_doesnt_exist_or_inaccessible);
                    mb.open();
                }
            }
        });
        return super.createContents(parent);
    }
}