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
