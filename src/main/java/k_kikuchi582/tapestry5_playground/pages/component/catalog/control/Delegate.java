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

public class Delegate {
    @Inject
    @Id("delegateSample")
    private Block delegateSampleBlock;

    @Inject
    @Id("delegateSampleJava")
    private Block delegateSampleJavaBLock;

    @Inject
    @Id("delegateSampleTemplate")
    private Block delegateSampleTemplateBlock;

    public List<Block> getDelegateSampleTabBodies() {
        return Arrays.asList(delegateSampleBlock, delegateSampleJavaBLock, delegateSampleTemplateBlock);
    }

    @Inject
    @Path("../../../../components/component/catalog/control/DelegateSample.java")
    private Asset delegateSampleJava;

    @Inject
    @Path("../../../../components/component/catalog/control/DelegateSample.tml")
    private Asset delegateSampleTemplate;

    public String getDelegateSampleJavaText() throws IOException {
        return Utils.getText(delegateSampleJava);
    }

    public String getDelegateSampleTemplateText() throws IOException {
        return Utils.getText(delegateSampleTemplate);
    }
}
