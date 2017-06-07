package org.mrr.integration;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.core.CodeTestActionLogic;
import org.mrr.core.ParseTestActionLogic;
import org.mrr.core.TestSpecificationStore;
import org.mrr.core.domain.Action;
import org.mrr.specification.CodeSpecificationLogicImpl;

import static org.mockito.Mockito.verify;
import static org.mrr.core.domain.ActionType.UNKNOWN;

public class CodeSpecificationLogicImplTest {

    private static final String TEST_DESCRIPTION = "test description";

    @Mock
    private ParseTestActionLogic parseLogic;

    @Mock
    private CodeTestActionLogic generateLogic;

    @Mock
    private TestSpecificationStore specificationStore;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenParsingSpecification_shouldLoadDescriptionsFromSpecificationStore() {
        parseSpecificationLogic().codeForSpecification();
        verify(specificationStore).testDescriptions();
    }

    private CodeSpecificationLogicImpl parseSpecificationLogic() {
        return new CodeSpecificationLogicImpl(parseLogic, generateLogic, specificationStore);
    }

    private Action testStep() {
        return new Action(UNKNOWN, "");
    }
}