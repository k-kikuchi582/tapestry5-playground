package k_kikuchi582.tapestry5_playground.components.component.catalog;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Id;
import org.apache.tapestry5.ioc.annotations.Inject;

public class BlockSample {
    @Inject
    @Id("block")
    private Block block;

    public Block getBlockContent() {
        return block;
    }
}
