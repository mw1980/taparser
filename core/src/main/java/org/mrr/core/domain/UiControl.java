package org.mrr.core.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.mrr.core.domain.IdentificationCriteria.UNKNOWN;

/**
 * Java representation of an user interface control.
 */
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UiControl {
    public static final UiControl NO_CONTROL = new UiControl(EMPTY, new UiLocation(UNKNOWN, EMPTY));

    private final String name;
    private final UiLocation location;

    public IdentificationCriteria identifiedBy() {
        return location.identificationCriteria();
    }

    public String id() {
        return location.value();
    }
}
