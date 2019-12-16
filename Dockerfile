FROM openjdk:8
VOLUME /tmp
ADD ./target/servicioCuentaAhorro-0.0.1-SNAPSHOT.jar servicioCuentaAhorro.jar
ENTRYPOINT ["java","-jar","/servicioCuentaAhorro.jar"]