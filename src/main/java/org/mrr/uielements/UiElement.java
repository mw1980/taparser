package org.mrr.uielements;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.mrr.IdentificationType;

/**
 * The class contains the elements that identify an user interface element.
 */
public class UiElement {
  /**
   * The "non technical" name of the ui element as appears in the test case description.
   * e.g. login, calculate.
   */
  private final String name;

  /**
   * The way the user interface element is identified.
   * E.g. "By Id", "By XPath".
   */
  private final IdentificationType type;

  /**
   * The technical identification value.
   * E.g. the id of the element ("user_name").
   */
  private final String id;

  /**
   * @param name non technical user interface name.
   * @param type identification for ui element, e.g.: "id", "name", "xpath".
   * @param id technical identification string, e.g. the html id.
   */
  public UiElement(final String name, final IdentificationType type, final String id) {
    this.name = name;
    this.type = type;
    this.id = id;
  }

  public String name() {
    return name;
  }

  public IdentificationType type() {
    return type;
  }

  public String id() {
    return id;
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other) {
      return true;
    }

    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    final UiElement that = (UiElement) other;

    return new EqualsBuilder()
      .append(name(), that.name())
      .append(type(), that.type())
      .append(id(), that.id())
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
      .append(name())
      .append(type())
      .append(id())
      .toHashCode();
  }

  @Override
  public String toString() {
    return "UiElement{"
      + "name='" + name + '\''
      + ", type=" + type
      + ", id='" + id + '\''
      + '}';
  }
}
