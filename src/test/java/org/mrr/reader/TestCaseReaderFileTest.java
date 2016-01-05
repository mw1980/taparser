package org.mrr.reader;

import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class TestCaseReaderFileTest {

  @Test(expected = TestSpecificationReaderException.class)
  public void whenReadingNotExistingFile_shouldThrowException() {
    new FileTestCaseReader("NotExistingFile.txt").readTestCasesFromFile();
  }

  @Test
  public void whenReadingFromEmptyFile_shouldReturnEmptyList() {
    List<String> testCases = new FileTestCaseReader(TestConstants.PATH_TO_TEST_RESOURCE_FOLDER + "/EmptyTestCase.txt").readTestCasesFromFile();
    assertTrue(testCases.isEmpty());
  }

  @Test
  public void whenReadingFromSampleFile_shouldReturnExpectedListElements() {
    List<String> testCasesFromFile = new FileTestCaseReader(TestConstants.PATH_TO_TEST_RESOURCE_FOLDER + "FirstTestCase.txt").readTestCasesFromFile();
    assertThat(testCasesFromFile.size()).isEqualTo(8);
    assertThat(testCasesFromFile.get(0)).isEqualTo("Load page http://www.google.com");
  }
}
