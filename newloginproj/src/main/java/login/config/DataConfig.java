package login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class DataConfig {
	
	@Bean
	@Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.INTERFACES)
	public KeyHolder getKeyHolder(){
		return new GeneratedKeyHolder();
	}
}
