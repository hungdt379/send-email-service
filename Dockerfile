# Sử dụng image cơ sở là OpenJDK 17
FROM openjdk:17-jdk-alpine

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Copy file JAR vào container
COPY target/send-email-service-0.0.1-SNAPSHOT.jar app.jar

# Mở cổng 8085 để ứng dụng Spring Boot có thể lắng nghe
EXPOSE 8085

# Chạy ứng dụng Spring Boot khi container khởi động
ENTRYPOINT ["java", "-jar", "app.jar"]