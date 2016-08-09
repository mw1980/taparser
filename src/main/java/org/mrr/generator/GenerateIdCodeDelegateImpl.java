package org.mrr.generator;

import org.mrr.controls.api.UiControl;
import org.mrr.core.ControlsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.IdentificationCriteria.ID;
import static org.mrr.core.domain.IdentificationCriteria.UNKNOWN;

/**
 * Utility class. It contains methods to manipulate the user interface elements identifiers.
 */
@Component
public class GenerateIdCodeDelegateImpl implements GenerateIdCodeDelegate {
    private final ControlsLogic controlsLogic;

    @Autowired
    public GenerateIdCodeDelegateImpl(final ControlsLogic controlsLogic) {
        this.controlsLogic = controlsLogic;
    }

    @Override
    public String identificationFor(final String name) {
        final UiControl control = controlsLogic.findControlByName(name);
        if (controlIsFound(control)) {
            return createIdentificationCode(control);
        } else {
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

    private boolean controlIsFound(final UiControl control) {
        return !UNKNOWN.equals(control.identifiedBy());
    }
}
