package io.app.project.mp;

import org.springdoc.core.models.GroupedOpenApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("standford")
                .packagesToScan("io.app")
                .pathsToMatch("/api/**")
                .build();
    }

}
