package org.mrr;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mrr.reader.TestConstants.PATH_TO_TEST_RESOURCE_FOLDER;

public class AutomationCodeGeneratorTest {
  private AutomationCodeGenerator automationCodeGenerator;
  private List<String> automationCodeCommands;

  @Before
  public void setup() {
    this.automationCodeGenerator = new AutomationCodeGenerator();
    String pathToFirstTestFile = PATH_TO_TEST_RESOURCE_FOLDER + "FirstTestCase.txt";
    this.automationCodeCommands = this.automationCodeGenerator.createAutomationCodeForActionsInFile(pathToFirstTestFile);
  }

  @Test
  @Ignore
  public void firstSeleniumTest() {
    final WebDriver driver = new FirefoxDriver();
    driver.get("http://www.google.com");
    driver.findElement(By.id("lst-ib")).sendKeys("newValue");
    driver.findElement(By.id("btnG")).click();
    driver.close();
  }

  @Test
  public void shouldGenerateExpectedSeleniumCodeForCodeForPageLoadSingleStep() {
    final String generatedCode = this.automationCodeGenerator.createAutomationCodeForSingleStep("Load page http://www.google.de");
    assertThat(generatedCode).isEqualTo("driver.get(\"http://www.google.de\");");
  }

  @Test
  public void shouldGenerateExpectedSeleniumCodeForEditTextFieldSingleStep() {
    final String generatedCode = this.automationCodeGenerator.createAutomationCodeForSingleStep("Set in textfield user value \"user name\"");
    assertThat(generatedCode).isEqualTo("driver.findElement(By.id(\"userNameHtmlId\")).sendKeys(\"user name\");");
  }

  @Test
  public void shouldGenerateExpectedSeleniumCodeForClickButtonSingleStepCode() {
    final String generatedString = this.automationCodeGenerator.createAutomationCodeForSingleStep("Click button submit");
    assertThat(generatedString).isEqualTo("driver.findElement(By.id(\"submitButtonId\")).click();");
  }

  @Test
  public void shouldGenerateExpectedSeleniumCodeForClickLinkSingleStepCode() {
    final String generatedString = this.automationCodeGenerator.createAutomationCodeForSingleStep("Click link newpage");
    assertThat(generatedString).isEqualTo("driver.findElement(By.id(\"newPageLinkId\")).click();");
  }

  @Test
  public void shouldGenerateExpectedSeleniumCodeForSelectInDropdownSingleStepText() {
    final String generatedString = this.automationCodeGenerator.createAutomationCodeForSingleStep("Select in dropdown mydropdown value \"Johnie Walker\"");
    assertThat(generatedString).isEqualTo("new Select (driver.findElement(By.id(\"mydropdownHtmlId\"))).selectByVisibleText(\"Johnie Walker\");");
  }

  @Test
  public void shouldGenerateExpectedCodeForSelectCheckboxSingleStep(){
    final String generatedCode = this.automationCodeGenerator.createAutomationCodeForSingleStep("Select checkbox agreecookies");
    final String expectedCode = "if (!driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
    assertThat(generatedCode).isEqualTo(expectedCode);
  }

  @Test
  public void shouldGenerateExpectedCodeForDeselectCheckboxSingleStep(){
    final String expectedCode = "if (driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
    final String generatedCode = this.automationCodeGenerator.createAutomationCodeForSingleStep("Deselect checkbox agreecookies");
    assertThat(generatedCode).isEqualTo(expectedCode);
  }

  @Test
  public void shouldGenerateExpectedCodeForClickRadioButton(){
    final String expectedCode = "driver.findElement(By.id(\"emailRadioButtonHtmlId\")).click();";
    final String generatedCode = this.automationCodeGenerator.createAutomationCodeForSingleStep("Select radio button emailradiobutton");
    assertThat(generatedCode).isEqualTo(expectedCode);
  }

  @Test
  public void shouldLoadNotEmptyAutomationCodeCommandsList(){
    assertThat(this.automationCodeCommands).isNotEmpty();
  }

  @Test
  public void shouldGenerateExpectedLoadPageCodeFromTheFirstLineInExternalFile() {
    assertThat(this.automationCodeCommands.get(0)).isEqualTo("driver.get(\"http://www.google.com\");");
  }

  @Test
  public void shouldGenerateExpectedEditTextCodeFromTheSecondLineInExternalFile() {
    assertThat(this.automationCodeCommands.get(1)).isEqualTo("driver.findElement(By.id(\"userNameHtmlId\")).sendKeys(\"user name\");");
  }

  @Test
  public void shouldGenerateExpectedClickButtonCodeFromTheThirdLineInExternalFile() {
    assertThat(automationCodeCommands.get(2)).isEqualTo("driver.findElement(By.id(\"submitButtonId\")).click();");
  }

  @Test
  public void shouldGenerateExpectedClickLinkCodeFromTheFourthLineInExternalFile() {
    assertThat(automationCodeCommands.get(3)).isEqualTo("driver.findElement(By.id(\"newPageLinkId\")).click();");
  }

  @Test
  public void shouldGenerateExpectedSelectInDropdownCodeFromTheFifthLineInExternalFile() {
    assertThat(this.automationCodeCommands.get(4)).isEqualTo("new Select (driver.findElement(By.id(\"mydropdownHtmlId\"))).selectByVisibleText(\"Johnie Walker\");");
  }

  @Test
  public void shouldGenerateExpectedSelectCheckboxCodeFromTheSixthLineInExternalFile(){
    final String expectedCode = "if (!driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
    assertThat(this.automationCodeCommands.get(5)).isEqualTo(expectedCode);
  }

  @Test
  public void shouldGenerateExpectedDeselectCheckboxCodeFromTheSeventhLineInExternalFile(){
    final String expectedCode = "if (driver.findElement(By.id(\"agreeCookiesHtmlId\")).isSelected()){driver.findElement(By.id(\"agreeCookiesHtmlId\")).click();}";
    assertThat(this.automationCodeCommands.get(6)).isEqualTo(expectedCode);
  }

  @Test
  public void shouldGenerateExpectedSelectRadioButtonCodeFromTheEightsLineInExternalFile(){
    final String expectedCode = "driver.findElement(By.id(\"emailRadioButtonHtmlId\")).click();";
    assertThat(this.automationCodeCommands.get(7)).isEqualTo(expectedCode);
  }

  @After
  public void tearDown() {
    this.automationCodeGenerator = null;
    this.automationCodeCommands = null;
  }
}
