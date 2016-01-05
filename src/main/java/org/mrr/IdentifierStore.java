package org.mrr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mrr.reader.CsvIdentifiersReader;

/**
 * The class stores the known element identifiers for the current application.
 */
//TODO springify here.
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

  public Map<String, Identifier> getStoredElements(){
    if (storedElements.isEmpty()) {
      final List<Identifier> identifiers = new CsvIdentifiersReader(pathToFile).readElements();
      for (Identifier each : identifiers) {
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
      throw new IdentifierValueNotFoundException("No identifier found for the element: " + uiElement + ".");
    }
    return storedIdentifiers.get(uiElement);
  }
}
