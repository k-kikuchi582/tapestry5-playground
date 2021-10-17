package k_kikuchi582.tapestry5_playground.components.component.catalog;

import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Zone;

public class ZoneUpdateEffectSample {
    @Persist
    @Property
    private Boolean visible;

    @Persist
    @Property
    private String show;

    @Persist
    @Property
    private String update;

    @InjectComponent
    private Zone zoneEffectOuter;
    @InjectComponent
    private Zone zoneEffectInner;

    @SetupRender
    void setupRender() {
        if (visible == null) {
            visible = true;
        }

        if (show == null) {
            show = "show";
        }
        if (update == null) {
            update = "highlight";
        }
    }

    @OnEvent(value = "changeVisible")
    Object onChangeVisible( boolean visible ) {
        this.visible = visible;
        return zoneEffectOuter.getBody();
    }

    @OnEvent(value = "changeShow")
    Object onChangeShow( String effect ) {
        show = effect;
        return zoneEffectOuter.getBody();
    }

    @OnEvent(value = "changeUpdate")
    Object onChangeUpdate( String effect ) {
        update = effect;
        return zoneEffectOuter.getBody();
    }

    @OnEvent(value = "update")
    Object onUpdate() {
        return zoneEffectInner.getBody();
    }
}
