package org.mrr.selenium;

import org.mrr.api.CodeException;
import org.mrr.api.CodeLocationLogic;
import org.mrr.core.ControlsLogic;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.UiControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.IdentificationCriteria.ID;
import static org.mrr.core.domain.UiControl.NO_CONTROL;

/**
 * Code generator for identification of the user interface controls on the Gui.
 */
@Component
class DefaultCodeLocationLogic implements CodeLocationLogic {
    private final ControlsLogic controlsLogic;

    @Autowired
    public DefaultCodeLocationLogic(final ControlsLogic controlsLogic) {
        this.controlsLogic = controlsLogic;
    }

    @Override
    public String locationCodeFor(final String controlName) {
        final UiControl control = controlsLogic.controlWithName(controlName);
        if (controlFound(control)) {
            return identificationCodeFor(control);
        } else {
            throw new LoadControlsException(
                    format("Cannot find the control: %s in the repository. The code cannot be generated", controlName));
        }
    }

    private boolean controlFound(final UiControl control) {
        return !NO_CONTROL.equals(control);
    }

    private String identificationCodeFor(final UiControl control) {
        if (ID == control.identifiedBy()) {
            return format("By.id(\"%s\")", control.id());
        }
        throw new CodeException(
                format("Identification type for %s is unknown.", control.identifiedBy()));
    }
}
