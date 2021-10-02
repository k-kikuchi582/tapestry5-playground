package k_kikuchi582.tapestry5_playground.components;

import org.apache.commons.lang3.StringUtils;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.RenderSupport;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.List;

@IncludeStylesheet("./Tabs.css")
@IncludeJavaScriptLibrary("./Tabs.js")
public class Tabs {
    @Parameter(required = true)
    @Property
    private List<String> headers;

    @Parameter(required = true)
    @Property
    private List<Block> bodies;

    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String bodyMaxHeight;

    @Inject
    private ComponentResources componentResources;
    @Inject
    private RenderSupport renderSupport;

    @Property
    private String header;

    @Property
    private Block body;

    @Property
    private int index;

    @Property
    private String id;

    @SetupRender
    void setupRender() {
        id = renderSupport.allocateClientId(componentResources);

        renderSupport.addScript("new Tabs('%s');", id);
    }

    public boolean isFirst() {
        return index == 0;
    }

    public String getTabBodiesStyle() {
        if (StringUtils.isBlank(bodyMaxHeight)) {
            return "";
        }

        return "max-height: " + bodyMaxHeight + "; overflow-y: auto;";
    }
}
