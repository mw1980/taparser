package org.mrr.reader;

import java.util.List;

import org.junit.Test;
import org.mrr.IdentificationType;
import org.mrr.Identifier;

import static org.assertj.core.api.Assertions.assertThat;

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
    assertThat(elementsFromFile.size()).isEqualTo(4);
    assertThat(firstCsvElement()).isEqualTo(elementsFromFile.get(0));
    assertThat(secondCsvElement()).isEqualTo(elementsFromFile.get(1));
    assertThat(thirdCsvElement()).isEqualTo(elementsFromFile.get(2));
  }

  private Identifier firstCsvElement() {
    return new Identifier("name", IdentificationType.BY_ID, "userNameHtmlId");
  }

  private Identifier secondCsvElement() {
    return new Identifier("password", IdentificationType.BY_ID, "userPasswordHtmlId");
  }

  private Identifier thirdCsvElement() {
    return new Identifier("submit", IdentificationType.BY_ID, "buttonSubmit");
  }
}