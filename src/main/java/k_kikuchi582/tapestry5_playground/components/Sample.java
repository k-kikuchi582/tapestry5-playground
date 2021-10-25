package k_kikuchi582.tapestry5_playground.components;

import k_kikuchi582.tapestry5_playground.internal.AdditionalSampleItem;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Sample {
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String name;

    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String sourceDir;

    @Parameter
    private List<AdditionalSampleItem> additionalItems;

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

    @Inject
    @Id("jsBlock")
    private Block jsBlock;

    @Inject
    @Id("cssBlock")
    private Block cssBlock;

    @Inject
    @Id("propertiesBlock")
    private Block propertiesBlock;

    public List<String> getTabTitles() {
        List<String> titles = new ArrayList<>();
        titles.add(name);
        titles.add(name + ".java");
        if (isHasTemplate()) {
            titles.add(name + ".tml");
        }
        if (isHasJs()) {
            titles.add(name + ".js");
        }
        if (isHasCss()) {
            titles.add(name + ".css");
        }
        if (isHasProperties()) {
            titles.add(name + ".properties");
        }
        if (additionalItems != null) {
            additionalItems.forEach(addition -> titles.add(addition.getTitle()));
        }
        return titles;
    }

    public List<Block> getTabBodies() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(sampleBlock);
        blocks.add(javaBlock);
        if (isHasTemplate()) {
            blocks.add(templateBlock);
        }
        if (isHasJs()) {
            blocks.add(jsBlock);
        }
        if (isHasCss()) {
            blocks.add(cssBlock);
        }
        if (isHasProperties()) {
            blocks.add(propertiesBlock);
        }
        if (additionalItems != null) {
            additionalItems.forEach(addition -> blocks.add(addition.getBlock()));
        }
        return blocks;
    }

    private String resolveForClassPath(String dir, String name) {
        return Paths.get(getAppModuleClassPath(), dir, name).toString();
    }

    private String getAppModuleClassPath() {
        String appModuleClassPath = AppModule.class.getName().replace('.', '/');
        return Paths.get(appModuleClassPath).getParent().getParent().toString();
    }

    public String getJavaText() throws IOException {
        return getText(name + ".java");
    }

    public String getTemplateText() throws IOException {
        return getText(name + ".tml");
    }

    public boolean isHasTemplate() {
        return hasAsset(name + ".tml");
    }

    public String getJsText() throws IOException {
        return getText(name + ".js");
    }

    public boolean isHasJs() {
        return hasAsset(name + ".js");
    }

    public String getCssText() throws IOException {
        return getText(name + ".css");
    }

    public boolean isHasCss() {
        return hasAsset(name + ".css");
    }

    public String getPropertiesText() throws IOException {
        return getText(name + ".properties");
    }

    public boolean isHasProperties() {
        return hasAsset(name + ".properties");
    }

    private Asset getAsset( String name ) {
        return assetSource.getClasspathAsset(resolveForClassPath(sourceDir, name) );
    }

    private String getText( String name ) throws IOException {
        Asset asset = getAsset(name);
        return Utils.getText(asset);
    }

    private boolean hasAsset( String name ) {
        try {
            getAsset( name );
            return true;
        } catch ( RuntimeException e ) {
            return false;
        }
    }
}
