package ru.taximaxim.codekeeper.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class SQLSegmentEditor extends Composite{

    private StyledText st;

    public SQLSegmentEditor(Composite parent, int style, GridLayout layout) {
        super(parent, SWT.NONE);
        this.setLayout(layout);
        st = new StyledText(this, style);
        st.setLayoutData(new GridData(GridData.FILL_BOTH));
        st.addLineStyleListener(new SQLSegmentLineStyleListener(parent.getDisplay()));
    }
    
    public void setText(String text) {
        st.setText(text);
    }
}

class SQLSegmentLineStyleListener implements LineStyleListener {

    private final Color KEYWORD_COLOR;
    
    private List<String> keywords = new ArrayList<String>();

    public SQLSegmentLineStyleListener(Display display) {
        super();
        KEYWORD_COLOR = display.getSystemColor(SWT.COLOR_BLUE);
        keywords.add("select");
        keywords.add("from");
        keywords.add("where");
        keywords.add("create");
        keywords.add("inherits");
        keywords.add("table");
        keywords.add("set");
        keywords.add("to");
    }

    @Override
    public void lineGetStyle(LineStyleEvent event) {
        List<StyleRange> styles = new ArrayList<StyleRange>();
        int start = 0;
        int length = event.lineText.length();
        System.out.println("current line length:" + event.lineText.length());
        while (start < length) {
            System.out.println("while lopp");
            if (Character.isLetter(event.lineText.charAt(start))) {
                StringBuffer buf = new StringBuffer();
                int i = start;
                for (; i < length
                        && Character.isLetter(event.lineText.charAt(i)); i++) {
                    buf.append(event.lineText.charAt(i));
                }
                if (keywords.contains(buf.toString().toLowerCase())) {
                    styles.add(new StyleRange(event.lineOffset + start, i - start, KEYWORD_COLOR, null, SWT.BOLD));
                }
                start = i;
            }
            else{
                start ++;
            }
        }
        event.styles = (StyleRange[]) styles.toArray(new StyleRange[0]);
    }

}
