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
package org.jboss.tools.usage.util;

/**
 * @author André Dietisheim
 */
public class StringUtils {

	private static final String LINE_SEPARATOR_KEY = "line.separator";
	private static final int MAX_EVENT_LABEL_LENGTH = 120;

	public StringUtils() {
	}	

	public static String getLineSeparator() {
		return System.getProperty(LINE_SEPARATOR_KEY);
	}

	/**
	 * If the name is too long (more than 120 characters) then the name will be compressed and returned.
	 * For example for 
	 * "org.xxxxxxxxxxx.yyyyyyyyyyy.zzzzzzzzzzz.LoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooongClassName"
	 * this method will try to compress the name in a few steps:
	 * 1. "org.xxx~.yyy~.zzz~.LoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooongClassName" is still too long, then
	 * 2. "org.xx~.yy~.zz~.LoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooongClassName" is still too long, then
	 * 3. "o~.x~.y~.z~.LoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooongClassName" is still too long, then
	 * 4. "org.xxxxxxxxxxx.yyyyyyyyyyy.zzzzzzzzzzz.Looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo~ame" will be returned.
	 * 
	 * If the name is not longer than 120 then the original string will be returned. 
	 * @return
	 */
	public static String compressClassName(String className) {
		String regexStart = "(?<=\\w{";
		String regexEnd = "})\\w{2,}(?=\\.)";
		if(className.length()>MAX_EVENT_LABEL_LENGTH) {
			// Too long label. Let's make it short.
			for (int i = 3; i > 0; i--) {
				String comressedName = className.replaceAll(regexStart + i + regexEnd, "~");
				if(comressedName.length()<=MAX_EVENT_LABEL_LENGTH) {
					return comressedName;
				}
			}
			StringBuilder sb = new StringBuilder(className);
			sb.replace(MAX_EVENT_LABEL_LENGTH - 4, className.length() - 3, "~");
			return sb.toString();
		}
		return className;
	}
}