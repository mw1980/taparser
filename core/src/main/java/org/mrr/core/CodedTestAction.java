package org.mrr.core;

import org.mrr.core.domain.Action;

/**
 * The class is a representation of a test action that contains also its automation code.
 */
public interface CodedTestAction extends ParsedTestAction {
    String code();

    final class DummyCodedTestAction implements CodedTestAction {

        @Override
        public Action action() {
            return Action.EMPTY;
        }

        @Override
        public String description() {
            return "test action description";
        }

        @Override
        public String code() {
            return "generated code";
        }
    }
}
