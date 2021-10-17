package k_kikuchi582.tapestry5_playground.util;

import k_kikuchi582.tapestry5_playground.services.AppModule;
import org.apache.commons.io.IOUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.ioc.Resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Utils {
    public static String getText(Asset asset) throws IOException {
        return getText(asset.getResource());
    }

    public static String getText(Resource resource) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (InputStream input = resource.openStream()) {
            IOUtils.copy(input, output);
        }
        return escapeAsHtml(output.toString(StandardCharsets.UTF_8.name()));
    }

    private static String escapeAsHtml(String text) {
        return StringEscapeUtils.escapeHtml4(text);
    }

    public static String getPageName( Class<?> pageClass ) {
        String pageBase = getAppPackage() + ".pages";
        String fqcnClassName = pageClass.getName();
        if (!fqcnClassName.startsWith(pageBase)) {
            throw new IllegalArgumentException( "consider this class(" + pageClass.getName() + ") is not page-class." );
        }
        return fqcnClassName.substring(pageBase.length()+1).replace('.', '/');
    }

    private static String getAppPackage() {
        String[] split = AppModule.class.getName().split("\\.");
        return Arrays.stream(split)
                .limit(split.length-2)
                .collect(Collectors.joining("."));
    }
}
