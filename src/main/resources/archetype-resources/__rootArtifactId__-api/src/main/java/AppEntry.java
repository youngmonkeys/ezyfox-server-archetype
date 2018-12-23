#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${package}.config.AppConfig;
import com.tvd12.ezyfox.bean.EzyBeanContextBuilder;
import com.tvd12.ezyfoxserver.context.EzyAppContext;
import com.tvd12.ezyfoxserver.setting.EzyAppSetting;
import com.tvd12.ezyfoxserver.support.entry.EzySimpleAppEntry;
import com.tvd12.properties.file.mapping.PropertiesMapper;
import com.tvd12.properties.file.reader.BaseFileReader;

public class AppEntry extends EzySimpleAppEntry {

	@Override
	protected void preConfig(EzyAppContext ctx) {
		logger.info("${symbol_escape}n=================== HELLO-WORD APP START CONFIG ================${symbol_escape}n");
	}
	
	@Override
	protected void postConfig(EzyAppContext ctx) {
		logger.info("${symbol_escape}n=================== HELLO-WORD APP END CONFIG ================${symbol_escape}n");
	}
	
	@Override
	protected void setupBeanContext(EzyAppContext context, EzyBeanContextBuilder builder) {
		EzyAppSetting setting = context.getApp().getSetting();
		String appConfigFile = setting.getConfigFile();
		AppConfig appConfig = readAppConfig(appConfigFile);
		logger.info("hello-word app config: {}", appConfig);
	}
	
	public void start() throws Exception {
		getLogger().info("start ${parentArtifactId} app");
	}

	@Override
	protected String[] getScanableBeanPackages() {
		return new String[] {
				"${package}.common",
				"${package}.controller",
				"${package}.handler"
		};
	}
	
	@Override
	protected String[] getScanableBindingPackages() {
		return new String[] {
			"${package}.handler"
		};
	}

	private AppConfig readAppConfig(String appConfigFile) {
		return new PropertiesMapper()
				.file(appConfigFile)
				.context(getClass())
				.clazz(AppConfig.class)
				.reader(new BaseFileReader())
				.map();
	}

}
