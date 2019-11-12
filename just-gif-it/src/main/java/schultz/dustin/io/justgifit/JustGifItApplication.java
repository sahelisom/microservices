package schultz.dustin.io.justgifit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.RequestContextFilter;

@SpringBootApplication(excludeName =  {"javax.jms.ConnectionFactory"})
public class JustGifItApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustGifItApplication.class, args);
	}

	
	@Bean
	public FilterRegistrationBean deregisterRequestContextFilter(RequestContextFilter flter)
	{
		FilterRegistrationBean bean = new FilterRegistrationBean(flter);
		bean.setEnabled(false);
		return bean;
	}
}
