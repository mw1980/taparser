package org.mrr.reader;

import java.util.List;

import org.junit.Test;
import org.mrr.core.StepDescriptionsStore;
import org.mrr.core.ReadSpecificationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class TestCaseReaderFileTest {

  @Test(expected = ReadSpecificationException.class)
  public void whenReadingNotExistingFile_shouldThrowException() {
    new StepDescriptionsStore("NotExistingFile.txt").deliverStepsDescription();
  }

  @Test
  public void whenReadingFromEmptyFile_shouldReturnEmptyList() {
    List<String> testCases = new StepDescriptionsStore(TestConstants.TEST_RESOURCE_FOLDER_LOCATION + "/EmptyTestCase.txt").deliverStepsDescription();
    assertTrue(testCases.isEmpty());
  }

  @Test
  public void whenReadingFromSampleFile_shouldReturnExpectedListElements() {
    List<String> testCasesFromFile = new StepDescriptionsStore(TestConstants.TEST_RESOURCE_FOLDER_LOCATION + "FirstTestCase.txt").deliverStepsDescription();
    assertThat(testCasesFromFile.size()).isEqualTo(8);
    assertThat(testCasesFromFile.get(0)).isEqualTo("Load page http://www.google.com");
  }
}
