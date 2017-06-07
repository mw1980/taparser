package org.mrr.core.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.mrr.core.TestActionDescription;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DefaultTestActionDescription implements TestActionDescription {
    private final String description;

    @Override
    public String description() {
        return description;
    }
}
