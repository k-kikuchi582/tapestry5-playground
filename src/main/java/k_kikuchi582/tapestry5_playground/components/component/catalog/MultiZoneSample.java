package k_kikuchi582.tapestry5_playground.components.component.catalog;

import org.apache.tapestry5.ajax.MultiZoneUpdate;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class MultiZoneSample {
    @Property
    private String name;
    @Property
    private String description;

    @InjectComponent
    private Zone zone1;
    @InjectComponent
    private Zone zone2;

    @OnEvent("apple")
    Object onApple() {
        name = "リンゴ";
        description = "色は赤や緑が多く、甘く、一般的には丸い果実";

        return new MultiZoneUpdate("zone1", zone1)
                .add("zone2", zone2);
    }

    @OnEvent("orange")
    Object onOrange() {
        name = "オレンジ";
        description = "色は橙が多く、品種による多少はあるが酸味と甘味があり、外の厚い皮をむくと可食部が薄い皮に包まれている果実";

        return new MultiZoneUpdate("zone1", zone1)
                .add("zone2", zone2);
    }

    @OnEvent("peach")
    Object onPeach() {
        name = "桃";
        description = "皮の色は桃色で、果肉は白からやや黄色。果肉は非常に水分に富んでいて甘い反面、傷みやすい。";

        return new MultiZoneUpdate("zone1", zone1)
                .add("zone2", zone2);
    }
}
