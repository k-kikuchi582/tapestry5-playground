package k_kikuchi582.tapestry5_playground.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.Resource;
import org.apache.tapestry5.services.AssetFactory;
import org.apache.tapestry5.services.ContextProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppModule {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppModule.class);


    public static void contributeApplicationDefaults(MappedConfiguration<String,String> configuration)
    {
        configuration.add("tapestry.start-page-name", "index");
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,ja");
        configuration.add(SymbolConstants.APPLICATION_CATALOG, "context:WEB-INF/messages/app.properties");

        LOGGER.info("hogehogheofut$$$#R|~GJOG");
    }

    public static SampleService buildSampleService(@ContextProvider AssetFactory contextAssetFactory) {
        Resource rootResource = contextAssetFactory.getRootResource();

        LOGGER.info(rootResource.getFile());
        LOGGER.info(rootResource.getPath());

        return new SampleService();
    }
}
