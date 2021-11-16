package k_kikuchi582.tapestry5_playground.components.parameter;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.corelib.components.Zone;

public class ParameterBiDirectionalWrapperParent {
    @Persist
    private CountWrapper wrapper;

    @InjectComponent("wrapperCountZone")
    @Property
    private Zone wrapperCountZone;

    @SetupRender
    void setupRender() {
        if (wrapper == null) {
            wrapper = new CountWrapper();
        }
    }

    public CountWrapper getWrapper() {
        return wrapper;
    }

//    wrapperのsetterは不要
//    public void setWrapper(CountWrapper wrapper) {
//        this.wrapper = wrapper;
//    }

    public static class CountWrapper {
        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
