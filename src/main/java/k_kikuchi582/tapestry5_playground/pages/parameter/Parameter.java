package k_kikuchi582.tapestry5_playground.pages.parameter;

import k_kikuchi582.tapestry5_playground.internal.AdditionalSampleItem;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Id;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.Arrays;
import java.util.List;

public class Parameter {

    @Inject
    @Id("validUsageBlock")
    private Block validUsageBlock;

    @Inject
    @Id("invalidUsageBlock")
    private Block invalidUsageBlock;

    public List<AdditionalSampleItem> getAdditionalItems() {
        return Arrays.asList(
                new AdditionalSampleItem( "valid usage", validUsageBlock),
                new AdditionalSampleItem( "invalid usage", invalidUsageBlock)
        );
    }
}
