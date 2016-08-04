package org.mrr.generator;

import org.mrr.Constants;
import org.mrr.controls.api.UiControl;

import static org.mrr.core.IdentificationCriteria.ID;
import static org.mrr.core.IdentificationCriteria.UNKNOWN;

/**
 * Utility class. It contains methods to manipulate the user interface elements identifiers.
 */
public class CodeIdentifierGenerator {
    private final String filePath;

    public CodeIdentifierGenerator(final String newFilePath) {
        this.filePath = newFilePath;
    }

    CodeIdentifierGenerator() {
        this.filePath = Constants.IDS_PATH;
    }

    /**
     * Returns the selenium code  for accessing the ui element. e.g. By.id("idFromExternalFile").
     *
     * @param uiElement the "non technical" name of the user interface element.
     * @return the selenium automation code for interacting with the user interface element.
     */
    public String generate(final String uiElement) {
        //TODO avoid null. Implement real logic here.
        ///final UiControl identifier = new ControlsRepositoryImpl(new ControlsSupplyAgentImpl(this.filePath)).searchControlByName(uiElement);
        final UiControl identifier = null;
        if (UNKNOWN.equals(identifier.identifiedBy())) {
            return "Cannot find the control: " + uiElement + " in the repository. The code cannot be generated";
        }
        final StringBuilder seleniumText = new StringBuilder("");
        if (ID.equals(identifier.identifiedBy())) {
            seleniumText.append("By.id(\"");
        }
        //TODO ... continue here for the other identification strings.
        seleniumText.append(identifier.id()).append("\")");
        return seleniumText.toString();
    }
}
