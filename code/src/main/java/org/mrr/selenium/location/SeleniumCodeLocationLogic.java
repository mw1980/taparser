package org.mrr.selenium.location;

import org.mrr.api.CodeLocationLogic;
import org.mrr.core.CodeLocationVisitor;
import org.mrr.core.ControlsLogic;
import org.mrr.core.LoadControlsException;
import org.mrr.core.domain.UiControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static org.mrr.core.domain.UiControl.NO_CONTROL;

/**
 * Code generate operation to identify the user interface controls on the Gui.
 */
@Component
public class SeleniumCodeLocationLogic implements CodeLocationLogic {
    private final ControlsLogic controlsLogic;
    private final CodeLocationVisitor codeLocationVisitor;

    @Autowired
    public SeleniumCodeLocationLogic(final ControlsLogic controlsLogic,
                                     final CodeLocationVisitor seleniumCodeLocationVisitor) {
        this.controlsLogic = controlsLogic;
        this.codeLocationVisitor = seleniumCodeLocationVisitor;
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
        return control.identificationCriteria()
                .codeLocationStrategy(codeLocationVisitor)
                .codeFor(control.id());
    }
}
