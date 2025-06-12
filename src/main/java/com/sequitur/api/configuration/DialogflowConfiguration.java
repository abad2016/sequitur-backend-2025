package com.sequitur.api.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.dialogflow.v2.IntentsClient;
import com.google.cloud.dialogflow.v2.IntentsSettings;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.SessionsSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Configuration
public class DialogflowConfiguration {
    @Bean
    public IntentsClient intentsClient() throws Exception {
        String credentialsJson = System.getenv("GOOGLE_APPLICATION_CREDENTIALS");
        if (credentialsJson == null || credentialsJson.isEmpty()) {
            throw new IllegalStateException("La variable GOOGLE_APPLICATION_CREDENTIALS no está definida.");
        }

        GoogleCredentials credentials = GoogleCredentials.fromStream(
                new ByteArrayInputStream(credentialsJson.getBytes(StandardCharsets.UTF_8))
        );

        IntentsSettings settings = IntentsSettings.newBuilder()
                .setCredentialsProvider(() -> credentials)
                .build();

        return IntentsClient.create(settings);
    }

    @Bean
    public SessionsClient sessionsClient() throws Exception {
        String credentialsJson = System.getenv("GOOGLE_APPLICATION_CREDENTIALS");
        if (credentialsJson == null || credentialsJson.isEmpty()) {
            throw new IllegalStateException("La variable GOOGLE_APPLICATION_CREDENTIALS no está definida.");
        }

        GoogleCredentials credentials = GoogleCredentials.fromStream(
                new ByteArrayInputStream(credentialsJson.getBytes(StandardCharsets.UTF_8))
        );

        SessionsSettings settings = SessionsSettings.newBuilder()
                .setCredentialsProvider(() -> credentials)
                .build();

        return SessionsClient.create(settings);
    }
}
