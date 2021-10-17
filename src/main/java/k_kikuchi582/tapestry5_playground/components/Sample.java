package k_kikuchi582.tapestry5_playground.components;

import k_kikuchi582.tapestry5_playground.services.AppModule;
import k_kikuchi582.tapestry5_playground.util.Utils;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Id;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.AssetSource;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Sample {
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String name;

    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String sourceDir;

    @Inject
    private AssetSource assetSource;

    @Inject
    @Id("sampleBlock")
    private Block sampleBlock;

    @Inject
    @Id("javaBlock")
    private Block javaBlock;

    @Inject
    @Id("templateBlock")
    private Block templateBlock;

    public List<String> getTabTitles() {
        return Arrays.asList(name, name + ".java", name + ".tml");
    }

    public List<Block> getTabBodies() {
        return Arrays.asList(sampleBlock, javaBlock, templateBlock);
    }

    private String resolveForClassPath(String dir, String name) {
        return Paths.get(getAppModuleClassPath(), dir, name).toString();
    }

    private String getAppModuleClassPath() {
        String appModuleClassPath = AppModule.class.getName().replace('.', '/');
        return Paths.get(appModuleClassPath).getParent().getParent().toString();
    }

    public String getJavaText() throws IOException {
        Asset asset = assetSource.getClasspathAsset(resolveForClassPath(sourceDir, name + ".java"));
        return Utils.getText(asset);
    }

    public String getTemplateText() throws IOException {
        Asset asset = assetSource.getClasspathAsset(resolveForClassPath(sourceDir, name + ".tml"));
        return Utils.getText(asset);
    }
}
