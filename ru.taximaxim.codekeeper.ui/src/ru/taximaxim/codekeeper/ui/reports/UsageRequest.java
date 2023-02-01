package ru.taximaxim.codekeeper.ui.reports;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;

import org.eclipse.core.runtime.Platform;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;

/**
 * @see based on <a href="https://github.com/siddii/jgoogleanalytics">https://github.com/siddii/jgoogleanalytics</a>
 */
public class UsageRequest {

    /** 12.01.2023 all key u can look here https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#cd_
    / and here https://www.thyngster.com/ga4-measurement-protocol-cheatsheet/
     */

    private static final String USER_AGENT = "User-Agent"; //$NON-NLS-1$
    private static final String GET_METHOD_NAME = "POST"; //$NON-NLS-1$
    private static final int TIMEOUT = 10000; // Connection timeout is 10 seconds.

    //required fields
    private static final String TRACKING_URL = "https://www.google-analytics.com/g/collect"; //$NON-NLS-1$
    private static final String PARAM_TRACKING_CODE_VERSION = "v"; // GA protocol version for GU=1, for GA4=2
    private static final String VALUE_TRACKING_CODE_VERSION = "2"; //$NON-NLS-1$
    private static final String PARAM_ACCOUNT_NAME = "tid"; // GA Tracking ID
    private static final String GA_ACCOUNT = "G-89BE28NHFV"; //$NON-NLS-1$ // id for test account
    private static final String CLIENT_ID = "cid"; // GA Client ID

    //fields with data
    private static final String PARAM_OS = "ep.OS";
    private static final String PARAM_OS_VERSION = "ep.OS_version";
    private static final String PARAM_ECLIPSE_VERSION = "ep.Ecplise_version";
    private static final String PARAM_ECLIPSE_BUILD = "ep.Eclipse_build";
    private static final String PARAM_KEEPER_VERSION = "ep.keeper_version";
    private static final String PARAM_JVM_NAME = "ep.JVM_name";
    private static final String PARAM_JAVA_VERSION = "ep.java_version"; // GA flash version

    private static final String PARAM_EVENT_NAME = "en"; //
    private static final String VALUE_EVENT_NAME = "page_view";

    //optional fields
    private static final String PARAM_EVENT_TRACKING = "utme"; //$NON-NLS-1$ //
    private static final String GA_HOSTNAME = "technology45.ru"; //$NON-NLS-1$
    private static final String PARAM_DOCUMENT_ENCODING = "de"; //$NON-NLS-1$
    private static final String PARAM_HOST_NAME = "dh"; // GA Document Host Name

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
        appendParameter(PARAM_ACCOUNT_NAME, GA_ACCOUNT, builder);
        appendParameter(CLIENT_ID, environment.getUserId(), builder);

        appendParameter(PARAM_HOST_NAME, GA_HOSTNAME, builder);
        appendParameter(PARAM_DOCUMENT_ENCODING, "UTF-8", builder); //$NON-NLS-1$
        if (event != null) {
            appendParameter(PARAM_EVENT_TRACKING, event, builder);
        }

        appendParameter(PARAM_JAVA_VERSION, environment.getJavaVersion(), builder);
        appendParameter(PARAM_JVM_NAME, environment.getJavaVmName().replaceAll(" ", "_"), builder);
        appendParameter(PARAM_KEEPER_VERSION, event.getType().getComponentVersion(), builder);
        appendParameter(PARAM_OS, Platform.getOS(), builder);
        appendParameter(PARAM_OS_VERSION, environment.getOSVersion(), builder);
        appendParameter(PARAM_ECLIPSE_BUILD, environment.getApplicationName(), builder);
        appendParameter(PARAM_ECLIPSE_VERSION, environment.getApplicationVersion(), builder);

        appendParameter(PARAM_EVENT_NAME, VALUE_EVENT_NAME, false, builder);

        String url = builder.toString();

        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            urlConnection.setInstanceFollowRedirects(true);
            urlConnection.setFixedLengthStreamingMode(0);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod(GET_METHOD_NAME);
            urlConnection.setRequestProperty(USER_AGENT, environment.getUserAgent());
            urlConnection.setConnectTimeout(TIMEOUT);
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
                Log.log(Log.LOG_DEBUG, MessageFormat.format(
                        "HTTP POST to url \"{0}\" successfull!", url)); //$NON-NLS-1$
                return true;
            } else {
                Log.log(Log.LOG_ERROR, MessageFormat.format(
                        "HTTP POST to \"{0}\" failed, response code received \"{1}\"", url, responseCode)); //$NON-NLS-1$
            }
        } catch (Exception e) {
            Log.log(Log.LOG_DEBUG, MessageFormat.format(
                    "HTTP POST to \"{0}\" failed, exception occured: \"{1}\"", url, e)); //$NON-NLS-1$
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