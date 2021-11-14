package k_kikuchi582.tapestry5_playground.services;

import k_kikuchi582.tapestry5_playground.internal.AssetType;
import k_kikuchi582.tapestry5_playground.services.ioc.*;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.corelib.LoopFormState;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.InjectService;
import org.apache.tapestry5.ioc.annotations.ServiceId;
import org.apache.tapestry5.ioc.services.Builtin;
import org.apache.tapestry5.ioc.services.CoercionTuple;
import org.apache.tapestry5.ioc.services.ThreadLocale;
import org.apache.tapestry5.ioc.services.TypeCoercer;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.Core;
import org.apache.tapestry5.util.StringToEnumCoercion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppModule {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppModule.class);

    public static void bind(ServiceBinder binder) {
        binder.bind(SampleService.class);
        // インターフェースと実装クラスを指定することでIoCに登録することができる
        // IoCに登録したクラスはIoCがインスタンスを初期化してくれて、必要な場面でInjectしてくれる
        binder.bind(IService.class, ServiceA.class).withId("i-service-a");
        // 同じ型を複数登録したいときはあいまいにならないようにidが必要
        binder.bind(IService.class, ServiceB.class).withId("i-service-b");
        // インターフェースなしで直接クラスをIoC登録することもできる
        // コンストラクタが要求している引数の型がIoCに登録されていれば、IoCに登録されているインスタンスをInjectしてくれる
        binder.bind(ServiceD.class);
    }

    public static void contributeApplicationDefaults(MappedConfiguration<String,String> configuration) {
        configuration.add("tapestry.start-page-name", "index");
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,ja");
        configuration.add(SymbolConstants.APPLICATION_CATALOG, "context:WEB-INF/messages/app.properties");
    }

    // public static <型> build~() の形でインスタンスをIoCに登録することもできる
    public static ServiceC buildServiceC() {
        return new ServiceC();
    }

    // build~()でIoCにインスタンスを登録するときは@ServiceIdを使ってidを設定できる
    @ServiceId("i-service-composite")
    public static IService buildCompositeService(
            // 同じ型が複数登録されているときは@InjectServiceを使ってInjectしてほしいインスタンスを指定する
            @InjectService("i-service-a") IService serviceA,
            @InjectService("i-service-b") IService serviceB ) {
        return new CompositeService( serviceA, serviceB );
    }

    public static void contributeTypeCoercer(Configuration<CoercionTuple> configuration) {
        configuration.add(new CoercionTuple<>(String.class, AssetType.class, StringToEnumCoercion.create(AssetType.class)));
    }
}
