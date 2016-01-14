package org.mrr.reader;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mrr.IdentificationType;
import org.mrr.Identifier;

import java.util.List;

public class CsvIdentifiersReaderTest {

  @Test(expected = TestSpecificationReaderException.class)
  public void whenReadFromNoExistingFile_shouldThrowException() {
    new CsvIdentifiersReader("notExistingFile").readElements();
  }

  @Test
  public void whenReadingFromEmptyFile_shouldReturnEmptyList() {
    final String filePath = TestConstants.PATH_TO_TEST_RESOURCE_FOLDER + "EmptyElementIdentifiersFile.csv";
    final List<Identifier> elementsFromFile = new CsvIdentifiersReader(filePath).readElements();
    assertThat(elementsFromFile).isEmpty();
  }

  @Test
  public void whenReadingFromCorrectFile_shouldReturnAllElements() {
    final String filePath = TestConstants.PATH_TO_TEST_RESOURCE_FOLDER + "ElementIdentifiers.csv";
    final List<Identifier> elementsFromFile = new CsvIdentifiersReader(filePath).readElements();
    assertThat(firstCsvElement()).isEqualTo(elementsFromFile.get(0));
    assertThat(secondCsvElement()).isEqualTo(elementsFromFile.get(1));
    assertThat(thirdCsvElement()).isEqualTo(elementsFromFile.get(2));
  }

  private Identifier firstCsvElement() {
    return new Identifier("user", IdentificationType.BY_ID, "userNameHtmlId");
  }

  private Identifier secondCsvElement() {
    return new Identifier("password", IdentificationType.BY_ID, "userPassHtmlId");
  }

  private Identifier thirdCsvElement() {
    return new Identifier("submit", IdentificationType.BY_ID, "submitButtonId");
  }
}