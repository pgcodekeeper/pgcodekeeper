package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.AbstractInformationControl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IInformationControlExtension2;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.editors.text.EditorsUI;

public class SQLEditorInformationControl extends AbstractInformationControl
implements IInformationControlExtension2 {

    private Composite fParent;
    private SQLHoverInfo fInput;

    public SQLEditorInformationControl(Shell parentShell, String statusFieldText) {
        //TODO statusFieldText is dissappearing when rename operation done. Need fix
        super(parentShell, statusFieldText);
        create();
    }

    @Override
    public boolean hasContents() {
        return fInput != null;
    }

    private SQLHoverInfo getSQLHoverInfo() {
        return fInput;
    }

    @Override
    protected void createContent(Composite parentShell) {
        fParent = parentShell;
        GridLayout layout = new GridLayout(1, false);
        layout.verticalSpacing = 0;
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        fParent.setLayout(layout);
    }

    @Override
    public Point computeSizeHint() {

        Point preferedSize = getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT, true);

        Point constrains = getSizeConstraints();
        if (constrains == null) {
            return preferedSize;
        }

        int trimWidth = getShell().computeTrim(0, 0, 0, 0).width;
        Point constrainedSize = getShell().computeSize(constrains.x - trimWidth,
                SWT.DEFAULT, true);

        // get minimum needed width within constrained size including the trim and add a little extra
        // to ensure we don't get unnecessary wrapping of the text (4 is minimum for Windows)
        int width = Math.min(preferedSize.x + trimWidth + 4, constrainedSize.x);
        int height = Math.max(preferedSize.y, constrainedSize.y);

        return new Point(width, height);
    }

    @Override
    public void setInput(Object input) {
        fInput = (SQLHoverInfo) input;
        deferredCreateContent();
    }

    protected void deferredCreateContent() {
        createAnnotationInformation(getSQLHoverInfo().annotation);

        Color foreground = fParent.getForeground();
        Color background = fParent.getBackground();

        setForegroundColor(foreground); // For main composite.
        setBackgroundColor(background);
        setColorAndFont(fParent, foreground, background, JFaceResources.getDialogFont()); // For child elements.
        if (fInput.pgObjLocation != null) {
            MisplaceCompletionProposal [] misplaceCompletionProposals = MisplaceProposal.getMisplaceProposals(getSQLHoverInfo().annotation, fInput.pgObjLocation);
            if (misplaceCompletionProposals != null) {
                createCompletionProposalsControl(misplaceCompletionProposals);
            }
        }

        fParent.layout(true);
    }

    private void createAnnotationInformation(Annotation annotation) {
        Composite composite = new Composite(fParent, SWT.NONE);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        GridLayout layout = new GridLayout(2, false);
        layout.marginHeight = 2;
        layout.marginWidth = 2;
        layout.horizontalSpacing = 0;
        composite.setLayout(layout);

        GridData gridData = new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false);
        gridData.widthHint = 17;
        gridData.heightHint = 16;

        StyledText text = new StyledText(composite,
                SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.WRAP | SWT.READ_ONLY);
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        text.setLayoutData(data);
        text.setAlwaysShowScrollBars(false);
        if (annotation != null) {
            String annotationText = annotation.getText();
            if (annotationText != null) {
                text.setText(annotationText);
            }
        } else if (fInput.comment != null) {
            text.setText(fInput.comment);
        }
    }

    private void createCompletionProposalsControl(
            MisplaceCompletionProposal[] proposals) {
        Composite composite = new Composite(fParent, SWT.NONE);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout layout2 = new GridLayout(1, false);
        layout2.marginHeight = 0;
        layout2.marginWidth = 0;
        layout2.verticalSpacing = 2;
        composite.setLayout(layout2);

        Label separator = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
        GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        separator.setLayoutData(gridData);

        Label quickFixLabel = new Label(composite, SWT.NONE);
        GridData layoutData = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
        layoutData.horizontalIndent = 4;
        quickFixLabel.setLayoutData(layoutData);
        String text = proposals.length == 1 ? "Quick fix available:" : String.valueOf(proposals.length) + " quick fixes available:";
        quickFixLabel.setText(text);

        setColorAndFont(composite, fParent.getForeground(), fParent.getBackground(),
                JFaceResources.getDialogFont());
        createCompletionProposalsList(composite, proposals);
    }

    private void createCompletionProposalsList(Composite parent,
            MisplaceCompletionProposal[] proposals) {
        final ScrolledComposite scrolledComposite = new ScrolledComposite(parent,
                SWT.V_SCROLL | SWT.H_SCROLL);
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        scrolledComposite.setLayoutData(gridData);
        scrolledComposite.setExpandVertical(false);
        scrolledComposite.setExpandHorizontal(false);

        Composite composite = new Composite(scrolledComposite, SWT.NONE);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout layout = new GridLayout(2, false);
        layout.marginLeft = 5;
        layout.verticalSpacing = 2;
        composite.setLayout(layout);
        List<Link> list = new ArrayList<>();

        for (MisplaceCompletionProposal prop : proposals) {
            list.add(createCompletionProposalLink(composite, prop)); // Original link for single fix, hence pass 1 for count
        }
        scrolledComposite.setContent(composite);
        setColorAndFont(scrolledComposite, parent.getForeground(), parent.getBackground(),
                JFaceResources.getDialogFont());

        Point contentSize = composite.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        composite.setSize(contentSize);

        Point constraints = getSizeConstraints();
        if (constraints != null && contentSize.x < constraints.x) {
            ScrollBar horizontalBar = scrolledComposite.getHorizontalBar();

            int scrollBarHeight;
            if (horizontalBar == null) {
                Point scrollSize = scrolledComposite.computeSize(SWT.DEFAULT,
                        SWT.DEFAULT);
                scrollBarHeight = scrollSize.y - contentSize.y;
            } else {
                scrollBarHeight = horizontalBar.getSize().y;
            }
            gridData.heightHint = contentSize.y - scrollBarHeight;
        }
    }

    private Link createCompletionProposalLink(Composite parent,
            final MisplaceCompletionProposal proposal) {
        new Label(parent, SWT.NONE); // spacer to fill image cell
        parent = new Composite(parent, SWT.NONE); // indented composite for multi-fix
        GridLayout layout = new GridLayout(2, false);
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        parent.setLayout(layout);

        Link proposalLink = new Link(parent, SWT.NONE);
        GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        String linkText = proposal.getDisplayString();
        proposalLink.setText("<a>" + linkText + "</a>"); //$NON-NLS-1$ //$NON-NLS-2$
        proposalLink.setLayoutData(layoutData);

        proposalLink.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                dispose();
                IDocument document = fInput.viewer.getDocument();
                proposal.apply(document);
            }
        });
        return proposalLink;
    }

    private void setColorAndFont(Control control, Color foreground, Color background,
            Font font) {
        control.setForeground(foreground);
        control.setBackground(background);
        control.setFont(font);

        if (control instanceof Composite) {
            for (Control child : ((Composite) control).getChildren()) {
                setColorAndFont(child, foreground, background, font);
            }
        }
    }

    @Override
    public IInformationControlCreator getInformationPresenterControlCreator() {
        return parent -> new SQLEditorInformationControl(parent,
                EditorsUI.getTooltipAffordanceString());
    }
}
