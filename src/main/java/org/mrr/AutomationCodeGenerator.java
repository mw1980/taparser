package org.mrr;

import org.mrr.generator.AbstractCodeGenerator;
import org.mrr.generator.CodeGeneratorFactory;
import org.mrr.parser.AbstractStepParser;
import org.mrr.parser.StepParserFactory;
import org.mrr.reader.FileTestCaseReader;

import java.util.LinkedList;
import java.util.List;

/**
 * The class generates selenium code for a text action.
 */
class AutomationCodeGenerator {
  /**
   * The method delivers the automation code for a single action.
   * @param actionText the "non technical" action text.
   * @return the test automation code for the input text.
   */
  public String createAutomationCodeForSingleStep(final String actionText) {
    final AbstractStepParser stepParserCommand = StepParserFactory.newInstance(actionText);
    final AutomationStep automationBean = stepParserCommand.parse();
    final AbstractCodeGenerator codeGenerator = CodeGeneratorFactory.newInstance(automationBean);
    return codeGenerator.generateCode();
  }

  /**
   * Read all the action texts in the external file and generate the test automation code for them.
   * @param filePath the path to the file that contains the action texts.
   * @return List of test automation commands for the test action steps read in the external file.
   */
  public List<String> createCodeForActionsInFile(final String filePath) {
    final List<String> result = new LinkedList<>();
    for (final String each : new FileTestCaseReader(filePath).readTestCasesFromFile()) {
      result.add(createAutomationCodeForSingleStep(each));
    }
    return result;
  }
}
