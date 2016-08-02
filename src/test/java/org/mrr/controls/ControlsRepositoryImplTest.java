package org.mrr.controls;

import org.junit.Test;
import org.mrr.IdentificationType;
import org.mrr.controls.api.ControlsPoolException;
import org.mrr.controls.api.Locator;
import org.mrr.controls.api.UiControl;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mrr.reader.TestConstants.TEST_RESOURCE_FOLDER_LOCATION;

public class ControlsRepositoryImplTest {

    @Test
    public void whenReadingCorrectIdentifiers_shouldSaveThemAsExpected() {
        final String filePath = TEST_RESOURCE_FOLDER_LOCATION + "ElementIdentifiers.csv";
        //TODO: mock hier the controlAgent after switching to spring.
        Map<String, UiControl> elements = new ControlsRepositoryImpl(new ControlsCsvAgent(filePath)).controls();
        assertThat(elements.get("name")).isEqualTo(new UiControl("name",
                new Locator(IdentificationType.ID, "userNameHtmlId")));
    }

    @Test(expected = ControlsPoolException.class)
    public void whenReadingMalformedIdentifiers_shouldThrowTestSpecificationReaderException() {
        final String location = TEST_RESOURCE_FOLDER_LOCATION + "MalformedIdentifiers.csv";
        new ControlsRepositoryImpl(new ControlsCsvAgent(location)).controls();
    }
}