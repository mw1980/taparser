package org.mrr.selenium;

import org.mrr.api.CodeLocationLogic;
import org.mrr.api.CodeTestActionOperation;
import org.mrr.core.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;

/**
 * Code generate operation for the actions of type: "Click button myButton".
 */
@Component
public class CodeClickButtonOperation implements CodeTestActionOperation {

    private final CodeLocationLogic locationLogic;

    @Autowired
    public CodeClickButtonOperation(final CodeLocationLogic codeLocationLogic) {
        locationLogic = codeLocationLogic;
    }

    @Override
    public String codeFor(final Action action) {
        return format("driver.findElement(%s).click();",
                locationLogic.locationCodeFor(action.target()));
    }

    @Override
    public boolean canHandle(final Action action) {
        return CLICK_BUTTON == action.actionType();
    }
}
