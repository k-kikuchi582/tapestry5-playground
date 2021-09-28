package k_kikuchi582.tapestry5_playground.util;

import org.apache.commons.io.IOUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.tapestry5.Asset;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Utils {
    public static String getText(Asset asset) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (InputStream input = asset.getResource().openStream()) {
            IOUtils.copy(input, output);
        }
        return escapeAsHtml(output.toString(StandardCharsets.UTF_8.name()));
    }

    private static String escapeAsHtml(String text) {
        return StringEscapeUtils.escapeHtml4(text);
    }
}
