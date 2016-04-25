package org.mrr;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mrr.reader.TestConstants.PATH_TO_TEST_RESOURCE_FOLDER;

import org.junit.Test;
import org.mrr.uielements.UiElement;
import org.mrr.uielements.UiElementNotFoundException;
import org.mrr.uielements.UiElementsCsvSupplier;
import org.mrr.uielements.UiElementsStore;

import java.util.Map;

public class UiElementDepositTest {

  @Test
  public void whenReadingCorrectIdentifiers_shouldSaveThemAsExpected() {
    final String filePath = PATH_TO_TEST_RESOURCE_FOLDER + "ElementIdentifiers.csv";
    Map<String, UiElement> elements = new UiElementsStore(new UiElementsCsvSupplier(filePath)).articles();
    assertThat(elements.get("name")).isEqualTo(new UiElement("name", IdentificationType.ID, "userNameHtmlId"));
  }

  @Test(expected = UiElementNotFoundException.class)
  public void whenReadingMalformedIdentifiers_shouldThrowTestSpecificationReaderException() {
    final String location = PATH_TO_TEST_RESOURCE_FOLDER + "MalformedIdentifiers.csv";
    new UiElementsStore(new UiElementsCsvSupplier(location)).articles();
  }

}