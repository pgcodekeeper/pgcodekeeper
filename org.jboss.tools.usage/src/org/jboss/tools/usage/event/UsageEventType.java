/*******************************************************************************
 * Copyright (c) 2014 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.usage.event;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.Version;

/**
 * Represents an event type
 *
 * @author Alexey Kazakov
 */
public class UsageEventType {

	private final String componentName;
	private final String componentVersion;
	private String categoryName;
	private final String actionName;
	private final String labelDescription;
	private final String valueDescription;

	public UsageEventType(Plugin plugin,
			String actionName) {
		this(plugin, null, actionName, null, null);
	}

	public UsageEventType(Plugin plugin,
			String actionName,
			String labelDescription) {
		this(plugin, null, actionName, labelDescription, null);
	}

	public UsageEventType(Plugin plugin,
			String actionName,
			String labelDescription,
			String valueDescription) {
		this(plugin, null, actionName, labelDescription, valueDescription);
	}

	/**
	 * @param plugin The fourth segment of the plugin's id is used as the component name. The major, minor and micro versions are used as the component version.
	 *               For example plugin "jboss.tools.jst.kb.ui" version 3.5.2.20140228 will result componentName="jst", componentVersion="3.5.2"
	 * @param categoryName If null, the component name is used as category name. All whitespaces will be replaced by "-".
	 * @param actionName Action name. All whitespaces will be replaced by "-".
	 * @param labelDescription
	 * @param valueDescription
	 */
	public UsageEventType(Plugin plugin,
			String categoryName,
			String actionName,
			String labelDescription,
			String valueDescription) {
		this(getComponentName(plugin), getVersion(plugin), categoryName, actionName, labelDescription, valueDescription);
	}

	/**
	 * @param componentName May not be null. All whitespaces will be replaced by "-".
	 * @param componentVersion May not be null
	 * @param categoryName If null, the component name is used as category name. All whitespaces will be replaced by "-".
	 * @param actionName May not be null. All whitespaces will be replaced by "-".
	 */
	public UsageEventType(String componentName,
			String componentVersion,
			String categoryName,
			String actionName) {
		this(componentName, componentVersion, categoryName, actionName, null, null);
	}

	/**
	 * @param componentName May not be null. All whitespaces will be replaced by "-".
	 * @param componentVersion May not be null
	 * @param categoryName If null, the component name is used as category name. All whitespaces will be replaced by "-".
	 * @param actionName May not be null. All whitespaces will be replaced by "-".
	 * @param labelDescription Optinal. May be null.
	 */
	public UsageEventType(String componentName,
			String componentVersion,
			String categoryName,
			String actionName,
			String labelDescription) {
		this(componentName, componentVersion, categoryName, actionName, labelDescription, null);
	}

	/**
	 * @param componentName May not be null. All whitespaces will be replaced by "-".
	 * @param componentVersion May not be null
	 * @param categoryName If null, the component name is used as category name. All whitespaces will be replaced by "-".
	 * @param actionName May not be null. All whitespaces will be replaced by "-".
	 * @param labelDescription Optinal. May be null.
	 * @param valueDescription Optinal. May be null.
	 */
	public UsageEventType(String componentName,
			String componentVersion,
			String categoryName,
			String actionName,
			String labelDescription,
			String valueDescription) {
		Assert.isLegal(componentName!=null, "Component name may not be null");
		Assert.isLegal(componentVersion!=null, "Component version may not be null"); //$NON-NLS-1$
		Assert.isLegal(actionName != null, "Action name may not be null"); //$NON-NLS-1$
		this.componentName = componentName.replaceAll("\\s", "-");;
		this.componentVersion = componentVersion;
		if(categoryName == null) {
			this.categoryName = this.componentName;
		} else {
			this.categoryName = categoryName.replaceAll("\\s", "-");
		}
		this.actionName = actionName.replaceAll("\\s", "-");;
		this.labelDescription = labelDescription;
		this.valueDescription = valueDescription;
	}

	/**
	 * Creates a new event with this event type
	 * @param label
	 * @param value
	 * @return
	 */
	public UsageEvent event(String label, int value) {
		return new UsageEvent(this, label, value);
	}

	/**
	 * Creates a new event with this event type
	 * @param label
	 * @return
	 */
	public UsageEvent event(String label) {
		return new UsageEvent(this, label);
	}

	/**
	 * Creates a new event with this event type
	 * @return
	 */
	public UsageEvent event() {
		return new UsageEvent(this);
	}

	public String getComponentName() {
		return componentName;
	}

	public String getComponentVersion() {
		return componentVersion;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getActionName() {
		return actionName;
	}

	public String getLabelDescription() {
		return labelDescription;
	}

	public String getValueDescription() {
		return valueDescription;
	}

	/**
	 * Returns a forth segment of the bundle ID. E.g. "org.jboss.tool.common" --> "common".
	 * Throws IllegalArgumentException if the ID is too short.
	 * @param plugin
	 * @return
	 */
	public static String getComponentName(Plugin plugin) {
		Assert.isLegal(plugin!=null, "Plugin may not be null");
		String id = plugin.getBundle().getSymbolicName();
		String[] segments = id.split("\\.");
		Assert.isLegal(segments.length>=4, "Plugin ID (\"" + id + "\") must have at least 4 segments. For example: \"org.jboss.tools.common\""); //$NON-NLS-1$
		return segments[3];
	}

	/**
	 * Returns a short version (X.Y.Z) of the bundle ID. E.g. "1.3.100.20140307" --> "1.3.100".
	 * @param plugin
	 * @return
	 */
	public static String getVersion(Plugin plugin) {
		Assert.isLegal(plugin!=null, "Plugin may not be null");
		Version version = plugin.getBundle().getVersion();
		return "" + version.getMajor() + "." + version.getMinor() + "." + version.getMicro();
	}

	@Override
	public int hashCode() {
		return (componentName + categoryName + actionName).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof UsageEventType) {
			UsageEventType type = (UsageEventType)obj;
			return getComponentName().equals(type.getComponentName()) && getCategoryName().equals(type.getCategoryName()) && getActionName().equals(type.getActionName());
		}
		return false;
	}

	@Override
	public String toString() {
		return "{Component=\"" + componentName + "\"; Category=\"" + categoryName + "\"; Action=\"" + actionName + "\"}";
	}
}