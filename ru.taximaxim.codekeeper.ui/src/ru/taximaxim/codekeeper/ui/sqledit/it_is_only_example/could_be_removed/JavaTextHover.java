/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *
 * Portions of this file were contributed by Dan Breslau (dbreslau a t alumni dot uchicago dot edu)
 * These portions are released into the public domain. No rights reserved.
 * Use at your own risk.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.sqledit.it_is_only_example.could_be_removed;


import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.swt.graphics.Point;
//import org.eclipse.jface.text.DefaultInformationControl;

/**
 * Example implementation for an <code>ITextHover</code> which hovers over Java code.
 */
public class JavaTextHover implements ITextHover, ITextHoverExtension2  {

    /* (non-Javadoc)
     *
     */
    /**
     * Method declared and deprecated in ITextHover. (Since we need to implement
     * ITextHover, we need to implement this method.)
     * @param textViewer
     * @param hoverRegion
     * @return
     * @deprecated
     */
    @Deprecated
    @Override
    public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
        if (hoverRegion != null) {
            try {
                if (hoverRegion.getLength() > -1) {
                    return textViewer.getDocument().get(hoverRegion.getOffset(), hoverRegion.getLength());
                }
            } catch (BadLocationException x) {
            }
        }
        return JavaEditorMessages.getString("JavaTextHover.emptySelection"); //$NON-NLS-1$
    }

    @Override
    public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {

        // Start with the string returned by the older getHoverInfo()
        final String selection = getHoverInfo(textViewer, hoverRegion);

        // If text is selected in the editor window, it's returned as the
        // hover string. If no text is selected, then the returned hover is
        // a URL pointing to www.outofwhatbox.com/blog.
        return new JavaHoverInformationControl.IHTMLHoverInfo() {
            @Override
            public boolean isURL() {return selection.length() == 0;}
            @Override
            public String getHTMLString() {
                if (isURL()){
                    return "http://www.outofwhatbox.com/blog";             //$NON-NLS-1$
                }
                return selection;
            }
        };
    }


    /* (non-Javadoc)
     * Method declared on ITextHover
     */
    @Override
    public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
        Point selection= textViewer.getSelectedRange();
        if (selection.x <= offset && offset < selection.x + selection.y) {
            return new Region(selection.x, selection.y);
        }
        return new Region(offset, 0);
    }
}
