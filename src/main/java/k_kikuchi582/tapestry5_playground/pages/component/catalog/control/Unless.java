package k_kikuchi582.tapestry5_playground.pages.component.catalog.control;

import k_kikuchi582.tapestry5_playground.util.Utils;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Id;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Unless {
    @Inject
    @Id("unlessSample")
    private Block unlessSampleBlock;

    @Inject
    @Id("unlessSampleJava")
    private Block unlessSampleJavaBLock;

    @Inject
    @Id("unlessSampleTemplate")
    private Block unlessSampleTemplateBlock;

    public List<Block> getUnlessSampleTabBodies() {
        return Arrays.asList(unlessSampleBlock, unlessSampleJavaBLock, unlessSampleTemplateBlock);
    }

    @Inject
    @Path("../../../../components/component/catalog/control/UnlessSample.java")
    private Asset unlessSampleJava;

    @Inject
    @Path("../../../../components/component/catalog/control/UnlessSample.tml")
    private Asset unlessSampleTemplate;

    public String getUnlessSampleJavaText() throws IOException {
        return Utils.getText(unlessSampleJava);
    }

    public String getUnlessSampleTemplateText() throws IOException {
        return Utils.getText(unlessSampleTemplate);
    }
}
