package org.mrr.integration;

import org.junit.Before;
import org.junit.Test;
import org.mrr.CodeGeneratorFactory;
import org.mrr.NoCodeGeneratorFoundException;
import org.mrr.TestStepCodeGenerator;
import org.mrr.config.ApplicationConfig;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;
import org.mrr.selenium.ClickButtonCodeGenerator;
import org.mrr.selenium.DeselectCheckboxCodeGenerator;
import org.mrr.selenium.EditTextfieldCodeGenerator;
import org.mrr.selenium.LoadPageCodeGenerator;
import org.mrr.selenium.SelectCheckboxCodeGenerator;
import org.mrr.selenium.SelectInDropdownCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertTrue;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.EDIT_TEXT;
import static org.mrr.core.domain.ActionType.LOAD_PAGE;

public class CodeGeneratorFactoryIntegrationTest {
    private CodeGeneratorFactory codeGeneratorFactory;

    @Before
    public void setup() {
        final ApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        codeGeneratorFactory = context.getBean("codeGeneratorFactory", CodeGeneratorFactory.class);
    }

    @Test
    public void whenCreatingInstanceForLoadPageTestStep_shouldReturnLoadPageCodeGenerator() {
        final TestStep testStep = new TestStep(LOAD_PAGE, "");
        final TestStepCodeGenerator codeGenerator = codeGeneratorFactory.codeGeneratorForTestStep(testStep);
        assertTrue(codeGenerator instanceof LoadPageCodeGenerator);
    }

    @Test
    public void whenCreatingInstanceForEditTextTestStep_shouldReturnEditTextCodeGenerator() {
        final TestStep testStep = new TestStep(EDIT_TEXT, "");
        final TestStepCodeGenerator codeGenerator = codeGeneratorFactory.codeGeneratorForTestStep(testStep);
        assertTrue(codeGenerator instanceof EditTextfieldCodeGenerator);
    }

    @Test
    public void whenCreatingInstanceForClickButtonTestStep_shouldReturnClickButtonCodeGenerator() {
        final TestStep testStep = new TestStep(CLICK_BUTTON, "");
        final TestStepCodeGenerator codeGenerator = codeGeneratorFactory.codeGeneratorForTestStep(testStep);
        assertTrue(codeGenerator instanceof ClickButtonCodeGenerator);
    }

    @Test
    public void whenCreatingInstanceForSelectInDropdownTestStep_shouldReturnSelectInDropdownGenerator() {
        final TestStep testStep = new TestStep(ActionType.SELECT_IN_DROPDOWN, "");
        final TestStepCodeGenerator codeGenerator = codeGeneratorFactory.codeGeneratorForTestStep(testStep);
        assertTrue(codeGenerator instanceof SelectInDropdownCodeGenerator);
    }

    @Test
    public void whenCreatingInstanceForSelectCheckboxTestStep_shouldReturnSelectCheckboxCodeGenerator() {
        final TestStep testStep = new TestStep(ActionType.SELECT_CHECKBOX, "");
        final TestStepCodeGenerator codeGenerator = codeGeneratorFactory.codeGeneratorForTestStep(testStep);
        assertTrue(codeGenerator instanceof SelectCheckboxCodeGenerator);
    }

    @Test
    public void whenCreatingInstanceForDeselectCheckboxTestStep_shouldReturnDeselectCheckboxCodeGenerator() {
        final TestStep testStep = new TestStep(ActionType.DESELECT_CHECKBOX, "");
        final TestStepCodeGenerator codeGenerator = codeGeneratorFactory.codeGeneratorForTestStep(testStep);
        assertTrue(codeGenerator instanceof DeselectCheckboxCodeGenerator);
    }

    @Test(expected = NoCodeGeneratorFoundException.class)
    public void whenCreatingGeneratorForUnknownAction_shouldThrowException() {
        codeGeneratorFactory.codeGeneratorForTestStep(new TestStep(ActionType.UNKNOWN, ""));
    }
}
