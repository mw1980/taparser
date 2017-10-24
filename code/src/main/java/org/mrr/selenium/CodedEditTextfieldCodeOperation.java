package org.mrr.selenium;

import org.mrr.api.CodeLocationLogic;
import org.mrr.api.GenerateActionCodeOperation;
import org.mrr.core.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.EDIT_TEXT;

/**
 * Code generate operation for the operation "set value in edit description field".
 */
@Component
public class CodedEditTextfieldCodeOperation implements GenerateActionCodeOperation {

    private final CodeLocationLogic locationLogic;

    @Autowired
    public CodedEditTextfieldCodeOperation(final CodeLocationLogic codeLocationLogic) {
        locationLogic = codeLocationLogic;
    }

    @Override
    public String codeFor(final Action action) {
        return format("driver.findElement(%s).sendKeys(\"%s\");",
                locationLogic.locationCodeFor(action.target()),
                action.value());
    }

    @Override
    public boolean canHandle(final Action action) {
        return EDIT_TEXT == action.actionType();
    }
}
