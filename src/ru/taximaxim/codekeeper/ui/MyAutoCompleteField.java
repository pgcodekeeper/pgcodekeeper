package ru.taximaxim.codekeeper.ui;

import java.util.ArrayList;

import org.eclipse.jface.fieldassist.ContentProposal;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.swt.widgets.Control;

class MyAutoCompleteField {

    private MyContentProposalProvider proposalProvider;
    private ContentProposalAdapter adapter;

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
    public MyAutoCompleteField(Control control,
            IControlContentAdapter controlContentAdapter, String[] proposals) {
        proposalProvider = new MyContentProposalProvider(proposals);
        proposalProvider.setFiltering(true);
        adapter = new ContentProposalAdapter(control, controlContentAdapter,
                proposalProvider, null, null);
        adapter.setPropagateKeys(true);
        adapter
                .setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
    }
}

class MyContentProposalProvider implements IContentProposalProvider {

    private final String[] proposals;
    /*
     * The proposals mapped to IContentProposal. Cached for speed in the case
     * where filtering is not used.
     */
    private IContentProposal[] contentProposals;
    
    /*
     * Boolean that tracks whether filtering is used.
     */
    private boolean filterProposals = false;
    
    public MyContentProposalProvider(String[] proposals) {
        this.proposals = new String[proposals.length];
        
        for (int i = 0; i < proposals.length; ++i) {
            this.proposals[i] = proposals[i].toLowerCase();
        }
    }
    
    @Override
    public IContentProposal[] getProposals(String contents, int position) {
        if (filterProposals) {
            String contentsLc = contents.toLowerCase();
            String contentsNq = contentsLc.replace("\"", ""); //$NON-NLS-1$ //$NON-NLS-2$
            ArrayList<ContentProposal> list = new ArrayList<ContentProposal>();
            for (String proposal : proposals) {
                if (proposal.contains(contentsLc)
                        // ignore quotes
                        || proposal.replace("\"", "").contains(contentsNq)) { //$NON-NLS-1$ //$NON-NLS-2$
                    list.add(new ContentProposal(proposal));
                }
            }
            return list.toArray(new IContentProposal[list.size()]);
        }
        if (contentProposals == null) {
            contentProposals = new IContentProposal[proposals.length];
            for (int i = 0; i < proposals.length; i++) {
                contentProposals[i] = new ContentProposal(proposals[i]);
            }
        }
        return contentProposals;
    }

    public void setFiltering(boolean filterProposals) {
        this.filterProposals = filterProposals;
        // Clear any cached proposals.
        contentProposals = null;
    }
}