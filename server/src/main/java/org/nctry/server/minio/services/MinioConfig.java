package org.nctry.server.minio.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.minio")
public class MinioConfig {
    private String endpoint;
    private String accessKey;
    private String secretKey;
}
