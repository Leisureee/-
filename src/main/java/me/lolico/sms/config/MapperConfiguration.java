package me.lolico.sms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lolico
 */
@Configuration
@MapperScan("me.lolico.sms.mapper")
public class MapperConfiguration {
}
