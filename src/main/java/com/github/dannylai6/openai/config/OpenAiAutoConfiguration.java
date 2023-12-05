package com.github.dannylai6.openai.config;

import cn.bugstack.openai.session.Configuration;
import cn.bugstack.openai.session.OpenAiSession;
import cn.bugstack.openai.session.OpenAiSessionFactory;
import cn.bugstack.openai.session.defaults.DefaultOpenAiSessionFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Description: openai集成大模型自动化配置
 * <br/>
 * OpenAiAutoConfiguration
 *
 * @author laiql
 * @date 2023/12/5 11:49
 */
@AutoConfiguration
@EnableConfigurationProperties(OpenAiProperties.class)
public class OpenAiAutoConfiguration {
    @Bean
    public OpenAiSession openAiSession(OpenAiSessionFactory openAiSessionFactory) {
        return openAiSessionFactory.openSession();
    }

    @Bean
    public OpenAiSessionFactory openAiSessionFactory(OpenAiProperties openAiProperties) {
        Configuration configuration = new Configuration();
        configuration.setAliModelConfig(openAiProperties.getAliModelConfig());
        configuration.setChatGLMConfig(openAiProperties.getChatGLMConfig());
        configuration.setChatGPTConfig(openAiProperties.getChatGPTConfig());
        configuration.setXunFeiConfig(openAiProperties.getXunFeiConfig());

        //okHttpClient Config
        configuration.setLevel(openAiProperties.getLevel());
        configuration.setReadTimeout(openAiProperties.getReadTimeout().getSeconds());
        configuration.setWriteTimeout(openAiProperties.getWriteTimeout().getSeconds());
        configuration.setConnectTimeout(openAiProperties.getConnectTimeout().getSeconds());
        return new DefaultOpenAiSessionFactory(configuration);
    }
}
