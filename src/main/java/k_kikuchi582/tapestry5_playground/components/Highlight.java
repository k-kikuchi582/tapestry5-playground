package k_kikuchi582.tapestry5_playground.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.RenderSupport;
import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.IncludeJavaScriptLibrary;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.ioc.annotations.Inject;

@IncludeJavaScriptLibrary("./Highlight.js")
public class Highlight {
    @Parameter(required = true)
    private String text;
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String lang;

    @Inject
    private ComponentResources componentResources;
    @Inject
    private RenderSupport renderSupport;

    private String id;

    @SetupRender
    void setupRender() {
        id = renderSupport.allocateClientId(componentResources);

        renderSupport.addStylesheetLink("//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.5.0/styles/vs.min.css", null);
        renderSupport.addScriptLink("//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.5.0/highlight.min.js");
        renderSupport.addScript("CodeHighlight.init('%s');", id);
    }

    @BeginRender
    void beginRender(MarkupWriter writer) {
        writer.element("pre");
        {
            Element code = writer.element("code");
            code.addClassName("language-" + lang);
            code.attribute("id", id);
            writer.writeRaw(text);
            writer.end();
        }
        writer.end();
    }

}
