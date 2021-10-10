package k_kikuchi582.tapestry5_playground.components.component.catalog.control;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;

public class DelegateSample {
    @Persist
    @Property
    private String fruit;

    @InjectComponent
    private Zone delegateSampleZone;

    @Inject
    private Block notSelectedBlock;
    @Inject
    private Block appleBlock;
    @Inject
    private Block orangeBlock;
    @Inject
    private Block grapeBlock;

    @OnEvent(value = "changeFruit")
    Zone onChangeFruit(String fruit) {
        this.fruit = fruit;
        return delegateSampleZone;
    }

    public Object getSelectedBlock() {
        if (fruit == null) {
            return notSelectedBlock;
        }
        if (fruit.equals("apple")) {
            return appleBlock;
        }
        if (fruit.equals("orange")) {
            return orangeBlock;
        }
        if (fruit.equals("grape")) {
            return grapeBlock;
        }
        return notSelectedBlock;
    }
}
