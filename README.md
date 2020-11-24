## Quick Start

Before start application, you may want to be able to configure external service like mysql, edit `application-{env}.properties` and make `spring.profiles.active={env}`.
 
**Note:**

Application run with `dev` environment that using memory database h2 by default.

### Run with spring-boot plugin

```shell script
./mvnw spring-boot:run
```

### Execute with jar package

```shell script
./mvnw clean package -DskipTests -Pprd
cd target && java -jar sms-boot-exec.war
```

### Deploy to external tomcat container

```shell script
./mvnw clean package -DskipTests -Pprd
cp target/sms-boot.war ${CATALINA_HOME}/webapps
```

## License

MIT