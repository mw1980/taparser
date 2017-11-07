package org.mrr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParseDeselectCheckboxOperationTest {

    @Test
    void whenValidatingDescriptionWithWrongCheckboxName_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseDeselectCheckboxOperation().validate("Deselect checkbox my first checkbox")
        );
    }

    @Test
    void whenValidatingDescriptionWithMissingCheckbox_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseDeselectCheckboxOperation().validate("Deselect agreeWithCookies")
        );
    }

    @Test
    void whenParsingCorrectDescription_shouldReturnExpectedBean() {
        final Action parsed = new ParseDeselectCheckboxOperation().actionFor("Deselect checkbox agreecookies");
        assertThat(parsed).isEqualTo(new Action(ActionType.DESELECT_CHECKBOX, "agreecookies", ""));
    }

    @Test
    void shouldHandleDeselectCheckboxDescription() {
        final ParseDeselectCheckboxOperation underTest = new ParseDeselectCheckboxOperation();
        assertTrue(
                () -> underTest.canHandle("Deselect checkbox presentOption")
        );
    }

    @Test
    void shouldNotHandleEditTextfieldDescription() {
        final ParseDeselectCheckboxOperation underTest = new ParseDeselectCheckboxOperation();
        Assertions.assertFalse(
                () -> underTest.canHandle("Set in textfield name value John")
        );
    }
}