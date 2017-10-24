package org.mrr.specification;

import org.mrr.core.CodeActionLogic;
import org.mrr.core.CodeSpecificationLogic;
import org.mrr.core.CodedAction;
import org.mrr.core.ParseActionLogic;
import org.mrr.core.TestSpecificationStore;
import org.mrr.core.domain.DefaultCodedAction;
import org.mrr.core.domain.DefaultDescribedAction;
import org.mrr.core.domain.DefaultParsedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class CodeSpecificationLogicImpl implements CodeSpecificationLogic {
    private final ParseActionLogic parseLogic;
    private final CodeActionLogic codeLogic;
    private final TestSpecificationStore specificationStore;

    @Autowired
    public CodeSpecificationLogicImpl(final ParseActionLogic parseActionLogic,
                                      final CodeActionLogic codeLogic,
                                      final TestSpecificationStore specificationStore) {
        this.parseLogic = parseActionLogic;
        this.codeLogic = codeLogic;
        this.specificationStore = specificationStore;
    }

    @Override
    public List<CodedAction> codeForSpecification() {
        return specificationStore.testDescriptions().stream()
                .map(description ->
                        new DefaultCodedAction(
                                new DefaultParsedAction(
                                        new DefaultDescribedAction(description),
                                        parseLogic),
                                codeLogic)
                )
                .collect(toList());
    }
}
