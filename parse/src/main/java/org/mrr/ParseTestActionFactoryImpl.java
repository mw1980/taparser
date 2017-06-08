package org.mrr;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

import static java.util.Collections.emptyList;
import static org.mrr.AbstractParseTestActionOperationTemplate.UNKNOWN;

@Component("parseTestActionFactory")
public class ParseTestActionFactoryImpl implements ApplicationContextAware, ParseTestActionFactory {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public ParseTestActionOperation parseOperationFromDescription(final String description) {
        return registeredTestStepParsers().stream()
                .filter(parser -> parser.canHandle(description))
                .findFirst()
                .orElse(UNKNOWN);
    }

    private Collection<ParseTestActionOperation> registeredTestStepParsers() {
        final Map<String, ParseTestActionOperation> parseOperations = this.context.getBeansOfType(ParseTestActionOperation.class);
        return parseOperations == null ? emptyList() : parseOperations.values();
    }
}
