package com.lambdaschool.liftingweights.config;

import com.lambdaschool.liftingweights.models.User;
import com.lambdaschool.liftingweights.models.UserWorkout;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(UserWorkout.class);
    }
}