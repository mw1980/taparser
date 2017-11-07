package org.mrr.integration;

import org.junit.jupiter.api.Test;
import org.mrr.ParseActionFactory;
import org.mrr.ParseActionFactoryImpl;
import org.mrr.ParseActionOperation;
import org.mrr.ParseClickButtonOperation;
import org.mrr.ParseClickRadioButtonOperation;
import org.mrr.ParseDeselectCheckboxOperation;
import org.mrr.ParseEditTextfieldOperation;
import org.mrr.ParseLoadPageActionOperation;
import org.mrr.ParseSelectCheckboxOperation;
import org.mrr.ParseSelectDropdownOperation;
import org.mrr.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class ParseActionFactoryIntegrationTest {
    private final ApplicationContext context = SpringApplication.run(ApplicationConfig.class);
    private final ParseActionFactory underTest = context.getBean("parseActionFactory", ParseActionFactoryImpl.class);

    @Test
    void whenParsingLoadPageDescription_shouldReturnLoadPageOperation() throws Exception {
        assertThat(this.underTest.parseOperationForDescription("Load page www.myurl.com"))
                .isInstanceOf(ParseLoadPageActionOperation.class);
    }

    @Test
    void whenParsingEditTextDescription_shouldReturnEditTextOperation() {
        assertThat(this.underTest.parseOperationForDescription("Set in textfield myfield value 20"))
                .isInstanceOf(ParseEditTextfieldOperation.class);
    }

    @Test
    void whenParsingClickButtonDescription_shouldReturnClickButtonOperation() {
        assertThat(underTest.parseOperationForDescription("Click button submit"))
                .isInstanceOf(ParseClickButtonOperation.class);
    }

    @Test
    void whenParsingSelectDropdownDescription_shouldReturnSelectDropdownOperation() {
        assertThat(underTest.parseOperationForDescription("Select in dropdown clients value \"johnie walker\""))
                .isInstanceOf(ParseSelectDropdownOperation.class);
    }

    @Test
    void whenParsingSelectCheckboxDescription_shouldReturnSelectCheckboxOperation() {
        assertThat(underTest.parseOperationForDescription("Select checkbox iAgree"))
                .isInstanceOf(ParseSelectCheckboxOperation.class);
    }

    @Test
    void whenParsingDeselectCheckboxDescription_shouldReturnDeselectCheckboxOperation() {
        assertThat(underTest.parseOperationForDescription("Deselect checkbox iAgree"))
                .isInstanceOf(ParseDeselectCheckboxOperation.class);
    }

    @Test
    void whenParsingSelectRadioButtonDescription_shouldReturnClickRadioButtonOperation() {
        assertThat(underTest.parseOperationForDescription("Select radio button perEmail"))
                .isInstanceOf(ParseClickRadioButtonOperation.class);
    }

    @Test
    void whenParsingUnknownActionDescription_shouldReturnUnknownOperation() {
        assertThat(underTest.parseOperationForDescription("unknown action"))
                .isEqualTo(new ParseActionOperation.DummyParseActionOperation());
    }
}