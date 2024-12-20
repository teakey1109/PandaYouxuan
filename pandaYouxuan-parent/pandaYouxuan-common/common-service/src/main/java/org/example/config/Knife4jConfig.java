package org.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {

    /**
     * // 创建了一个api接口的分组
     * @return GroupedOpenApi
     */
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("admin-api") // 分组名称
                .pathsToMatch("/admin/**")  // 接口请求路径规则
                .build();
    }
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("熊猫优选API接口文档")
                        .version("1.0")
                        .description("熊猫优选API接口文档")
                        .contact(new Contact().name("zhanfang")) // 设定作者
                );
    }
}
