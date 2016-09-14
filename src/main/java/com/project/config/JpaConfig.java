package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * init
 *
 * @author mroziqella
 */
@Configuration
public class JpaConfig {

    /**
     * Inicialization Hibernate JPA entity manager
     *
     * @return entity manager
     */
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("postgres");
    }

}
