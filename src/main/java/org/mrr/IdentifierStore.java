package org.mrr;

import org.mrr.reader.CsvIdentifiersReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The class stores the known element identifiers for the current application.
 */
public class IdentifierStore {
  private final Map<String, Identifier> storedElements = new HashMap<>();
  private final String pathToFile;

  /**
   * Default constructor.
   * @param pathToFile the path to the external file where the identifiers are read from.
   */
  public IdentifierStore(final String pathToFile) {
    this.pathToFile = pathToFile;
  }

  /**
   * Initializes, if empty, and returns the list of the known ui identifiers.
   * @return map with [key, values] of type [uiName, uiIdentifier].
   */
  public Map<String, Identifier> getStoredElements() {
    if (storedElements.isEmpty()) {
      final List<Identifier> identifiers = new CsvIdentifiersReader(pathToFile).readElements();
      for (final Identifier each : identifiers) {
        storedElements.put(each.getName(), each);
      }
    }
    return storedElements;
  }

  /**
   * The method returns the identification text as found in the identifier file.
   * @param uiElement the name of the user interface elements.
   * @return The identification text for the user interface element received as parameter.
   */
  public Identifier getIdentifierFor(final String uiElement) {
    final Map<String, Identifier> storedIdentifiers = getStoredElements();
    if (!storedIdentifiers.containsKey(uiElement)) {
      throw new IdentifierValueNotFoundException("No identifier found for the element: "
        + uiElement + ".");
    }
    return storedIdentifiers.get(uiElement);
  }
}
