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
package ru.taximaxim.codekeeper.ui.propertytests;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IEditorPart;

import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.job.SingletonEditorJob;

public abstract class SingletonJobTester extends PropertyTester {

    protected static String makeEvalProperty(String property) {
        return PLUGIN_ID.THIS + '.' + property;
    }

    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
        if (getProperty().equals(property)) {
            for (Job j : Job.getJobManager().find(SingletonEditorJob.class)) {
                SingletonEditorJob sJob = (SingletonEditorJob) j;
                if (getEvalProperty().equals(sJob.getEvalProperty()) && sJob.blocks((IEditorPart) receiver)) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract String getProperty();

    public abstract String getEvalProperty();
}
