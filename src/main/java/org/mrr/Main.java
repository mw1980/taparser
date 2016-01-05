package org.mrr;

import java.util.List;

/**
 * Temporary runnable main class.
 */
class Main {
  public static void main(String[] args) {
    AutomationCodeGenerator codeGenerator = new AutomationCodeGenerator();

    final List<String> actionsInFile = codeGenerator.createAutomationCodeForActionsInFile("src/main/resources/org/mrr/txt/FirstTestCase.txt");
    for (String action : actionsInFile) {
      System.out.println(action);
    }
  }
}
