package org.mrr.core;

import org.mrr.core.domain.IdentificationCriteria;

/**
 * Visitor class for the {@link IdentificationCriteria} enums.
 * Returns the CodeLocationType classes, that deliver the identification code for the ui controls.
 */
public interface CodeLocationVisitor {

    CodeLocationType codeLocationForId();

    CodeLocationType codeLocationForXPath();

    CodeLocationType codeLocationForUnknownCriteria();
}
