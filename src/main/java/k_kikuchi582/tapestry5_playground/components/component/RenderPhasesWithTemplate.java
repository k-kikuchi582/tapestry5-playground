package k_kikuchi582.tapestry5_playground.components.component;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.dom.Element;

public class RenderPhasesWithTemplate {
    @Parameter(required = true)
    private int number;

    @Parameter
    @Property
    private int current;

    public int getLoopSize() {
        return number-1;
    }

    @SetupRender
    void setupRender(MarkupWriter writer) {
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
    void beginRenderBody(MarkupWriter writer) {
        Element element = writer.element("div");
        element.addClassName("box");
        writer.write("beginRenderBody");
    }

    @AfterRenderBody
    void afterRenderBody(MarkupWriter writer) {

        writer.write("afterRenderBody");
        writer.end();
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
