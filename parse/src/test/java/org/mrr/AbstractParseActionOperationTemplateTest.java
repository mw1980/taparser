package org.mrr;

import org.junit.jupiter.api.Test;
import org.mrr.ParseActionOperation.DummyParseActionOperation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mrr.core.domain.ActionType.UNKNOWN;


class AbstractParseActionOperationTemplateTest {

    @Test
    void nullObjectShouldParseDescriptionToUnknownTestStep() {
        final DummyParseActionOperation underTest = new DummyParseActionOperation();
        assertThat(underTest.actionFor("any description").actionType()).isEqualTo(UNKNOWN);
    }

    @Test
    void nullObjectShouldNotHandleAnyDescriptions() {
        final DummyParseActionOperation underTest = new DummyParseActionOperation();
        assertThat(underTest.canHandle("any description")).isFalse();
    }
}