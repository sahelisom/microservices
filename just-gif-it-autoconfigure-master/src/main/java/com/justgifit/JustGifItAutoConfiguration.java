package com.justgifit;

import java.io.File;

import javax.inject.Inject;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.justgifit.services.ConverterService;
import com.justgifit.services.GifEncoderService;
import com.justgifit.services.VideoDecoderService;
import com.madgag.gif.fmsware.AnimatedGifEncoder;

@Configuration
@ConditionalOnClass({FFmpegFrameGrabber.class,AnimatedGifEncoder.class})
@EnableConfigurationProperties(JustGifItProperties.class)
public class JustGifItAutoConfiguration {

    @Inject
	private JustGifItProperties properties;
    
    @ConditionalOnProperty(prefix="com.justgifit",name="create-result-dir")
    private Boolean  createResultDir() {
        File gifFolder = properties.getGifLocation();
        if (!gifFolder.exists()) {
            gifFolder.mkdir();
        }
        return true;
    }

	@Bean
	@ConditionalOnMissingBean(VideoDecoderService.class)
	public VideoDecoderService videoDecoderService()
	{
		return new VideoDecoderService();
	}
	@Bean
	@ConditionalOnMissingBean(ConverterService.class)
	public ConverterService converterService()
	{
		return new ConverterService();
	}
	@Bean
	@ConditionalOnMissingBean(GifEncoderService.class)
	public GifEncoderService gifEncoderService()
	{
		return new GifEncoderService();
	}
	
	@Configuration
	@ConditionalOnWebApplication
	public static class WebConfiguration{
		
		@Inject
		private JustGifItProperties properties;
		
		 @Bean
		 @ConditionalOnProperty(prefix = "com.justgifit",name="optimize")
			public FilterRegistrationBean deregisterRequestContextFilter(RequestContextFilter flter)
			{
				FilterRegistrationBean bean = new FilterRegistrationBean(flter);
				bean.setEnabled(false);
				return bean;
			}

		    @Bean
		    public WebMvcConfigurer webMvcConfigurer() {
		        return new WebMvcConfigurerAdapter() {
		            @Override
		            public void addResourceHandlers(ResourceHandlerRegistry registry) {
		                registry.addResourceHandler("/gif/**")
		                        .addResourceLocations("file:" + properties.getGifLocation());
		                super.addResourceHandlers(registry);
		            }
		        };
		    }
		
	}
}
