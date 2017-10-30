package org.dldev.aiweb;

import org.dldev.aiweb.util.ModelProperties;
import org.dldev.aiweb.util.UploadProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({UploadProperties.class, ModelProperties.class})
public class AiwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiwebApplication.class, args);
	}
}
