/*******************************************************************************
 * Copyright (c) 2010 Red Hat, Inc.
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
 * @author Andre Dietisheim
 */
public class GoogleAnalyticsCookie {

	private CharSequence value;
	private String identifier;
	private char[] delimiters;

	public GoogleAnalyticsCookie(String identifier, CharSequence value, char... delimiters) {
		this.identifier = identifier;
		this.value = value;
		this.delimiters = delimiters;
	}

	public GoogleAnalyticsCookie(String identifier, CharSequence value) {
		this(identifier, value, new char[0]);
	}

	/**
	 * Appends the identifier and the value of this cookie to the given
	 * <code>StringBuilder</code>. If no value is present <code>null</code>,
	 * nothing is appended.
	 * 
	 * @param builder
	 *            the builder
	 */
	public void appendTo(StringBuilder builder) {
		if (identifier != null && identifier.length() > 0 && value != null && value.length() > 0) {
			builder.append(identifier)
					.append(IGoogleAnalyticsParameters.EQUALS_SIGN)
					.append(value);
			for (char delimiter : delimiters) {
				builder.append(delimiter);
			}
		}
	}
}
