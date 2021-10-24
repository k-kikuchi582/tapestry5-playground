package k_kikuchi582.tapestry5_playground.components.component.catalog.form;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class RadioSample {
    @Property
    private String fruit;
    @Property
    @Persist
    private String fruitForDisabled;
    @Property
    @Persist
    private boolean disabled;

    @InjectComponent("fruitZone")
    private Zone fruitZone;
    @InjectComponent("disabledZone")
    private Zone disabledZone;

    @OnEvent("toggleDisabled")
    private Block onToggleDisabled(boolean disabled) {
        this.disabled = disabled;
        return disabledZone.getBody();
    }

    @OnEvent(value = EventConstants.SUBMIT, component = "fruitForm")
    Block onSubmitFromFruitForm() {
        return fruitZone.getBody();
    }

    @OnEvent(value = EventConstants.SUBMIT, component = "disabledForm")
    Block onSubmitFromDisabledForm() {
        return disabledZone.getBody();
    }
}
