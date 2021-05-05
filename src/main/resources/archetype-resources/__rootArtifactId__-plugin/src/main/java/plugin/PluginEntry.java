#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.plugin;

import java.util.Properties;

import com.tvd12.ezyfox.bean.EzyBeanContextBuilder;
import com.tvd12.ezyfoxserver.context.EzyPluginContext;
import com.tvd12.ezyfoxserver.setting.EzyPluginSetting;
import com.tvd12.ezyfoxserver.support.entry.EzyDefaultPluginEntry;

/**
 * @author tavandung12
 *
 */
public class PluginEntry extends EzyDefaultPluginEntry {

	@Override
	protected void preConfig(EzyPluginContext ctx) {
		logger.info("${symbol_escape}n=================== ${parentArtifactId} PLUGIN START CONFIG ================${symbol_escape}n");
	}
	
	@Override
	protected void postConfig(EzyPluginContext ctx) {
		logger.info("${symbol_escape}n=================== ${parentArtifactId} PLUGIN END CONFIG ================${symbol_escape}n");
	}
	
	@Override
	protected void setupBeanContext(EzyPluginContext context, EzyBeanContextBuilder builder) {
		EzyPluginSetting setting = context.getPlugin().getSetting();
		builder.addProperties(getConfigFile(setting));
		Properties properties = builder.getProperties();
	}

	protected String getConfigFile(EzyPluginSetting setting) {
		return setting.getConfigFile();
	}
	
	@Override
	protected String[] getScanableBeanPackages() {
		return new String[] {
			"${package}.common",
			"${package}.plugin"
		};
	}
}