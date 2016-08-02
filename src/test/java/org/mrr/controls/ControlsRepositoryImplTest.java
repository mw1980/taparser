package org.mrr.controls;

import org.junit.Ignore;
import org.junit.Test;
import org.mrr.controls.api.LoadControlsException;

import static org.mrr.reader.TestConstants.TEST_RESOURCE_FOLDER_LOCATION;

public class ControlsRepositoryImplTest {

    @Test
    @Ignore
    public void whenReadingCorrectIdentifiers_shouldSaveThemAsExpected() {
        final String filePath = TEST_RESOURCE_FOLDER_LOCATION + "ElementIdentifiers.csv";

        //TODO: mock hier the controlAgent after switching to spring.
        //Map<String, UiControl> elements = new ControlsRepositoryImpl(new ControlsAgentImpl(filePath)).controls();
        //assertThat(elements.get("name")).isEqualTo(new UiControl("name",
        //        new UiLocator(IdentificationType.ID, "userNameHtmlId")));
    }

    @Test(expected = LoadControlsException.class)
    @Ignore
    public void whenReadingMalformedIdentifiers_shouldThrowTestSpecificationReaderException() {
        final String location = TEST_RESOURCE_FOLDER_LOCATION + "MalformedIdentifiers.csv";
        //new ControlsRepositoryImpl(new ControlsAgentImpl(location)).controls();
    }
}