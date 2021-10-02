package k_kikuchi582.tapestry5_playground.components;

import org.apache.commons.lang3.StringUtils;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.ioc.annotations.Inject;

@SupportsInformalParameters
public class Tag {
    @Inject
    private ComponentResources componentResources;

    @BeginRender
    void beginRender(MarkupWriter writer) {
        Element element = writer.element("span");
        componentResources.renderInformalParameters(writer);
        String classNames = element.getAttribute("class");
        if (StringUtils.isBlank(classNames)) {
            element.attribute("class", "tag is-white");
        } else {
            element.attribute("class", "tag " + classNames);
        }
    }

    @AfterRender
    void afterRender(MarkupWriter writer) {
        writer.end();
    }
}
