package org.mrr;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mrr.api.CodeLocationLogic;
import org.mrr.api.CodeOperationNotFoundException;
import org.mrr.api.GenerateActionCodeOperation;
import org.mrr.core.domain.Action;
import org.mrr.selenium.CodedClickButtonOperation;
import org.mrr.selenium.CodedSelectInDropdownOperation;
import org.springframework.context.ApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mrr.core.domain.ActionType.CLICK_BUTTON;
import static org.mrr.core.domain.ActionType.SELECT_IN_DROPDOWN;

class DefaultCodeFactoryTest {
    private final ApplicationContext context = Mockito.mock(ApplicationContext.class);

    @Test
    void shouldHandleMissingCodeGenerationOperation() {
        final DefaultCodeFactory underTest = new DefaultCodeFactory();
        underTest.setApplicationContext(context);
        when(context.getBeansOfType(GenerateActionCodeOperation.class)).thenReturn(emptyMap());
        assertThrows(
                CodeOperationNotFoundException.class,
                () -> underTest.codeGenerationOperationFor(Action.withType(CLICK_BUTTON))
        );
    }

    @Test
    void shouldDeliverTheRightCodeGenerationOperation() {
        final CodeLocationLogic codeLocationLogic = Mockito.mock(CodeLocationLogic.class);
        final DefaultCodeFactory underTest = new DefaultCodeFactory();
        underTest.setApplicationContext(context);
        when(context.getBeansOfType(GenerateActionCodeOperation.class))
                .thenReturn(
                        map(new CodedClickButtonOperation(codeLocationLogic), new CodedSelectInDropdownOperation(codeLocationLogic)));

        assertThat(underTest.codeGenerationOperationFor(Action.withType(SELECT_IN_DROPDOWN))).isInstanceOf(CodedSelectInDropdownOperation.class);
    }

    private Map<String, GenerateActionCodeOperation> map(final GenerateActionCodeOperation first,
                                                         final GenerateActionCodeOperation second) {
        Map<String, GenerateActionCodeOperation> result = new LinkedHashMap<>();
        result.put("first", first);
        result.put("second", second);
        return result;
    }

}