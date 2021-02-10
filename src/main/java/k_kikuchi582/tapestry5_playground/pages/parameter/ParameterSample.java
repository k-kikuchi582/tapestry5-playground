package k_kikuchi582.tapestry5_playground.pages.parameter;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class ParameterSample {

    @Persist
    @Property
    private int count;

    private String getNull() {
        return null;
    }
}
