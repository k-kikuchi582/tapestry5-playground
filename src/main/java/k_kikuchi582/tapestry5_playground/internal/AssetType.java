package k_kikuchi582.tapestry5_playground.internal;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.services.AssetSource;

import java.io.IOException;

public enum AssetType {
    CONTEXT {
        @Override
        public Asset getAsset(AssetSource assetSource, String path) throws IOException {
            return assetSource.getContextAsset(path, null);
        }
    },
    CLASS_PATH {
        @Override
        public Asset getAsset(AssetSource assetSource, String path) throws IOException {
            return assetSource.getClasspathAsset(path);
        }
    };

    abstract public Asset getAsset(AssetSource assetSource, String path) throws IOException;
}
