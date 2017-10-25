package org.mrr.reader.txt.controls;

import org.mrr.core.domain.UiControl;
import org.mrr.reader.txt.controls.api.ControlsRepository;
import org.mrr.reader.txt.controls.api.RegisteredControls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.apache.commons.collections4.MapUtils.isEmpty;

/**
 * Repository class for the controls registered to the application.
 * The class also implements a low level caching mechanism.
 */
@Component
class DefaultControlsRepository implements ControlsRepository {

    private final RegisteredControls registered;

    //low level caching
    private Map<String, UiControl> controls;

    @Autowired
    public DefaultControlsRepository(final RegisteredControls registeredControls) {
        this.registered = registeredControls;
    }

    @Override
    public Map<String, UiControl> controls() {
        havingTheControlsInitialized();
        return controls;
    }

    private void havingTheControlsInitialized() {
        if (isEmpty(this.controls)) {
            this.controls = registered.allRegistered();
        }
    }

    @Override
    public UiControl controlWithName(final String name) {
        havingTheControlsInitialized();
        return controls.getOrDefault(name, UiControl.NO_CONTROL);
    }
}
