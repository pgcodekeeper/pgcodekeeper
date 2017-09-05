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

	/**
	 * @param componentName May not be null. All whitespaces will be replaced by "-".
	 * @param componentVersion May not be null
	 * @param categoryName If null, the component name is used as category name. All whitespaces will be replaced by "-".
	 * @param actionName May not be null. All whitespaces will be replaced by "-".
	 * @param labelDescription Optinal. May be null.
	 * @param valueDescription Optinal. May be null.
	 */
	public UsageEventType(String componentName, String componentVersion, String categoryName,
			String actionName, String labelDescription,	String valueDescription) {
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
		return new UsageEvent(this, label, null);
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

	@Override
	public int hashCode() {
		return (componentName + categoryName + actionName).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof UsageEventType) {
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