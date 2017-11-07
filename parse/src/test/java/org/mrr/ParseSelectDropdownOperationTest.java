package org.mrr;

import org.junit.jupiter.api.Test;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParseSelectDropdownOperationTest {

    @Test
    void whenValidatingEmptyDescription_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseSelectDropdownOperation().validate("")
        );
    }

    @Test
    void whenValidatingMalformedDescription_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseSelectDropdownOperation().validate("Select dropdown mydropdown value \"5\"")
        );
    }

    @Test
    void whenValidatingMissingValueInDescription_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseSelectDropdownOperation().validate("Select in dropdown mydropdown \"ui label\"")
        );
    }

    @Test
    void whenValidatingDescriptionWithoutQuotationMarks_shouldThrowException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseSelectDropdownOperation().validate("Select in dropdown mydropdown value ui option")
        );
    }

    @Test
    void whenParsingCorrectDescription_shouldParseAsExpected() {
        final Action parsed = new ParseSelectDropdownOperation().actionFor("Select in dropdown mydropdown value \"ui option\"");
        assertThat(parsed).isEqualTo(
                new Action(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "ui option")
        );
    }

    @Test
    void whenParsingCorrectDescriptionWithNumericalOptionValue_shouldReturnExpectedTestStep() {
        final Action parsed = new ParseSelectDropdownOperation().actionFor("Select in dropdown mydropdown value \"3\"");
        assertThat(parsed).isEqualTo(new Action(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "3"));
    }

    @Test
    void whenParsingDescription_shouldReturnExpectedTestStep() {
        final Action parsed = new ParseSelectDropdownOperation().actionFor("Select in dropdown mydropdown value \"Johnie Walker\"");
        assertThat(parsed).isEqualTo(
                new Action(ActionType.SELECT_IN_DROPDOWN, "mydropdown", "Johnie Walker")
        );
    }

    @Test
    void shouldHandleSelectInDropdownDescription() {
        final ParseSelectDropdownOperation underTest = new ParseSelectDropdownOperation();
        assertThat(underTest.canHandle("Select in dropdown x value y")).isTrue();
    }

    @Test
    void shouldNotHandleLoadPageDescription() {
        final ParseSelectDropdownOperation underTest = new ParseSelectDropdownOperation();
        assertThat(underTest.canHandle("Load page www.somepage.com")).isFalse();
    }
}