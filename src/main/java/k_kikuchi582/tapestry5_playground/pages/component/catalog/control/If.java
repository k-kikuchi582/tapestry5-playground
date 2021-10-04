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

public class If {
    @Inject
    @Id("ifSample")
    private Block ifSampleBlock;

    @Inject
    @Id("ifSampleJava")
    private Block ifSampleJavaBLock;

    @Inject
    @Id("ifSampleTemplate")
    private Block ifSampleTemplateBlock;

    public List<Block> getIfSampleTabBodies() {
        return Arrays.asList(ifSampleBlock, ifSampleJavaBLock, ifSampleTemplateBlock);
    }

    @Inject
    @Path("../../../../components/component/catalog/control/IfSample.java")
    private Asset ifSampleJava;

    @Inject
    @Path("../../../../components/component/catalog/control/IfSample.tml")
    private Asset ifSampleTemplate;

    public String getIfSampleJavaText() throws IOException {
        return Utils.getText(ifSampleJava);
    }

    public String getIfSampleTemplateText() throws IOException {
        return Utils.getText(ifSampleTemplate);
    }
}
