package org.mrr.core;

import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
class ParserLogicImpl implements ParserLogic {
    private final TestStepParserLogic parserLogic;
    private final TestCaseGeneratorLogic generatorLogic;
    private final TestSpecificationStore specificationStore;

    @Autowired
    public ParserLogicImpl(final TestStepParserLogic testStepParserLogic,
                           final TestCaseGeneratorLogic generatorLogic,
                           final TestSpecificationStore specificationStore) {
        this.parserLogic = testStepParserLogic;
        this.generatorLogic = generatorLogic;
        this.specificationStore = specificationStore;
    }

    @Override
    public List<String> parseSpecification() {
        final List<String> result = new LinkedList<>();
        for (final String step : specificationStore.deliverTestDescriptions()) {
            result.add(createCodeForSingleTestStep(step));
        }
        return result;
    }

    /*
     * The method delivers the automation code for a single action.
     * @param description the "non technical" test step description. E.g. Click button submit
     * @return the test automation code for the non technical description.
     */
    private String createCodeForSingleTestStep(final String description) {
        final TestStep testStep = parserLogic.createTestStepForDescription(description);
        return generatorLogic.generateCode(testStep);
    }
}
