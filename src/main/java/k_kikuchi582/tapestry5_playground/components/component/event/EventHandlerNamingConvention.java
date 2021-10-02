package k_kikuchi582.tapestry5_playground.components.component.event;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.Zone;

public class EventHandlerNamingConvention {

    @InjectComponent
    private Zone eventHandlerNamingConventionZone;

    private Fruit fruit;

    private boolean isSubmitted;

    Zone onActionFromApple() {
        fruit = Fruit.APPLE;
        return eventHandlerNamingConventionZone;
    }

    Zone onOrange() {
        fruit = Fruit.ORANGE;
        return eventHandlerNamingConventionZone;
    }

    Zone onGrape() {
        fruit = Fruit.GRAPE;
        return eventHandlerNamingConventionZone;
    }

    void onSelectedFromPeach() {
        fruit = Fruit.PEACH;
    }

    Zone onSubmitFromEventHandlerNamingConventionForm() {
        isSubmitted = true;
        return eventHandlerNamingConventionZone;
    }

    public String getMessage() {
        StringBuilder builder = new StringBuilder();
        if (isSubmitted) {
            builder.append("[submit on eventHandlerNamingConventionForm] ");
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
