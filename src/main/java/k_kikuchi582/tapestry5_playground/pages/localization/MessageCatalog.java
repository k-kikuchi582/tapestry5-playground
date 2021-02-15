package k_kikuchi582.tapestry5_playground.pages.localization;

import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

public class MessageCatalog {
    @Inject
    private Messages messages;

    public String getTitle2() {
        return messages.get("localization.section2.title");
    }

    public String getBody2() {
        return messages.format("localization.section2.body");
    }
}
