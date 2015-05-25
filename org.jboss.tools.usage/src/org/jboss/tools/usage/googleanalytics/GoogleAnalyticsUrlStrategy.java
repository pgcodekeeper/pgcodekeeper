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

package org.jboss.tools.usage.googleanalytics;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

import org.jboss.tools.usage.googleanalytics.AbstractGoogleAnalyticsParameters.GoogleAnalyticsEvent;
import org.jboss.tools.usage.tracker.IFocusPoint;
import org.jboss.tools.usage.tracker.IURLBuildingStrategy;
import org.jboss.tools.usage.util.HttpEncodingUtils;

/**
 * Class that builds an URL that passes given parameters to google analytics
 * 
 * example:
 * <p>
 * <code>
 *  http://www.google-analytics.com/__utm.gif?
 *  utmwv=5.2.4
 *  &utms=10
 *  &utmn=583355747
 *  &utmhn=devstudio.jboss.com
 *  &utmcs=UTF-8
 *  &utmsr=2560x1440
 *  &utmvp=1265x393
 *  &utmsc=24-bit
 *  &utmul=en-us
 *  &utmje=1
 *  &utmfl=10.1 r102
 *  &utmdt=JBoss Developer Studio - Early Access
 *  &utmhid=1589877876
 *  &utmr=-
 *  &utmp=/earlyaccess/
 *  &utmac=UA-xxxxxx-x
 *  &utmcc=
 *  	__utma=136910373.1786599479.1328002257.1328002257.1328216095.2;
 *  	+__utmz=136910373.1328002257.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none);
 *  	+__utmv=136910373.wonka;
 *  &utmu=rAAQ~
 *  </code>
 * 
 * @author Andre Dietisheim
 * @author Siddique Hameed
 * 
 * @see based on <a
 *      href="http://jgoogleAnalytics.googlecode.com">http://jgoogleAnalytics
 *      .googlecode.com</a>
 * 
 * @see <a
 *      href="http://code.google.com/apis/analytics/docs/tracking/gaTrackingTroubleshooting.html#gifParameters">GIF
 *      Request Parameters</a>
 * @see <a
 *      href="http://code.google.com/apis/analytics/docs/concepts/gaConceptsCookies.html#cookiesSet">Cookies
 *      Set By Google Analytics</a>
 * 
 * @see <a
 *      href="http://www.morevisibility.com/analyticsblog/from-__utma-to-__utmz-google-analytics-cookies.html">From
 *      __utma to __utmz (Google Analytics Cookies)</a>
 */
public class GoogleAnalyticsUrlStrategy implements IURLBuildingStrategy {

	private static final String TRACKING_URL = "http://www.google-analytics.com/__utm.gif";
	private IGoogleAnalyticsParameters googleParameters;

	public GoogleAnalyticsUrlStrategy(IGoogleAnalyticsParameters googleAnalyticsParameters) {
		this.googleParameters = googleAnalyticsParameters;
	}

	public String build(IFocusPoint focusPoint) throws UnsupportedEncodingException {

		StringBuilder builder = new StringBuilder(TRACKING_URL)
				.append(IGoogleAnalyticsParameters.URL_PARAM_DELIMITER);
		appendParameter(IGoogleAnalyticsParameters.PARAM_TRACKING_CODE_VERSION,
				IGoogleAnalyticsParameters.VALUE_TRACKING_CODE_VERSION, builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_UNIQUE_TRACKING_NUMBER, getRandomNumber(), builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_HOST_NAME, googleParameters.getHostname(), builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_LANGUAGE_ENCODING,
				IGoogleAnalyticsParameters.VALUE_ENCODING_UTF8, builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_SCREEN_RESOLUTION, googleParameters.getScreenResolution(),
				builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_SCREEN_COLOR_DEPTH, googleParameters.getScreenColorDepth(),
				builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_BROWSER_LANGUAGE, googleParameters.getBrowserLanguage(),
				builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_PAGE_TITLE, focusPoint.getTitle(), builder);
		// appendParameter(IGoogleAnalyticsParameters.PARAM_HID,
		// getRandomNumber(), builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_FLASH_VERSION, googleParameters.getFlashVersion(), builder);
		/**
		 * TODO: support multiple events. Obviously these would just get appended to the very same string
		 */
		appendParameter(IGoogleAnalyticsParameters.PARAM_EVENT_TRACKING, googleParameters.getEvent(), builder);
		
		appendParameter(IGoogleAnalyticsParameters.PARAM_REFERRAL, googleParameters.getReferral(), builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_PAGE_REQUEST, focusPoint.getURI(), builder);

		appendParameter(IGoogleAnalyticsParameters.PARAM_ACCOUNT_NAME, googleParameters.getAccountName(), builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_COOKIES, getCookies(), builder);
		appendParameter(IGoogleAnalyticsParameters.PARAM_GAQ, "1", false, builder);

		googleParameters.visit(); // update visit timestamps and count

		return builder.toString();
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
	private String getCookies() {
		StringBuilder builder = new StringBuilder();

		/**
		 * unique visitor id cookie has to be unique per eclipse installation
		 */
		// String timeStamp = "-1";
		// //String.valueOf(System.currentTimeMillis());
		new GoogleAnalyticsCookie(IGoogleAnalyticsParameters.PARAM_COOKIES_UNIQUE_VISITOR_ID,
				new StringBuilder().append("999.")
						.append(googleParameters.getUserId()).append(IGoogleAnalyticsParameters.DOT)
						.append(googleParameters.getFirstVisit()).append(IGoogleAnalyticsParameters.DOT)
						.append(googleParameters.getLastVisit()).append(IGoogleAnalyticsParameters.DOT)
						.append(googleParameters.getCurrentVisit()).append(IGoogleAnalyticsParameters.DOT)
						.append(googleParameters.getVisitCount()))
				.appendTo(builder);

		builder.append(IGoogleAnalyticsParameters.SEMICOLON)
				.append(IGoogleAnalyticsParameters.PLUS_SIGN);

		new GoogleAnalyticsCookie(IGoogleAnalyticsParameters.PARAM_COOKIES_REFERRAL_TYPE,
						new StringBuilder()
								.append("999.")
								.append(googleParameters.getFirstVisit())
								.append(IGoogleAnalyticsParameters.DOT)
								.append("1.1."))
				.appendTo(builder);

		// new
		// GoogleAnalyticsCookie(IGoogleAnalyticsParameters.PARAM_COOKIES_SESSION,
		// new StringBuilder()
		// .append("1"),
		// IGoogleAnalyticsParameters.SEMICOLON
		// , IGoogleAnalyticsParameters.PLUS_SIGN)
		// .appendTo(builder);
		//
		// new
		// GoogleAnalyticsCookie(IGoogleAnalyticsParameters.PARAM_COOKIES_BROWSERSESSION,
		// new StringBuilder()
		// .append("1"),
		// IGoogleAnalyticsParameters.SEMICOLON
		// , IGoogleAnalyticsParameters.PLUS_SIGN)
		// .appendTo(builder);

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
				googleParameters.getKeyword())
				.appendTo(builder);

		builder.append(IGoogleAnalyticsParameters.SEMICOLON)
				.append(IGoogleAnalyticsParameters.PLUS_SIGN);

		/**
		 * <tt>User defined Value<tt> cookie format: (domain hash).(setvar value)
		 * 
		 * @see <a
		 *      href="http://www.martynj.com/google-analytics-cookies-tracking-multiple-domains-filters">__utmv,
		 *      __utmb, __utmc cookies formats and more</a>
		 */
		new GoogleAnalyticsCookie(IGoogleAnalyticsParameters.PARAM_COOKIES_USERDEFINED,
				getRandomNumber()
						+ IGoogleAnalyticsParameters.DOT
						+ googleParameters.getUserDefined(),
				IGoogleAnalyticsParameters.SEMICOLON)
				.appendTo(builder);

		return HttpEncodingUtils.checkedEncodeUtf8(builder.toString());
	}

	private String getRandomNumber() {
		return Integer.toString((int) (Math.random() * 0x7fffffff));
	}

	private void appendParameter(String name, GoogleAnalyticsEvent event, StringBuilder builder) {
		appendParameter(name, 
				MessageFormat.format("5({0}*{1}*{2})", event.getName(), event.getLabel(), event.getValue()), 
				true, 
				builder);
	}

	private void appendParameter(String name, String value, StringBuilder builder) {
		appendParameter(name, value, true, builder);
	}

	private void appendParameter(String name, String value, boolean appendAmpersand, StringBuilder builder) {
		builder.append(name)
				.append(IGoogleAnalyticsParameters.EQUALS_SIGN)
				.append(value);
		if (appendAmpersand) {
			builder.append(IGoogleAnalyticsParameters.AMPERSAND);
		}
	}
}
