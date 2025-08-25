/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.utils;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.pgcodekeeper.core.monitor.IMonitor;

public class UIMonitor implements IMonitor {

    private final IProgressMonitor monitor;

    public UIMonitor(IProgressMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void setCanceled(boolean cancelled) {
        if (monitor != null) {
            this.monitor.setCanceled(cancelled);
        }
    }

    @Override
    public boolean isCanceled() {
        return monitor != null && monitor.isCanceled();
    }

    @Override
    public void worked(int i) {
        if (monitor != null) {
            monitor.worked(i);
        }
    }

    @Override
    public IMonitor createSubMonitor() {
        return new UIMonitor(SubMonitor.convert(monitor));
    }

    @Override
    public void setWorkRemaining(int size) {
        if (monitor instanceof SubMonitor sub) {
            sub.setWorkRemaining(size);
        }
    }
}
