package org.mrr;

import static org.mrr.reader.TestConstants.TEST_ELEMENTS_IDENTIFIER_LOCATION;

import org.junit.Before;
import org.mrr.generator.CodeIdentifierGenerator;

/**
 * Base class for the generator tests.
 * It contains the method to reset the list of identifiers read from the external file.
 */
public class CodeGeneratorBaseTest {

  protected CodeIdentifierGenerator testCodeIdentifierGenerator;

  @Before
  public void setup(){
    this.testCodeIdentifierGenerator = new CodeIdentifierGenerator(TEST_ELEMENTS_IDENTIFIER_LOCATION);
  }


}
