FROM hub.c.163.com/xbingo/jdk8:latest
VOLUME /tmp
ADD mybatisplus-spring-boot-1.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]