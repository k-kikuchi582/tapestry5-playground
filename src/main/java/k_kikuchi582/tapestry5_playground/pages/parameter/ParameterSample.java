package k_kikuchi582.tapestry5_playground.pages.parameter;

import org.apache.commons.io.IOUtils;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ParameterSample {
    @Persist
    @Property
    private int count;

    @Inject
    @Path("./parameters")
    private Asset parametersClassContent;

    private String getNull() {
        return null;
    }

    public String getParametersClassContent() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (InputStream input = parametersClassContent.getResource().openStream()) {
            IOUtils.copy(input, output);
        }
        return output.toString();
    }
}
