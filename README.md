### Reproducer

Run:
```bash
./reproduce.sh
```

The kie-server will fail to deploy executable KJAR with following exception:

```log
2023-08-30 13:11:15.514 ERROR 27612 --- [           main] o.k.server.services.impl.KieServerImpl   : Error creating container 'executable-model-kjar' for module 'com.company:business-application-kjar-executable:1.0-SNAPSHOT'

java.lang.RuntimeException: java.lang.ClassNotFoundException: org.redhat.Rules6250a1f16c134505b02d14df7fe5f58d
        at org.drools.modelcompiler.CanonicalKieModule.getModels(CanonicalKieModule.java:426) ~[drools-model-compiler-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.drools.modelcompiler.CanonicalKieModule.getModelForKBase(CanonicalKieModule.java:459) ~[drools-model-compiler-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.drools.modelcompiler.CanonicalKieModule.createKiePackages(CanonicalKieModule.java:303) ~[drools-model-compiler-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.drools.modelcompiler.CanonicalKieModule.lambda$createKieBase$1(CanonicalKieModule.java:234) ~[drools-model-compiler-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at java.base/java.util.concurrent.ConcurrentHashMap.computeIfAbsent(ConcurrentHashMap.java:1708) ~[na:na]
        at org.drools.modelcompiler.CanonicalKieModule.createKieBase(CanonicalKieModule.java:234) ~[drools-model-compiler-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.drools.compiler.kie.builder.impl.KieContainerImpl.createKieBase(KieContainerImpl.java:475) ~[drools-compiler-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.drools.compiler.kie.builder.impl.KieContainerImpl.getKieBase(KieContainerImpl.java:439) ~[drools-compiler-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.kie.server.services.drools.DroolsKieServerExtension.createContainer(DroolsKieServerExtension.java:102) ~[kie-server-services-drools-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.kie.server.services.impl.KieServerImpl.createContainer(KieServerImpl.java:341) ~[kie-server-services-common-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.kie.server.services.impl.ContainerManager.installContainersSync(ContainerManager.java:49) ~[kie-server-services-common-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.kie.server.services.impl.ContainerManager.installContainers(ContainerManager.java:35) ~[kie-server-services-common-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.kie.server.services.impl.ImmutableContainerStartupStrategy.startup(ImmutableContainerStartupStrategy.java:58) ~[kie-server-services-common-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.kie.server.services.impl.KieServerImpl.init(KieServerImpl.java:206) ~[kie-server-services-common-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.kie.server.springboot.ImmutableSpringBootKieServerImpl.init(ImmutableSpringBootKieServerImpl.java:64) ~[kie-server-spring-boot-autoconfiguration-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.kie.server.springboot.autoconfiguration.KieServerAutoConfiguration.kieServer(KieServerAutoConfiguration.java:125) ~[kie-server-spring-boot-autoconfiguration-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.kie.server.springboot.autoconfiguration.KieServerAutoConfiguration$$EnhancerBySpringCGLIB$$4fa3e3ae.CGLIB$kieServer$7(<generated>) ~[kie-server-spring-boot-autoconfiguration-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.kie.server.springboot.autoconfiguration.KieServerAutoConfiguration$$EnhancerBySpringCGLIB$$4fa3e3ae$$FastClassBySpringCGLIB$$9b58f556.invoke(<generated>) ~[kie-server-spring-boot-autoconfiguration-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.springframework.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:244) ~[spring-core-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.context.annotation.ConfigurationClassEnhancer$BeanMethodInterceptor.intercept(ConfigurationClassEnhancer.java:331) ~[spring-context-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.kie.server.springboot.autoconfiguration.KieServerAutoConfiguration$$EnhancerBySpringCGLIB$$4fa3e3ae.kieServer(<generated>) ~[kie-server-spring-boot-autoconfiguration-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:154) ~[spring-beans-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:652) ~[spring-beans-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:637) ~[spring-beans-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1341) ~[spring-beans-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1181) ~[spring-beans-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:556) ~[spring-beans-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:516) ~[spring-beans-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:324) ~[spring-beans-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:322) ~[spring-beans-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:897) ~[spring-beans-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:879) ~[spring-context-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:551) ~[spring-context-5.2.14.RELEASE.jar:5.2.14.RELEASE]
        at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:143) ~[spring-boot-2.3.10.RELEASE.jar:2.3.10.RELEASE]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:755) ~[spring-boot-2.3.10.RELEASE.jar:2.3.10.RELEASE]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:747) ~[spring-boot-2.3.10.RELEASE.jar:2.3.10.RELEASE]
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:402) ~[spring-boot-2.3.10.RELEASE.jar:2.3.10.RELEASE]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:312) ~[spring-boot-2.3.10.RELEASE.jar:2.3.10.RELEASE]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1247) ~[spring-boot-2.3.10.RELEASE.jar:2.3.10.RELEASE]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1236) ~[spring-boot-2.3.10.RELEASE.jar:2.3.10.RELEASE]
        at org.kie.Application.main(Application.java:17) ~[classes/:na]
Caused by: java.lang.ClassNotFoundException: org.redhat.Rules6250a1f16c134505b02d14df7fe5f58d
        at org.drools.reflective.classloader.ProjectClassLoader.tryDefineType(ProjectClassLoader.java:205) ~[drools-core-reflective-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.drools.reflective.classloader.ProjectClassLoader.loadType(ProjectClassLoader.java:195) ~[drools-core-reflective-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.drools.reflective.classloader.ProjectClassLoader.loadClass(ProjectClassLoader.java:149) ~[drools-core-reflective-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:520) ~[na:na]
        at org.drools.modelcompiler.CanonicalKieModule.createInstance(CanonicalKieModule.java:167) ~[drools-model-compiler-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.drools.modelcompiler.CanonicalKieModule.initModelsFromProjectDescriptor(CanonicalKieModule.java:434) ~[drools-model-compiler-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
        at org.drools.modelcompiler.CanonicalKieModule.getModels(CanonicalKieModule.java:424) ~[drools-model-compiler-7.59.0.Final-redhat-00006.jar:7.59.0.Final-redhat-00006]
```

The non-executable KJAR is deployed successfully.