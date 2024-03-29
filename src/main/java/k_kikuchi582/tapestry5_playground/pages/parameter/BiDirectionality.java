package k_kikuchi582.tapestry5_playground.pages.parameter;

import k_kikuchi582.tapestry5_playground.internal.AdditionalSampleItem;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Id;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.Arrays;
import java.util.List;

public class BiDirectionality {

    @Inject
    @Id("parameterBiDirectionalJavaBlock")
    private Block parameterBiDirectionalJavaBlock;

    @Inject
    @Id("parameterBiDirectionalTmlBlock")
    private Block parameterBiDirectionalTmlBlock;

    public List<AdditionalSampleItem> getAdditionalItems() {
        return Arrays.asList(
                new AdditionalSampleItem( "ParameterBiDirectional.java", parameterBiDirectionalJavaBlock ),
                new AdditionalSampleItem( "ParameterBiDirectional.tml", parameterBiDirectionalTmlBlock )
        );
    }
}
