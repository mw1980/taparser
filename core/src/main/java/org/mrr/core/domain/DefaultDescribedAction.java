package org.mrr.core.domain;

import lombok.Value;
import org.mrr.core.DescribedAction;

@Value
public class DefaultDescribedAction implements DescribedAction {
    private final String description;

    @Override
    public String description() {
        return description;
    }
}
