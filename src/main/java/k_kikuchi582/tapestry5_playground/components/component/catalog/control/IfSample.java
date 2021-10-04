package k_kikuchi582.tapestry5_playground.components.component.catalog.control;

import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Zone;

public class IfSample {
    @Persist
    @Property
    private boolean flag;

    @InjectComponent
    private Zone ifSampleZone;

    @SetupRender
    void setupRender() {
        flag = true;
    }

    @OnEvent(value = "toggleFlag")
    Zone onToggleFlag(boolean nextFlag) {
        flag = nextFlag;
        return ifSampleZone;
    }
}
