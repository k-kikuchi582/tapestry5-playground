package k_kikuchi582.tapestry5_playground.components;

import k_kikuchi582.tapestry5_playground.EventRadioContainer;
import org.apache.commons.lang3.StringUtils;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.RenderSupport;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.EventLink;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.ioc.annotations.Inject;

@SupportsInformalParameters
@IncludeJavaScriptLibrary({"./EventRadio.js"})
public class EventRadio {
    @Parameter(required = true)
    private Object value;
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String event;
    @Parameter
    private boolean disabled;
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String id;
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String zone;
    @Parameter
    private Object[] context;

    @Inject
    private ComponentResources componentResources;
    @Inject
    private RenderSupport renderSupport;

    @Environmental
    private EventRadioContainer eventRadioContainer;

    @InjectComponent
    private EventLink eventRadioLink;

    @Property
    private String radioId;

    @SetupRender
    void setupRender() {
        if (radioId == null) {
            radioId = generateRadioId();
        }
    }

    private String generateRadioId() {
        if (StringUtils.isNotBlank(id)) {
            return id;
        }
        return renderSupport.allocateClientId(componentResources.getId());
    }

    @AfterRender
    void afterRender(MarkupWriter markupWriter) {
        componentResources.renderInformalParameters(markupWriter);
        Element radio = markupWriter.getElement().getElementById(radioId);
        if (eventRadioContainer.isSelected(value)) {
            radio.attribute("checked", "checked");
        }
        if (isDisabled()) {
            radio.attribute("disabled", "disabled");
        } else {
            renderSupport.addScript("EventRadio.init('%s', '%s');", radioId, eventRadioLink.getClientId());
        }
    }

    public String getName() {
        return eventRadioContainer.getControlName();
    }

    public boolean isDisabled() {
        return disabled || eventRadioContainer.isDisabled();
    }

    public String getEvent() {
        if (StringUtils.isNotBlank(event)) {
            return event;
        }

        return eventRadioContainer.getEvent();
    }

    public String getZone() {
        if (StringUtils.isNotBlank(zone)) {
            return zone;
        }
        return eventRadioContainer.getZone();
    }

    public Object[] getContext() {
        Object[] base;
        if (context != null) {
            base = context;
        } else {
            base = eventRadioContainer.getContext();
        }

        if (base == null) {
            return new Object[] { value };
        }

        Object[] ret = new Object[base.length+1];
        ret[0] = value;
        System.arraycopy(base, 0, ret, 1, base.length);
        return ret;
    }

}
