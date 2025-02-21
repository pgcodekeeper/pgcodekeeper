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
package ru.taximaxim.codekeeper.core.parsers.antlr.verification;

import java.util.List;

import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrError;
import ru.taximaxim.codekeeper.core.parsers.antlr.ErrorTypes;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Role_name_with_groupContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Rule_commonContext;

/**
 * class for checking objects according to general rules
 */
public final class VerificationGrant implements IVerification {

    private final Rule_commonContext ruleCtx;
    private final VerificationProperties rules;
    private final String fileName;
    private List<Object> errors;

    protected VerificationGrant(Rule_commonContext ruleCtx, VerificationProperties rules, String fileName,
            List<Object> errors) {
        this.ruleCtx = ruleCtx;
        this.rules = rules;
        this.fileName = fileName;
        this.errors = errors;
    }

    @Override
    public void verify() {
        var deniedUsers = rules.getDeniedUsers();
        if (deniedUsers.isEmpty() || ruleCtx.REVOKE() != null || ruleCtx.other_rules() != null) {
            return;
        }

        for (Role_name_with_groupContext roleCtx : ruleCtx.roles_names().role_name_with_group()) {
            // skip CURRENT_USER and SESSION_USER
            IdentifierContext user = roleCtx.user_name().identifier();
            if (user == null) {
                continue;
            }
            String role = user.getText();
            if (deniedUsers.contains(role)) {
                AntlrError err = new AntlrError(user.getStart(), fileName, ruleCtx.getStop().getLine(),
                        ruleCtx.getStart().getCharPositionInLine(), Messages.VerificationGrant_denied_grant + role,
                        ErrorTypes.VERIFICATIONERROR);
                errors.add(err);
            }
        }
    }
}
