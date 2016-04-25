package org.mrr;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mrr.reader.TestConstants.PATH_TO_TEST_RESOURCE_FOLDER;

import org.junit.After;
import org.junit.Test;

import java.util.Map;

public class IdentifierStoreTest {

  @Test
  public void whenReadingCorrectIdentifiers_shouldSaveThemAsExpected() {
    final String filePath = PATH_TO_TEST_RESOURCE_FOLDER + "ElementIdentifiers.csv";
    Map<String, Identifier> identifiers = new IdentifierStore(filePath).getStoredElements();
    assertThat(identifiers.get("name")).isEqualTo(new Identifier("name", IdentificationType.BY_ID, "userNameHtmlId"));
  }

  @Test(expected = IdentifierValueNotFoundException.class)
  public void whenReadingMalformedIdentifiers_shouldThrowTestSpecificationReaderException() {
    final String filePath = PATH_TO_TEST_RESOURCE_FOLDER + "MalformedIdentifiers.csv";
    new IdentifierStore(filePath).getStoredElements();
  }

}