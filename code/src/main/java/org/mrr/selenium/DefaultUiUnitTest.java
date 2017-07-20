package org.mrr.selenium;

import org.apache.log4j.Logger;
import org.mrr.api.CodeException;
import org.mrr.core.CodedTestAction;
import org.mrr.core.UiUnitTest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A user interface test.
 */
@Component
public class DefaultUiUnitTest implements UiUnitTest {
    private static final Logger LOG = Logger.getLogger(DefaultUiUnitTest.class);

    private static final String SHORT_PACKAGE_PATH = "org.mrr";
    private static final String GECKO_DRIVER_PATH = "/home/wamsiema/github/gecko/geckodriver";
    private static final String COMPLETE_PACKAGE_PATH = "./execution/src/test/java/org/mrr/";

    @Override
    public void persist(final Iterable<CodedTestAction> actions) {
        final String className = "Test_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY_MM_dd_hh_mm_ss"));
        saveCodeToTestFile(
                className,
                generateUnitTestCode(className, actions)
        );
    }

    private String generateUnitTestCode(final String className, final Iterable<CodedTestAction> actions) {
        final StringBuilder testActionsCode = new StringBuilder("final WebDriver driver = new FirefoxDriver();\n");
        actions.forEach(testAction -> testActionsCode.append(testAction.code()).append("\n"));
        return "package " + SHORT_PACKAGE_PATH + "; \n"
                + "import org.junit.Test; \n"
                + "import org.openqa.selenium.*; \n"
                + "import org.openqa.selenium.firefox.*; \n"
                + "import org.openqa.selenium.support.ui.*; \n"
                + "public class " + className + "{ \n"
                + "@Test public void test(){ \n"
                + " System.setProperty(\"webdriver.gecko.driver\", \"" + GECKO_DRIVER_PATH + "\");\n"
                + testActionsCode.toString()
                + "}"
                + "}"; //End of class
    }

    private void saveCodeToTestFile(String fileName, String testCode) {
        try {
            Files.write(Paths.get(COMPLETE_PACKAGE_PATH + fileName + ".java"), testCode.getBytes());
        } catch (final IOException exception) {
            final String message = "Can not save the unit test to disk.";
            LOG.error(message, exception);
            throw new CodeException(message);
        }
    }
}
