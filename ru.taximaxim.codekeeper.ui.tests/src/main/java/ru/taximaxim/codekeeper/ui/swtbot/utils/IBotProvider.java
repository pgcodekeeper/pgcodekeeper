/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.swtbot.utils;

import org.eclipse.swtbot.swt.finder.SWTBot;

/**
 * Provides a contract for objects that can supply an SWTBot instance.
 * 
 * <p>
 * This is a sealed interface that permits only specific implementations within
 * the package. No other classes are allowed to implement this interface.
 * </p>
 * 
 * <p>
 * <b>Permitted Implementations:</b>
 * </p>
 * <ul>
 * <li>{@link EditorBotProvider}</li>
 * <li>{@link ShellBotProvider}</li>
 * </ul>
 * 
 * @see EditorBotProvider
 * @see ShellBotProvider
 */
public sealed interface IBotProvider permits EditorBotProvider, ShellBotProvider {
    SWTBot bot();
}
