package k_kikuchi582.tapestry5_playground.components.component.catalog.form;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class TextFieldSample {
    @Property
    private String explicit;

    @Property
    private String implicit;

    @Property
    private String clientId;

    @InjectComponent("explicitValueZone")
    private Zone explicitValueZone;

    @InjectComponent("implicitValueZone")
    private Zone implicitValueZone;

    @InjectComponent("clientIdZone")
    private Zone clientIdZone;

    @OnEvent(value = EventConstants.SUBMIT, component = "explicitValueForm")
    Block onSubmitFromExplicitValueForm() {
        return explicitValueZone.getBody();
    }

    @OnEvent(value = EventConstants.SUBMIT, component = "implicitValueForm")
    Block onSubmitFromImplicitValueForm() {
        return implicitValueZone.getBody();
    }

    @OnEvent(value = EventConstants.SUBMIT, component = "clientIdForm")
    Block onSubmitFromClientIdForm() {
        return clientIdZone.getBody();
    }
}
