package org.mrr;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;

import static java.util.Collections.singletonMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class ParseActionFactoryImplTest {

    private final ApplicationContext context = Mockito.mock(ApplicationContext.class);

    @Test
    void shouldReturnDummyParserIfNoneAvailable() {
        when(context.getBeansOfType(ParseActionOperation.class)).thenReturn(null);
        final ParseActionFactoryImpl underTest = new ParseActionFactoryImpl();
        underTest.setApplicationContext(context);

        assertThat(underTest.parseOperationForDescription("Click button myButton"))
                .isEqualTo(new ParseActionOperation.DummyParseActionOperation());
    }

    @Test
    void shouldReturnTheRightParserIfAnyAvailable() {
        final ParseClickButtonOperation clickButtonOperation = new ParseClickButtonOperation();
        when(context.getBeansOfType(ParseActionOperation.class)).thenReturn(singletonMap("", clickButtonOperation));
        final ParseActionFactoryImpl underTest = new ParseActionFactoryImpl();
        underTest.setApplicationContext(context);

        assertThat(underTest.parseOperationForDescription("Click button myButton"))
                .isEqualTo(clickButtonOperation);
    }
}