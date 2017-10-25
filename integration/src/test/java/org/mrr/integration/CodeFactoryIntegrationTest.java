package org.mrr.integration;

import org.junit.Before;
import org.junit.Test;
import org.mrr.DefaultCodeFactory;
import org.mrr.api.CodeOperationNotFoundException;
import org.mrr.api.GenerateActionCodeOperation;
import org.mrr.config.ApplicationConfig;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;
import org.mrr.selenium.CodedClickButtonOperation;
import org.mrr.selenium.CodedDeselectCheckboxOperation;
import org.mrr.selenium.CodedEditTextfieldOperation;
import org.mrr.selenium.CodedLoadPageOperation;
import org.mrr.selenium.CodedSelectCheckboxOperation;
import org.mrr.selenium.CodedSelectInDropdownOperation;
import org.mrr.selenium.DefaultUiUnitTest;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.EDIT_TEXT;
import static org.mrr.core.domain.ActionType.LOAD_PAGE;

public class CodeFactoryIntegrationTest {
    private DefaultCodeFactory factory;
    private ApplicationContext context;

    @Before
    public void setup() {
        context = SpringApplication.run(ApplicationConfig.class);
        factory = context.getBean("defaultCodeFactory", DefaultCodeFactory.class);
    }

    @Test
    public void whenCreatingInstanceForLoadPageTestStep_shouldReturnLoadPageCodeGenerator() {
        final Action action = new Action(LOAD_PAGE, "");
        final GenerateActionCodeOperation codeGenerator = factory.codeGenerationOperationFor(action);
        assertTrue(codeGenerator instanceof CodedLoadPageOperation);
    }

    @Test
    public void whenCreatingInstanceForEditTextTestStep_shouldReturnEditTextCodeGenerator() {
        final Action action = new Action(EDIT_TEXT, "");
        final GenerateActionCodeOperation codeGenerator = factory.codeGenerationOperationFor(action);
        assertTrue(codeGenerator instanceof CodedEditTextfieldOperation);
    }

    @Test
    public void whenCreatingInstanceForClickButtonTestStep_shouldReturnClickButtonCodeGenerator() {
        final Action action = new Action(CLICK_BUTTON, "");
        final GenerateActionCodeOperation codeGenerator = factory.codeGenerationOperationFor(action);
        assertTrue(codeGenerator instanceof CodedClickButtonOperation);
    }

    @Test
    public void whenCreatingInstanceForSelectInDropdownTestStep_shouldReturnSelectInDropdownGenerator() {
        final Action action = new Action(ActionType.SELECT_IN_DROPDOWN, "");
        final GenerateActionCodeOperation codeGenerator = factory.codeGenerationOperationFor(action);
        assertTrue(codeGenerator instanceof CodedSelectInDropdownOperation);
    }

    @Test
    public void whenCreatingInstanceForSelectCheckboxTestStep_shouldReturnSelectCheckboxCodeGenerator() {
        final Action action = new Action(ActionType.SELECT_CHECKBOX, "");
        final GenerateActionCodeOperation codeGenerator = factory.codeGenerationOperationFor(action);
        assertTrue(codeGenerator instanceof CodedSelectCheckboxOperation);
    }

    @Test
    public void whenCreatingInstanceForDeselectCheckboxTestStep_shouldReturnDeselectCheckboxCodeGenerator() {
        final Action action = new Action(ActionType.DESELECT_CHECKBOX, "");
        final GenerateActionCodeOperation codeGenerator = factory.codeGenerationOperationFor(action);
        assertTrue(codeGenerator instanceof CodedDeselectCheckboxOperation);
    }

    @Test(expected = CodeOperationNotFoundException.class)
    public void whenCreatingGeneratorForUnknownAction_shouldThrowException() {
        factory.codeGenerationOperationFor(new Action(ActionType.UNKNOWN, ""));
    }

    @Test
    public void shouldInjectTheDefaultUiTest() {
        assertThat(
                context.getBean("defaultUiUnitTest", DefaultUiUnitTest.class),
                notNullValue());
    }
}
