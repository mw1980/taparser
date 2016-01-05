package org.mrr.generator;

import org.mrr.Constants;
import org.mrr.Identifier;
import org.mrr.IdentifierStore;

import static org.mrr.IdentificationType.BY_ID;

/**
 * Utility class. It contains methods to manipulate the user interface elements identifiers.
 */
//TODO Springify it...
class CodeIdentifierGenerator {
  private CodeIdentifierGenerator() {
    //Utility class, the constructor is hidden.
  }

  /**
   * The method looks for the action target in the list of the stored identifiers and delivers the automation code used to interact with the target.
   * Returns the selenium code  for accessing the ui element (e.g. : By.id("idFromExternalFile")
   * @param uiElement the target of the ui action.
   * @return the selenium automation code for interacting with the target.
   */
  private static String getIdentifierCodeFor(final String uiElement, final String filePath) {
    //TODO Springify here.
    final Identifier identifier = new IdentifierStore(filePath).getIdentifierFor(uiElement);
    final StringBuilder seleniumText = new StringBuilder("");
    if (BY_ID.equals(identifier.getIdentificationType())) {
      seleniumText.append("By.id(\"");
    }
    //TODO ... continue here for the other identification strings.
    seleniumText.append(identifier.getIdentificationString()).append("\")");
    return seleniumText.toString();
  }

  /**
   * Returns the selenium code used to identify the user interface element in the page.
   * @param uiElement the name of the user interface element.
   * @return the selenium code that can be used to identify the user interface element in a selenium script.
   * Example: By.id(id="userNameHtmlId");
   */
  public static String getIdentifierCodeFor(final String uiElement) {
    return getIdentifierCodeFor(uiElement, Constants.IDENTIFIER_PATH);
  }

}
