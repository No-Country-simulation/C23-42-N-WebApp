package org.nctry.server.minio.services;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.http.Method;
import org.nctry.server.Exceptions.minio.MinioClientException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MinioManager {
    private final MinioClient minioClient;

    public MinioManager(MinioConfig minioConfig) {

        this.minioClient = MinioClient.builder()
                .endpoint(minioConfig.getEndpoint())
                .credentials(minioConfig.getAccessKey(), minioConfig.getSecretKey())
                .build();
    }

    @Cacheable(value = "presigned-urls", key = "#urlBucket", unless = "#result == null")
    public String getPresignedUrl(String urlBucket) {
        try {
            String[] componentes = urlBucket.split("/");
            String bucket = componentes[0];
            String objectName = componentes[1];

            System.out.println("EN MINIO MANAGER - OBJETO: " + componentes[0] + " - " + componentes[1]);
            String url =
                    minioClient.getPresignedObjectUrl(
                            GetPresignedObjectUrlArgs.builder()
                                    .method(Method.GET)
                                    .bucket(bucket)
                                    .object(objectName)
                                    .expiry(4, TimeUnit.MINUTES)
                                    .build());
            return url;
        } catch (Exception e) {
            throw new MinioClientException("Error generating presigned URL for: " + urlBucket, e);
        }
    }
}
