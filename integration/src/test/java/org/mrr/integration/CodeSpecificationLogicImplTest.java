package org.mrr.integration;

import org.junit.jupiter.api.Test;
import org.mrr.core.CodeActionLogic;
import org.mrr.core.ParseActionLogic;
import org.mrr.core.TestSpecificationStore;
import org.mrr.specification.CodeSpecificationLogicImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CodeSpecificationLogicImplTest {

    @Test
    void whenCodingSpecification_shouldLoadDescriptionsFromSpecificationStore() {
        final TestSpecificationStore specificationStore = mock(TestSpecificationStore.class);
        final CodeSpecificationLogicImpl underTest = new CodeSpecificationLogicImpl(
                mock(ParseActionLogic.class),
                mock(CodeActionLogic.class),
                specificationStore);
        underTest.codeForSpecification();
        verify(specificationStore).testDescriptions();
    }
}