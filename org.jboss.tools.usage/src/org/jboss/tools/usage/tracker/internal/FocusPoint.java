/*******************************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 ******************************************************************************/

package org.jboss.tools.usage.tracker.internal;

import org.jboss.tools.usage.tracker.IFocusPoint;
import org.jboss.tools.usage.util.HttpEncodingUtils;

/**
 * Represents a focus in the usage of a application. It can represent
 * application related events like startup, module load, user actions, error
 * events etc.
 * 
 * @author Andre Dietisheim
 * @author Siddique Hameed
 * @see based on <a
 *      href="http://jgoogleAnalytics.googlecode.com">http://jgoogleAnalytics
 *      .googlecode.com</a>
 */
public class FocusPoint implements IFocusPoint {

	private String name;
	private IFocusPoint childFocusPoint;
	public static final String URI_SEPARATOR = "/";
	public static final String TITLE_SEPARATOR = "-";

	public FocusPoint(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public IFocusPoint setChild(IFocusPoint childFocusPoint) {
		this.childFocusPoint = childFocusPoint;
		return this;
	}

	public IFocusPoint getChild() {
		return childFocusPoint;
	}

	public String getURI() {
		StringBuilder builder = new StringBuilder();
		appendContentURI(builder, this);
		return HttpEncodingUtils.checkedEncodeUtf8(builder.toString());
	}

	protected void appendContentURI(StringBuilder builder, IFocusPoint focusPoint) {
		IFocusPoint parentFocuPoint = focusPoint.getChild();
		appendToURI(focusPoint.getName(), builder);
		if (parentFocuPoint != null) {
			appendContentURI(builder, parentFocuPoint);
		}
	}

	protected void appendToURI(String toAppend, StringBuilder builder) {
		builder.append(URI_SEPARATOR);
		builder.append(toAppend);
	}

	protected void appendToTitle(String toAppend, StringBuilder builder) {
		builder.append(TITLE_SEPARATOR);
		builder.append(toAppend);
	}

	public String getTitle() {
		StringBuilder builder = new StringBuilder();
		appendContentTitle(builder, this);
		return HttpEncodingUtils.checkedEncodeUtf8(builder.toString());
	}

	protected void appendContentTitle(StringBuilder builder, IFocusPoint focusPoint) {
		IFocusPoint childFocusPoint = focusPoint.getChild();
		builder.append(focusPoint.getName());
		if (childFocusPoint != null) {
			builder.append(TITLE_SEPARATOR);
			appendContentTitle(builder, childFocusPoint);
		}
	}
}
