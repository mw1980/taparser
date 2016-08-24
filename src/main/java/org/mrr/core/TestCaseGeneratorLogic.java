package org.mrr.core;

import org.mrr.core.domain.TestStep;

/**
 * Base interface for generate code classes.
 */
public interface TestCaseGeneratorLogic {
    String generateCode(TestStep testStep);
}
