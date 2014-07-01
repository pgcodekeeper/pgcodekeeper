package ru.taximaxim.codekeeper.ui.differ;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.ui.differ.messages"; //$NON-NLS-1$
    public static String DbSource_db_is_not_loaded_yet_object_is_null;
    public static String DbSource_executing_pg_dump;
    public static String DbSource_filter_on;
    public static String DbSource_loading_db_from;
    public static String DbSource_loading_dump;
    public static String DbSource_loading_tree;
    public static String DbSource_repository_rev_checkout;
    public static String DbSource_unknown_db;
    public static String DbSource_unknown_host;
    public static String Differ_calculating_diff;
    public static String Differ_diff_from;
    public static String Differ_diff_is_undefined;
    public static String Differ_direct_diff;
    public static String Differ_reverse_diff;
    public static String Differ_runnable_has_not_finished;
    public static String Differ_to;
    public static String DiffTableViewer_change_type;
    public static String DiffTableViewer_container;
    public static String DiffTableViewer_filtering_diff_tree_based_on_gui_selection;
    public static String DiffTableViewer_object_name;
    public static String DiffTableViewer_object_type;
    public static String DiffTableViewer_objects;
    public static String DiffTableViewer_select_all;
    public static String DiffTableViewer_select_none;
    public static String DiffTableViewer_tried_to_add_equal_elements_to_checkedset;
    public static String DiffTreeViewer_collapse_all;
    public static String DiffTreeViewer_collapse_subtree;
    public static String DiffTreeViewer_debug_view;
    public static String DiffTreeViewer_deselect_subtree;
    public static String DiffTreeViewer_expand_all;
    public static String DiffTreeViewer_expand_subtree;
    public static String DiffTreeViewer_select_all;
    public static String DiffTreeViewer_select_none;
    public static String DiffTreeViewer_select_subtree;
    public static String TreeDiffer_building_diff_tree;
    public static String TreeDiffer_calculating_diff;
    public static String TreeDiffer_diff_is_undefined;
    public static String TreeDiffer_runnable_has_not_yet_finished;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
