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
package org.jboss.tools.usage.internal.reporting;

import java.text.MessageFormat;

import org.jboss.tools.usage.event.UsageEvent;
import org.jboss.tools.usage.googleanalytics.GoogleAnalyticsCookie;
import org.jboss.tools.usage.googleanalytics.IGoogleAnalyticsParameters;
import org.jboss.tools.usage.googleanalytics.IJBossToolsEclipseEnvironment;
import org.jboss.tools.usage.googleanalytics.RequestType;
import org.jboss.tools.usage.internal.JBossToolsUsageActivator;
import org.jboss.tools.usage.internal.http.HttpGetRequest;
import org.jboss.tools.usage.tracker.internal.UsagePluginLogger;
import org.jboss.tools.usage.util.HttpEncodingUtils;

/**
 * @author Andre Dietisheim
 * @author Siddique Hameed
 * @author Alexey Kazakov
 *
 * @see based on <a href="http://jgoogleAnalytics.googlecode.com">http://jgoogleAnalytics.googlecode.com</a>
 */
public class UsageRequest {

	private static final String TRACKING_URL = "http://www.google-analytics.com/__utm.gif";
	private final UsagePluginLogger logger = new UsagePluginLogger(JBossToolsUsageActivator.getDefault());
	protected IJBossToolsEclipseEnvironment environment;

	public UsageRequest(IJBossToolsEclipseEnvironment environment) {
		this.environment = environment;
	}

	/**
	 * Sends a tracking request
	 * @param environment
	 * @param pagePath
	 * @param title can be null
	 * @param event can be null
	 * @param type if null, RequestType.PAGE is used
	 * @param startNewVisitSession if false, the current session from environment is used
	 * @return true if the request was sent successfully
	 */
	synchronized public boolean sendRequest(String pagePath,
			String title,
			UsageEvent event,
			RequestType type,
			boolean startNewVisitSession) {
		String url = createUrl(environment, pagePath, title, event, type, startNewVisitSession);
		return sendRequest(environment, url);
	}

	/**
	 * @return the environment
	 */
	public IJBossToolsEclipseEnvironment getEnvironment() {
		return environment;
	}

	private String createUrl(IJBossToolsEclipseEnvironment environment,
			String pagePath,
			String title,
			UsageEvent event,
			RequestType type,
			boolean startNewVisitSession) {

		if(startNewVisitSession) {
			environment.startNewVisitSession();
		}
		StringBuilder builder = new StringBuilder(TRACKING_URL).append(IGoogleAnalyticsParameters.URL_PARAM_DELIMITER);
		appendParameter(IGoogleAnalyticsParameters.PARAM_TRACKING_CODE_VERSION,	IGoogleAnalyticsParameters.VALUE_TRACKING_CODE_VERSION, builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_UNIQUE_TRACKING_NUMBER, getRandomNumber(), builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_HOST_NAME, environment.getHostname(), builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_LANGUAGE_ENCODING,	IGoogleAnalyticsParameters.VALUE_ENCODING_UTF8, builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_SCREEN_RESOLUTION, environment.getScreenResolution(), builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_SCREEN_COLOR_DEPTH, environment.getScreenColorDepth(), builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_BROWSER_LANGUAGE, environment.getBrowserLanguage(), builder);
		if(title!=null) {
			String encoded = HttpEncodingUtils.checkedEncodeUtf8(title);
			appendParameter(IGoogleAnalyticsParameters.PARAM_PAGE_TITLE, encoded, builder);
		}
		appendParameter(IGoogleAnalyticsParameters.PARAM_FLASH_VERSION, environment.getFlashVersion(), builder);
		if(event!=null) {
			appendParameter(IGoogleAnalyticsParameters.PARAM_EVENT_TRACKING, event, builder);
			if(type!=null && type!=RequestType.PAGE) {
				appendParameter(IGoogleAnalyticsParameters.PARAM_REQUEST_TYPE, type.toString(), builder);
			}
		}

		appendParameter(IGoogleAnalyticsParameters.PARAM_REFERRAL, environment.getReferral(), builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_PAGE_REQUEST, pagePath, builder);

		appendParameter(IGoogleAnalyticsParameters.PARAM_ACCOUNT_NAME, environment.getAccountName(), builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_COOKIES, getCookies(environment), builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_GAQ, "1", false, builder);

		return builder.toString();
	}

	private boolean sendRequest(IJBossToolsEclipseEnvironment environment, String url) {
		HttpGetRequest request = new HttpGetRequest(environment.getUserAgent(), logger);
		return request.request(url);
	}

	/**
	 * Returns the google analytics cookies. These cookies determines user
	 * identity, session identity etc.
	 *
	 * @return the cookies
	 *
	 * @see <a
	 *      href="http://www.analyticsexperts.com/google-analytics/information-about-the-utmlinker-and-the-__utma-__utmb-and-__utmc-cookies/">Information
	 *      about the utmLinker and the __utma, __utmb and __utmc cookies</a>
	 * @see <a
	 *      href="http://www.martynj.com/google-analytics-cookies-tracking-multiple-domains-filters">cookie
	 *      values and formats</a>
	 */
	private String getCookies(IJBossToolsEclipseEnvironment environment) {
		StringBuilder builder = new StringBuilder();

		/**
		 * unique visitor id cookie has to be unique per eclipse installation
		 */
		new GoogleAnalyticsCookie(IGoogleAnalyticsParameters.PARAM_COOKIES_UNIQUE_VISITOR_ID,
				new StringBuilder().append("999.")
				.append(environment.getUserId()).append(IGoogleAnalyticsParameters.DOT)
				.append(environment.getFirstVisit()).append(IGoogleAnalyticsParameters.DOT)
				.append(environment.getLastVisit()).append(IGoogleAnalyticsParameters.DOT)
				.append(environment.getCurrentVisit()).append(IGoogleAnalyticsParameters.DOT)
				.append(environment.getVisitCount()))
		.appendTo(builder);

		builder.append(IGoogleAnalyticsParameters.SEMICOLON)
		.append(IGoogleAnalyticsParameters.PLUS_SIGN);

		new GoogleAnalyticsCookie(IGoogleAnalyticsParameters.PARAM_COOKIES_REFERRAL_TYPE,
				new StringBuilder()
				.append("999.")
				.append(environment.getFirstVisit())
				.append(IGoogleAnalyticsParameters.DOT)
				.append("1.1."))
		.appendTo(builder);

		new GoogleAnalyticsCookie(IGoogleAnalyticsParameters.PARAM_COOKIES_UTMCSR,
				"(direct)",
				IGoogleAnalyticsParameters.PIPE)
		.appendTo(builder);

		new GoogleAnalyticsCookie(IGoogleAnalyticsParameters.PARAM_COOKIES_UTMCCN,
				"(direct)",
				IGoogleAnalyticsParameters.PIPE)
		.appendTo(builder);

		new GoogleAnalyticsCookie(IGoogleAnalyticsParameters.PARAM_COOKIES_UTMCMD,
				"(none)",
				IGoogleAnalyticsParameters.PIPE)
		.appendTo(builder);

		new GoogleAnalyticsCookie(IGoogleAnalyticsParameters.PARAM_COOKIES_KEYWORD,
				environment.getKeyword())
		.appendTo(builder);

		builder.append(IGoogleAnalyticsParameters.SEMICOLON)
		.append(IGoogleAnalyticsParameters.PLUS_SIGN);

		if(environment.isLinuxDistro()) {
			/**
			 * <tt>User defined Value<tt> cookie format: (domain hash).(setvar value)
			 *
			 * @see <a href="http://www.martynj.com/google-analytics-cookies-tracking-multiple-domains-filters">__utmv, __utmb, __utmc cookies formats and more</a>
			 */
			new GoogleAnalyticsCookie(IGoogleAnalyticsParameters.PARAM_COOKIES_USERDEFINED,
					getRandomNumber()
					+ IGoogleAnalyticsParameters.DOT
					+ environment.getUserDefined(),
					IGoogleAnalyticsParameters.SEMICOLON)
			.appendTo(builder);
		}

		return HttpEncodingUtils.checkedEncodeUtf8(builder.toString());
	}

	private void appendParameter(String name, UsageEvent event, StringBuilder builder) {
		//5(object*action*label)(value)
		String eventString = null;
		String label = event.getLabel();
		if(label==null) {
			eventString = MessageFormat.format("5({0}*{1})", event.getType().getCategoryName(), event.getType().getActionName());
		} else {
			eventString = MessageFormat.format("5({0}*{1}*{2})", event.getType().getCategoryName(), event.getType().getActionName(), label);
			if(event.getValue()!=null) {
				eventString = eventString + MessageFormat.format("({0})", event.getValue());
			}
		}
		String encoded = HttpEncodingUtils.checkedEncodeUtf8(eventString);
		appendParameter(name, encoded, true, builder);
	}

	private void appendParameter(String name, String value, StringBuilder builder) {
		appendParameter(name, value, true, builder);
	}

	private void appendParameter(String name, String value, boolean appendAmpersand, StringBuilder builder) {
		builder.append(name).append(IGoogleAnalyticsParameters.EQUALS_SIGN).append(value);
		if (appendAmpersand) {
			builder.append(IGoogleAnalyticsParameters.AMPERSAND);
		}
	}

	private String getRandomNumber() {
		return Integer.toString((int) (Math.random() * 0x7fffffff));
	}
}