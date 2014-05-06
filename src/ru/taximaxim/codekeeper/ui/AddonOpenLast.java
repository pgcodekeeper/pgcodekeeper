 
package ru.taximaxim.codekeeper.ui;


public class AddonOpenLast {

    // FIXME cannot create parts on startup, luna probably bugged
    /*
    @Inject
    @Optional
    private void openLast(
            @EventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE)
            //@EventTopic(UIConsts.EVENT_WELCOME_ACTIVE)
            final MApplication app,
            
            final EModelService model,
            
            @Named(UIConsts.PREF_STORE) final IPreferenceStore mainPrefs,
            
            final EPartService partService,
            
            @Preference(value=UIConsts.PREF_OPEN_LAST_ON_START) String prefOpenLast,

            @Preference(value = UIConsts.PREF_RECENT_PROJECTS) String prefRecentProjects,
            
            UISynchronize sync) {
        
        if (prefOpenLast != null && prefOpenLast.equals("true")) {
            String[] recent = RecentProjects.getRecent(prefRecentProjects);
            if (recent == null) {
                return;
            }
            
            String last = recent[0];
            final PgDbProject proj = new PgDbProject(last);
            
            if (proj.getProjectFile().isFile()) {
                sync.syncExec(new Runnable() {
                    
                    @Override
                    public void run() {
                        LoadProj.load(proj, app.getContext(), partService, model, app,
                                mainPrefs);
                    }
                });
            } else {
                Log.log(Log.LOG_WARNING, "Couldn't open last project at "
                        + proj.getProjectFile()
                        + ". Project pref store either doesn't exist or not a file.");
            }
        }
    }
    */
}
