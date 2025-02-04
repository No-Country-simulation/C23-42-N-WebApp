package org.nctry.server.minio.services;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.http.Method;
import org.nctry.server.Exceptions.minio.MinioClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class MinioManager {
    private final MinioClient minioClient;

    public MinioManager(@Value("${minio.endpoint}") String endpoint, @Value("${minio.access-key}") String accessKey, @Value("${minio.secret-key}") String secretKey) {
        this.minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    public String getPresignedUrl(String urlBucket) {
        try {
            String[] componentes = urlBucket.split("/");
            //[0] es el bucket, [1] es el nombre del archivo
            Map<String, String> reqParams = new HashMap<String, String>();
            reqParams.put("response-content-type", "application/json");

            String url =
                    minioClient.getPresignedObjectUrl(
                            GetPresignedObjectUrlArgs.builder()
                                    .method(Method.GET)
                                    .bucket(componentes[0])
                                    .object(componentes[1])
                                    .expiry(4, TimeUnit.MINUTES)
                                    .extraQueryParams(reqParams)
                                    .build());
            System.out.println(url);
            return url;
        } catch (Exception e) {
            throw new MinioClientException("Error generating presigned URL for: " + urlBucket, e);
        }
    }
}
