package k_kikuchi582.tapestry5_playground.components.component;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.dom.Element;

public class RenderPhases {
    @Parameter(required = true)
    private int number;

    @Parameter
    private int current;

    @SetupRender
    void setupRender(MarkupWriter writer) {
        current = 0;

        Element element = writer.element("div");
        element.addClassName("box");
        writer.write("setupRender");
    }

    @BeginRender
    void beginRender(MarkupWriter writer) {
        Element element = writer.element("div");
        element.addClassName("box");
        writer.write("beginRender");
    }

    @BeforeRenderTemplate
    void beginRenderTemplate(MarkupWriter writer) {
        Element element = writer.element("div");
        element.addClassName("box");
        writer.write("beginRenderTemplate");
    }

    @BeforeRenderBody
    boolean beginRenderBody(MarkupWriter writer) {
        if (current >= number) return false;

        Element element = writer.element("div");
        element.addClassName("box");
        writer.write("beginRenderBody");
        return true;
    }

    @AfterRenderBody
    boolean afterRenderBody(MarkupWriter writer) {
        if (current >= number) return true;

        writer.write("afterRenderBody");
        writer.end();
        current++;
        return current >= number;
    }

    @AfterRenderTemplate
    void afterRenderTemplate(MarkupWriter writer) {
        writer.write("afterRenderTemplate");
        writer.end();
    }

    @AfterRender
    void afterRender(MarkupWriter writer) {
        writer.write("afterRender");
        writer.end();
    }

    @CleanupRender
    void cleanupRender(MarkupWriter writer) {
        writer.write("cleanupRender");
        writer.end();
    }
}
