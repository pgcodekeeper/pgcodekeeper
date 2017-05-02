package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

public class SQLEditorCommonDocumentProvider {

    /**
     * The recipe partitioning. It contains two partition types: {@link #SQL_CODE} and
     * {@link #SQL_SINGLE_COMMENT}.
     */
    public static final String SQL_PARTITIONING = "ru.taximaxim.codekeeper.ui.sqleditor.partitioning"; //$NON-NLS-1$

    /**
     * The identifier of the comment body type.
     */
    public static final String SQL_CODE = IDocument.DEFAULT_CONTENT_TYPE;
    /**
     * The identifier of the comment partition type.
     */
    public static final String SQL_SINGLE_COMMENT = "SQL_SINGLE_COMMENT"; //$NON-NLS-1$
    public static final String SQL_MULTI_COMMENT = "SQL_MULTI_COMMENT"; //$NON-NLS-1$
    public static final String SQL_CHARACTER_STRING_LITERAL = "SQL_CHARACTER_STRING_LITERAL"; //$NON-NLS-1$

    private static final String[] CONTENT_TYPES= {
            SQL_CODE,
            SQL_SINGLE_COMMENT,
            SQL_MULTI_COMMENT,
            SQL_CHARACTER_STRING_LITERAL
    };

    void setupDocument(IDocument document) {
        if (document instanceof IDocumentExtension3) {
            IDocumentExtension3 ext= (IDocumentExtension3) document;
            IDocumentPartitioner partitioner= createRecipePartitioner();
            ext.setDocumentPartitioner(SQL_PARTITIONING, partitioner);
            partitioner.connect(document);
        }
    }

    IDocumentPartitioner createRecipePartitioner() {
        IPredicateRule[] rules = {
                new SingleLineRule("--", null, new Token(SQL_SINGLE_COMMENT), (char) 0, true, false), //$NON-NLS-1$
                new MultiLineRule("/*", "*/", new Token(SQL_MULTI_COMMENT), (char) 0, true),  //$NON-NLS-1$ //$NON-NLS-2$
                new MultiLineRule( "'", "'", new Token(SQL_CHARACTER_STRING_LITERAL), (char) 0 , true) //$NON-NLS-1$ //$NON-NLS-2$
        };

        RuleBasedPartitionScanner scanner = new RuleBasedPartitionScanner();
        scanner.setPredicateRules(rules);

        return new FastPartitioner(scanner, CONTENT_TYPES);
    }
}
