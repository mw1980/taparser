package org.mrr;

import org.junit.jupiter.api.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParseEditTextfieldOperationTest {

    @Test
    void whenValidatingDescriptionWithoutValue_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseEditTextfieldOperation().validate("Set in textfield login \"user name\"")
        );
    }

    @Test
    void whenValidatingDescriptionWithoutQuotationMarks_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseEditTextfieldOperation().validate("Set in textfied login value user")
        );
    }

    @Test
    void shouldParseBasicStepDescriptionTextAsExpected() {
        Action parsed = new ParseEditTextfieldOperation().actionFor("Set in textfield login value \"my user name\"");
        assertThat(parsed).isEqualTo(new Action(ActionType.EDIT_TEXT, "login", "my user name"));
    }

    @Test
    void shouldHandleEditTextFieldDescription() {
        final ParseEditTextfieldOperation underTest = new ParseEditTextfieldOperation();
        assertThat(underTest.canHandle("Set in textfield name value Mark")).isTrue();
    }

    @Test
    void shouldNotHandleClickButtonDescription() {
        final ParseEditTextfieldOperation underTest = new ParseEditTextfieldOperation();
        assertThat(underTest.canHandle("Click button submit")).isFalse();
    }
}