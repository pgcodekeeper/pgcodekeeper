package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.YesNoEditingSupport.Values;

public class IgnoredObjectPrefListEditor extends PrefListEditor<IgnoredObject> {

    enum BooleanChangeValues {
        REGULAR(1<<0),
        IGNORE_CONTENT(1<<1);
        
        private final int statusFlagValue;

        BooleanChangeValues(int statusFlagValue) {
            this.statusFlagValue = statusFlagValue;
        }

        public int getStatusFlagValue(){
            return statusFlagValue;
        }
    }
    
    public IgnoredObjectPrefListEditor(Composite parent, boolean doSorting) {
        super(parent, doSorting);
    }

    @Override
    protected IgnoredObject getObject(String name) {
        if (name.trim().isEmpty()) {
            return null;
        }
        return new IgnoredObject(name, false, false);
    }

    @Override
    protected void createViewer(Composite parent) {
        TableViewer viewer = new TableViewer(parent, SWT.H_SCROLL
                | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
        viewerObjs = viewer;
        viewer.setContentProvider(new ArrayContentProvider());
        
        addColumns();
        viewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        viewer.getTable().setLinesVisible(true);
        viewer.getTable().setHeaderVisible(true);
    }

    private void addColumns() {
        TableViewer tableViewer = (TableViewer) viewerObjs;
        TableViewerColumn name = new TableViewerColumn(tableViewer, 0);
        name.getColumn().setResizable(true);
        name.getColumn().setText(Messages.ignoredObjectPrefListEditor_name);
        name.getColumn().setResizable(true);
        name.getColumn().setMoveable(true);
        name.setLabelProvider(new ColumnLabelProvider() {
            
            @Override
            public String getText(Object element) {
                IgnoredObject obj = (IgnoredObject) element;
                return obj.getName();
            }
        });
        
        TableViewerColumn isRegular = new TableViewerColumn(tableViewer, SWT.CHECK, 1);
        isRegular.getColumn().setResizable(true);
        isRegular.getColumn().setText(Messages.ignoredObjectPrefListEditor_regular);
        isRegular.getColumn().setResizable(false);
        isRegular.getColumn().setMoveable(true);
        isRegular.setLabelProvider(new ColumnLabelProvider() {
            
            @Override
            public String getText(Object element) {
                IgnoredObject obj = (IgnoredObject) element;
                return obj.isRegular()? Values.YES.toString() : Values.NO.toString();
            }
        });
        isRegular.setEditingSupport(new YesNoEditingSupport(tableViewer, BooleanChangeValues.REGULAR));
        
        TableViewerColumn ignoreContents = new TableViewerColumn(tableViewer, SWT.CHECK, 2);
        ignoreContents.getColumn().setResizable(true);
        ignoreContents.getColumn().setText(Messages.ignoredObjectPrefListEditor_ignore_contents);
        ignoreContents.getColumn().setResizable(false);
        ignoreContents.getColumn().setMoveable(true);
        ignoreContents.setLabelProvider(new ColumnLabelProvider() {
            
            @Override
            public String getText(Object element) {
                IgnoredObject obj = (IgnoredObject) element;
                return obj.isIgnoreContent()? Values.YES.toString() : Values.NO.toString();
            }
        });
        ignoreContents.setEditingSupport(new YesNoEditingSupport(tableViewer, BooleanChangeValues.IGNORE_CONTENT));
        
        // name column will take half of the space
        int width = (int)(tableViewer.getTable().getSize().x * 0.5);
        // not less than 200
        name.getColumn().setWidth(Math.max(width, 200));
        
        PixelConverter pc = new PixelConverter(tableViewer.getControl());
        isRegular.getColumn().setWidth(pc.convertWidthInCharsToPixels(10));
        ignoreContents.getColumn().setWidth(pc.convertWidthInCharsToPixels(11));        
    }
}


