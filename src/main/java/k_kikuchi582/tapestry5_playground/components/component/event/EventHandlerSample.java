package k_kikuchi582.tapestry5_playground.components.component.event;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.corelib.components.Zone;

public class EventHandlerSample {

    @InjectComponent
    private Zone eventHandlerSampleZone;

    private Fruit fruit;

    private boolean isSubmitted;

    @OnEvent(component = "apple")
    Zone onActionFromApple() {
        fruit = Fruit.APPLE;
        return eventHandlerSampleZone;
    }

    @OnEvent("orange")
    Zone onOrange() {
        fruit = Fruit.ORANGE;
        return eventHandlerSampleZone;
    }

    @OnEvent("grape")
    Zone onGrape() {
        fruit = Fruit.GRAPE;
        return eventHandlerSampleZone;
    }

    @OnEvent(value = EventConstants.SELECTED, component = "peach")
    void onSelectedFromPeach() {
        fruit = Fruit.PEACH;
    }

    @OnEvent(value = EventConstants.SUBMIT, component = "eventHandlerSampleForm")
    Zone onSubmitFromEventHandlerSampleForm() {
        isSubmitted = true;
        return eventHandlerSampleZone;
    }

    public String getMessage() {
        StringBuilder builder = new StringBuilder();
        if (isSubmitted) {
            builder.append("[submit on eventHandlerSampleForm] ");
        }
        if (fruit != null) {
            builder.append(fruit.name);
        }
        return builder.toString();
    }

    enum Fruit {
        APPLE("apple"),
        ORANGE("orange"),
        GRAPE("grape"),
        PEACH("peach");

        private final String name;

        Fruit(String name) {
            this.name = name;
        }
    }
}
