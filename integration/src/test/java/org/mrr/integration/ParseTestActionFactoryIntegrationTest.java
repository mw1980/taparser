package org.mrr.integration;

import org.junit.Test;
import org.mrr.AbstractParseTestActionOperationTemplate;
import org.mrr.ParseClickButtonOperation;
import org.mrr.ParseClickRadioButtonOperation;
import org.mrr.ParseDeselectCheckboxOperation;
import org.mrr.ParseEditTextfieldOperation;
import org.mrr.ParseLoadPageActionOperation;
import org.mrr.ParseSelectCheckboxOperation;
import org.mrr.ParseSelectDropdownOperation;
import org.mrr.ParseTestActionFactory;
import org.mrr.ParseTestActionFactoryImpl;
import org.mrr.ParseTestActionOperation;
import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParseTestActionFactoryIntegrationTest {
    private final ParseTestActionFactory parserFactory;

    public ParseTestActionFactoryIntegrationTest() {
        final ApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        this.parserFactory = context.getBean("parseTestActionFactory", ParseTestActionFactoryImpl.class);
    }

    @Test
    public void whenCreatingInstanceWithLoadPageDescription_shouldReturnLoadPageParser() throws Exception {
        final ParseTestActionOperation parser = this.parserFactory.parseOperationFromDescription("Load page www.myurl.com");
        assertTrue(parser instanceof ParseLoadPageActionOperation);
    }

    @Test
    public void whenCreatingInstanceWithEditTextDescription_shouldReturnEditTextParser() {
        final ParseTestActionOperation parser = this.parserFactory.parseOperationFromDescription("Set in textfield myfield value 20");
        assertTrue(parser instanceof ParseEditTextfieldOperation);
    }

    @Test
    public void whenCreatingNewInstanceWithClickButtonText_shouldReturnClickButtonStepParserCommand() {
        final ParseTestActionOperation parser = parserFactory.parseOperationFromDescription("Click button submit");
        assertTrue(parser instanceof ParseClickButtonOperation);
    }

    @Test
    public void whenCreatingInstanceWithSelectDropdownText_shouldReturnSelectDropdownStepParser() {
        final ParseTestActionOperation parser = parserFactory.parseOperationFromDescription("Select in dropdown clients value \"johnie walker\"");
        assertTrue(parser instanceof ParseSelectDropdownOperation);
    }

    @Test
    public void whenCreatingInstanceWithSelectCheckboxText_shouldReturnSelectCheckboxStepParser() {
        final ParseTestActionOperation parser = parserFactory.parseOperationFromDescription("Select checkbox iAgree");
        assertTrue(parser instanceof ParseSelectCheckboxOperation);
    }

    @Test
    public void whenCreatingInstanceWithDeselectCheckboxText_shouldReturnDeselectCheckboxStepParser() {
        final ParseTestActionOperation parser = parserFactory.parseOperationFromDescription("Deselect checkbox iAgree");
        assertTrue(parser instanceof ParseDeselectCheckboxOperation);
    }

    @Test
    public void whenCreatingInstanceWithSelectRadioButtonText_shouldReturnClickRadioButtonParser() {
        final ParseTestActionOperation parser = parserFactory.parseOperationFromDescription("Select radio button perEmail");
        assertTrue(parser instanceof ParseClickRadioButtonOperation);
    }

    @Test
    public void whenCreatingParserForUnknownAction_shouldReturnUnknownAction() {
        assertEquals(AbstractParseTestActionOperationTemplate.UNKNOWN, parserFactory.parseOperationFromDescription("unknown action"));
    }
}