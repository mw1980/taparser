package org.mrr;

import org.junit.jupiter.api.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for the class {@link ParseLoadPageActionOperation}.
 */
class ParseLoadPageActionOperationTest {

    @Test
    void whenValidatingMissingUrlDescription_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseLoadPageActionOperation().validate("Load page")
        );
    }

    @Test
    void whenValidatingMissingPageDescription_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseLoadPageActionOperation().validate("Load http://www.google.com")
        );
    }

    @Test
    void whenParsingLoadAction_shouldReturnCorrectActionTypeAndEmptyTarget() {
        final Action parsed = new ParseLoadPageActionOperation().actionFor("Load page http://www.google.de");
        final Action expected = new Action(ActionType.LOAD_PAGE, "", "http://www.google.de");
        assertThat(parsed).isEqualTo(expected);
    }

    @Test
    void shouldHandleLoadPageOperation() {
        final ParseLoadPageActionOperation underTest = new ParseLoadPageActionOperation();
        assertThat(underTest.canHandle("Load page www.somepage.com")).isTrue();
    }

    @Test
    void shouldNotHandleClickButtonOperation() {
        final ParseLoadPageActionOperation underTest = new ParseLoadPageActionOperation();
        assertThat(underTest.canHandle("Click button submit")).isFalse();
    }
}
