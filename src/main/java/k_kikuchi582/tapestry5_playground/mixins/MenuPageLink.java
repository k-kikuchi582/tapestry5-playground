package k_kikuchi582.tapestry5_playground.mixins;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.MixinAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

@MixinAfter
public class MenuPageLink {

    @Inject
    private ComponentResources componentResources;

    @BeginRender
    void onBeginRender(MarkupWriter markupWriter) {
        String pageName = componentResources.getPageName().toLowerCase().replace('.', '/');
        String href = markupWriter.getElement().getAttribute("href");
        if (href.contains(pageName)) {
            markupWriter.getElement().addClassName("is-active");
        }
    }

}
