FROM alpine:3.11.2
RUN apk add --no-cache openjdk11
COPY build/libs/az-digital-umbrella-az-cbar-integration-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java"]
CMD ["-jar", "app/az-digital-umbrella-az-cbar-integration-0.0.1-SNAPSHOT.jar"]