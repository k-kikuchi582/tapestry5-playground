package k_kikuchi582.tapestry5_playground.pages.component;

import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

public class BindingExpression {

    @Inject
    private Messages messages;

    public String getText() {
        return messages.get("bindingExpression.text");
    }
}
