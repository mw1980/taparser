package org.mrr.controls;

import java.util.Map;

import static java.util.Collections.unmodifiableMap;

/**
 * The class stores the controls registered for the current application.
 */
public class ControlsPool {
    private final ControlsAgent supplier;
    //TODO Spring bean with shared (cached) content here...
    private Map<String, Control> controls;

    public ControlsPool(final ControlsAgent supplier) {
        this.supplier = supplier;
    }

    /**
     * Delivers the currently registered controls.
     */
    protected Map<String, Control> controls() {
        initControlsIfEmpty();
        return unmodifiableMap(this.controls);
    }

    //TODO move the functionality into the spring bean afterCreation method and remove the content in the controls() body.
    private void initControlsIfEmpty() {
        if (this.controls == null) {
            this.controls = supplier.supply();
        }
    }

    /**
     * The method returns the control with the given name.
     * @param name control name
     * @return the control, if found. Otherwise a null control object.
     */
    public Control searchForControl(final String name) {
        //TODO replace the call to controls() with field article when the class as spring bean defined is.
        if (controls().containsKey(name)) {
            return controls.get(name);
        } else {
            return Control.NO_CONTROL;
        }
    }
}
