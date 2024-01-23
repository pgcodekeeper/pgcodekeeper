/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.dialogs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

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

    private final List<IContentProposal> proposals;

    public PgStatementProposalProvider(List<IContentProposal> proposals) {
        this.proposals = proposals;
    }

    @Override
    public IContentProposal[] getProposals(String contents, int position) {
        String contentsLc = contents.toLowerCase(Locale.ROOT);
        String contentsNq = contentsLc.replace("\"", ""); //$NON-NLS-1$

        List<IContentProposal> list = new ArrayList<>();
        for (IContentProposal proposal : proposals) {
            String content = proposal.getContent();
            if (content.contains(contentsLc)
                    // ignore quotes
                    || content.replace("\"", "").contains(contentsNq)) { //$NON-NLS-1$
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