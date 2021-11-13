package k_kikuchi582.tapestry5_playground.components.persistence;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class PersistSample {
    @Property
    private String noPersistValue;

    @Persist
    @Property
    private String persistValue;

    @Persist(value = PersistenceConstants.SESSION)
    @Property
    private String sessionValue;

    @Persist(value = PersistenceConstants.FLASH)
    @Property
    private String flashValue;

    @Persist(value = PersistenceConstants.CLIENT)
    @Property
    private String clientValue;

    // NG @Persistなフィールドはprivateでなければいけない
//    @Persist
//    Object notPrivate;

    // NG @Persistなフィールドは宣言時に初期化してはいけない
//    @Persist
//    private Object initialized = "initialized";

    @InjectComponent(value = "persistZone")
    private Zone persistZone;


    @OnEvent(value = EventConstants.SUBMIT)
    Block onSubmit() {
        return persistZone.getBody();
    }

    @OnEvent(value="update")
    Block onUpdate() {
        return persistZone.getBody();
    }
}
