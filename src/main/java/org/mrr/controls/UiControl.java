package org.mrr.controls;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.mrr.IdentificationType;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.mrr.IdentificationType.UNKNOWN;

/**
 * Java representation of an user interface control.
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UiControl {
    static final UiControl NO_CONTROL = new UiControl(EMPTY, new Locator(UNKNOWN, EMPTY));
    private final String name;
    private final Locator locator;

    public IdentificationType identificationType() {
        return locator.type();
    }

    public String id() {
        return locator.id();
    }
}
