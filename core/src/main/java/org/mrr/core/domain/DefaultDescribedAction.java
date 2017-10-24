package org.mrr.core.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.mrr.core.DescribedAction;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DefaultDescribedAction implements DescribedAction {
    private final String description;

    @Override
    public String description() {
        return description;
    }
}
