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

/**
 *  Represents a data which will be send to Google Analytics to track the user's event
 * @author Alexey Kazakov
 */
public class UsageEvent {

	private UsageEventType type;
	private String label;
	private Integer value;

	public UsageEvent(UsageEventType type) {
		this(type, null, null);
	}

	public UsageEvent(UsageEventType type, String label) {
		this(type, label, null);
	}

	public UsageEvent(UsageEventType type, String label, Integer value) {
		if(type == null) {
			throw new IllegalArgumentException("Type name may not be null"); //$NON-NLS-1$
		}
		this.type = type;
		if(type.getLabelDescription()==null && label!=null) {
			throw new IllegalArgumentException("The label of this event may not be null since its event type has a label description"); //$NON-NLS-1$
		}
		if(type.getValueDescription()==null && value!=null) {
			throw new IllegalArgumentException("The value of this event may not be null since its event type has a value description"); //$NON-NLS-1$
		}
		this.label = label;
		this.value = value;
	}

	/**
	 * @return the event type
	 */
	public UsageEventType getType() {
		return type;
	}

	/**
	 * @return the event label name. May be null.
	 */
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the event value. May be null.
	 */
	public Integer getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{Type=").append(type.toString()).append(label!=null?("; Label=\"" + label) + "\"":"").append(value!=null?("; Value=\"" + value + "\""):"").append("}");
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public UsageEvent clone() {
		return new UsageEvent(this.type, this.label, this.value);
	}
}