package k_kikuchi582.tapestry5_playground.pages.parameter;

import k_kikuchi582.tapestry5_playground.util.Utils;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.io.IOException;

public class ParameterSample {

    @Inject
    @Path("./parameters")
    private Asset parametersClassContent;

    private String getNull() {
        return null;
    }

    public String getParametersClassContent() throws IOException {
        return Utils.getText(parametersClassContent);
    }
}
