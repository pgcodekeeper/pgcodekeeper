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
package org.jboss.tools.usage.googleanalytics;

/**
 * @author Alexey Kazakov
 */
public enum RequestType {
	EVENT("event"),
	PAGE("page");

	String type;

	private RequestType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}
}