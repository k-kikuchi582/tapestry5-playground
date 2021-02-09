package k_kikuchi582.tapestry5_playground.services.ioc;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CompositeService implements IService {
    private final IService[] services;

    public CompositeService( IService...services ) {
        this.services = services;
    }

    @Override
    public String method() {
        return Arrays.stream(services)
                .map(IService::method)
                .collect(Collectors.joining(","));
    }
}
