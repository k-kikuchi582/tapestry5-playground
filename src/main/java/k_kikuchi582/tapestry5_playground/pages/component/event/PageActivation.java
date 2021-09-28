package k_kikuchi582.tapestry5_playground.pages.component.event;


import k_kikuchi582.tapestry5_playground.util.Utils;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.io.IOException;

public class PageActivation {

    @Property
    private int count;

    @Property
    private Object[] values;

    @Property
    private Object value; // for loop

    @Property
    private Object[] one = new Object[] { "1" };

    @Property
    private Object[] two = new Object[] { "1", "2" };

    private Object[] params;

    @OnEvent(EventConstants.ACTIVATE)
    void onActivate(EventContext eventContext) {
        count = eventContext.getCount();
        values = new Object[count];
        for (int i = 0; i < count; i++) {
            values[i] = eventContext.get(Object.class, i);
        }
    }

    @OnEvent(component = "zero")
    void onActionFromZero() {
        params = new Object[0];
    }

    @OnEvent(component = "one")
    void onActionFromOne() {
        params = one;
    }

    @OnEvent(component = "two")
    void onActionFromTwo() {
        params = two;
    }

    @OnEvent(EventConstants.PASSIVATE)
    Object[] onPassivate() {
        return params;
    }

    @Inject
    @Path("./PageActivation.txt")
    private Asset pageActivation;

    @Inject
    @Path("./PagePassivate.txt")
    private Asset pagePassivate;

    public String getPageActivationJavaText() throws IOException {
        return Utils.getText(pageActivation);
    }

    public String getPagePassivateJavaText() throws IOException {
        return Utils.getText(pagePassivate);
    }
}
