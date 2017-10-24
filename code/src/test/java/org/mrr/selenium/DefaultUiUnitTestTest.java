package org.mrr.selenium;

import org.junit.Test;
import org.mrr.api.CodeException;
import org.mrr.api.PersistToFileOperation.DummyPersistToFileOperation;
import org.mrr.api.PersistToFileOperation.PersistToFileOperationWithException;
import org.mrr.core.CodedAction.DummyCodedAction;
import org.mrr.core.TestSettings.DummyTestSetting;
import org.mrr.core.UiUnitTest;

import static java.util.Collections.singletonList;

public class DefaultUiUnitTestTest {

    @Test
    public void persistSingleAction_noException() {
        final UiUnitTest underTest = new DefaultUiUnitTest(
                new DummyTestSetting(),
                new DummyPersistToFileOperation());
        underTest.persist(singletonList(new DummyCodedAction()));
    }

    @Test(expected = CodeException.class)
    public void persistSingleAction_parseException() {
        final UiUnitTest underTest = new DefaultUiUnitTest(
                new DummyTestSetting(),
                new PersistToFileOperationWithException());
        underTest.persist(singletonList(new DummyCodedAction()));
    }
}