package ru.taximaxim.codekeeper.ui.dialogs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.swt.widgets.Control;

class PgStatementAutoCompleteField {

    private final ContentProposalAdapter adapter;

    /**
     * Construct an AutoComplete field on the specified control, whose
     * completions are characterized by the specified array of Strings.
     *
     * @param control
     *            the control for which autocomplete is desired. May not be
     *            <code>null</code>.
     * @param controlContentAdapter
     *            the <code>IControlContentAdapter</code> used to obtain and
     *            update the control's contents. May not be <code>null</code>.
     * @param proposals
     *            the array of Strings representing valid content proposals for
     *            the field.
     */
    public PgStatementAutoCompleteField(Control control,
            IControlContentAdapter controlContentAdapter, List<IContentProposal> proposals) {
        adapter = new ContentProposalAdapter(control, controlContentAdapter,
                new PgStatementProposalProvider(proposals), null, null);
        adapter.setPropagateKeys(true);
        adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
    }
}

class PgStatementProposalProvider implements IContentProposalProvider {

    private static final Pattern PATTERN_QUOTE = Pattern.compile("\"", Pattern.LITERAL); //$NON-NLS-1$

    private final List<IContentProposal> proposals;

    public PgStatementProposalProvider(List<IContentProposal> proposals) {
        this.proposals = proposals;
    }

    @Override
    public IContentProposal[] getProposals(String contents, int position) {
        String contentsLc = contents.toLowerCase();
        String contentsNq = PATTERN_QUOTE.matcher(contentsLc).replaceAll(""); //$NON-NLS-1$

        List<IContentProposal> list = new ArrayList<>();
        for (IContentProposal proposal : proposals) {
            String content = proposal.getContent();
            if (content.contains(contentsLc)
                    // ignore quotes
                    || PATTERN_QUOTE.matcher(content).replaceAll("").contains(contentsNq)) { //$NON-NLS-1$
                list.add(proposal);
            }
        }
        return list.toArray(new IContentProposal[list.size()]);
    }
}

class PgStatementProposalComparator implements Comparator<IContentProposal> {

    public static final PgStatementProposalComparator INSTANCE = new PgStatementProposalComparator();

    @Override
    public int compare(IContentProposal o1, IContentProposal o2) {
        return o1.getContent().compareTo(o2.getContent());
    }
}