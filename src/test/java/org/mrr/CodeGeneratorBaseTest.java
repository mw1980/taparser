package org.mrr;

import static org.mrr.reader.TestConstants.TEST_ELEMENTS_IDENTIFIER_LOCATION;

import org.junit.Before;
import org.mrr.generator.GenerateIdCodeDelegateImpl;

/**
 * Base class for the generator tests.
 * It contains the method to reset the list of controls descriptionsAsText from the external file.
 */
public class CodeGeneratorBaseTest {

  protected GenerateIdCodeDelegateImpl testControlIdCodeGenerator;

  @Before
  public void setup(){
    this.testControlIdCodeGenerator = new GenerateIdCodeDelegateImpl(TEST_ELEMENTS_IDENTIFIER_LOCATION);
  }


}
