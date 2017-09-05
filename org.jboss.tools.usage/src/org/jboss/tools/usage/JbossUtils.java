package org.jboss.tools.usage;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.jboss.tools.usage.internal.JBossToolsUsageActivator;
import org.osgi.service.prefs.BackingStoreException;

public final class JbossUtils {

	private static final String ENCODING_UTF8 = "UTF-8";
	private static final Pattern CHARSET_ENCODING_PATTERN = Pattern.compile("charset=(.+)");

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

	/**
	 * Returns an error status for a given plugin id, message and arguments.
	 *
	 * @param pluginId
	 *            the plugin id
	 * @param message
	 *            the message
	 * @param throwable
	 *            the throwable
	 * @param messageArguments
	 *            the message arguments
	 * @return the error status
	 */
	public static IStatus getErrorStatus(String pluginId, String message, Throwable throwable,
			Object... messageArguments) {
		String formattedMessage = null;
		if (message != null) {
			formattedMessage = MessageFormat.format(message, messageArguments);
		}
		return new Status(Status.ERROR, pluginId, Status.ERROR, formattedMessage,
				throwable);
	}

	public static String getLineSeparator() {
		return System.getProperty("line.separator");
	}

	public static IEclipsePreferences getPreferences() {
		return ConfigurationScope.INSTANCE.getNode(JBossToolsUsageActivator.PLUGIN_ID);
	}

	public static IEclipsePreferences getDefaultPreferences() {
		return DefaultScope.INSTANCE.getNode(JBossToolsUsageActivator.PLUGIN_ID);
	}

	public static IPersistentPreferenceStore getStore() {
		return new ScopedPreferenceStore(ConfigurationScope.INSTANCE, JBossToolsUsageActivator.PLUGIN_ID);
	}

	public static void checkedSavePreferences(IEclipsePreferences preferences, Plugin plugin, String message) {
		try {
			preferences.flush();
		} catch (BackingStoreException e) {
			IStatus status = JbossUtils.getErrorStatus(plugin.getBundle().getSymbolicName(),
					message, e, preferences.absolutePath());
			plugin.getLog().log(status);
		}
	}

	private JbossUtils() {
	}
}
