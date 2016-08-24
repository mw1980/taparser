package org.mrr.core;

import org.mrr.core.domain.TestStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * The class generates selenium code for a text action.
 */
@Component
class AutomationCodeGenerator {
    private final TestStepParserLogic parserLogic;
    private final TestCaseGeneratorLogic generatorLogic;

    @Autowired
    public AutomationCodeGenerator(final TestStepParserLogic testStepParserLogic,
                                   final TestCaseGeneratorLogic generatorLogic) {
        this.parserLogic = testStepParserLogic;
        this.generatorLogic = generatorLogic;
    }

    /**
     * The method delivers the automation code for a single action.
     *
     * @param description the "non technical" test step description.
     *                    E.g. Click button submit
     * @return the test automation code for the input text.
     */
    private String createCodeForSingleTestStep(final String description) {
        final TestStep testStep = parserLogic.createAutomationStepForDescription(description);
        return generatorLogic.generateCode(testStep);
    }

    /**
     * Read all the action texts in the external file and generate the test automation code for them.
     *
     * @param location the path to the file that contains the action texts.
     * @return List of test automation commands for the test actions described in the external file.
     */
    List<String> createCodeForActionsInFile(final String location) {
        final List<String> result = new LinkedList<>();
        for (final String step : new StepDescriptionsStore(location).deliverStepsDescription()) {
            result.add(createCodeForSingleTestStep(step));
        }
        return result;
    }
}
