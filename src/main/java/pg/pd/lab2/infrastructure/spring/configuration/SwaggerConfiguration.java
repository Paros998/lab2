package pg.pd.lab2.infrastructure.spring.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * The type Swagger configuration.
 */
@Configuration
@RestController
@RequestMapping(path = "/")
public class SwaggerConfiguration {

    /**
     * Public api grouped open api.
     *
     * @return the grouped open api
     */
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("all")
                .pathsToMatch("/**")
                .pathsToExclude("/")
                .build();
    }

    /**
     * V 1 api grouped open api.
     *
     * @return the grouped open api
     */
    @Bean
    public GroupedOpenApi v1Api() {
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/login", "/logout", "/api/v1/**")
                .pathsToExclude("/")
                .build();
    }

    /**
     * Lab 2 open api.
     *
     * @return the open api
     */
    @Bean
    public OpenAPI lab2OpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API v1")
                        .description("Simple API")
                        .version("v0.2")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Simple API Wiki Documentation")
                        .url("https://github.com/Paros998/lab2"));
    }

    /**
     * Redirect view.
     *
     * @return the redirect view
     */
    @GetMapping
    public RedirectView redirectView() {
        return new RedirectView("/swagger-ui.html");
    }
}
