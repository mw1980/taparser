package org.mrr.parser;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static org.mrr.parser.AbstractTestStepParserTemplate.UNKNOWN;

@Component("testStepParserAgent")
class TestStepParserFactoryImpl implements ApplicationContextAware, TestStepParserFactory {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public TestStepParser deliverParser(final String description) {
        for (final TestStepParser parser : registeredTestStepParsers()) {
            if (parser.canHandle(description)) {
                return parser;
            }
        }
        return UNKNOWN;
    }

    private Collection<TestStepParser> registeredTestStepParsers() {
        final Map<String, TestStepParser> parsers = this.context.getBeansOfType(TestStepParser.class);
        return parsers == null ? new ArrayList<TestStepParser>() : parsers.values();
    }
}
