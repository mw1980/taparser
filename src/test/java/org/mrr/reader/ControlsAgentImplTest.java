package org.mrr.reader;

import org.junit.Ignore;
import org.junit.Test;
import org.mrr.IdentificationType;
import org.mrr.ReadSpecificationException;
import org.mrr.controls.api.UiControl;
import org.mrr.controls.api.UiLocator;

public class ControlsAgentImplTest {

    @Test(expected = ReadSpecificationException.class)
    @Ignore
    public void whenReadFromNoExistingFile_shouldThrowException() {
        //new ControlsAgentImpl("notExistingFile").supply();
    }

    @Test
    @Ignore
    public void whenReadingFromEmptyFile_shouldReturnEmptyList() {
        final String filePath = TestConstants.TEST_RESOURCE_FOLDER_LOCATION + "EmptyElementIdentifiersFile.csv";
        //final Map<String, UiControl> elementsFromFile = new ControlsAgentImpl(filePath).supply();
        //assertThat(elementsFromFile).isEmpty();
    }

    @Test
    @Ignore
    public void whenReadingFromCorrectFile_shouldReturnAllElements() {
        final String filePath = TestConstants.TEST_RESOURCE_FOLDER_LOCATION + "ElementIdentifiers.csv";
        //final Map<String, UiControl> elementsFromFile = new ControlsAgentImpl(filePath).supply();
        //assertThat(firstCsvElement()).isEqualTo(elementsFromFile.get("user"));
        ///assertThat(secondCsvElement()).isEqualTo(elementsFromFile.get("password"));
        //assertThat(thirdCsvElement()).isEqualTo(elementsFromFile.get("submit"));
    }

    private UiControl firstCsvElement() {
        return new UiControl("user",
                new UiLocator(IdentificationType.ID, "userNameHtmlId"));
    }

    private UiControl secondCsvElement() {
        return new UiControl("password",
                new UiLocator(IdentificationType.ID, "userPassHtmlId"));
    }

    private UiControl thirdCsvElement() {
        return new UiControl("submit",
                new UiLocator(IdentificationType.ID, "submitButtonId"));
    }
}