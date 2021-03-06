package org.mrr;

import org.mrr.api.CodeFactory;
import org.mrr.api.CodeOperationNotFoundException;
import org.mrr.api.CodedOperation;
import org.mrr.core.domain.Action;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class DefaultCodeFactory implements ApplicationContextAware, CodeFactory {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public CodedOperation codedOperationFor(final Action action) {
        return this.context.getBeansOfType(CodedOperation.class)
                .values().stream()
                .filter(operation -> operation.canHandle(action))
                .findFirst()
                .orElseThrow(() -> new CodeOperationNotFoundException("No code generate operation registered for the test step: " + action));
    }
}
