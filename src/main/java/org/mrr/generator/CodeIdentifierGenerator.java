package org.mrr.generator;

import static org.mrr.IdentificationType.BY_ID;

import org.mrr.Constants;
import org.mrr.Identifier;
import org.mrr.IdentifierStore;

/**
 * Utility class. It contains methods to manipulate the user interface elements identifiers.
 */
//TODO Springify it...
class CodeIdentifierGenerator {
  private CodeIdentifierGenerator() {
    //Utility class, the constructor is hidden.
  }

  /**
   * Returns the selenium code  for accessing the ui element. e.g. By.id("idFromExternalFile").
   * @param uiElement the "non technical" name of the user interface element.
   * @param filePath the file to look for the technical identifiers for the user interface element.
   * @return the selenium automation code for interacting with the user interface element.
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
   * @return the selenium used to identify the user interface element By.id(id="userNameHtmlId").
   */
  public static String getIdentifierCodeFor(final String uiElement) {
    return getIdentifierCodeFor(uiElement, Constants.IDS_PATH);
  }

}
