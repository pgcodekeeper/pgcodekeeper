/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.internal.SWTEventListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TypedListener;

/**
 * Aggregates multiple consecutive events into one with defined time threshold.
 * Use/add static methods to add this listener to controls.
 * <br><br>
 * Note: it doesn't make sense to use this listener on events that don't come
 *       in series in quick succession.
 *
 * @author levsha_aa
 */
public class AggregatingListener extends TypedListener {

    public static void addModifyListener(Text text, ModifyListener listener) {
        text.addListener(SWT.Modify, new AggregatingListener(listener));
    }

    private static final int DEFAULT_AGGREGATION_THRESHOLD_MS = 500;

    private int aggregationThresholdMs = DEFAULT_AGGREGATION_THRESHOLD_MS;
    private DelayedEvent lastEvent;

    public void setAggregationThresholdMs(int aggregationThresholdMs) {
        this.aggregationThresholdMs = aggregationThresholdMs;
    }

    private AggregatingListener(SWTEventListener listener) {
        super(listener);
    }

    @Override
    public void handleEvent(Event e) {
        e.display.timerExec(aggregationThresholdMs, new DelayedEvent(e));
    }

    private class DelayedEvent implements Runnable {

        private final Event e;

        public DelayedEvent(Event e) {
            this.e = e;
            lastEvent = this;
        }

        @Override
        public void run() {
            if (this == lastEvent) {
                AggregatingListener.super.handleEvent(e);
            }
        }
    }
}
