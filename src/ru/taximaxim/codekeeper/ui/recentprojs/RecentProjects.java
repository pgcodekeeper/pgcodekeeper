package ru.taximaxim.codekeeper.ui.recentprojs;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;

import ru.taximaxim.codekeeper.ui.UIConsts;

public class RecentProjects {
    
    public static String [] getRecent(String prefRecent){
        if (prefRecent == null || prefRecent.isEmpty()){
            return null;
        }
        return prefRecent.split(Pattern.quote("*"));
    }
    
    public static void addRecent(String recent, IPreferenceStore prefStore){
        LinkedList<String> l = getList(prefStore.getString(UIConsts.PREF_RECENT_PROJECTS));
        if (!l.contains(recent)){
            l.addFirst(recent);
        }
        while (l.size() > 10){
            l.removeLast();
        }
        writePref(l, prefStore);
    }

    public static void deleteRecent(String recent, IPreferenceStore prefStore) {
        LinkedList<String> l = getList(prefStore.getString(UIConsts.PREF_RECENT_PROJECTS));
        l.remove(recent);
        writePref(l, prefStore);
    }
    
    private static LinkedList <String> getList(String prefRecent){
        return new LinkedList<String>(Arrays.asList(prefRecent.split(Pattern.quote("*"))));
    }
    
    private static void writePref(LinkedList<String> prefRecent, IPreferenceStore prefStore){
        StringBuilder sb = new StringBuilder();
        Iterator<String> iter = prefRecent.iterator();
        while (iter.hasNext()){
            sb.append(iter.next());
            if (iter.hasNext()){
                sb.append("*");
            }
        }
        prefStore.setValue(UIConsts.PREF_RECENT_PROJECTS, sb.toString());
        if(prefStore.needsSaving() && prefStore instanceof IPersistentPreferenceStore) {
            try {
                ((IPersistentPreferenceStore) prefStore).save();
            } catch (IOException ex) {
                throw new IllegalStateException(
                        "Unexpected error while saving preferences!", ex);
            }
        }
    }
}
