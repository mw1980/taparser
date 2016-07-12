package org.mrr.controls;

import org.mrr.IdentificationType;

import static org.mrr.IdentificationType.UNKNOWN;

/**
 * Java representation of an html control.
 */

public class UiControl {
    static final UiControl NO_CONTROL = new UiControl("", new Locator(UNKNOWN, ""));
    private final String name;
    private final Locator locator;

    public UiControl(final String nme, final Locator lcator) {
        this.name = nme;
        this.locator = lcator;
    }

    public IdentificationType type() {
        return locator.type();
    }

    public String id() {
        return locator.id();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UiControl component = (UiControl) o;

        if (name != null ? !name.equals(component.name) : component.name != null) return false;
        return locator != null ? locator.equals(component.locator) : component.locator == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (locator != null ? locator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UiControl{" +
                "name='" + name + '\'' +
                ", locator=" + locator +
                '}';
    }
}
