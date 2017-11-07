package org.mrr;

import org.junit.jupiter.api.Test;
import org.mrr.core.domain.Action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mrr.core.domain.ActionType.SELECT_CHECKBOX;

class ParseSelectCheckboxOperationTest {

    @Test
    void whenValidatingWrongCheckboxNameText_shouldThrowDescriptionNotParsableException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseSelectCheckboxOperation().validate("Select checkbox my first checkbox")
        );
    }

    @Test
    void whenValidatingDescriptionWithMissingCheckboxText_shouldThrowDescriptionNotParsableException() {
        assertThrows(
                DescriptionNotParsableException.class,
                () -> new ParseSelectCheckboxOperation().validate("Select myCheckbox")
        );
    }

    @Test
    void whenParsingCorrectDescription_shouldParseAsExpected() {
        final Action parsed = new ParseSelectCheckboxOperation().actionFor("Select checkbox a");
        final Action expected = new Action(SELECT_CHECKBOX, "a", "");
        assertThat(parsed).isEqualTo(expected);
    }

    @Test
    void shouldHandleSelectCheckboxDescription() {
        final ParseSelectCheckboxOperation underTest = new ParseSelectCheckboxOperation();
        assertThat(underTest.canHandle("Select checkbox gender")).isTrue();
    }

    @Test
    void shouldNotHandleLoadPageOperation() {
        final ParseSelectCheckboxOperation underTest = new ParseSelectCheckboxOperation();
        assertThat(underTest.canHandle("Load page www.somepage.com")).isFalse();
    }
}
