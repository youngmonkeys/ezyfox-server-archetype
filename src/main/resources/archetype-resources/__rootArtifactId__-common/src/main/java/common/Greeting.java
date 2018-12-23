#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common;

import com.tvd12.ezyfox.bean.annotation.EzySingleton;

@EzySingleton
public class Greeting {

	public String greet(String who) {
		return "Greet " + who + "!";
	}
	
}
