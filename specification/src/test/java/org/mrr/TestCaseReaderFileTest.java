package org.mrr;

import org.junit.Test;
import org.mrr.core.TestSpecificationException;
import org.mrr.specification.FileTestSpecificationStoreImpl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class TestCaseReaderFileTest {

  @Test(expected = TestSpecificationException.class)
  public void whenReadingNotExistingFile_shouldThrowException() {
    new FileTestSpecificationStoreImpl("NotExistingFile.txt").testDescriptions();
  }

  @Test
  public void whenReadingFromEmptyFile_shouldReturnEmptyList() {
    final List<String> testCases = new FileTestSpecificationStoreImpl(TestConstants.TEST_RESOURCE_FOLDER_LOCATION + "/EmptyTestCase.txt").testDescriptions();
    assertThat(testCases).isEmpty();
  }

  @Test
  public void whenReadingFromSampleFile_shouldReturnExpectedListElements() {
    final List<String> testCasesFromFile = new FileTestSpecificationStoreImpl(TestConstants.TEST_RESOURCE_FOLDER_LOCATION + "FirstTestCase.txt").testDescriptions();
    assertThat(testCasesFromFile.size()).isEqualTo(8);
    assertThat(testCasesFromFile.get(0)).isEqualTo("Load page http://www.google.com");
  }
}
