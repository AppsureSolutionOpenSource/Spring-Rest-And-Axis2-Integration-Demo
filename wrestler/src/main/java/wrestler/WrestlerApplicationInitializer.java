package wrestler;

import org.apache.axis2.deployment.WarBasedAxisConfigurator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import wrestler.service.soap.EventLoggingServiceSoapController;
import wrestler.service.soap.RandomNumbersSoapController;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@EnableWebMvc
@EnableAutoConfiguration
@Configuration
public class WrestlerApplicationInitializer {
    @Bean
    public ServletRegistrationBean<WrestlerAxis2Servlet> servletRegistrationBean() throws URISyntaxException {
        final Map<String,String> initParameters = new HashMap<>();
        initParameters.put(WarBasedAxisConfigurator.PARAM_AXIS2_REPOSITORY_PATH, new File(WarBasedAxisConfigurator.class.getClassLoader().getResource("axis2_repo/").toURI()).getAbsolutePath());
        final WrestlerAxis2Servlet axisServlet = new WrestlerAxis2Servlet();

        ServletRegistrationBean<WrestlerAxis2Servlet> bean = new ServletRegistrationBean<>(
                axisServlet, "/axis2/services/*");
        bean.setName("AxisServlet");
        bean.setInitParameters(initParameters);
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean(name = "RandomNumbersSoapController")
    public RandomNumbersSoapController getRandomNumbersSoapController(){
        return new RandomNumbersSoapController();
    }

    @Bean(name = "EventLoggingServiceSoapController")
    public EventLoggingServiceSoapController getEventLoggingServiceSoapController(){
        return new EventLoggingServiceSoapController();
    }




    //@Bean
    //public DataSource dataSource() {
       // return new EmbeddedDatabaseBuilder()
               // .setType(EmbeddedDatabaseType.H2)
                //.addScript("db/init.schema.sql")
                //.addScript("db/init.schema.data.sql")
        //.build();
    //}
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                Environment env) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("wrestler");

        Properties jpaProperties = new Properties();

        //Configures the used database dialect. This allows Hibernate to create SQL
        //that is optimized for the used database.
        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));

        //Specifies the action that is invoked to the database when the Hibernate
        //SessionFactory is created or closed.
        jpaProperties.put("hibernate.hbm2ddl.auto",
                env.getRequiredProperty("hibernate.hbm2ddl.auto")
        );

        //Configures the naming strategy that is used when Hibernate creates
        //new database objects and schema elements
        jpaProperties.put("hibernate.ejb.naming_strategy",
                env.getRequiredProperty("hibernate.ejb.naming_strategy")
        );

        //If the value of this property is true, Hibernate writes all SQL
        //statements to the console.
        jpaProperties.put("hibernate.show_sql",
                env.getRequiredProperty("hibernate.show_sql")
        );

        //If the value of this property is true, Hibernate will format the SQL
        //that is written to the console.
        jpaProperties.put("hibernate.format_sql",
                env.getRequiredProperty("hibernate.format_sql")
        );

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

}
