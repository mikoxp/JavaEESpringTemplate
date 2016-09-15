package com.project.config.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Security Config
 *
 * @author moles
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("postgres")
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().
                dataSource(dataSource)
                .passwordEncoder(new Md5PasswordEncoder())
                .usersByUsernameQuery(
                        "select login,password,enabled  from account where login=?")
                .authoritiesByUsernameQuery(
                        "SELECT a.login,r.name FROM account a JOIN groups g ON a.id_group=g.id " +
                                "JOIN groups_roles gr ON g.id=gr.Group_id JOIN roles r ON gr.roles_id=r.id WHERE login=?");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/test/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

    /**
     * @return mysql data source
     */
    @Bean(name = "mysql")
    public DriverManagerDataSource mysqlDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/s");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("");
        return driverManagerDataSource;
    }

    /**
     * @return postgres datasource
     */
    @Bean(name = "postgres")
    public DriverManagerDataSource postgresDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/test2");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("postgres");
        return driverManagerDataSource;
    }
}


