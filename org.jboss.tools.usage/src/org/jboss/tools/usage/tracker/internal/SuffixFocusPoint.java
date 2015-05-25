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
package org.jboss.tools.usage.tracker.internal;

import org.jboss.tools.usage.util.HttpEncodingUtils;

/**
 * A focus point that always reports the current jboss tools version as last
 * component.
 */
public class SuffixFocusPoint extends FocusPoint {

	private String suffix;

	public SuffixFocusPoint(String name, String suffix) {
		super(name);
		this.suffix = suffix;
	}

	@Override
	public String getURI() {
		StringBuilder builder = new StringBuilder();
		appendContentURI(builder, this);
		appendToURI(suffix, builder);
		return HttpEncodingUtils.checkedEncodeUtf8(builder.toString());
	}

	@Override
	public String getTitle() {
		StringBuilder builder = new StringBuilder();
		appendContentTitle(builder, this);
		appendToTitle(suffix, builder);
		return HttpEncodingUtils.checkedEncodeUtf8(builder.toString());
	}
}
