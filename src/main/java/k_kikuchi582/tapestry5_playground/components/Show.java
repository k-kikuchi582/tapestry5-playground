package k_kikuchi582.tapestry5_playground.components;

import org.apache.tapestry5.annotations.Parameter;

import java.util.Arrays;
import java.util.Objects;

public class Show {
    @Parameter(required = true)
    private Object value;

    public String getType() {
        if (value == null) return "type: NULLr";
        return value.getClass().getSimpleName();
    }

    public String getValue() {
        if (value instanceof Object[]) {
            return Arrays.toString((Object[]) value);
        }

        return Objects.toString(value);
    }
}
