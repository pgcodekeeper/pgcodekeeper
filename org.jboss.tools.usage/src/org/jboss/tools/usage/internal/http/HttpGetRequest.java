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
package org.jboss.tools.usage.internal.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;

import org.jboss.tools.usage.localizations.Messages;
import org.jboss.tools.usage.tracker.internal.UsagePluginLogger;

/**
 * Class that executes a HTTP Get request to the given url.
 *
 * @author Andre Dietisheim
 */
public class HttpGetRequest {

	private static final String USER_AGENT = "User-Agent"; //$NON-NLS-1$

	private static final String GET_METHOD_NAME = "GET"; //$NON-NLS-1$

	private static final int TIMEOUT = 10000; // Connection timeout is 10 seconds.

	private UsagePluginLogger logger = null;

	private final String userAgent;

	public HttpGetRequest(String userAgent, UsagePluginLogger logger) {
		this.userAgent = userAgent;
		this.logger = logger;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.usage.IHttpGetRequest#request(java.lang.String)
	 */
	public boolean request(String urlString) {
		try {
			HttpURLConnection urlConnection = createURLConnection(urlString, userAgent);
			urlConnection.connect();
			int responseCode = urlConnection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				logger.debug(MessageFormat.format(Messages.HttpGetMethod_Success, urlString, responseCode));
				return true;
			} else {
				logger.error(MessageFormat.format(Messages.HttpGetMethod_Error_Http, urlString, responseCode));
			}
		} catch (Exception e) {
			logger.debug(MessageFormat.format(Messages.HttpGetMethod_Error_Io, urlString, e.toString()));
		}
		return false;
	}

	/**
	 * Creates a new url connection.
	 *
	 * @param urlString the url string
	 * @param userAgent the user agent
	 * @return the http url connection
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private HttpURLConnection createURLConnection(String urlString, String userAgent) throws IOException {
		HttpURLConnection urlConnection = (HttpURLConnection) new URL(urlString).openConnection();
		urlConnection.setInstanceFollowRedirects(true);
		urlConnection.setRequestMethod(GET_METHOD_NAME);
		urlConnection.setRequestProperty(USER_AGENT, userAgent);
		urlConnection.setConnectTimeout(TIMEOUT);
		return urlConnection;
	}
}
