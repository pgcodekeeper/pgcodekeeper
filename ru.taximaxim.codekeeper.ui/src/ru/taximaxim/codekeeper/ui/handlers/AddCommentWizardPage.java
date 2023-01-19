package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class AddCommentWizardPage extends UserInputWizardPage {

    private static final String PAGE_NAME = "AddCommentWizardPage";

    private Text txtComment;

    public AddCommentWizardPage(PgDbParser parser) {
        super(PAGE_NAME);
    }

    @Override
    public void createControl(Composite parent) {
        Composite top = new Composite(parent, SWT.NONE);
        initializeDialogUnits(top);
        setControl(top);

        top.setLayout(new GridLayout(2, false));

        Label label = new Label(top, SWT.NONE);
        label.setText(Messages.AddCommentWizardPage_new_page);
        txtComment = new Text(top, SWT.BORDER);
        txtComment.setLayoutData(new GridData());
    }

}
