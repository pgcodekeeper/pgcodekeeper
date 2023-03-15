/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.model.graph;

import java.util.Objects;

import ru.taximaxim.codekeeper.core.schema.PgStatement;

/**
 * Класс используется как контейнер для объединения дейсвий с объектом БД
 * (CREATE ALTER DROP) Также хранит объект, инициировавший действие
 */
class ActionContainer {
    private final PgStatement oldObj;
    private final PgStatement newObj;
    private final StatementActions action;
    private final PgStatement starter;

    public ActionContainer(PgStatement oldObj, PgStatement newObj,
            StatementActions action, PgStatement starter) {
        this.oldObj = oldObj;
        this.newObj = newObj;
        this.action = action;
        this.starter = starter;
    }

    public PgStatement getOldObj() {
        return oldObj;
    }

    public PgStatement getNewObj() {
        return newObj;
    }

    public StatementActions getAction() {
        return action;
    }

    public PgStatement getStarter() {
        return starter;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((action == null) ? 0 : action.hashCode());
        result = prime * result + ((oldObj == null) ? 0 : oldObj.hashCode());
        result = prime * result + ((newObj == null) ? 0 : newObj.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActionContainer) {
            ActionContainer cont = (ActionContainer) obj;
            return action == cont.getAction() &&
                    Objects.equals(oldObj, cont.getOldObj()) &&
                    Objects.equals(newObj, cont.getNewObj());
        }
        return false;
    }
    @Override
    public String toString() {
        return action + " " + (oldObj == null? " " : oldObj.getName());
    }
}