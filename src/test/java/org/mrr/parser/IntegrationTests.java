package org.mrr.parser;

import org.junit.Test;
import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertTrue;

public class IntegrationTests {
    private final TestStepParserFactory parserAgent;

    public IntegrationTests() {
        final ApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        this.parserAgent = context.getBean("testStepParserAgent", TestStepParserFactoryImpl.class);
    }

    @Test
    public void whenCreatingInstanceWithLoadPageDescription_shouldReturnLoadPageParser() throws Exception {
        final TestStepParser parser = this.parserAgent.deliverParserForDescription("Load page www.myurl.com");
        assertTrue(parser instanceof LoadPageStepParser);
    }

    @Test
    public void whenCreatingInstanceWithEditTextDescription_shouldReturnEditTextParser() {
        final TestStepParser parser = this.parserAgent.deliverParserForDescription("Set in textfield myfield value 20");
        assertTrue(parser instanceof EditTextfieldStepParserTemplate);
    }

    @Test
    public void whenCreatingNewInstanceWithClickButtonText_shouldReturnClickButtonStepParserCommand() {
        final TestStepParser parser = parserAgent.deliverParserForDescription("Click button submit");
        assertTrue(parser instanceof ClickButtonStepParser);
    }

    @Test
    public void whenCreatingInstanceWithSelectDropdownText_shouldReturnSelectDropdownStepParser() {
        final TestStepParser parser = parserAgent.deliverParserForDescription("Select in dropdown clients value \"johnie walker\"");
        assertTrue(parser instanceof SelectDropdownStepParserTemplate);
    }

    @Test
    public void whenCreatingInstanceWithSelectCheckboxText_shouldReturnSelectCheckboxStepParser() {
        final TestStepParser parser = parserAgent.deliverParserForDescription("Select checkbox iAgree");
        assertTrue(parser instanceof SelectCheckboxStepParser);
    }

    @Test
    public void whenCreatingInstanceWithDeselectCheckboxText_shouldReturnDeselectCheckboxStepParser() {
        final TestStepParser parser = parserAgent.deliverParserForDescription("Deselect checkbox iAgree");
        assertTrue(parser instanceof DeselectCheckboxStepParser);
    }

    @Test
    public void whenCreatingInstanceWithSelectRadioButtonText_shouldReturnClickRadioButtonParser() {
        final TestStepParser parser = parserAgent.deliverParserForDescription("Select radio button perEmail");
        assertTrue(parser instanceof ClickRadioButtonStepParser);
    }
}