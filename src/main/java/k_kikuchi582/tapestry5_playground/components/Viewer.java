package k_kikuchi582.tapestry5_playground.components;

import k_kikuchi582.tapestry5_playground.internal.AssetType;
import k_kikuchi582.tapestry5_playground.util.Utils;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.AssetSource;

import java.io.IOException;

public class Viewer {
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String source;

    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String lang;

    @Parameter(defaultPrefix = BindingConstants.LITERAL, name = "type")
    private AssetType assetType = AssetType.CLASS_PATH;

    @Inject
    private AssetSource assetSource;

    public String getText() throws IOException {
        Asset asset = assetType.getAsset( assetSource, source );
        return Utils.getText( asset );
    }
}
