package ru.taximaxim.codekeeper.ui.reports;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;

/**
 * @see based on <a href="https://github.com/siddii/jgoogleanalytics">https://github.com/siddii/jgoogleanalytics</a>
 */
public class UsageRequest {

    private static final String GA_ACCOUNT = "G-B1L6VLS9K5"; //$NON-NLS-1$
    private static final String GA_HOSTNAME = "technology45.ru"; //$NON-NLS-1$

    private static final String TRACKING_URL = "https://www.google-analytics.com/g/collect"; //$NON-NLS-1$
    private static final String USER_AGENT = "User-Agent"; //$NON-NLS-1$
    private static final String GET_METHOD_NAME = "POST"; //$NON-NLS-1$
    private static final int TIMEOUT = 10000; // Connection timeout is 10 seconds.

    private static final String PARAM_ACCOUNT_NAME = "tid"; //$NON-NLS-1$
    private static final String PARAM_HOST_NAME = "dh"; //$NON-NLS-1$
    private static final String CLIENT_ID = "cid";

    private static final String PARAM_CAMPAING_SOURSE = "cs"; //$NON-NLS-1$
    private static final String PARAM_CAMPAING_NAME = "cn"; //$NON-NLS-1$
    private static final String PARAM_CAMPAING_MEDIUM = "cm"; //$NON-NLS-1$


    private static final String PARAM_TRACKING_CODE_VERSION = "v"; //$NON-NLS-1$
    private static final String PARAM_DOCUMENT_ENCODING = "de"; //$NON-NLS-1$
    private static final String PARAM_JAVA_VERSION = "fl"; //$NON-NLS-1$

    private static final String VALUE_TRACKING_CODE_VERSION = "2"; //$NON-NLS-1$
    private static final String PARAM_EXTERNAL_EVENT = "ee";

    // The constants which maybe will be deleted
    private static final String PARAM_PAGE_TITLE = "utmdt"; //$NON-NLS-1$ //
    private static final String PARAM_EVENT_TRACKING = "utme"; //$NON-NLS-1$ //


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
        appendParameter(PARAM_HOST_NAME, GA_HOSTNAME, builder);
        appendParameter(PARAM_DOCUMENT_ENCODING, "UTF-8", builder); //$NON-NLS-1$

        if (title != null) {
            String encoded = PgDiffUtils.checkedEncodeUtf8(title);
            appendParameter(PARAM_PAGE_TITLE, encoded, builder);
        }
        appendParameter(PARAM_JAVA_VERSION, environment.getJavaVersion(), builder);
        if (event != null) {
            appendParameter(PARAM_EVENT_TRACKING, event, builder);
        }


        appendParameter(PARAM_ACCOUNT_NAME, GA_ACCOUNT, builder);
        appendParameter(CLIENT_ID, environment.getUserId() + environment.getFirstVisit(), builder);
        appendParameter(PARAM_CAMPAING_SOURSE, "=(direct)|", builder);
        appendParameter(PARAM_CAMPAING_NAME, "=(direct)|", builder);
        appendParameter(PARAM_CAMPAING_MEDIUM, "=(none)|", builder);
        appendParameter(PARAM_EXTERNAL_EVENT, "1", false, builder); //$NON-NLS-1$

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
                        "HTTP GET to url \"{0}\" successfull!", url)); //$NON-NLS-1$
                return true;
            } else {
                Log.log(Log.LOG_ERROR, MessageFormat.format(
                        "HTTP GET to \"{0}\" failed, response code received \"{1}\"", url, responseCode)); //$NON-NLS-1$
            }
        } catch (Exception e) {
            Log.log(Log.LOG_DEBUG, MessageFormat.format(
                    "HTTP GET to \"{0}\" failed, exception occured: \"{1}\"", url, e)); //$NON-NLS-1$
        }
        return false;

    }

    /**
     * @return the environment
     */
    public EclipseEnvironment getEnvironment() {
        return environment;
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
}