package org.mrr.generator;

import org.junit.Before;
import org.junit.Test;
import org.mrr.config.ApplicationConfig;
import org.mrr.core.domain.ActionType;
import org.mrr.core.domain.TestStep;
import org.mrr.generator.selenium.ClickButtonCodeGenerator;
import org.mrr.generator.selenium.DeselectCheckboxCodeGenerator;
import org.mrr.generator.selenium.EditTextfieldCodeGenerator;
import org.mrr.generator.selenium.LoadPageCodeGenerator;
import org.mrr.generator.selenium.SelectCheckboxCodeGenerator;
import org.mrr.generator.selenium.SelectInDropdownCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertTrue;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.EDIT_TEXT;
import static org.mrr.core.domain.ActionType.LOAD_PAGE;

public class GenerateCodeFactoryIntegrationTest {
    private GenerateCodeFactory generateCodeFactory;

    @Before
    public void setup() {
        final ApplicationContext context = SpringApplication.run(ApplicationConfig.class);
        generateCodeFactory = context.getBean("generateCodeFactory", GenerateCodeFactory.class);
    }

    @Test
    public void whenCreatingInstanceForLoadPageAutomationBean_shouldReturnLoadPageCodeGenerator() {
        final TestStep testStep = new TestStep(LOAD_PAGE, "");
        final TestCaseCodeGenerator codeGenerator = generateCodeFactory.findGenerator(testStep);
        assertTrue(codeGenerator instanceof LoadPageCodeGenerator);
    }

    @Test
    public void whenCreatingInstanceForEditTextAutomationBean_shouldReturnEditTextCodeGenerator() {
        final TestStep testStep = new TestStep(EDIT_TEXT, "");
        final TestCaseCodeGenerator codeGenerator = generateCodeFactory.findGenerator(testStep);
        assertTrue(codeGenerator instanceof EditTextfieldCodeGenerator);
    }

    @Test
    public void whenCreatingInstanceForClickButtonBean_shouldReturnClickButtonCodeGenerator() {
        final TestStep testStep = new TestStep(CLICK_BUTTON, "");
        final TestCaseCodeGenerator codeGenerator = generateCodeFactory.findGenerator(testStep);
        assertTrue(codeGenerator instanceof ClickButtonCodeGenerator);
    }

    @Test
    public void whenCreatingInstanceForSelectInDropdownAutomationBean_shouldReturnSelectInDropdownGenerator() {
        final TestStep testStep = new TestStep(ActionType.SELECT_IN_DROPDOWN, "");
        final TestCaseCodeGenerator codeGenerator = generateCodeFactory.findGenerator(testStep);
        assertTrue(codeGenerator instanceof SelectInDropdownCodeGenerator);
    }

    @Test
    public void whenCreatingInstanceForSelectCheckboxAutomationBean_shouldReturnSelectCheckboxCodeGenerator() {
        final TestStep testStep = new TestStep(ActionType.SELECT_CHECKBOX, "");
        final TestCaseCodeGenerator codeGenerator = generateCodeFactory.findGenerator(testStep);
        assertTrue(codeGenerator instanceof SelectCheckboxCodeGenerator);
    }

    @Test
    public void whenCreatingInstanceForDeselectCheckboxAutomationBean_shouldReturnDeselectCheckboxCodeGenerator() {
        final TestStep testStep = new TestStep(ActionType.DESELECT_CHECKBOX, "");
        final TestCaseCodeGenerator codeGenerator = generateCodeFactory.findGenerator(testStep);
        assertTrue(codeGenerator instanceof DeselectCheckboxCodeGenerator);
    }
}
