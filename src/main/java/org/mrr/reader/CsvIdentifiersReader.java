package org.mrr.reader;

import static java.nio.charset.Charset.defaultCharset;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

import org.mrr.IdentificationType;
import org.mrr.Identifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class contains methods to read from ui elements identifier from external csv file.
 */
public class CsvIdentifiersReader {
  /**
   * Path to the file that contains the list of elements identifiers.
   */
  private final String filePath;

  /**
   * Default Constructor.
   * @param filePath Path to the file to read the identifiers from.
   */
  public CsvIdentifiersReader(final String filePath) {
    this.filePath = filePath;
  }

  /**
   * Reads the mask identifiers from the external file.
   * @return List of Element Identifiers from external file.
   */
  public List<Identifier> readElements() {
    final List<Identifier> identifiers = new ArrayList<>();
    try {
      final List<String> inputs = readAllLines(get(this.filePath), defaultCharset());
      for (final String input : inputs) {
        identifiers.add(readElementIdentifierFromString(input));
      }
    } catch (IOException e) {
      throw new TestSpecificationReaderException("File not found: " + this.filePath);
    }
    return identifiers;
  }

  private Identifier readElementIdentifierFromString(final String csvLine) {
    final String[] lineItems = csvLine.split(" ");
    return new Identifier(lineItems[0], IdentificationType.forValue(lineItems[1]), lineItems[2]);
  }
}
