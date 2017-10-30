package org.mrr.integration;

import org.junit.jupiter.api.Test;
import org.mrr.DefaultCodeFactory;
import org.mrr.api.CodeOperationNotFoundException;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.DESELECT_CHECKBOX;
import static org.mrr.core.domain.ActionType.EDIT_TEXT;
import static org.mrr.core.domain.ActionType.LOAD_PAGE;
import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;
import static org.mrr.core.domain.ActionType.SELECT_IN_DROPDOWN;

class CodeFactoryIntegrationTest {
    private final ApplicationContext context = SpringApplication.run(ApplicationConfig.class);
    private final DefaultCodeFactory factory = context.getBean("defaultCodeFactory", DefaultCodeFactory.class);

    @Test
    void whenCodingLoadPage_shouldReturnLoadPageOperation() {
        assertThat(factory.codedOperationFor(Action.withType(LOAD_PAGE)))
                .isInstanceOf(CodedLoadPageOperation.class);
    }

    @Test
    void whenCodingEditText_shouldReturnEditTextOperation() {
        assertThat(factory.codedOperationFor(Action.withType(EDIT_TEXT)))
                .isInstanceOf(CodedEditTextfieldOperation.class);
    }

    @Test
    void whenCodingClickButton_shouldReturnClickButtonOperation() {
        assertThat(factory.codedOperationFor(Action.withType(CLICK_BUTTON)))
                .isInstanceOf(CodedClickButtonOperation.class);
    }

    @Test
    void whenCodingSelectInDropdown_shouldReturnSelectInDropdownOperation() {
        assertThat(factory.codedOperationFor(Action.withType(SELECT_IN_DROPDOWN)))
                .isInstanceOf(CodedSelectInDropdownOperation.class);
    }

    @Test
    void whenCodingSelectCheckbox_shouldReturnSelectCheckboxOperation() {
        assertThat(factory.codedOperationFor(Action.withType(SELECT_CHECKBOX)))
                .isInstanceOf(CodedSelectCheckboxOperation.class);
    }

    @Test
    void whenCodingDeselectCheckbox_shouldReturnDeselectCheckboxOperation() {
        assertThat(factory.codedOperationFor(Action.withType(DESELECT_CHECKBOX)))
                .isInstanceOf(CodedDeselectCheckboxOperation.class);
    }

    @Test
    void whenCreatingGeneratorForUnknownAction_shouldThrowException() {
        assertThrows(
                CodeOperationNotFoundException.class,
                () -> factory.codedOperationFor(new Action(ActionType.UNKNOWN, "")));
    }

    @Test
    void shouldInjectTheDefaultUiTest() {
        assertThat(
                context.getBean("defaultUiUnitTest", DefaultUiUnitTest.class),
                notNullValue());
    }
}
