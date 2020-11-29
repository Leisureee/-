FROM tomcat:9-jdk8
#镜像信息
MAINTAINER lolico<534619360@qq.com>
#工作目录
WORKDIR ${CATALINA_HOME}/webapps
#复制war包到工作目录
COPY target/sms-boot.war ./sms.war
#暴露端口
EXPOSE 8080
