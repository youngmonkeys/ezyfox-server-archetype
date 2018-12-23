#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.plugin;

import ${package}.plugin.config.PluginConfig;
import com.tvd12.ezyfox.bean.EzyBeanContextBuilder;
import com.tvd12.ezyfoxserver.context.EzyPluginContext;
import com.tvd12.ezyfoxserver.setting.EzyPluginSetting;
import com.tvd12.ezyfoxserver.support.entry.EzySimplePluginEntry;
import com.tvd12.properties.file.mapping.PropertiesMapper;
import com.tvd12.properties.file.reader.BaseFileReader;

/**
 * @author tavandung12
 *
 */
public class PluginEntry extends EzySimplePluginEntry {

	@Override
	protected void preConfig(EzyPluginContext ctx) {
		logger.info("${symbol_escape}n=================== HELLO-WORLD PLUGIN START CONFIG ================${symbol_escape}n");
	}
	
	@Override
	protected void postConfig(EzyPluginContext ctx) {
		logger.info("${symbol_escape}n=================== HELLO-WORLD PLUGIN END CONFIG ================${symbol_escape}n");
	}
	
	@Override
	protected void setupBeanContext(EzyPluginContext context, EzyBeanContextBuilder builder) {
		EzyPluginSetting setting = context.getPlugin().getSetting();
		String pluginConfigFile = setting.getConfigFile();
		PluginConfig pluginConfig = readPluginConfig(pluginConfigFile);
		logger.info("${parentArtifactId} plugin config: {}", pluginConfig);
	}

	@Override
	public void start() throws Exception {
		getLogger().info("chat plugin: start");
	}
	
	@Override
	protected String[] getScanableBeanPackages() {
		return new String[] {
			"${package}.plugin",
		};
	}

    private PluginConfig readPluginConfig(String appConfigFile) {
		return new PropertiesMapper()
				.file(appConfigFile)
				.context(getClass())
				.clazz(PluginConfig.class)
				.reader(new BaseFileReader())
				.map();
	}

}