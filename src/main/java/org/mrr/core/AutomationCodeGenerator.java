package org.mrr.core;

import org.mrr.core.domain.TestStep;
import org.mrr.generator.GenerateCodeFactory;
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
    private final GenerateCodeFactory generateCodeFactory;

    @Autowired
    public AutomationCodeGenerator(final TestStepParserLogic testStepParserLogic,
                                   final GenerateCodeFactory generateCodeFactory) {
        this.parserLogic = testStepParserLogic;
        this.generateCodeFactory = generateCodeFactory;
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
        //TODO: implement generatorLogic class that automatically generates code for test step.
        //the next 2 lines should be replaced by single call.
        final TestCaseCodeGenerator codeGenerator = generateCodeFactory.findGenerator(testStep);
        return codeGenerator.generateCode(testStep);
    }

    /**
     * Read all the action texts in the external file and generate the test automation code for them.
     *
     * @param location the path to the file that contains the action texts.
     * @return List of test automation commands for the test action steps descriptionsAsText in the external file.
     */
    List<String> createCodeForActionsInFile(final String location) {
        final List<String> result = new LinkedList<>();
        for (final String step : new StepDescriptionsStore(location).deliverStepsDescription()) {
            result.add(createCodeForSingleTestStep(step));
        }
        return result;
    }
}
