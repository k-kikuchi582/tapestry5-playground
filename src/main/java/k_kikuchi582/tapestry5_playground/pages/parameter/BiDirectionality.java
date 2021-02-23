package k_kikuchi582.tapestry5_playground.pages.parameter;

import k_kikuchi582.tapestry5_playground.util.Utils;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.io.IOException;

public class BiDirectionality {
    @Persist
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Persist
    private CountWrapper wrapper;

    @OnEvent(EventConstants.ACTIVATE)
    void onActivate() {
        if (wrapper == null) {
            wrapper = new CountWrapper();
        }
    }

    public CountWrapper getWrapper() {
        return wrapper;
    }

    public static class CountWrapper {
        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    @Inject
    @Path("./biDirectionality")
    private Asset biDirectionality;

    @Inject
    @Path("./biDirectionalityPage1")
    private Asset biDirectionalityPage1;

    @Inject
    @Path("./biDirectionalityPage2")
    private Asset biDirectionalityPage2;

    @Inject
    @Path("./biDirectionalityTml1")
    private Asset biDirectionalityTml1;

    @Inject
    @Path("./biDirectionalityTml2")
    private Asset biDirectionalityTml2;

    public String getComponentText() throws IOException {
        return Utils.getText(biDirectionality);
    }

    public String getPageText1() throws IOException {
        return Utils.getText(biDirectionalityPage1);
    }

    public String getPageText2() throws IOException {
        return Utils.getText(biDirectionalityPage2);
    }

    public String getTmlText1() throws IOException {
        return Utils.getText(biDirectionalityTml1);
    }

    public String getTmlText2() throws IOException {
        return Utils.getText(biDirectionalityTml2);
    }

    @InjectComponent("countZone")
    @Property
    private Zone countZone;

    @InjectComponent("wrapperCountZone")
    @Property
    private Zone wrapperCountZone;
}
