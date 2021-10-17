package k_kikuchi582.tapestry5_playground.components.component.catalog;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;

public class ZoneInLoopSample {
    @Inject
    private ComponentResources componentResources;

    @InjectComponent
    private Zone zoneWithId;

    @InjectComponent
    private Zone zoneWithoutId;

    @Persist
    private int[] countsForZoneWithId;

    @Persist
    private int[] countsForZoneWithoutId;

    @Property
    private int index;

    @SetupRender
    void setupRender() {
        countsForZoneWithId = new int[3];
        countsForZoneWithoutId = new int[3];
    }

    public String getExplicitZoneId() {
        return componentResources.getId() + "-zoneWithId-" + index;
    }

    public int getCountForZoneWithId() {
        return countsForZoneWithId[index];
    }

    public int getCountForZoneWithoutId() {
        return countsForZoneWithoutId[index];
    }

    @OnEvent(component = "countForZoneWithId")
    Object onActionFromCountForZoneWithId( int index ) {
        this.index = index;
        countsForZoneWithId[index]++;
        return zoneWithId.getBody();
    }

    @OnEvent(component = "countForZoneWithoutId")
    Object onActionFromCountForZoneWithoutId( int index ) {
        this.index = index;
        countsForZoneWithoutId[index]++;
        return zoneWithoutId.getBody();
    }
}
