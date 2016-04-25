package org.mrr;

import org.mrr.reader.UiElementsCsvSupplier;

import java.util.*;

/**
 * The class stores the user interface elements [name, identifiedBy, id] registered for the current application.
 */
public class UiElementsDeposit {
    //TODO Spring bean with shared (cached) content here...
    private Map<String, UiElement> articles = new TreeMap<>();
    private final UiElementsCsvSupplier supplier;

    public UiElementsDeposit(final UiElementsCsvSupplier supplier) {
        this.supplier = supplier;
    }

    /**
     * Delivers the registered ui elements.
     * @return map with [key, values] of type [uiName, id].
     */
    Map<String, UiElement> articles() {
        initArticlesIfEmpty();
        return Collections.unmodifiableMap(articles);
    }

    //TODO move the functionality into the spring bean init method and remove the content in the articles() body.
    private void initArticlesIfEmpty() {
        if (articles.isEmpty()) {
            articles = supplier.createUiElements();
        }
    }

    /**
     * The method returns the the user interface element stored with the given name.
     *
     * @param name the name of the user interface element.
     * @return The UiElement for the corresponding name.
     * @throws UiElementNotFoundException if no element is stored in deposit for the current name.
     */
    public UiElement searchUiElementByName(final String name) {
        //TODO replace the call to articles() with field article when the class as spring bean defined is.
        if (articles().containsKey(name)) {
            return articles.get(name);
        }
        throw new UiElementNotFoundException("No identifier found for the element: "
                    + name + ".");
    }
}
