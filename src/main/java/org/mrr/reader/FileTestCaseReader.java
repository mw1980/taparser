package org.mrr.reader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class contains methods for reading test cases from an external file.
 */
public class FileTestCaseReader {
  private final String filePath;

  public FileTestCaseReader(final String newFilePath) {
    this.filePath = newFilePath;
  }

  /**
   * This method reads test cases from an external text file.
   * @return List of Strings, each element contains a line in the text file.
   * @throws TestSpecificationReaderException if an error occurs while processing the file.
   */
  public List<String> readTestCasesFromFile() throws TestSpecificationReaderException {
    try {
      return Files.readAllLines(Paths.get(filePath), Charset.defaultCharset());
    } catch (IOException e) {
      throw new TestSpecificationReaderException(e.getMessage());
    }
  }
}
