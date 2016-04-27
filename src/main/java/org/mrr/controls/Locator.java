package org.mrr.controls;

import org.mrr.IdentificationType;

/**
 * The class stores the information needed to locate a control on a html page.
 */
public class Locator {
    private final IdentificationType type;
    private final String id;

    public Locator(final IdentificationType type, final String id) {
        this.type = type;
        this.id = id;
    }

    public IdentificationType type() {
        return type;
    }

    public String id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locator locator = (Locator) o;

        if (type != locator.type) return false;
        return id != null ? id.equals(locator.id) : locator.id == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Locator{" +
                "type=" + type +
                ", id='" + id + '\'' +
                '}';
    }
}
