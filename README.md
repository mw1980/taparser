
This is a toy project to generate the test automation code needed to automate the testing of the graphical user interface.

The idea of this software is to create test automation code for human readable test input, by breaking a bigger task into more actions that interact with a single UiComponent.
Example: 
Load page http://www.google.com
Set in textfield user value "user name"
Click button submit

//This selenium code should be generated:
driver.get("http://www.google.com");
driver.findElement(By.id("userNameHtmlId")).sendKeys("user name");
driver.findElement(By.id("submitButtonId")).click();

The parser needs to receive the information in order to identify the user interface elements on the interface, like the text field "user" and the "submit" button in the previous example.
The control descriptions can be loaded from an external source, if they are stored in this form: "controlName identificationType identificationValue".
Example:
-> user id userNameHtmlId
-> submit id submitButtonId
Check the controls.api package for details.
A default implementation for controls descriptions stored in "csv" format is provided. You should provide another implementation of the ControlDescriptions interface if you need another storage option for the control descriptions, like data base, or xml files.

This is the application flow:
-> The test specification is read from the external resource. The default implementation expects the test specification to be loaded from an external file, each line containing a single action. 
A parser reads each action and identifies the action type and searches for the matching action parser class, that creates a test step representation for the free action description.
The java representation of the test step contains the action type, the action target and the potential value to be set / verified.
Check the parse package for the implementation.

-> A code generator runs over the previous created TestSteps, searches for a matching code generator and generates the automation code for the free action description.
The default implementation generates selenium code. 
If you need to generate code for another testing framework, provide a matching implementation of the TestStepCodeGenerators.
