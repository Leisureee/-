FROM openjdk:8-alpine
#镜像信息
MAINTAINER lolico<534619360@qq.com>
#工作目录
WORKDIR /app
#复制war包到工作目录
COPY bin/*.sh .
COPY target/sms-boot-exec.war .
#环境变量
ENV APPLICATION_NAME="sms-boot" \
    DEBUG="false"
#暴露端口
EXPOSE 8080 18080

CMD ["--spring.application.name=${APPLICATION_NAME}","--debug=${DEBUG}"]

ENTRYPOINT ["java","-Xdebug -Xrunjdwp:transport=dt_socket,address=18080,server=y,suspend=n","-jar","sms-boot-exec.war"]