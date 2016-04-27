package org.mrr.generator;

import org.mrr.Constants;
import org.mrr.controls.Control;
import org.mrr.controls.ControlsPool;
import org.mrr.controls.ControlsCsvAgent;

import static org.mrr.IdentificationType.ID;
import static org.mrr.IdentificationType.UNKNOWN;

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
        //TODO cache hier...
        final Control identifier = new ControlsPool(new ControlsCsvAgent(this.filePath)).searchForControl(uiElement);
        if (UNKNOWN.equals(identifier.type())) {
            return "Cannot find the control: " + uiElement + " in the repository. The code cannot be generated";
        }
        final StringBuilder seleniumText = new StringBuilder("");
        if (ID.equals(identifier.type())) {
            seleniumText.append("By.id(\"");
        }
        //TODO ... continue here for the other identification strings.
        seleniumText.append(identifier.id()).append("\")");
        return seleniumText.toString();
    }
}
