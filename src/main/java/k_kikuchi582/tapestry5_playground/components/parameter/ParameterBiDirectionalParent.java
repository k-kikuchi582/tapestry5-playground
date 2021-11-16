package k_kikuchi582.tapestry5_playground.components.parameter;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class ParameterBiDirectionalParent {
    @Persist
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @InjectComponent("countZone")
    @Property
    private Zone countZone;
}
