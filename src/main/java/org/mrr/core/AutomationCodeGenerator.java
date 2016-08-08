package org.mrr.core;

import org.mrr.core.domain.AutomationStep;
import org.mrr.generator.AbstractCodeGenerator;
import org.mrr.generator.CodeGeneratorFactory;
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

    @Autowired
    public AutomationCodeGenerator(final TestStepParserLogic testStepParserLogic) {
        this.parserLogic = testStepParserLogic;
    }

  /**
   * The method delivers the automation code for a single action.
   * @param description the "non technical" test step description.
   *                    E.g. Click button submit
   * @return the test automation code for the input text.
   */
   private String createAutomationCodeForSingleStep(final String description) {
    final AutomationStep automationStep = parserLogic.createAutomationStepForDescription(description);
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(automationStep);
    return codeGenerator.generateCode();
  }

  /**
   * Read all the action texts in the external file and generate the test automation code for them.
   * @param location the path to the file that contains the action texts.
   * @return List of test automation commands for the test action steps descriptionsAsText in the external file.
   */
  List<String> createCodeForActionsInFile(final String location) {
    final List<String> result = new LinkedList<>();
    for (final String step : new StepDescriptionsStore(location).deliverStepsDescription()) {
      result.add(createAutomationCodeForSingleStep(step));
    }
    return result;
  }
}
