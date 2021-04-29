package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.LinkedList;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.TypedPosition;
import org.eclipse.jface.text.formatter.ContextBasedFormattingStrategy;
import org.eclipse.jface.text.formatter.FormattingContextProperties;
import org.eclipse.jface.text.formatter.IFormattingContext;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

import cz.startnet.utils.pgdiff.formatter.FileFormatter;
import cz.startnet.utils.pgdiff.formatter.FormatConfiguration;
import cz.startnet.utils.pgdiff.formatter.FormatConfiguration.IndentType;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.FORMATTER_PREF;

public class SQLFormattingStrategy extends ContextBasedFormattingStrategy {

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    /** Documents to be formatted by this strategy */
    private final LinkedList<IDocument> fDocuments = new LinkedList<>();
    /** Partitions to be formatted by this strategy */
    private final LinkedList<TypedPosition> fPartitions = new LinkedList<>();

    private final SQLEditor editor;

    public SQLFormattingStrategy(SQLEditor editor) {
        this.editor = editor;
    }

    @Override
    public void format() {
        super.format();

        final IDocument document = fDocuments.removeFirst();
        final TypedPosition partition = fPartitions.removeFirst();

        if (document != null && partition != null) {
            Map<String, IDocumentPartitioner> partitioners = null;
            int offset = partition.getOffset();
            int length = partition.getLength();

            try {
                TextEdit edit = formatDoc(offset, length, document.get());

                if (edit != null) {
                    if (edit.getChildrenSize() > 20) {
                        partitioners = TextUtilities
                                .removeDocumentPartitioners(document);
                    }

                    edit.apply(document);
                }
            } catch (MalformedTreeException | BadLocationException e) {
                Log.log(e);
            } finally {
                if (partitioners != null) {
                    TextUtilities.addDocumentPartitioners(document,
                            partitioners);
                }
            }
        }
    }

    private TextEdit formatDoc(int offset, int length, String source) {
        FormatConfiguration config = new FormatConfiguration();

        String mode = mainPrefs.getString(FORMATTER_PREF.INDENT_TYPE);
        if (FORMATTER_PREF.WHITESPACE.equals(mode)) {
            config.setIndentType(IndentType.WHITESPACE);
        } else if (FORMATTER_PREF.TAB.equals(mode)) {
            config.setIndentType(IndentType.TAB);
        }

        config.setIndentSize(mainPrefs.getInt(FORMATTER_PREF.INDENT_SIZE));
        config.setRemoveTrailingWhitespace(
                mainPrefs.getBoolean(FORMATTER_PREF.REMOVE_TRAILING_WHITESPACE));
        config.setAddWhitespaceBeforeOp(
                mainPrefs.getBoolean(FORMATTER_PREF.ADD_WHITESPACE_BEFORE_OP));
        config.setAddWhitespaceAfterOp(
                mainPrefs.getBoolean(FORMATTER_PREF.ADD_WHITESPACE_AFTER_OP));

        if (mainPrefs.getBoolean(FORMATTER_PREF.REPLACE_TAB)) {
            config.setSpacesForTabs(mainPrefs.getInt(FORMATTER_PREF.WHITESPACE_COUNT));
        }

        FileFormatter formatter = new FileFormatter(source, offset, length, config, editor.isMsSql());
        return formatter.getFormatEdit();
    }

    @Override
    public void formatterStarts(final IFormattingContext context) {
        super.formatterStarts(context);

        fPartitions.addLast((TypedPosition) context
                .getProperty(FormattingContextProperties.CONTEXT_PARTITION));
        fDocuments.addLast((IDocument) context
                .getProperty(FormattingContextProperties.CONTEXT_MEDIUM));
    }

    @Override
    public void formatterStops() {
        super.formatterStops();

        fPartitions.clear();
        fDocuments.clear();
    }
}
