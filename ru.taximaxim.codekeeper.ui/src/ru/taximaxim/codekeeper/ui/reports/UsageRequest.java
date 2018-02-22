package ru.taximaxim.codekeeper.ui.reports;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Random;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;

/**
 * @see based on <a href="http://jgoogleAnalytics.googlecode.com">http://jgoogleAnalytics.googlecode.com</a>
 */
public class UsageRequest {

    private static final String GA_ACCOUNT = "UA-63353874-1"; //$NON-NLS-1$
    private static final String GA_HOSTNAME = "technology45.ru"; //$NON-NLS-1$

    private static final String TRACKING_URL = "http://www.google-analytics.com/__utm.gif"; //$NON-NLS-1$
    private static final String USER_AGENT = "User-Agent"; //$NON-NLS-1$
    private static final String GET_METHOD_NAME = "GET"; //$NON-NLS-1$
    private static final int TIMEOUT = 10000; // Connection timeout is 10 seconds.

    private static final String PARAM_PAGE_REQUEST = "utmp"; //$NON-NLS-1$
    private static final String PARAM_ACCOUNT_NAME = "utmac"; //$NON-NLS-1$
    private static final String PARAM_HOST_NAME = "utmhn"; //$NON-NLS-1$
    private static final String PARAM_EVENT_TRACKING = "utme"; //$NON-NLS-1$
    private static final String PARAM_COOKIES = "utmcc"; //$NON-NLS-1$
    private static final String PARAM_COOKIES_UNIQUE_VISITOR_ID = "__utma"; //$NON-NLS-1$
    private static final String PARAM_COOKIES_REFERRAL_TYPE = "__utmz"; //$NON-NLS-1$
    private static final String PARAM_COOKIES_UTMCSR = "utmcsr"; //$NON-NLS-1$
    private static final String PARAM_COOKIES_UTMCCN = "utmccn"; //$NON-NLS-1$
    private static final String PARAM_COOKIES_UTMCMD = "utmcmd"; //$NON-NLS-1$
    private static final String PARAM_COOKIES_KEYWORD = "utmctr"; //$NON-NLS-1$

    private static final String PARAM_REFERRAL = "utmr"; //$NON-NLS-1$
    private static final String PARAM_TRACKING_CODE_VERSION = "utmwv"; //$NON-NLS-1$
    private static final String PARAM_UNIQUE_TRACKING_NUMBER = "utmn"; //$NON-NLS-1$
    private static final String PARAM_LANGUAGE_ENCODING = "utmcs"; //$NON-NLS-1$
    private static final String PARAM_PAGE_TITLE = "utmdt"; //$NON-NLS-1$
    private static final String PARAM_GAQ = "gaq"; //$NON-NLS-1$

    private static final String VALUE_TRACKING_CODE_VERSION = "4.7.2"; //$NON-NLS-1$
    private static final String VALUE_NO_REFERRAL = "0"; //$NON-NLS-1$


    private final EclipseEnvironment environment = Activator.getDefault().getEclipseEnvironment();

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
    public synchronized boolean sendRequest(String pagePath,
            String title,
            UsageEvent event,
            boolean startNewVisitSession) {

        if (startNewVisitSession) {
            environment.startNewVisitSession();
        }
        StringBuilder builder = new StringBuilder(TRACKING_URL).append('?');
        appendParameter(PARAM_TRACKING_CODE_VERSION, VALUE_TRACKING_CODE_VERSION, builder);
        appendParameter(PARAM_UNIQUE_TRACKING_NUMBER, getRandomNumber(), builder);
        appendParameter(PARAM_HOST_NAME, GA_HOSTNAME, builder);
        appendParameter(PARAM_LANGUAGE_ENCODING, "UTF-8", builder); //$NON-NLS-1$

        if (title != null) {
            String encoded = PgDiffUtils.checkedEncodeUtf8(title);
            appendParameter(PARAM_PAGE_TITLE, encoded, builder);
        }
        if (event != null) {
            appendParameter(PARAM_EVENT_TRACKING, event, builder);
        }

        appendParameter(PARAM_REFERRAL, VALUE_NO_REFERRAL, builder);
        appendParameter(PARAM_PAGE_REQUEST, pagePath, builder);

        appendParameter(PARAM_ACCOUNT_NAME, GA_ACCOUNT, builder);
        appendParameter(PARAM_COOKIES, getCookies(environment), builder);
        appendParameter(PARAM_GAQ, "1", false, builder); //$NON-NLS-1$

        String url = builder.toString();

        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            urlConnection.setInstanceFollowRedirects(true);
            urlConnection.setRequestMethod(GET_METHOD_NAME);
            urlConnection.setRequestProperty(USER_AGENT, environment.getUserAgent());
            urlConnection.setConnectTimeout(TIMEOUT);
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Log.log(Log.LOG_DEBUG, MessageFormat.format(
                        "HTTP GET to url \"{0}\" successfull!", url, responseCode)); //$NON-NLS-1$
                return true;
            } else {
                Log.log(Log.LOG_ERROR, MessageFormat.format(
                        "HTTP GET to \"{0}\" failed, response code received \"{1}\"", url, responseCode)); //$NON-NLS-1$
            }
        } catch (Exception e) {
            Log.log(Log.LOG_DEBUG, MessageFormat.format(
                    "HTTP GET to \"{0}\" failed, exception occured: \"{1}\"", url, e.toString())); //$NON-NLS-1$
        }
        return false;

    }

    /**
     * @return the environment
     */
    public EclipseEnvironment getEnvironment() {
        return environment;
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
    private String getCookies(EclipseEnvironment environment) {
        StringBuilder builder = new StringBuilder();

        /**
         * unique visitor id cookie has to be unique per eclipse installation
         */
        builder.append(PARAM_COOKIES_UNIQUE_VISITOR_ID)
        .append("=999.").append(environment.getUserId()) //$NON-NLS-1$
        .append('.').append(environment.getFirstVisit())
        .append('.').append(environment.getLastVisit())
        .append('.').append(environment.getCurrentVisit())
        .append('.').append(environment.getVisitCount());

        builder.append(";+"); //$NON-NLS-1$

        builder.append(PARAM_COOKIES_REFERRAL_TYPE).append("=999.") //$NON-NLS-1$
        .append(environment.getFirstVisit()).append(".1.1."); //$NON-NLS-1$

        builder.append(PARAM_COOKIES_UTMCSR).append("=(direct)|"); //$NON-NLS-1$

        builder.append(PARAM_COOKIES_UTMCCN).append("=(direct)|"); //$NON-NLS-1$

        builder.append(PARAM_COOKIES_UTMCMD).append("=(none)|"); //$NON-NLS-1$

        builder.append(PARAM_COOKIES_KEYWORD)
        .append('=').append(environment.getKeyword());

        builder.append(";+"); //$NON-NLS-1$

        return PgDiffUtils.checkedEncodeUtf8(builder.toString());
    }

    private void appendParameter(String name, UsageEvent event, StringBuilder builder) {
        String eventString = null;
        String label = event.getLabel();
        if (label == null) {
            eventString = MessageFormat.format("5({0})", event.getType().getActionName()); //$NON-NLS-1$
        } else {
            eventString = MessageFormat.format("5({0}*{1})", event.getType().getActionName(), label); //$NON-NLS-1$
            if(event.getValue()!=null) {
                eventString = eventString + MessageFormat.format("({0})", event.getValue()); //$NON-NLS-1$
            }
        }
        String encoded = PgDiffUtils.checkedEncodeUtf8(eventString);
        appendParameter(name, encoded, true, builder);
    }

    private void appendParameter(String name, String value, StringBuilder builder) {
        appendParameter(name, value, true, builder);
    }

    private void appendParameter(String name, String value, boolean appendAmpersand, StringBuilder builder) {
        builder.append(name).append('=').append(value);
        if (appendAmpersand) {
            builder.append('&');
        }
    }

    private String getRandomNumber() {
        return Integer.toString(new Random().nextInt(Integer.MAX_VALUE));
    }
}