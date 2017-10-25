package org.mrr.selenium;

import org.junit.jupiter.api.Test;
import org.mrr.api.CodeException;
import org.mrr.api.PersistToFileOperation.DummyPersistToFileOperation;
import org.mrr.api.PersistToFileOperation.PersistToFileOperationWithException;
import org.mrr.core.CodedAction.DummyCodedAction;
import org.mrr.core.TestSettings.DummyTestSetting;
import org.mrr.core.UiUnitTest;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultUiUnitTestTest {

    @Test
    void persistSingleAction_noException() {
        final UiUnitTest underTest = new DefaultUiUnitTest(
                new DummyTestSetting(),
                new DummyPersistToFileOperation());
        underTest.persist(singletonList(new DummyCodedAction()));
    }

    @Test
//(expected = CodeException.class)
    void persistSingleAction_parseException() {
        final UiUnitTest underTest = new DefaultUiUnitTest(
                new DummyTestSetting(),
                new PersistToFileOperationWithException());
        assertThrows(
                CodeException.class,
                () -> underTest.persist(singletonList(new DummyCodedAction()))
        );
    }
}