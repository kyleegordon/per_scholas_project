package org.perscholas.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Slf4j
@Configuration
public class UploadConfig {

    //gets maxFileSize from application.properties configuration
    @Value("${fileupload.maxFileSize}")
    String maxFileSize;


    //sets max file upload size in bytes
    @Bean
    public CommonsMultipartResolver commonsMultipartResolver() {

        //the following 2 lines are unnecessary for functionality, just a logging example
        long bytes = DataSize.parse(maxFileSize).toBytes();
        log.debug("Maximum file size upload is " + bytes + " bytes");

        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSizePerFile(DataSize.parse(maxFileSize).toBytes());

        return commonsMultipartResolver;
    }
}
