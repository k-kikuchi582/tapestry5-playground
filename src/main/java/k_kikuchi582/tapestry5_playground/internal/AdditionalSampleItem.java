package k_kikuchi582.tapestry5_playground.internal;


import org.apache.tapestry5.Block;

public class AdditionalSampleItem {
    private final String title;
    private final Block block;

    public AdditionalSampleItem(String title, Block block) {
        this.title = title;
        this.block = block;
    }

    public String getTitle() {
        return title;
    }

    public Block getBlock() {
        return block;
    }
}
