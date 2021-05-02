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

1. mvnw package

```shell
./mvnw clean package -DskipTests -Pdev
```

2. copy war to lib

```shell
cd target && mkdir lib
cp sms-boot-exec.war lib # windows using copy ".\sms-boot-exec.war" ".\lib"
```

3. packaging

```shell
rm -rf sms-boot # make sure the sms-boot directory is clean
# Installer
jpackage --name sms-boot --input lib --main-jar sms-boot-exec.war --vendor lolico.me --win-dir-chooser --win-shortcut --win-menu --win-menu-group "sms-boot"
# Portable file
jpackage --name sms-boot --input lib --main-jar sms-boot-exec.war --vendor lolico.me --type app-image
tar -czvf sms-boot.tar.gz sms-boot
```

## License

MIT
