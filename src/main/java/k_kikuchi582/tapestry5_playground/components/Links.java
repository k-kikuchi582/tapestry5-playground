package k_kikuchi582.tapestry5_playground.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Parameter;

public class Links {
    @Parameter(name = "class", value = "", defaultPrefix = BindingConstants.LITERAL)
    private String className;

    public String getClassName() {
        return className;
    }
}
