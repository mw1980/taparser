package org.mrr;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static org.mrr.AbstractTestStepParserTemplate.UNKNOWN;

@Component("testStepParserAgent")
public class TestStepParserFactoryImpl implements ApplicationContextAware, TestStepParserFactory {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public TestStepParser parserForDescription(final String description) {
        return registeredTestStepParsers().stream()
                .filter(parser -> parser.canHandle(description))
                .findFirst()
                .orElse(UNKNOWN);
    }

    private Collection<TestStepParser> registeredTestStepParsers() {
        final Map<String, TestStepParser> parsers = this.context.getBeansOfType(TestStepParser.class);
        return parsers == null ? new ArrayList<>() : parsers.values();
    }
}
