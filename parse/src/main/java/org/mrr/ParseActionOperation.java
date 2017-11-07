package org.mrr;

import lombok.EqualsAndHashCode;
import org.mrr.core.domain.Action;
import org.mrr.core.domain.ActionType;

/**
 * General interface for parsing string test description to {@link Action} objects.
 */
public interface ParseActionOperation {
    /**
     * Deliver the {@link Action} object for some action description.
     */
    Action actionFor(String description);

    /**
     * Specifies if the parse operation understands the action description received as parameter.
     */
    boolean canHandle(String description);

    @EqualsAndHashCode
    final class DummyParseActionOperation implements ParseActionOperation {
        @Override
        public Action actionFor(final String description) {
            return new Action(ActionType.UNKNOWN, "", "");
        }

        @Override
        public boolean canHandle(final String description) {
            return false;
        }
    }
}
