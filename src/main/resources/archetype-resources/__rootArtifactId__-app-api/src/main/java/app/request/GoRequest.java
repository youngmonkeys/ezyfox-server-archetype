#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app.request;

import com.tvd12.ezyfox.binding.annotation.EzyObjectBinding;

import lombok.Data;

@Data
@EzyObjectBinding
public class GoRequest {

	private String nickName;
	
}
