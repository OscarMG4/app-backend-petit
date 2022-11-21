package idat.edu.pe.apiPetit.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.anonymous().disable();

        http.authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/api/accountsTypes/**").permitAll()
                .antMatchers("/api/petsTypes/**").permitAll()
                .antMatchers("/api/servicesTypes/**").permitAll()
                .antMatchers("/api/states/**").permitAll()
                .antMatchers("/api/users/**").permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new OAuth2AccessDeniedHandler());


    }
}
