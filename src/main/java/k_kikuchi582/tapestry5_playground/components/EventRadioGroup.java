package k_kikuchi582.tapestry5_playground.components;

import k_kikuchi582.tapestry5_playground.EventRadioContainer;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.RenderSupport;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Environment;

import java.util.Objects;

public class EventRadioGroup {
    @Parameter(required = true)
    private Object value;
    @Parameter
    private boolean disabled;
    @Parameter
    private Object[] context;
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String event;
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String zone;

    @Inject
    private ComponentResources componentResources;
    @Inject
    private RenderSupport renderSupport;
    @Inject
    private Environment environment;

    @SetupRender
    void setupRender() {
        String controlName = renderSupport.allocateClientId(componentResources);

        environment.push(EventRadioContainer.class, new EventRadioContainer() {
            @Override
            public String getControlName() {
                return controlName;
            }

            @Override
            public boolean isDisabled() {
                return disabled;
            }

            @Override
            public boolean isSelected(Object value) {
                return Objects.equals(EventRadioGroup.this.value, value);
            }

            @Override
            public String getEvent() {
                return event == null ? componentResources.getId(): event;
            }

            @Override
            public Object[] getContext() {
                return context;
            }

            @Override
            public String getZone() {
                return zone;
            }
        });
    }

    @AfterRender
    void afterRender() {
        environment.pop(EventRadioContainer.class);
    }
}
