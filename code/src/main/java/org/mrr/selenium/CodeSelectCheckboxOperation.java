package org.mrr.selenium;

import org.mrr.api.CodeLocationLogic;
import org.mrr.api.CodeTestActionOperation;
import org.mrr.core.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;

/**
 * Code generator class for the step: select checkbox myCheckbox.
 */
@Component
public class CodeSelectCheckboxOperation implements CodeTestActionOperation {

    private final CodeLocationLogic locationLogic;

    @Autowired
    public CodeSelectCheckboxOperation(final CodeLocationLogic codeLocationLogic) {
        locationLogic = codeLocationLogic;
    }

    @Override
    public String codeFor(final Action action) {
        final String targetCode = identificationCode(action);
        return format("if (!driver.findElement(%s).isSelected()){driver.findElement(%s).click();}",
                targetCode,
                targetCode);
    }

    private String identificationCode(final Action action) {
        return locationLogic.locationCodeFor(action.target());
    }

    @Override
    public boolean canHandle(final Action action) {
        return SELECT_CHECKBOX == action.actionType();
    }
}
