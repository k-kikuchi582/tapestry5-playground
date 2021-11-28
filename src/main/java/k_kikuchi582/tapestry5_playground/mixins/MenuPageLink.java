package k_kikuchi582.tapestry5_playground.mixins;

import k_kikuchi582.tapestry5_playground.pages.Index;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.MixinAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.Locale;

@MixinAfter
public class MenuPageLink {

    @Inject
    private ComponentResources componentResources;
    @Inject
    private Locale locale;

    @BeginRender
    void onBeginRender(MarkupWriter markupWriter) {
        String pageName = componentResources.getPageName().toLowerCase();
        int lastSlashIndex = pageName.lastIndexOf('/');
        if (lastSlashIndex > 0 && lastSlashIndex+1 < pageName.length() ) {
            pageName = pageName.substring(lastSlashIndex+1);
        }
        String href = markupWriter.getElement().getAttribute("href");
        if (href.endsWith(pageName) || currentPageIsIndexPage(href)) {
            markupWriter.getElement().addClassName("is-active");
        }
    }

    private boolean currentPageIsIndexPage(String href) {
        return componentResources.getPage().getClass().getName().equals(Index.class.getName()) && href.endsWith(locale.getLanguage());
    }

}
