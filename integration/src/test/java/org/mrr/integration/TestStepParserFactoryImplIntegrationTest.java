package org.mrr.integration;

import org.junit.Test;
import org.mrr.AbstractTestStepParserTemplate;
import org.mrr.ClickButtonStepParser;
import org.mrr.ClickRadioButtonStepParser;
import org.mrr.DeselectCheckboxStepParser;
import org.mrr.EditTextfieldStepParserTemplate;
import org.mrr.LoadPageStepParser;
import org.mrr.SelectCheckboxStepParser;
import org.mrr.SelectDropdownStepParserTemplate;
import org.mrr.TestStepParser;
import org.mrr.TestStepParserFactory;
import org.mrr.TestStepParserFactoryImpl;
import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestStepParserFactoryImplIntegrationTest {
    private final TestStepParserFactory parserFactory;

    public TestStepParserFactoryImplIntegrationTest() {
        final ApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        this.parserFactory = context.getBean("testStepParserAgent", TestStepParserFactoryImpl.class);
    }

    @Test
    public void whenCreatingInstanceWithLoadPageDescription_shouldReturnLoadPageParser() throws Exception {
        final TestStepParser parser = this.parserFactory.parserForDescription("Load page www.myurl.com");
        assertTrue(parser instanceof LoadPageStepParser);
    }

    @Test
    public void whenCreatingInstanceWithEditTextDescription_shouldReturnEditTextParser() {
        final TestStepParser parser = this.parserFactory.parserForDescription("Set in textfield myfield value 20");
        assertTrue(parser instanceof EditTextfieldStepParserTemplate);
    }

    @Test
    public void whenCreatingNewInstanceWithClickButtonText_shouldReturnClickButtonStepParserCommand() {
        final TestStepParser parser = parserFactory.parserForDescription("Click button submit");
        assertTrue(parser instanceof ClickButtonStepParser);
    }

    @Test
    public void whenCreatingInstanceWithSelectDropdownText_shouldReturnSelectDropdownStepParser() {
        final TestStepParser parser = parserFactory.parserForDescription("Select in dropdown clients value \"johnie walker\"");
        assertTrue(parser instanceof SelectDropdownStepParserTemplate);
    }

    @Test
    public void whenCreatingInstanceWithSelectCheckboxText_shouldReturnSelectCheckboxStepParser() {
        final TestStepParser parser = parserFactory.parserForDescription("Select checkbox iAgree");
        assertTrue(parser instanceof SelectCheckboxStepParser);
    }

    @Test
    public void whenCreatingInstanceWithDeselectCheckboxText_shouldReturnDeselectCheckboxStepParser() {
        final TestStepParser parser = parserFactory.parserForDescription("Deselect checkbox iAgree");
        assertTrue(parser instanceof DeselectCheckboxStepParser);
    }

    @Test
    public void whenCreatingInstanceWithSelectRadioButtonText_shouldReturnClickRadioButtonParser() {
        final TestStepParser parser = parserFactory.parserForDescription("Select radio button perEmail");
        assertTrue(parser instanceof ClickRadioButtonStepParser);
    }

    @Test
    public void whenCreatingParserForUnknownAction_shouldReturnUnknownAction() {
        assertEquals(AbstractTestStepParserTemplate.UNKNOWN, parserFactory.parserForDescription("unknown action"));
    }
}