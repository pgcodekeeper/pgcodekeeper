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
package ru.taximaxim.codekeeper.core;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * For thread pools that shouldn't prevent normal program shutdown.
 *
 * @author levsha_aa
 */
public class DaemonThreadFactory implements ThreadFactory {

    ThreadFactory defaultTf = Executors.defaultThreadFactory();

    @Override
    public Thread newThread(Runnable r) {
        Thread t = defaultTf.newThread(r);
        t.setDaemon(true);
        return t;
    }
}
