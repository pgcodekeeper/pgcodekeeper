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
 * An interface that provides methods for all parameters that google analytics
 * needs to know about.
 *
 * @author Andre Dietisheim
 * @see <a
 *      href="http://code.google.com/apis/analytics/docs/tracking/gaTrackingTroubleshooting.html#gifParameters">GIF
 *      Request Parameters</a>
 */
public interface IGoogleAnalyticsParameters {

	public static final char AMPERSAND = '&';
	public static final char EQUALS_SIGN = '=';
	public static final char URL_PARAM_DELIMITER = '?';
	public static final char PLUS_SIGN = '+';
	public static final char DOT = '.';
	public static final char SEMICOLON = ';';
	public static final char PIPE = '|';

	public static final String PARAM_PAGE_REQUEST = "utmp";
	public static final String PARAM_ACCOUNT_NAME = "utmac";
	public static final String PARAM_HOST_NAME = "utmhn";
	public static final String PARAM_EVENT_TRACKING = "utme";
	public static final String PARAM_COOKIES = "utmcc";
	public static final String PARAM_COOKIES_UNIQUE_VISITOR_ID = "__utma";
	public static final String PARAM_COOKIES_REFERRAL_TYPE = "__utmz";
	public static final String PARAM_COOKIES_UTMCSR = "utmcsr";
	public static final String PARAM_COOKIES_UTMCCN = "utmccn";
	public static final String PARAM_COOKIES_UTMCMD = "utmcmd";
	public static final String PARAM_COOKIES_KEYWORD = "utmctr";
	public static final String PARAM_COOKIES_USERDEFINED = "__utmv";

	public static final String PARAM_REFERRAL = "utmr";
	public static final String PARAM_TRACKING_CODE_VERSION = "utmwv";
	public static final String PARAM_UNIQUE_TRACKING_NUMBER = "utmn";
	public static final String PARAM_LANGUAGE_ENCODING = "utmcs";
	public static final String PARAM_SCREEN_RESOLUTION = "utmsr";
	public static final String PARAM_SCREEN_COLOR_DEPTH = "utmsc";
	public static final String PARAM_FLASH_VERSION = "utmfl";
	public static final String PARAM_BROWSER_LANGUAGE = "utmul";
	public static final String PARAM_PAGE_TITLE = "utmdt";
	public static final String PARAM_REQUEST_TYPE = "utmt";
	public static final String PARAM_GAQ = "gaq";

	public static final String VALUE_TRACKING_CODE_VERSION = "4.7.2";
	public static final String VALUE_NO_REFERRAL = "0";
	public static final String VALUE_ENCODING_UTF8 = "UTF-8";

	public static final String SCREERESOLUTION_DELIMITER = "x";
	public static final String SCREENCOLORDEPTH_POSTFIX = "-bit";

	public String getAccountName();

	public String getReferral();

	public String getScreenResolution();

	public String getScreenColorDepth();

	public String getBrowserLanguage();

	public String getHostname();

	public String getUserAgent();

	public String getUserId();

	public String getKeyword();

	public String getFirstVisit();

	public String getLastVisit();

	public String getCurrentVisit();

	public long getVisitCount();

	/**
	 * Starts a new visit session.
	 */
	public void startNewVisitSession();

	public String getFlashVersion();

	public String getJavaVmName();

	public String getJavaBitVersion();
}