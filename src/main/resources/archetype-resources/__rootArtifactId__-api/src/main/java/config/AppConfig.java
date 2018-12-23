#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import com.tvd12.properties.file.annotation.Property;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppConfig {

	@Property("database.name")
	private String databaseName;
	
}
