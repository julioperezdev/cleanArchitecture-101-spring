package example.infrastructure.app.config;

import example.adapter.delivery.CourseEndpoints;
import example.adapter.repository.CourseAdapterRepository;
import example.adapter.shared.ModelMapper;
import example.core.course.service.CourseService;
import example.infrastructure.delivery.SpringCourseController;
import example.infrastructure.repository.dao.CourseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"example"})
public class SpringDependenciesConfiguration {

    @Autowired
    private CourseDao courseDao;

//    @Autowired
//    private SpringCourseController springCourseController;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(10000)).build();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public CourseAdapterRepository courseRepository(){
        return new CourseAdapterRepository(courseDao, modelMapper());
    }

    @Bean
    public CourseService courseService(){
        return new CourseService(courseRepository());
    }

    @Bean
    public CourseEndpoints courseController(){
        return new CourseEndpoints(courseService());
    }



}
