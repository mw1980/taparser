package org.mrr.controls.api;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.mrr.IdentificationType;

/**
 * The class stores the information needed to locate a control on a html page.
 */
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Locator {
    private final IdentificationType type;
    private final String id;

    IdentificationType type() {
        return type;
    }

    public String id() {
        return id;
    }
}
