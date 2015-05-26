/*******************************************************************************
 * Copyright (c) 2010-2015 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.usage.internal.http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import org.jboss.tools.usage.tracker.internal.UsagePluginLogger;
import org.jboss.tools.usage.util.HttpEncodingUtils;


/**
 * Base class that holds a map that subclasses may get. The values in the map
 * are fetched and parsed from a document that is fetched on a url that the
 * subclass provides
 * 
 * @author Andre Dietisheim
 */
public class HttpRemotePropertiesProvider implements IPropertiesProvider {

	static final String GET_METHOD_NAME = "GET"; //$NON-NLS-1$

	private Map<Object, Object> valuesMap;
	private String url;
	private UsagePluginLogger logger;

	public HttpRemotePropertiesProvider(String url, UsagePluginLogger loggingAdapter) {
		this.url = url;
		this.logger = loggingAdapter;
	}

	/* (non-Javadoc)
	 * @see org.jboss.tools.usage.internal.http.IMapProvider#getValueMap()
	 */
	@Override
	public synchronized Map<Object, Object> getMap() throws IOException {
		if (valuesMap == null) {
			HttpURLConnection urlConnection = createURLConnection(url);
			InputStreamReader reader = request(urlConnection);
			if(reader != null) {
				try {
					Properties pr = new Properties();
					pr.load(reader);
					valuesMap = pr;
				} finally {
					reader.close();
				}
			}
			if(valuesMap == null) {
				valuesMap = Collections.emptyMap();
			}
		}
		return valuesMap;
	}

	/**
	 * Sends a http GET request to the given URL. Returns the response string or
	 * <tt>null</tt> if an error occurred. The errors catched are Exceptions or
	 * HTTP error codes.
	 * 
	 * @param url
	 *            the url to send the GET request to
	 * @return the response or <tt>null</tt> if an error occured.
	 * @throws UnsupportedEncodingException
	 * 
	 * @see HttpURLConnection
	 */
	protected InputStreamReader request(HttpURLConnection urlConnection) throws IOException {
		InputStreamReader responseReader = null;
		try {
			urlConnection.connect();
			int responseCode = getResponseCode(urlConnection);
			if (responseCode == HttpURLConnection.HTTP_OK) { // OK
				logger.debug(MessageFormat.format(HttpMessages.HttpResourceMap_Info_HttpQuery, url));
				responseReader = getInputStreamReader(urlConnection.getInputStream(), urlConnection.getContentType());
			} else if(responseCode >= 300 && responseCode < 400) { // Redirect
				// URLConnection does not redirect automatically if the protocols are different. HTTP -> HTTPS for example.
				// So we have to do it manually.
				// See https://issues.jboss.org/browse/JBDS-3159
				String redirectLocation = urlConnection.getHeaderField("location");
				if(redirectLocation!=null && !urlConnection.getURL().toString().equalsIgnoreCase(redirectLocation)) { // Ignore responses with empty redirect locations or with the same redirect URL
					urlConnection = createURLConnection(redirectLocation);
					return request(urlConnection);
				} else {
					logStatusCode(urlConnection);
				}
			} else {
				logStatusCode(urlConnection);
			}
			return responseReader;
		} catch (IOException e) {
			logger.debug(MessageFormat.format(HttpMessages.HttpGetMethod_Error_Io, url, e.toString()));
			return null;
		}
	}

	private void logStatusCode(HttpURLConnection urlConnection) throws IOException {
		String responseMessage = urlConnection.getResponseMessage();
		StringBuilder message = new StringBuilder(MessageFormat.format(HttpMessages.HttpGetMethod_Error_Http, url, urlConnection.getResponseCode()));
		if(responseMessage!=null) {
			message.append("; Response message: ").append(responseMessage);
		}
		logger.error(message.toString(), false);
	}

	private InputStreamReader getInputStreamReader(InputStream inputStream, String contentType)
			throws UnsupportedEncodingException, IOException {
		String contentTypeCharset = HttpEncodingUtils.getContentTypeCharset(contentType);
		if (contentTypeCharset != null && contentTypeCharset.length() > 0) {
			return new InputStreamReader(new BufferedInputStream(inputStream),
					contentTypeCharset);
		} else {
			return new InputStreamReader(new BufferedInputStream(inputStream));
		}
	}

	/**
	 * Creates a new url connection.
	 * 
	 * @param urlString
	 *            the url string
	 * @return the http url connection
	 * @throws IOException
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected HttpURLConnection createURLConnection(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setInstanceFollowRedirects(true);
		urlConnection.setRequestMethod(GET_METHOD_NAME);
		return urlConnection;
	}

	/**
	 * Returns the return code from the given {@link HttpURLConnection}.
	 * Provided to be called by test cases so that they can retrieve the return
	 * code.
	 * 
	 * @param urlConnection
	 *            to get the response code from
	 * @return the return code the HttpUrlConnection received
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected int getResponseCode(HttpURLConnection urlConnection) throws IOException {
		return urlConnection.getResponseCode();
	}
}