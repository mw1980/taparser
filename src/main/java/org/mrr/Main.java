package org.mrr;

import java.util.List;

/**
 * Temporary runnable main class.
 */
class Main {
  public static void main(String[] args) {
    AutomationCodeGenerator codeGenerator = new AutomationCodeGenerator();

    final String filePath = "src/main/resources/org/mrr/txt/FirstTestCase.txt";
    final List<String> actionsInFile = codeGenerator.createCodeForActionsInFile(filePath);
    for (String action : actionsInFile) {
      System.out.println(action);
    }
  }
}
