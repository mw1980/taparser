package org.mrr.reader;

import org.junit.Test;
import org.mrr.core.TestSpecificationException;
import org.mrr.specification.FileTestSpecificationStoreImpl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class TestCaseReaderFileTest {

  @Test(expected = TestSpecificationException.class)
  public void whenReadingNotExistingFile_shouldThrowException() {
    new FileTestSpecificationStoreImpl("NotExistingFile.txt").deliverTestDescriptions();
  }

  @Test
  public void whenReadingFromEmptyFile_shouldReturnEmptyList() {
    List<String> testCases = new FileTestSpecificationStoreImpl(TestConstants.TEST_RESOURCE_FOLDER_LOCATION + "/EmptyTestCase.txt").deliverTestDescriptions();
    assertTrue(testCases.isEmpty());
  }

  @Test
  public void whenReadingFromSampleFile_shouldReturnExpectedListElements() {
    List<String> testCasesFromFile = new FileTestSpecificationStoreImpl(TestConstants.TEST_RESOURCE_FOLDER_LOCATION + "FirstTestCase.txt").deliverTestDescriptions();
    assertThat(testCasesFromFile.size()).isEqualTo(8);
    assertThat(testCasesFromFile.get(0)).isEqualTo("Load page http://www.google.com");
  }
}
