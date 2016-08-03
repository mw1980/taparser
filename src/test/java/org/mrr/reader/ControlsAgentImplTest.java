package org.mrr.reader;

import org.hamcrest.core.IsNull;
import org.junit.Ignore;
import org.junit.Test;
import org.mrr.core.IdentificationCriteria;
import org.mrr.ReadSpecificationException;
import org.mrr.config.ApplicationConfig;
import org.mrr.controls.ControlsAgentImpl;
import org.mrr.controls.api.ControlsAgent;
import org.mrr.controls.api.UiControl;
import org.mrr.controls.api.UiLocator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class ControlsAgentImplTest {

    @Test
    public void checkSpringInjection(){
        final ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        ControlsAgent controlsAgent = context.getBean("controlsAgentImpl", ControlsAgentImpl.class);
        final Map<String, UiControl> controls = controlsAgent.supply();
        assertThat(controls, IsNull.notNullValue());
        System.out.println(controls);

    }

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
                new UiLocator(IdentificationCriteria.ID, "userNameHtmlId"));
    }

    private UiControl secondCsvElement() {
        return new UiControl("password",
                new UiLocator(IdentificationCriteria.ID, "userPassHtmlId"));
    }

    private UiControl thirdCsvElement() {
        return new UiControl("submit",
                new UiLocator(IdentificationCriteria.ID, "submitButtonId"));
    }
}