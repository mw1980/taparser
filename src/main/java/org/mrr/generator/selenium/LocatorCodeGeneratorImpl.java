package org.mrr.generator.selenium;

import org.mrr.controls.CodeGenerationException;
import org.mrr.core.ControlsLogic;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.UiControl;
import org.mrr.generator.LocatorCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mrr.core.domain.IdentificationCriteria.ID;
import static org.mrr.core.domain.UiControl.NO_CONTROL;

/**
 * Code generator for identification of the user interface controls on the Gui.
 */
@Component
class LocatorCodeGeneratorImpl implements LocatorCodeGenerator {
    private final ControlsLogic controlsLogic;

    @Autowired
    public LocatorCodeGeneratorImpl(final ControlsLogic controlsLogic) {
        this.controlsLogic = controlsLogic;
    }

    @Override
    public String identificationCodeFor(final String name) {
        final UiControl control = controlsLogic.findControlByName(name);
        if (isControlFound(control)) {
            return createIdentificationCode(control);
        } else {
            throw new LoadControlsException(
                    String.format("Cannot find the control: %s in the repository. The code cannot be generated",
                            name));
        }
    }

    private String createIdentificationCode(final UiControl control) {
        if (ID.equals(control.identifiedBy())) {
            return String.format("By.id(\"%s\")", control.id());
        }
        throw new CodeGenerationException(
                String.format("Identification type for %s is unknown.", control.identifiedBy()));
    }

    private boolean isControlFound(final UiControl control) {
        return !NO_CONTROL.equals(control);
    }
}
