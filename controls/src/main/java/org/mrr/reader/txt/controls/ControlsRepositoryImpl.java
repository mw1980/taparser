package org.mrr.reader.txt.controls;

import org.mrr.core.domain.UiControl;
import org.mrr.reader.txt.controls.api.ControlsRepository;
import org.mrr.reader.txt.controls.api.RegisteredControls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.apache.commons.collections.MapUtils.isEmpty;

/**
 * Repository class for the controls allRegistered to the application.
 * The class also implements a low level caching mechanism.
 */
@Component
class ControlsRepositoryImpl implements ControlsRepository {

    private final RegisteredControls registered;

    //kind of caching
    private Map<String, UiControl> controls;

    @Autowired
    public ControlsRepositoryImpl(final RegisteredControls registeredControls) {
        this.registered = registeredControls;
    }

    @Override
    public Map<String, UiControl> controls() {
        havingTheControlsInitialized();
        return controls;
    }

    private void havingTheControlsInitialized() {
        if (isEmpty(this.controls)) {
            this.controls = registered.all();
        }
    }

    @Override
    public UiControl findControlByName(final String name) {
        havingTheControlsInitialized();
        return controls.getOrDefault(name, UiControl.NO_CONTROL);
    }
}
