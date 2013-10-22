package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.preference.IPreferencePage;

/**
 * Instead of storing preference pages info in extension and reading it manually
 * from there - store it in a more convenient array of custom container objects.
 * 
 * @author Alexander Levsha
 */
public class FakePrefPageExtension {
	
	private final String id;
	
	private final String name;
	
	private final IPreferencePage page;
	
	private final String category;
	
	public FakePrefPageExtension(String id, String name, IPreferencePage page,
			String category) {
		this.id = id;
		this.name = name;
		this.page = page;
		this.category = category;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public IPreferencePage getPage() {
		return page;
	}
	
	public String getCat() {
		return category;
	}
}