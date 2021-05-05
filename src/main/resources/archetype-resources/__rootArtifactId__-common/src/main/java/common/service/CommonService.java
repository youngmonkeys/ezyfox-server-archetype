#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.service;

import com.tvd12.ezyfox.bean.annotation.EzySingleton;

@EzySingleton
public class CommonService {

	public String hello(String prefix, String who) {
		return prefix + who + "!";
	}
	
	public String go(String prefix, String who) {
		return prefix + who + "!";
	}
	
}
