package org.mrr;

import java.util.Map;

import org.junit.Test;
import org.mrr.reader.TestConstants;

import static org.assertj.core.api.Assertions.assertThat;

public class IdentifierStoreTest {

  @Test
  public void whenReadingCorrectIdentifiers_shouldSaveThemAsExpected() {
    final String filePath = TestConstants.PATH_TO_TEST_RESOURCE_FOLDER + "ElementIdentifiers.csv";
    Map<String, Identifier> identifiers = new IdentifierStore(filePath).getStoredElements();
    assertThat(identifiers.get("name")).isEqualTo(new Identifier("name", IdentificationType.BY_ID, "userNameHtmlId"));
  }

  @Test(expected = IdentifierValueNotFoundException.class)
  public void whenReadingMalformedIdentifiers_shouldThrowTestSpecificationReaderException() {
    final String filePath = TestConstants.PATH_TO_TEST_RESOURCE_FOLDER + "MalformedIdentifiers.csv";
    new IdentifierStore(filePath).getStoredElements();
  }
}