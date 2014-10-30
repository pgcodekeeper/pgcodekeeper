package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;

public class SQLEditorHyperLinkDetector extends AbstractHyperlinkDetector {

    public SQLEditorHyperLinkDetector() {
    }

    @Override
    public IHyperlink[] detectHyperlinks(ITextViewer textViewer,
            IRegion region, boolean canShowMultipleHyperlinks) {
        IRegion lineInfo;
        String line;
        int offset = region.getOffset();

        try {
            IDocument document = textViewer.getDocument();
            lineInfo = document.getLineInformationOfOffset(offset);
            line = document.get(lineInfo.getOffset(), lineInfo.getLength());
        } catch (BadLocationException ex) {
            return null;
        }

        Pattern pa = Pattern.compile(
                "^.+(EXTENSION)[\\s]+([\\S]+).+$",
                Pattern.CASE_INSENSITIVE);
        Matcher ma = pa.matcher(line);
        if (!ma.matches()) {
            return null;
        }
        int begin = line.indexOf(ma.group(2));
        int end = begin + ma.group(2).length();

        if (end < 0 || begin < 0 || end == begin + 1)
            return null;

        String text = line.substring(begin, end);
        IRegion region1 = new Region(lineInfo.getOffset() + begin,
                text.length());
        return new IHyperlink[] { new SQLEditorHyperLink(region1, text,
                textViewer)};
    }
}