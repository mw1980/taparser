package org.mrr;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

import static java.util.Collections.emptyList;
import static org.mrr.AbstractParseActionOperationTemplate.UNKNOWN;

@Component("parseActionFactory")
public class ParseActionFactoryImpl implements ApplicationContextAware, ParseActionFactory {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public ParseActionOperation parseOperationFromDescription(final String description) {
        return registeredTestStepParsers().stream()
                .filter(parser -> parser.canHandle(description))
                .findFirst()
                .orElse(UNKNOWN);
    }

    private Collection<ParseActionOperation> registeredTestStepParsers() {
        final Map<String, ParseActionOperation> parseOperations = this.context.getBeansOfType(ParseActionOperation.class);
        return parseOperations == null ? emptyList() : parseOperations.values();
    }
}
