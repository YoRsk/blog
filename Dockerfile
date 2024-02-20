FROM openjdk:17

# set work directory
WORKDIR /app

# jar package to /app
COPY target/blog-0.0.1-SNAPSHOT.jar /app/

# 暴露端口，与你的应用配置相匹配
EXPOSE 8080

# 指定容器启动时运行的命令
CMD ["java", "-jar", "blog-0.0.1-SNAPSHOT.jar"]