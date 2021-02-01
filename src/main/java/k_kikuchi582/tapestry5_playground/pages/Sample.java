package k_kikuchi582.tapestry5_playground.pages;

import k_kikuchi582.tapestry5_playground.services.SampleService;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class Sample {
    @Inject
    private SampleService sampleService;

    @Persist
    @Property
    private String text;

    @OnEvent(EventConstants.SUBMIT)
    void onSubmit() {

    }

}
