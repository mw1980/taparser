package org.mrr.core;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class contains methods for reading test cases from an external file.
 */
public class StepDescriptionsStore {
  private final String location;

  public StepDescriptionsStore(final String lctn) {
    this.location = lctn;
  }

  /**
   * This method reads test cases from an external text file.
   * @return List of Strings, each element contains a line in the text file.
   * @throws ReadSpecificationException if an error occurs while processing the file.
   */
  public List<String> deliverStepsDescription() throws ReadSpecificationException {
    try {
      return Files.readAllLines(Paths.get(location), Charset.defaultCharset());
    } catch (IOException e) {
      throw new ReadSpecificationException(e.getMessage());
    }
  }
}
