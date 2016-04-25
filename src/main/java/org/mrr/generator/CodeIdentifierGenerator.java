package org.mrr.generator;

import static org.mrr.IdentificationType.BY_ID;

import org.mrr.Constants;
import org.mrr.Identifier;
import org.mrr.IdentifierStore;

/**
 * Utility class. It contains methods to manipulate the user interface elements identifiers.
 */
public class CodeIdentifierGenerator {
  private final String filePath;

  public CodeIdentifierGenerator(final String newFilePath) {
    this.filePath = newFilePath;
  }

  public CodeIdentifierGenerator() {
    this.filePath = Constants.IDS_PATH;
  }

  /**
   * Returns the selenium code  for accessing the ui element. e.g. By.id("idFromExternalFile").
   * @param uiElement the "non technical" name of the user interface element.
   * @return the selenium automation code for interacting with the user interface element.
   */
  public String generate(final String uiElement) {
    //TODO cache hier...
    final Identifier identifier = new IdentifierStore(this.filePath).getIdentifierFor(uiElement);
    final StringBuilder seleniumText = new StringBuilder("");
    if (BY_ID.equals(identifier.getType())) {
      seleniumText.append("By.id(\"");
    }
    //TODO ... continue here for the other identification strings.
    seleniumText.append(identifier.getId()).append("\")");
    return seleniumText.toString();
  }
}
