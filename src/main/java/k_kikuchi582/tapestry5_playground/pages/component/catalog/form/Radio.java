package k_kikuchi582.tapestry5_playground.pages.component.catalog.form;

import k_kikuchi582.tapestry5_playground.internal.AdditionalSampleItem;
import k_kikuchi582.tapestry5_playground.util.Utils;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Id;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Radio {
    @Inject
    @Id("radioSamplePropertiesBlock")
    private Block radioSamplePropertiesBlock;

    @Inject
    @Path("../../../../components/component/catalog/form/RadioSample.properties")
    private Asset radioSampleProperties;

    public List<AdditionalSampleItem> getAdditionalItems() {
        return Collections.singletonList(
                new AdditionalSampleItem("RadioSample.properties", radioSamplePropertiesBlock)
        );
    }

    public String getRadioSamplePropertiesText() throws IOException {
        return Utils.getText(radioSampleProperties);
    }
}
