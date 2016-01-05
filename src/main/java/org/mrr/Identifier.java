package org.mrr;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The class contains the elements that identify an user interface element.
 */
public class Identifier {
  /**
   * The "non technical" name of the ui element as appears in the test case description.
   * e.g. login, calculate.
   */
  private final String name;

  /**
   * The way the user interface element is identified.
   * E.g. "By Id", "By XPath".
   */
  private final IdentificationType identificationType;

  /**
   * The technical identification type.
   * E.g. the id of the element ("user_name").
   */
  private final String identificationString;

  /**
   * Bean class, stores the elements needed to identify an user interface element.
   * @param name non technical user interface name.
   * @param identificationType identification for ui element, e.g.: "id", "name", "xpath".
   * @param identificationString technical identification string, e.g. the html id.
   */
  public Identifier(final String name, final IdentificationType identificationType,
                    final String identificationString) {
    this.name = name;
    this.identificationType = identificationType;
    this.identificationString = identificationString;
  }

  public String getName() {
    return name;
  }

  public IdentificationType getIdentificationType() {
    return identificationType;
  }

  public String getIdentificationString() {
    return identificationString;
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other) {
      return true;
    }

    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    final Identifier that = (Identifier) other;

    return new EqualsBuilder()
      .append(getName(), that.getName())
      .append(getIdentificationType(), that.getIdentificationType())
      .append(getIdentificationString(), that.getIdentificationString())
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
      .append(getName())
      .append(getIdentificationType())
      .append(getIdentificationString())
      .toHashCode();
  }

  @Override
  public String toString() {
    return "Identifier{"
      + "name='" + name + '\''
      + ", identificationType=" + identificationType
      + ", identificationString='" + identificationString + '\''
      + '}';
  }
}
