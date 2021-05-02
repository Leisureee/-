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

### Packaging an installer or portable file

jpackage require wix3.0+. Before packaging, make sure jdk11+
and [wix3.0+](https://wixtoolset.org/releases/) is installed on system.

1. Installer

```shell script
./mvnw clean package -DskipTests -Pdev
mkdir lib && cp target/sms-boot-exec.war lib
jpackage --name sms-boot --input lib --main-jar sms-boot-exec.war --vendor raven --win-dir-chooser --win-shortcut --win-menu --win-menu-group "sms-boot"
```

2. Portable file

```shell script
./mvnw clean package -DskipTests -Pdev
mkdir lib && cp target/sms-boot-exec.war lib
jpackage --name sms-boot --input lib --main-jar sms-boot-exec.war --vendor raven --type app-image
```

## License

MIT
