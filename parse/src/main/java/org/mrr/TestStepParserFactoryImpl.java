package org.mrr;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static org.mrr.AbstractParseTestActionOperationTemplate.UNKNOWN;

@Component("testStepParserAgent")
public class TestStepParserFactoryImpl implements ApplicationContextAware, TestStepParserFactory {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public ParseTestActionOperation parserForDescription(final String description) {
        return registeredTestStepParsers().stream()
                .filter(parser -> parser.canHandle(description))
                .findFirst()
                .orElse(UNKNOWN);
    }

    private Collection<ParseTestActionOperation> registeredTestStepParsers() {
        final Map<String, ParseTestActionOperation> parsers = this.context.getBeansOfType(ParseTestActionOperation.class);
        return parsers == null ? new ArrayList<>() : parsers.values();
    }
}
