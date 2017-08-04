
This is a toy project to generate the test automation code needed to automate the testing of the graphical user interface.

### The idea
The idea of this software is to create test automation code for human readable test input, by breaking a bigger task into more actions that interact with a single UiComponent.

Example:
```
Load page http://www.google.com
Set in textfield user value "user name"
Click button submit
```

This selenium code should be generated:
```
driver.get("http://www.google.com");
driver.findElement(By.id("userNameHtmlId")).sendKeys("user name");
driver.findElement(By.id("submitButtonId")).click();
```

The parser needs to receive the information in order to identify the user interface elements on the interface, like the text field "user" and the "submit" button in the previous example.

### Identify the controls on the user interface
The control descriptions can be loaded from an external source, if they are stored in this form:
```
controlName identificationType identificationValue
```

Example:
```
user id userNameHtmlId
submit id submitButtonId
```

Check the controls.api package for details.

A default implementation for controls descriptions stored in "csv" format is provided. You should provide another implementation of the ControlDescriptions interface if you need another storage option for the control descriptions, like data base, or xml files.

### Concepts
A TestStep consists of more test actions.
Each test action has a description, a java representation and a test automation code.
* The test action description is read from an external source in a human readable form.
* The java representation of the test action contains the action type, the action target and eventually a value to be set or read. The "parse operation" classes parse the free test description to java "Action" object.
* The test automation code for the Action classes is provided by a suite of code operation classes. The default implementation is for Selenium framework.
