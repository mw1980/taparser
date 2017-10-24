package org.mrr.core.domain;

import lombok.Value;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.mrr.core.domain.IdentificationCriteria.UNKNOWN;

/**
 * Java representation of an user interface control.
 */
@Value
public class UiControl {
    public static final UiControl NO_CONTROL = new UiControl(EMPTY, new UiLocation(UNKNOWN, EMPTY));

    private final String name;
    private final UiLocation location;

    public IdentificationCriteria identificationCriteria() {
        return location.identificationCriteria();
    }

    public String id() {
        return location.value();
    }
}
