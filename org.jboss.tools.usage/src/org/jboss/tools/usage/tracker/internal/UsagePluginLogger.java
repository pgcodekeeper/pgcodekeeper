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
package org.jboss.tools.usage.tracker.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;

/**
 * @author Andre Dietisheim
 */
public class UsagePluginLogger {

	private final Plugin plugin;

	public UsagePluginLogger(Plugin plugin) {
		this.plugin = plugin;
	}

	public void error(String message) {
		error(message, true);
	}

	public void error(String message, boolean debug) {
		log(IStatus.ERROR, message, debug);
	}

	public void error(Throwable t) {
		error(t, false);
	}

	public void error(Throwable t, boolean debug) {
		if (!debug || isTracingEnabled()) {
			Status status = new Status(IStatus.ERROR, plugin.getBundle().getSymbolicName(),
					0, t.getMessage() != null ? t.getMessage() : "", t);
			plugin.getLog().log(status);
		}
	}

	public void debug(String message) {
		log(IStatus.INFO, message, true);
	}

	private void log(int severity, String message, boolean debug) {
		if ((!debug || isTracingEnabled()) && plugin != null) {
			IStatus status = new Status(severity, plugin.getBundle().getSymbolicName(), message);
			plugin.getLog().log(status);
		}
	}

	private boolean isTracingEnabled() {
		Plugin plug = getPlugin();
		return plug != null && plug.isDebugging();
	}

	private Plugin getPlugin() {
		return plugin;
	}
}
