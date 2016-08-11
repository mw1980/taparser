package org.mrr.generator.selenium;

import org.mrr.controls.api.UiControl;
import org.mrr.core.ControlsLogic;
import org.mrr.generator.IdCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.IdentificationCriteria.ID;
import static org.mrr.core.domain.IdentificationCriteria.UNKNOWN;

/**
 * Code generator for identification of the user interface controls.
 */
@Component
public class IdCodeGeneratorImpl implements IdCodeGenerator {
    private final ControlsLogic controlsLogic;

    @Autowired
    public IdCodeGeneratorImpl(final ControlsLogic controlsLogic) {
        this.controlsLogic = controlsLogic;
    }

    @Override
    public String identificationCodeFor(final String name) {
        final UiControl control = controlsLogic.findControlByName(name);
        if (isControlFound(control)) {
            return createIdentificationCode(control);
        } else {
            //TODO throw exception here?
            return "Cannot find the control: " + name + " in the repository. The code cannot be generated";
        }
    }

    private String createIdentificationCode(final UiControl control) {
        if (ID.equals(control.identifiedBy())) {
            return "By.id(\"" + control.id() + "\")";
        }
        //TODO: throw exception here?
        return "Identification type not known.";
    }

    private boolean isControlFound(final UiControl control) {
        return !UNKNOWN.equals(control.identifiedBy());
    }
}
