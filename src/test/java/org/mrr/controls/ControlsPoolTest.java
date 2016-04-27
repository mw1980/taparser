package org.mrr.controls;

import org.junit.Test;
import org.mrr.IdentificationType;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mrr.reader.TestConstants.TEST_RESOURCE_FOLDER_LOCATION;

public class ControlsPoolTest {

    @Test
    public void whenReadingCorrectIdentifiers_shouldSaveThemAsExpected() {
        final String filePath = TEST_RESOURCE_FOLDER_LOCATION + "ElementIdentifiers.csv";
        //TODO: mock hier the controlAgent after switching to spring.
        Map<String, Control> elements = new ControlsPool(new ControlsCsvAgent(filePath)).controls();
        assertThat(elements.get("name")).isEqualTo(new Control("name",
                new Locator(IdentificationType.ID, "userNameHtmlId")));
    }

    @Test(expected = ControlsPoolException.class)
    public void whenReadingMalformedIdentifiers_shouldThrowTestSpecificationReaderException() {
        final String location = TEST_RESOURCE_FOLDER_LOCATION + "MalformedIdentifiers.csv";
        new ControlsPool(new ControlsCsvAgent(location)).controls();
    }
}