package k_kikuchi582.tapestry5_playground.pages.component;

import k_kikuchi582.tapestry5_playground.util.Utils;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PageAndComponent {
    @Property
    private int index;

    @Inject
    @Id("renderPhases")
    private Block renderPhasesBlock;

    @Inject
    @Id("renderPhasesJava")
    private Block renderPhasesJavaBLock;

    @Inject
    @Id("renderPhasesWithTemplate")
    private Block renderPhasesWithTemplateBlock;

    @Inject
    @Id("renderPhasesWithTemplateJava")
    private Block renderPhasesWithTemplateJavaBlock;

    @Inject
    @Id("renderPhasesWithTemplateTml")
    private Block renderPhasesWithTemplateTmlBlock;

    public List<Block> getTabsBodies() {
        return Arrays.asList(
                renderPhasesBlock,
                renderPhasesJavaBLock,
                renderPhasesWithTemplateBlock,
                renderPhasesWithTemplateJavaBlock,
                renderPhasesWithTemplateTmlBlock
        );
    }

    @Inject
    @Path("../../components/component/RenderPhases.java")
    private Asset renderPhasesJava;

    @Inject
    @Path("../../components/component/RenderPhasesWithTemplate.java")
    private Asset renderPhasesWithTemplateJava;

    @Inject
    @Path("../../components/component/RenderPhasesWithTemplate.tml")
    private Asset renderPhasesWithTemplateTml;

    public String getRenderPhasesJavaText() throws IOException {
        return Utils.getText(renderPhasesJava);
    }

    public String getRenderPhasesWithTemplateJavaText() throws IOException {
        return Utils.getText(renderPhasesWithTemplateJava);
    }

    public String getRenderPhasesWithTemplateTmlText() throws IOException {
        return Utils.getText(renderPhasesWithTemplateTml);
    }
}
