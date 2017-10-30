package org.mrr.core;

/**
 * A test action, that contains its human readable description.
 */
public interface DescribedAction {

    String description();

    final class EmptyDescribedAction implements DescribedAction {

        @Override
        public String description() {
            return "";
        }
    }
}
