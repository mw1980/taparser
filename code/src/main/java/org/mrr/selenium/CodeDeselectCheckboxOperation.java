package org.mrr.selenium;

import org.mrr.api.CodeLocationLogic;
import org.mrr.api.CodeTestActionOperation;
import org.mrr.core.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.DESELECT_CHECKBOX;

/**
 * Code generate operation for the actions of type: "deselect checkbox my_checkbox".
 */
@Component
public class CodeDeselectCheckboxOperation implements CodeTestActionOperation {

    private final CodeLocationLogic locationLogic;

    @Autowired
    public CodeDeselectCheckboxOperation(final CodeLocationLogic codeLocationLogic) {
        locationLogic = codeLocationLogic;
    }

    @Override
    public String codeFor(final Action action) {
        final String targetCode = identificationCodeFor(action);
        return format("if (driver.findElement(%s).isSelected()){driver.findElement(%s).click();}",
                targetCode, targetCode);
    }

    private String identificationCodeFor(final Action action) {
        return locationLogic.locationCodeFor(action.target());
    }

    @Override
    public boolean canHandle(final Action action) {
        return DESELECT_CHECKBOX == action.actionType();
    }
}
