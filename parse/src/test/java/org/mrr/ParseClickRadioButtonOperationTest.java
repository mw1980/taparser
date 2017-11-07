package org.mrr;

import org.junit.jupiter.api.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParseClickRadioButtonOperationTest {

    @Test
    void whenValidatingWrongClickRadioButtonText_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseClickRadioButtonOperation().validate("Select radiobutton value")
        );
    }

    @Test
    void whenValidatingWrongOptionText_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseClickRadioButtonOperation().validate("Select radio button per post")
        );
    }

    @Test
    void whenValidatingMissingTargetDescription_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseClickRadioButtonOperation().validate("Select radio button")
        );
    }

    @Test
    void whenParsingCorrectDescription_shouldReturnBeanWithExpectedActionType() {
        final Action parsed = new ParseClickRadioButtonOperation().actionFor("Select radio button 1");
        assertThat(parsed).isEqualTo(new Action(ActionType.CLICK_BUTTON, "1", ""));
    }

    @Test
    void shouldHandleClickRadioButtonDescription() {
        final ParseClickRadioButtonOperation underTest = new ParseClickRadioButtonOperation();
        assertTrue(
                () -> underTest.canHandle("Select radio button salutation")
        );
    }

    @Test
    void shouldNotHandleEditTextfieldDescription() {
        final ParseClickRadioButtonOperation underTest = new ParseClickRadioButtonOperation();
        assertFalse(
                () -> underTest.canHandle("Set in textfield name value John")
        );
    }
}