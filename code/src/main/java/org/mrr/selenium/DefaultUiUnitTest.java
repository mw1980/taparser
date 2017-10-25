package org.mrr.selenium;

import org.apache.log4j.Logger;
import org.mrr.api.CodeException;
import org.mrr.api.PersistToFileOperation;
import org.mrr.core.CodedAction;
import org.mrr.core.TestSettings;
import org.mrr.core.UiUnitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.String.format;

/**
 * A user interface test.
 */
@Component
public class DefaultUiUnitTest implements UiUnitTest {
    private static final Logger LOG = Logger.getLogger(DefaultUiUnitTest.class);

    private final TestSettings settings;
    private final PersistToFileOperation persistOperation;

    @Autowired
    public DefaultUiUnitTest(final TestSettings testSettings, final PersistToFileOperation persistToFileOperation) {
        this.settings = testSettings;
        this.persistOperation = persistToFileOperation;
    }

    @Override
    public void persist(final Iterable<CodedAction> actions) {
        final String className = "Test_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY_MM_dd_hh_mm_ss"));
        saveCodeToTestFile(
                className,
                generatedUnitTestCode(className, actions)
        );
    }

    private void saveCodeToTestFile(final String fileName, final String testCode) {
        try {
            persistOperation.execute(
                    format("%s%s.java", settings.completePackagePath(), fileName),
                    testCode);
        } catch (final IOException exception) {
            LOG.error(errorMessage(), exception);
            throw new CodeException(errorMessage());
        }
    }

    private String generatedUnitTestCode(final String className, final Iterable<CodedAction> actions) {
        final StringBuilder actionsCode = new StringBuilder("final WebDriver driver = new FirefoxDriver();\n");
        actions.forEach(action -> actionsCode.append(action.code()).append("\n"));
        return "package " + settings.basePackagePath() + "; \n"
                + "import org.junit.Test; \n"
                + "import org.openqa.selenium.*; \n"
                + "import org.openqa.selenium.firefox.*; \n"
                + "import org.openqa.selenium.support.ui.*; \n"
                + "public class " + className + "{ \n"
                + "@Test public void test(){ \n"
                + " System.setProperty(\"webdriver.gecko.driver\", \"" + settings.geckoDriverPath() + "\");\n"
                + actionsCode.toString()
                + "}"
                + "}"; //End of class
    }

    private String errorMessage() {
        return "Can not save the unit test to disk.";
    }
}
