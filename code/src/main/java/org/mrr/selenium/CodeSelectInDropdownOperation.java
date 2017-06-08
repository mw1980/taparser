package org.mrr.selenium;


import org.mrr.api.CodeLocationLogic;
import org.mrr.api.CodeTestActionOperation;
import org.mrr.core.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.SELECT_IN_DROPDOWN;

/**
 * Code generate operation for the action: select in dropdown x value "y".
 */
@Component
public class CodeSelectInDropdownOperation implements CodeTestActionOperation {

    private final CodeLocationLogic locationLogic;

    @Autowired
    public CodeSelectInDropdownOperation(final CodeLocationLogic codeLocationLogic) {
        locationLogic = codeLocationLogic;
    }

    @Override
    public String codeFor(final Action action) {
        return format("new Select (driver.findElement(%s)).selectByVisibleText(\"%s\");",
                locationLogic.locationCodeFor(action.target()), action.value());
    }

    @Override
    public boolean canHandle(final Action action) {
        return SELECT_IN_DROPDOWN == action.actionType();
    }
}
