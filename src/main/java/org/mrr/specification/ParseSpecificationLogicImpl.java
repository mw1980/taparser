package org.mrr.specification;

import org.mrr.core.ParseSpecificationLogic;
import org.mrr.core.TestSpecificationStore;
import org.mrr.core.TestStepGeneratorLogic;
import org.mrr.core.TestStepParserLogic;
import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ParseSpecificationLogicImpl implements ParseSpecificationLogic {
    private final TestStepParserLogic parserLogic;
    private final TestStepGeneratorLogic generatorLogic;
    private final TestSpecificationStore specificationStore;

    @Autowired
    public ParseSpecificationLogicImpl(final TestStepParserLogic testStepParserLogic,
                                       final TestStepGeneratorLogic generatorLogic,
                                       final TestSpecificationStore specificationStore) {
        this.parserLogic = testStepParserLogic;
        this.generatorLogic = generatorLogic;
        this.specificationStore = specificationStore;
    }

    @Override
    public List<String> parseSpecification() {
        return specificationStore.testDescriptions().stream()
                .map(this::codeForSingleTestStep)
                .collect(toList());
    }

    /*
     * The method delivers the automation code for a single action.
     * @param description the free text description of the test step. E.g. Click button submit
     * @return the test automation code for the free text description.
     */
    private String codeForSingleTestStep(final String description) {
        final TestStep testStep = parserLogic.testStepForDescription(description);
        return generatorLogic.automationCodeFor(testStep);
    }
}
