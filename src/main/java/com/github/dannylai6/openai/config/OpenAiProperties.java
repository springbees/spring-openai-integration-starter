package com.github.dannylai6.openai.config;

import cn.bugstack.openai.executor.model.aliyun.config.AliModelConfig;
import cn.bugstack.openai.executor.model.chatglm.config.ChatGLMConfig;
import cn.bugstack.openai.executor.model.chatgpt.config.ChatGPTConfig;
import cn.bugstack.openai.executor.model.xunfei.config.XunFeiConfig;
import lombok.Data;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.time.Duration;

import static com.github.dannylai6.openai.config.OpenAiProperties.OPENAI_CONFIG_PREFIX;


/**
 * Description: OpenAi模型服务配置
 * <br/>
 * OpenAiProperties
 *
 * @author laiql
 * @date 2023/12/5 11:47
 */
@Data
@ConfigurationProperties(prefix = OPENAI_CONFIG_PREFIX)
public class OpenAiProperties {
    public final static String OPENAI_CONFIG_PREFIX = "openai";

    /**
     * 智谱Ai ChatGLM Config
     */
    @NestedConfigurationProperty
    private ChatGLMConfig chatGLMConfig;

    /**
     * OpenAi ChatGLM Config
     */
    @NestedConfigurationProperty
    private ChatGPTConfig chatGPTConfig;

    /**
     * 讯飞
     */
    @NestedConfigurationProperty
    private XunFeiConfig xunFeiConfig;

    /**
     * 阿里通义千问
     */
    @NestedConfigurationProperty
    private AliModelConfig aliModelConfig;


    /**
     * okhttp client config
     */
    private HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.HEADERS;

    /**
     * 连接超时时间
     */
    private Duration connectTimeout = Duration.ofSeconds(5L);

    /**
     * 写超时时间
     */
    private Duration writeTimeout = Duration.ofSeconds(5L);

    /**
     * 读超时时间
     */
    private Duration readTimeout = Duration.ofSeconds(5L);
}
