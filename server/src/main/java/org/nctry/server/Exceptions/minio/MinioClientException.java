package org.nctry.server.Exceptions.minio;

public class MinioClientException extends RuntimeException {
    public MinioClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
