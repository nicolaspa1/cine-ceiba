package com.ceiba.infraestructura.configuracion;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Configuration
public class ConfiguracionJackson {
	
	public static final String FORMATO_LOCAL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMATO_LOCAL_DATE = "yyyy-MM-dd";

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        
        SimpleModule module = new SimpleModule();
        
        module.addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            @Override
            public void serialize(LocalDateTime localDateTime, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException {
                gen.writeString(DateTimeFormatter.ofPattern(FORMATO_LOCAL_DATE_TIME).format(localDateTime));
            }
        });
        
        module.addSerializer(LocalDate.class, new JsonSerializer<LocalDate>() {
            @Override
            public void serialize(LocalDate localDate, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException {
                gen.writeString(DateTimeFormatter.ofPattern(FORMATO_LOCAL_DATE).format(localDate));
            }
        });
        
        module.addDeserializer(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
                return LocalDate.parse(jp.getText(), DateTimeFormatter.ofPattern(FORMATO_LOCAL_DATE));
            }
        });
        
        module.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
                return LocalDateTime.parse(jp.getText(), DateTimeFormatter.ofPattern(FORMATO_LOCAL_DATE_TIME));
            }
        });
        
        objectMapper.registerModule(javaTimeModule);
        
        objectMapper.registerModule(module);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        objectMapper.setSerializationInclusion(NON_NULL);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        
        return objectMapper;
    }
}
