package org.mrr.parser;

import org.junit.Test;
import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mrr.parser.AbstractTestStepParserTemplate.UNKNOWN;

public class TestStepParserFactoryImplIntegrationTest {
    private final TestStepParserFactory parserFactory;

    public TestStepParserFactoryImplIntegrationTest() {
        final ApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        this.parserFactory = context.getBean("testStepParserAgent", TestStepParserFactoryImpl.class);
    }

    @Test
    public void whenCreatingInstanceWithLoadPageDescription_shouldReturnLoadPageParser() throws Exception {
        final TestStepParser parser = this.parserFactory.deliverParser("Load page www.myurl.com");
        assertTrue(parser instanceof LoadPageStepParser);
    }

    @Test
    public void whenCreatingInstanceWithEditTextDescription_shouldReturnEditTextParser() {
        final TestStepParser parser = this.parserFactory.deliverParser("Set in textfield myfield value 20");
        assertTrue(parser instanceof EditTextfieldStepParserTemplate);
    }

    @Test
    public void whenCreatingNewInstanceWithClickButtonText_shouldReturnClickButtonStepParserCommand() {
        final TestStepParser parser = parserFactory.deliverParser("Click button submit");
        assertTrue(parser instanceof ClickButtonStepParser);
    }

    @Test
    public void whenCreatingInstanceWithSelectDropdownText_shouldReturnSelectDropdownStepParser() {
        final TestStepParser parser = parserFactory.deliverParser("Select in dropdown clients value \"johnie walker\"");
        assertTrue(parser instanceof SelectDropdownStepParserTemplate);
    }

    @Test
    public void whenCreatingInstanceWithSelectCheckboxText_shouldReturnSelectCheckboxStepParser() {
        final TestStepParser parser = parserFactory.deliverParser("Select checkbox iAgree");
        assertTrue(parser instanceof SelectCheckboxStepParser);
    }

    @Test
    public void whenCreatingInstanceWithDeselectCheckboxText_shouldReturnDeselectCheckboxStepParser() {
        final TestStepParser parser = parserFactory.deliverParser("Deselect checkbox iAgree");
        assertTrue(parser instanceof DeselectCheckboxStepParser);
    }

    @Test
    public void whenCreatingInstanceWithSelectRadioButtonText_shouldReturnClickRadioButtonParser() {
        final TestStepParser parser = parserFactory.deliverParser("Select radio button perEmail");
        assertTrue(parser instanceof ClickRadioButtonStepParser);
    }

    @Test
    public void whenCreatingParserForUnknownAction_shouldReturnUnknownAction() {
        assertEquals(UNKNOWN, parserFactory.deliverParser("unknown action"));
    }
}