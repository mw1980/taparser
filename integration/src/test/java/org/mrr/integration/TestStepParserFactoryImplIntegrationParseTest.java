package org.mrr.integration;

import org.junit.Test;
import org.mrr.AbstractParseTestActionOperationTemplate;
import org.mrr.LoadPageActionOperationParse;
import org.mrr.ParseClickButtonOperation;
import org.mrr.ParseClickRadioButtonOperation;
import org.mrr.ParseDeselectCheckboxOperation;
import org.mrr.ParseEditTextfieldOperation;
import org.mrr.ParseSelectCheckboxOperation;
import org.mrr.ParseSelectDropdownOperation;
import org.mrr.ParseTestActionOperation;
import org.mrr.TestStepParserFactory;
import org.mrr.TestStepParserFactoryImpl;
import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestStepParserFactoryImplIntegrationParseTest {
    private final TestStepParserFactory parserFactory;

    public TestStepParserFactoryImplIntegrationParseTest() {
        final ApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        this.parserFactory = context.getBean("testStepParserAgent", TestStepParserFactoryImpl.class);
    }

    @Test
    public void whenCreatingInstanceWithLoadPageDescription_shouldReturnLoadPageParser() throws Exception {
        final ParseTestActionOperation parser = this.parserFactory.parserForDescription("Load page www.myurl.com");
        assertTrue(parser instanceof LoadPageActionOperationParse);
    }

    @Test
    public void whenCreatingInstanceWithEditTextDescription_shouldReturnEditTextParser() {
        final ParseTestActionOperation parser = this.parserFactory.parserForDescription("Set in textfield myfield value 20");
        assertTrue(parser instanceof ParseEditTextfieldOperation);
    }

    @Test
    public void whenCreatingNewInstanceWithClickButtonText_shouldReturnClickButtonStepParserCommand() {
        final ParseTestActionOperation parser = parserFactory.parserForDescription("Click button submit");
        assertTrue(parser instanceof ParseClickButtonOperation);
    }

    @Test
    public void whenCreatingInstanceWithSelectDropdownText_shouldReturnSelectDropdownStepParser() {
        final ParseTestActionOperation parser = parserFactory.parserForDescription("Select in dropdown clients value \"johnie walker\"");
        assertTrue(parser instanceof ParseSelectDropdownOperation);
    }

    @Test
    public void whenCreatingInstanceWithSelectCheckboxText_shouldReturnSelectCheckboxStepParser() {
        final ParseTestActionOperation parser = parserFactory.parserForDescription("Select checkbox iAgree");
        assertTrue(parser instanceof ParseSelectCheckboxOperation);
    }

    @Test
    public void whenCreatingInstanceWithDeselectCheckboxText_shouldReturnDeselectCheckboxStepParser() {
        final ParseTestActionOperation parser = parserFactory.parserForDescription("Deselect checkbox iAgree");
        assertTrue(parser instanceof ParseDeselectCheckboxOperation);
    }

    @Test
    public void whenCreatingInstanceWithSelectRadioButtonText_shouldReturnClickRadioButtonParser() {
        final ParseTestActionOperation parser = parserFactory.parserForDescription("Select radio button perEmail");
        assertTrue(parser instanceof ParseClickRadioButtonOperation);
    }

    @Test
    public void whenCreatingParserForUnknownAction_shouldReturnUnknownAction() {
        assertEquals(AbstractParseTestActionOperationTemplate.UNKNOWN, parserFactory.parserForDescription("unknown action"));
    }
}