package org.mrr.controls.api;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.mrr.core.IdentificationCriteria;

/**
 * The class stores the information needed to locate a control on a html page.
 */
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UiLocator {
    private final IdentificationCriteria identificationCriteria;
    private final String id;

    IdentificationCriteria identificationCriteria() {
        return identificationCriteria;
    }

    public String id() {
        return id;
    }
}
