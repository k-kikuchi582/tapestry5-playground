package k_kikuchi582.tapestry5_playground.pages.ioc;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Id;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.Arrays;
import java.util.List;

public class IoC {
    @Inject
    @Id("appModuleText")
    private Block appModuleText;
    @Inject
    @Id("iServiceText")
    private Block iServiceText;
    @Inject
    @Id("serviceAText")
    private Block serviceAText;
    @Inject
    @Id("serviceBText")
    private Block serviceBText;
    @Inject
    @Id("serviceCText")
    private Block serviceCText;
    @Inject
    @Id("serviceDText")
    private Block serviceDText;
    @Inject
    @Id("compositeServiceText")
    private Block compositeServiceText;
    @Inject
    @Id("webXmlText")
    private Block webXmlText;

    public List<Block> getRegisterIocContainerBodies() {
        return Arrays.asList(appModuleText, iServiceText, serviceAText, serviceBText, serviceCText, serviceDText, compositeServiceText, webXmlText);
    }
}
