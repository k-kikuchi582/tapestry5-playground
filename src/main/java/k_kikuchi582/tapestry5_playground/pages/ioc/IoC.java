package k_kikuchi582.tapestry5_playground.pages.ioc;

import k_kikuchi582.tapestry5_playground.services.ioc.IService;
import k_kikuchi582.tapestry5_playground.services.ioc.ServiceD;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.InjectService;

public class IoC {
    // @InjectServiceを使ってIoCに登録されているインスタンスをInjectできる
    @InjectService("i-service-a")
    private IService serviceA;
    @InjectService("i-service-b")
    private IService serviceB;
    @InjectService("i-service-composite")
    private IService serviceComposite;
    // idが必要なければ@Injectを使う
    @Inject
    private ServiceD serviceD;

    public String getServiceA() {
        return serviceA.method();
    }

    public String getServiceB() {
        return serviceB.method();
    }

    public String getServiceComposite() {
        return serviceComposite.method();
    }

    public String getServiceD() {
        return serviceD.method();
    }
}
