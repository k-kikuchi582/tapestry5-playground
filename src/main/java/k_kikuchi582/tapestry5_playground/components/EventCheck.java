package k_kikuchi582.tapestry5_playground.components;

import org.apache.commons.lang3.StringUtils;
import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.EventLink;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.List;

@SupportsInformalParameters
@IncludeJavaScriptLibrary({"./EventCheck.js"})
public class EventCheck {
    @Parameter(required = true)
    @Property
    private boolean checked;
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String event;
    @Parameter
    @Property
    private boolean disabled;
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String id;
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String zone;
    @Parameter
    @Property
    private Object[] context;

    @Inject
    private ComponentResources componentResources;
    @Inject
    private RenderSupport renderSupport;

    @InjectComponent
    private EventLink eventCheckLink;

    @Property
    private String checkboxId;

    @SetupRender
    void setupRender() {
        if (checkboxId == null) {
            checkboxId = generateCheckboxId();
        }
    }

    private String generateCheckboxId() {
        if (StringUtils.isNotBlank(id)) {
            return id;
        }
        return renderSupport.allocateClientId(componentResources.getId());
    }

    @AfterRender
    void afterRender(MarkupWriter markupWriter) {
        componentResources.renderInformalParameters(markupWriter);
        Element checkbox = markupWriter.getElement().getElementById(checkboxId);
        if (checked) {
            checkbox.attribute("checked", "checked");
        }
        if (disabled) {
            checkbox.attribute("disabled", "disabled");
        } else {
            renderSupport.addScript("EventCheck.init('%s', '%s');", checkboxId, eventCheckLink.getClientId());
        }
    }

    public String getEvent() {
        if (StringUtils.isNotBlank(event)) {
            return event;
        }

        return componentResources.getId();
    }
}
