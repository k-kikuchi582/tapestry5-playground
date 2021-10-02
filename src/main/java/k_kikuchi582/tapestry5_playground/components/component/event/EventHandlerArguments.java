package k_kikuchi582.tapestry5_playground.components.component.event;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.util.TimeInterval;

import java.util.List;
import java.util.StringJoiner;

public class EventHandlerArguments {
    @InjectComponent
    private Zone eventHandlerArgumentsZone;

    @Property
    private String message = "";

    @OnEvent(value = "noArgs")
    private Zone onNoArgs() {
        message = "no-args";
        return eventHandlerArgumentsZone;
    }

    @OnEvent(value = "1arg")
    private Zone on1arg(int a) {
        message = "1 arg: " + a;
        return eventHandlerArgumentsZone;
    }

    @OnEvent(value = "2args")
    private Zone on2arg(String a, double b) {
        message = "2 args: " + a + "," + b;
        return eventHandlerArgumentsZone;
    }

    @OnEvent(value = "eventContext")
    private Zone onEventContext(EventContext context) {
        StringJoiner joiner = new StringJoiner(", ", "event-context[count=" + context.getCount() + "]: ", "");
        joiner.add(context.get(Integer.class, 0).toString());
        joiner.add(context.get(Boolean.class, 1).toString());
        joiner.add(context.get(TimeInterval.class, 2).toString());
        message = joiner.toString();
        return eventHandlerArgumentsZone;
    }
}
