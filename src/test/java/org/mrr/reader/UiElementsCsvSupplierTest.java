package org.mrr.reader;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mrr.IdentificationType;
import org.mrr.ReadSpecificationException;
import org.mrr.uielements.UiElement;
import org.mrr.uielements.UiElementsCsvSupplier;

import java.util.Map;

public class UiElementsCsvSupplierTest {

  @Test(expected = ReadSpecificationException.class)
  public void whenReadFromNoExistingFile_shouldThrowException() {
    new UiElementsCsvSupplier("notExistingFile").createUiElements();
  }

  @Test
  public void whenReadingFromEmptyFile_shouldReturnEmptyList() {
    final String filePath = TestConstants.PATH_TO_TEST_RESOURCE_FOLDER + "EmptyElementIdentifiersFile.csv";
    final Map<String, UiElement> elementsFromFile = new UiElementsCsvSupplier(filePath).createUiElements();
    assertThat(elementsFromFile).isEmpty();
  }

  @Test
  public void whenReadingFromCorrectFile_shouldReturnAllElements() {
    final String filePath = TestConstants.PATH_TO_TEST_RESOURCE_FOLDER + "ElementIdentifiers.csv";
    final Map<String, UiElement> elementsFromFile = new UiElementsCsvSupplier(filePath).createUiElements();
    assertThat(firstCsvElement()).isEqualTo(elementsFromFile.get("user"));
    assertThat(secondCsvElement()).isEqualTo(elementsFromFile.get("password"));
    assertThat(thirdCsvElement()).isEqualTo(elementsFromFile.get("submit"));
  }

  private UiElement firstCsvElement() {
    return new UiElement("user", IdentificationType.ID, "userNameHtmlId");
  }

  private UiElement secondCsvElement() {
    return new UiElement("password", IdentificationType.ID, "userPassHtmlId");
  }

  private UiElement thirdCsvElement() {
    return new UiElement("submit", IdentificationType.ID, "submitButtonId");
  }
}