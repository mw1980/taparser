package org.mrr.core;

/**
 * A user interface test.
 */
public interface UiUnitTest {
    /**
     * Saves a unit test file, that contains the test actions received as parameter, on the disk.
     *
     * @param actions, the test actions that the unit test should provide
     */
    void persist(Iterable<CodedTestAction> actions);
}
