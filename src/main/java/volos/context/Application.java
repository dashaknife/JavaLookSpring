package volos.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"volos.controller","volos.service","volos.repository" })
@Import(volos.context.HibernateConfCommon.class)
public class Application {

}
