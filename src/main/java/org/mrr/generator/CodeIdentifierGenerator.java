package org.mrr.generator;

import org.mrr.Constants;
import org.mrr.uielements.UiElement;
import org.mrr.uielements.UiElementsStore;
import org.mrr.uielements.UiElementsCsvSupplier;

import static org.mrr.IdentificationType.ID;

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
        final UiElement identifier = new UiElementsStore(new UiElementsCsvSupplier(this.filePath)).searchUiElementByName(uiElement);
        final StringBuilder seleniumText = new StringBuilder("");
        if (ID.equals(identifier.type())) {
            seleniumText.append("By.id(\"");
        }
        //TODO ... continue here for the other identification strings.
        seleniumText.append(identifier.id()).append("\")");
        return seleniumText.toString();
    }
}
