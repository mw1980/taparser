package org.mrr.reader;

import org.junit.Test;
import org.mrr.IdentificationType;
import org.mrr.ReadSpecificationException;
import org.mrr.controls.Control;
import org.mrr.controls.ControlsCsvAgent;
import org.mrr.controls.Locator;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ControlsCsvAgentTest {

    @Test(expected = ReadSpecificationException.class)
    public void whenReadFromNoExistingFile_shouldThrowException() {
        new ControlsCsvAgent("notExistingFile").supply();
    }

    @Test
    public void whenReadingFromEmptyFile_shouldReturnEmptyList() {
        final String filePath = TestConstants.TEST_RESOURCE_FOLDER_LOCATION + "EmptyElementIdentifiersFile.csv";
        final Map<String, Control> elementsFromFile = new ControlsCsvAgent(filePath).supply();
        assertThat(elementsFromFile).isEmpty();
    }

    @Test
    public void whenReadingFromCorrectFile_shouldReturnAllElements() {
        final String filePath = TestConstants.TEST_RESOURCE_FOLDER_LOCATION + "ElementIdentifiers.csv";
        final Map<String, Control> elementsFromFile = new ControlsCsvAgent(filePath).supply();
        assertThat(firstCsvElement()).isEqualTo(elementsFromFile.get("user"));
        assertThat(secondCsvElement()).isEqualTo(elementsFromFile.get("password"));
        assertThat(thirdCsvElement()).isEqualTo(elementsFromFile.get("submit"));
    }

    private Control firstCsvElement() {
        return new Control("user",
                new Locator(IdentificationType.ID, "userNameHtmlId"));
    }

    private Control secondCsvElement() {
        return new Control("password",
                new Locator(IdentificationType.ID, "userPassHtmlId"));
    }

    private Control thirdCsvElement() {
        return new Control("submit",
                new Locator(IdentificationType.ID, "submitButtonId"));
    }
}