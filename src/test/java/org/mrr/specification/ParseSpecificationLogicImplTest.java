package org.mrr.specification;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mrr.core.TestSpecificationStore;
import org.mrr.core.TestStepGenerateLogic;
import org.mrr.core.TestStepParseLogic;
import org.mrr.core.domain.TestStep;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.UNKNOWN;

public class ParseSpecificationLogicImplTest {

    private static final String TEST_DESCRIPTION = "test description";

    @Mock
    private TestStepParseLogic parseLogic;

    @Mock
    private TestStepGenerateLogic generateLogic;

    @Mock
    private TestSpecificationStore specificationStore;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenParsingSpecification_shouldLoadDescriptionsFromSpecificationStore() {
        parseSpecificationLogic().parseSpecification();
        verify(specificationStore).testDescriptions();
    }

    private ParseSpecificationLogicImpl parseSpecificationLogic() {
        return new ParseSpecificationLogicImpl(parseLogic, generateLogic, specificationStore);
    }

    @Test
    public void whenParsingSpecification_shouldParseDescriptionToTestStep() {
        when(specificationStore.testDescriptions()).thenReturn(singletonList(TEST_DESCRIPTION));
        parseSpecificationLogic().parseSpecification();
        verify(parseLogic).testStepForDescription(TEST_DESCRIPTION);
    }

    @Test
    public void whenParsingSpecification_shouldGenerateTestStepCode() {
        when(specificationStore.testDescriptions()).thenReturn(singletonList(TEST_DESCRIPTION));
        when(parseLogic.testStepForDescription(TEST_DESCRIPTION)).thenReturn(testStep());
        parseSpecificationLogic().parseSpecification();
        verify(generateLogic).automationCodeFor(testStep());
    }

    private TestStep testStep() {
        return new TestStep(UNKNOWN, "");
    }
}