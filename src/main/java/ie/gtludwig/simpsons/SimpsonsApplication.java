package ie.gtludwig.simpsons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class SimpsonsApplication {

    private static final String MESSAGE_SOURCE = "i18n/messages";

    @Bean(name = "messageSource")
	@Description("Spring message resolver")
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename(MESSAGE_SOURCE);
		messageSource.setFallbackToSystemLocale(false);
		messageSource.setCacheSeconds(0);
		messageSource.setDefaultEncoding("utf-8");
		return messageSource;
    }

    @Bean(name = "localeResolver")
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }
    public static void main(String[] args) {
        SpringApplication.run(SimpsonsApplication.class);
    }


}
