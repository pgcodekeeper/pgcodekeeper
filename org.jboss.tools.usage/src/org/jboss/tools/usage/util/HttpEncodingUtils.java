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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Andre Dietisheim
 */
public class HttpEncodingUtils {

	private static final String ENCODING_UTF8 = "UTF-8";

	private static Pattern CHARSET_ENCODING_PATTERN = Pattern.compile("charset=(.+)");

	/**
	 * Encodes the given string in utf8 while catching exceptions that may
	 * occur. If an encoding exception occurs, <tt>null</tt> is returned
	 * 
	 * @param aString
	 *            the a string to be encoded
	 * @return the encoded string or <tt>null</tt> if an error occured while
	 *         encoding
	 */
	public static String checkedEncodeUtf8(String string) {
		try {
			return URLEncoder.encode(string, ENCODING_UTF8);
		} catch (UnsupportedEncodingException e) {
			return string;
		}
	}

	/**
	 * Returns the charset indicated in the content-type field of the http
	 * header. Returns <tt>null</tt> if none is indicated.
	 * 
	 * @param contentType
	 *            the content type
	 * @return the content type charset or <tt>null</tt>
	 */
	public static String getContentTypeCharset(String contentType) {
		Matcher matcher = CHARSET_ENCODING_PATTERN.matcher(contentType);
		if (!matcher.find()) {
			return null;
		}

		return matcher.group(1);
	}

}
