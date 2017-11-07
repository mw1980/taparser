package org.mrr;

import org.junit.jupiter.api.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParseClickButtonOperationTest {

    @Test
    void whenParsingMalformedClickButtonDescription_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseClickButtonOperation().validate("Click button firstbutton secondbutton")
        );
    }

    @Test
    void whenParsingValidClickButtonDescription_shouldValidate() {
        new ParseClickButtonOperation().validate("Click button singlebutton");
    }

    @Test
    void whenParsingUppercaseClickButtonDescription_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseClickButtonOperation().validate("Click Button firstButton")
        );
    }

    @Test
    void whenParsingCorrectClickButtonDescription_shouldIdentifyTheTarget() {
        final Action parsed = new ParseClickButtonOperation().actionFor("Click button submitform");
        final Action expected = new Action(ActionType.CLICK_BUTTON, "submitform", "");
        assertThat(parsed).isEqualTo(expected);
    }

    @Test
    void whenParsingMalformedClickLinkDescription_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseClickButtonOperation().validate("Click link firstbutton secondbutton")
        );
    }

    @Test
    void whenParsingWellFormedLinkStepDescription_shouldValidateWithoutException() {
        new ParseClickButtonOperation().validate("Click link singlebutton");
    }

    @Test
    void whenParsingUppercaseLinkDescription_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseClickButtonOperation().validate("Click Link firstButton")
        );
    }

    @Test
    void whenParsingCorrectClickLinkDescription_shouldIdentifyTheTarget() {
        final Action parsed = new ParseClickButtonOperation().actionFor("Click link submitform");
        assertThat(parsed).isEqualTo(new Action(ActionType.CLICK_BUTTON, "submitform", ""));
    }

    @Test
    void shouldHandleClickButtonDescription() {
        final ParseClickButtonOperation underTest = new ParseClickButtonOperation();
        assertTrue(
                () -> underTest.canHandle("Click button submit")
        );
    }

    @Test
    void shouldHandleClickLinkDescription() {
        final ParseClickButtonOperation underTest = new ParseClickButtonOperation();
        assertTrue(
                () -> underTest.canHandle("Click link nextPage")
        );
    }

    @Test
    void shouldHandleEditTextfieldDescription() {
        final ParseClickButtonOperation underTest = new ParseClickButtonOperation();
        assertFalse(
                () -> underTest.canHandle("Set in textfield name value John")
        );
    }
}