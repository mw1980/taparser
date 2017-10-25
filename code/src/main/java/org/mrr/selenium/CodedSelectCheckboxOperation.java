package org.mrr.selenium;

import org.mrr.api.CodeLocationLogic;
import org.mrr.api.CodedOperation;
import org.mrr.core.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;

/**
 * Code generate operation for the step: "select checkbox myCheckbox".
 */
@Component
public class CodedSelectCheckboxOperation implements CodedOperation {

    private final CodeLocationLogic locationLogic;

    @Autowired
    public CodedSelectCheckboxOperation(final CodeLocationLogic codeLocationLogic) {
        locationLogic = codeLocationLogic;
    }

    @Override
    public String codeFor(final Action action) {
        final String targetCode = locationLogic.locationCodeFor(action.target());
        return format("if (!driver.findElement(%s).isSelected()){driver.findElement(%s).click();}",
                targetCode, targetCode);
    }

    @Override
    public boolean canHandle(final Action action) {
        return SELECT_CHECKBOX == action.actionType();
    }
}
