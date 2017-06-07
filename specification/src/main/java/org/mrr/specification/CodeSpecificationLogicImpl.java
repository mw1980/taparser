package org.mrr.specification;

import org.mrr.core.CodeSpecificationLogic;
import org.mrr.core.CodeTestActionLogic;
import org.mrr.core.CodedTestAction;
import org.mrr.core.ParseTestActionLogic;
import org.mrr.core.TestActionDescription;
import org.mrr.core.TestSpecificationStore;
import org.mrr.core.domain.DefaultCodedTestAction;
import org.mrr.core.domain.DefaultParsedTestAction;
import org.mrr.core.domain.DefaultTestActionDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class CodeSpecificationLogicImpl implements CodeSpecificationLogic {
    private final ParseTestActionLogic parseLogic;
    private final CodeTestActionLogic generateLogic;
    private final TestSpecificationStore specificationStore;

    @Autowired
    public CodeSpecificationLogicImpl(final ParseTestActionLogic parseTestActionLogic,
                                      final CodeTestActionLogic generateLogic,
                                      final TestSpecificationStore specificationStore) {
        this.parseLogic = parseTestActionLogic;
        this.generateLogic = generateLogic;
        this.specificationStore = specificationStore;
    }

    @Override
    public List<CodedTestAction> codeForSpecification() {
        return specificationStore.testDescriptions().stream()
                .map(DefaultTestActionDescription::new)
                .map(this::codeForSingleTestStep)
                .collect(toList());
    }

    /*
     * The method delivers the automation code for a single action.
     * @param description the free text description of the test step. E.g. Click button submit
     * @return the test action that contains the automation code for the free text description.
     */
    private CodedTestAction codeForSingleTestStep(final TestActionDescription description) {
        return new DefaultCodedTestAction(
                new DefaultParsedTestAction(description, parseLogic),
                generateLogic
        );
    }
}
