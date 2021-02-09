package k_kikuchi582.tapestry5_playground.services.ioc;

import org.apache.tapestry5.ioc.annotations.InjectService;

public class ServiceD implements IService {
    private final ServiceC serviceC;
    private final IService compositeService;

    public ServiceD(ServiceC serviceC, @InjectService("i-service-composite") IService compositeService) {
        this.serviceC = serviceC;
        this.compositeService = compositeService;
    }

    @Override
    public String method() {
        return "[" + serviceC.method() + "," + compositeService.method() + "]";
    }
}
