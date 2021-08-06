package tads.eaj.ufrn.animeapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tads.eaj.ufrn.animeapp.service.FileStorageService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class AnimeAppApplication implements CommandLineRunner, WebMvcConfigurer {

	@Resource
	FileStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(AnimeAppApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Register resource handler for images
		//registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
				//.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
		registry.addResourceHandler("/images/**").addResourceLocations("/images/")
		.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}

}
