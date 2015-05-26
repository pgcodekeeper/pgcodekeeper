/*******************************************************************************
 * Copyright (c) 
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.usage.googleanalytics.eclipse;

import java.text.MessageFormat;

import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * Emulates a Firefox Browser User-Agent String but reports eclipse related
 * informations.
 * 
 * @author Andre Dietisheim
 */
public class EclipseUserAgent implements IEclipseUserAgent {

	public static final char BROWSER_LOCALE_DELIMITER = '-';

	public static final char JAVA_LOCALE_DELIMITER = '_';

	private static final String ECLIPSE_RUNTIME_BULDEID = "org.eclipse.core.runtime"; //$NON-NLS-1$

	private static final String USERAGENT_WIN = "{0}/{1} (Windows; U; Windows NT {2}; {3})"; //$NON-NLS-1$
	private static final String USERAGENT_WIN_64 = "{0}/{1} (Windows; U; Windows NT {2}; Win64; x64; {3})"; //$NON-NLS-1$
	private static final String USERAGENT_MAC = "{0}/{1} (Macintosh; U; Intel Mac OS X {2}; {3})"; //$NON-NLS-1$
	private static final String USERAGENT_LINUX = "{0}/{1} (X11; U; Linux i686; {3})"; //$NON-NLS-1$
	private static final String USERAGENT_LINUX_64 = "{0}/{1} (X11; U; Linux x86_64; {3})"; //$NON-NLS-1$

	public static final char VERSION_DELIMITER = '.'; //$NON-NLS-1$

	private static final String PROP_OS_VERSION = "os.version"; //$NON-NLS-1$
	private static final String PROP_SUN_ARCH = "sun.arch.data.model"; //$NON-NLS-1$

	private static final CharSequence ARCHITECTURE_64 = "64";

	private String browserLanguage;

	public String toString() {
		String productId = getApplicationName();
		String productVersion = getApplicationVersion();

		return MessageFormat.format(
				getUserAgentPattern()
				, productId
				, productVersion
				, getOSVersion()
				, getBrowserLanguage()
				);
	}

	private String createBrowserLanguage() {
		String nl = getNL();
		if (nl == null) {
			return ""; //$NON-NLS-1$
		}

		int indexOf = nl.indexOf(JAVA_LOCALE_DELIMITER); //$NON-NLS-1$
		if (indexOf <= 0) {
			return nl;
		}

		return new StringBuilder()
				.append(nl.substring(0, indexOf))
				.append(BROWSER_LOCALE_DELIMITER)
				.append(nl.substring(indexOf + 1))
				.toString();
	}

	protected String getNL() {
		return Platform.getNL();
	}

	public String getBrowserLanguage() {
		if (browserLanguage == null) {
			browserLanguage = createBrowserLanguage();
		}
		return browserLanguage;
	}

	public String getOS() {
		return Platform.getOS();
	}

	public String getJavaArchitecture() {
		return System.getProperty(PROP_SUN_ARCH);
	}
	
	public String getOSVersion() {
		return System.getProperty(PROP_OS_VERSION);
	}

	private String getUserAgentPattern() {
		String os = getOS();
		String userAgentPattern = ""; //$NON-NLS-1$
		if (Platform.OS_LINUX.equals(os)) {
			if (is64()) {
				return USERAGENT_LINUX_64;
			} else {
				return USERAGENT_LINUX;
			}
		} else if (Platform.OS_MACOSX.equals(os)) {
			return USERAGENT_MAC;
		} else if (Platform.OS_WIN32.equals(os)) {
			if (is64()) {
				return USERAGENT_WIN_64;
			} else {
				return USERAGENT_WIN;
			}
		}
		return userAgentPattern;
	}

	/**
	 * Returns <code>true</code> if the jvm this is running in is a 64bit jvm.
	 * 
	 * @param architecture
	 * @return
	 * 
	 * @see <a href="// http://stackoverflow.com/questions/807263/how-do-i-detect-which-kind-of-jre-is-installed-32bit-vs-64bit">stackoverflow</a>
	 */
	private boolean is64() {
		String architecture = getJavaArchitecture();
		return architecture != null
				&& architecture.equals(ARCHITECTURE_64);
	}

	public String getApplicationName() {
		return getApplicationBundle().getSymbolicName();
	}

	public String getApplicationVersion() {
		String fullVersion = getApplicationBundle().getVersion().toString();
		int productVersionStart = fullVersion.lastIndexOf(VERSION_DELIMITER);
		if (productVersionStart > 0) {
			return fullVersion.substring(0, productVersionStart);
		} else {
			return fullVersion;
		}
	}

	/**
	 * Returns the bundle that launched the application that this class runs in.
	 * 
	 * @return the defining bundle
	 */
	private Bundle getApplicationBundle() {
		IProduct product = Platform.getProduct();
		if (product != null) {
			return product.getDefiningBundle();
		} else {
			return Platform.getBundle(ECLIPSE_RUNTIME_BULDEID);
		}
	}
}
