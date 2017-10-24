package org.mrr.integration;

import org.junit.Test;
import org.mrr.AbstractParseActionOperationTemplate;
import org.mrr.ParseActionFactory;
import org.mrr.ParseActionFactoryImpl;
import org.mrr.ParseActionOperation;
import org.mrr.ParseClickButtonOperation;
import org.mrr.ParseClickRadioButtonOperation;
import org.mrr.ParseDeselectCheckboxOperation;
import org.mrr.ParseEditTextfieldOperation;
import org.mrr.ParseLoadPageActionOperation;
import org.mrr.ParseSelectCheckboxOperation;
import org.mrr.ParseSelectDropdownOperation;
import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParseActionFactoryIntegrationTest {
    private final ParseActionFactory parserFactory;

    public ParseActionFactoryIntegrationTest() {
        final ApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        this.parserFactory = context.getBean("parseActionFactory", ParseActionFactoryImpl.class);
    }

    @Test
    public void whenCreatingInstanceWithLoadPageDescription_shouldReturnLoadPageParser() throws Exception {
        final ParseActionOperation parser = this.parserFactory.parseOperationFromDescription("Load page www.myurl.com");
        assertTrue(parser instanceof ParseLoadPageActionOperation);
    }

    @Test
    public void whenCreatingInstanceWithEditTextDescription_shouldReturnEditTextParser() {
        final ParseActionOperation parser = this.parserFactory.parseOperationFromDescription("Set in textfield myfield value 20");
        assertTrue(parser instanceof ParseEditTextfieldOperation);
    }

    @Test
    public void whenCreatingNewInstanceWithClickButtonText_shouldReturnClickButtonStepParserCommand() {
        final ParseActionOperation parser = parserFactory.parseOperationFromDescription("Click button submit");
        assertTrue(parser instanceof ParseClickButtonOperation);
    }

    @Test
    public void whenCreatingInstanceWithSelectDropdownText_shouldReturnSelectDropdownStepParser() {
        final ParseActionOperation parser = parserFactory.parseOperationFromDescription("Select in dropdown clients value \"johnie walker\"");
        assertTrue(parser instanceof ParseSelectDropdownOperation);
    }

    @Test
    public void whenCreatingInstanceWithSelectCheckboxText_shouldReturnSelectCheckboxStepParser() {
        final ParseActionOperation parser = parserFactory.parseOperationFromDescription("Select checkbox iAgree");
        assertTrue(parser instanceof ParseSelectCheckboxOperation);
    }

    @Test
    public void whenCreatingInstanceWithDeselectCheckboxText_shouldReturnDeselectCheckboxStepParser() {
        final ParseActionOperation parser = parserFactory.parseOperationFromDescription("Deselect checkbox iAgree");
        assertTrue(parser instanceof ParseDeselectCheckboxOperation);
    }

    @Test
    public void whenCreatingInstanceWithSelectRadioButtonText_shouldReturnClickRadioButtonParser() {
        final ParseActionOperation parser = parserFactory.parseOperationFromDescription("Select radio button perEmail");
        assertTrue(parser instanceof ParseClickRadioButtonOperation);
    }

    @Test
    public void whenCreatingParserForUnknownAction_shouldReturnUnknownAction() {
        assertEquals(AbstractParseActionOperationTemplate.UNKNOWN, parserFactory.parseOperationFromDescription("unknown action"));
    }
}