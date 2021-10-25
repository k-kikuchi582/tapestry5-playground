package k_kikuchi582.tapestry5_playground.components.component.catalog.form;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class TextAreaSample {
    @Property
    private String value;

    @InjectComponent("zone")
    private Zone zone;

    @OnEvent(value = EventConstants.SUBMIT, component = "form")
    Block onSubmitFromForm() {
        return zone.getBody();
    }

    public String getEscapedValue() {
        if ( value == null ) {
            return null;
        }
        return StringEscapeUtils.escapeHtml4( value ).replaceAll("(\\r\\n|\\r|\\n)", "<br>");
    }
}
