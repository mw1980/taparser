package org.mrr.specification;

import org.junit.jupiter.api.Test;
import org.mrr.core.CodeActionLogic;
import org.mrr.core.CodeSpecificationLogic;
import org.mrr.core.CodedAction;
import org.mrr.core.ParseActionLogic;
import org.mrr.core.TestSpecificationStore;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DefaultCodeSpecificationLogicTest {

    @Test
    void whenCodingSpecification_shouldLoadDescriptionsFromSpecificationStore() {
        final TestSpecificationStore specificationStore = mock(TestSpecificationStore.class);
        final DefaultCodeSpecificationLogic underTest = new DefaultCodeSpecificationLogic(
                mock(ParseActionLogic.class),
                mock(CodeActionLogic.class),
                specificationStore);
        underTest.codeForSpecification();
        verify(specificationStore).testDescriptions();
    }

    @Test
    void whenCodingSpecification_shouldCalculateCodedActionAsExpected() {
        final TestSpecificationStore store = mock(TestSpecificationStore.class);
        when(store.testDescriptions()).thenReturn(Collections.singletonList("Click button submit"));

        final CodeSpecificationLogic underTest = new DefaultCodeSpecificationLogic(
                mock(ParseActionLogic.class), mock(CodeActionLogic.class), store);
        final List<CodedAction> codedActions = underTest.codeForSpecification();

        assertAll(
                () -> assertThat(codedActions).hasSize(1),
                () -> assertThat(codedActions.get(0)).isInstanceOf(CodedAction.class)

        );
    }
}