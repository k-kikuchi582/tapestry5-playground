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

public class Loop {
    @Inject
    @Id("loopSample")
    private Block loopSampleBlock;

    @Inject
    @Id("loopSampleJava")
    private Block loopSampleJavaBLock;

    @Inject
    @Id("loopSampleTemplate")
    private Block loopSampleTemplateBlock;

    public List<Block> getLoopSampleTabBodies() {
        return Arrays.asList(loopSampleBlock, loopSampleJavaBLock, loopSampleTemplateBlock);
    }

    @Inject
    @Path("../../../../components/component/catalog/control/LoopSample.java")
    private Asset loopSampleJava;

    @Inject
    @Path("../../../../components/component/catalog/control/LoopSample.tml")
    private Asset loopSampleTemplate;

    public String getLoopSampleJavaText() throws IOException {
        return Utils.getText(loopSampleJava);
    }

    public String getLoopSampleTemplateText() throws IOException {
        return Utils.getText(loopSampleTemplate);
    }
}
