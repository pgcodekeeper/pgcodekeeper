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

package org.jboss.tools.usage.tracker.internal;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

import org.jboss.tools.usage.internal.http.IHttpGetRequest;
import org.jboss.tools.usage.tracker.IFocusPoint;
import org.jboss.tools.usage.tracker.ITracker;
import org.jboss.tools.usage.tracker.IURLBuildingStrategy;

/**
 * Reports (tracks) usage
 * 
 * @author Andre Dietisheim
 * @author Siddique Hameed
 * @see based on <a href="http://jgoogleAnalytics.googlecode.com">http://jgoogleAnalytics.googlecode.com</a>
 */
public class Tracker implements ITracker {

	private IURLBuildingStrategy urlBuildingStrategy = null;
	private IHttpGetRequest httpRequest;
	private UsagePluginLogger logger;
	
	public Tracker(IURLBuildingStrategy urlBuildingStrategy, IHttpGetRequest httpGetRequest, UsagePluginLogger logger) {
		this.httpRequest = httpGetRequest;
		this.logger = logger;
		this.urlBuildingStrategy = urlBuildingStrategy;
	}

	public void trackSynchronously(IFocusPoint focusPoint) {
		logger
				.debug(MessageFormat.format(TrackerMessages.Tracker_Synchronous, focusPoint.getTitle()));
		try {
			httpRequest.request(getTrackingUrl(focusPoint));
		} catch (Exception e) {
			logger.error(MessageFormat.format(TrackerMessages.Tracker_Error, e.getMessage()));
		}
	}

	protected String getTrackingUrl(IFocusPoint focusPoint) throws UnsupportedEncodingException {
		return urlBuildingStrategy.build(focusPoint);
	}

	public void trackAsynchronously(IFocusPoint focusPoint) {
		logger.debug(MessageFormat
				.format(TrackerMessages.Tracker_Asynchronous, focusPoint.getTitle()));
		new Thread(new TrackingRunnable(focusPoint)).start();
	}

	private class TrackingRunnable implements Runnable {
		private IFocusPoint focusPoint;

		private TrackingRunnable(IFocusPoint focusPoint) {
			this.focusPoint = focusPoint;
		}

		public void run() {
			try {
				httpRequest.request(getTrackingUrl(focusPoint));
			} catch (Exception e) {
				logger.error(MessageFormat.format(TrackerMessages.Tracker_Error, e.getMessage()));
			}
		}
	}
}
