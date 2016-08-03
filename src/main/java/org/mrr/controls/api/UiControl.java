package org.mrr.controls.api;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.mrr.core.IdentificationCriteria;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.mrr.core.IdentificationCriteria.UNKNOWN;

/**
 * Java representation of an user interface control.
 */
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UiControl {
    public static final UiControl NO_CONTROL = new UiControl(EMPTY, new UiLocator(UNKNOWN, EMPTY));

    private final String name;
    private final UiLocator locator;

    public IdentificationCriteria identifiedBy() {
        return locator.identificationCriteria();
    }

    public String id() {
        return locator.id();
    }
}
