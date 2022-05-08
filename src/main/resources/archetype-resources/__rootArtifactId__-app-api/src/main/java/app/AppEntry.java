import com.tvd12.ezyfox.bean.EzyBeanContextBuilder;
import com.tvd12.ezyfoxserver.context.EzyAppContext;
import com.tvd12.ezyfoxserver.context.EzyZoneContext;
import com.tvd12.ezyfoxserver.setting.EzyAppSetting;
import com.tvd12.ezyfoxserver.support.entry.EzyDefaultAppEntry;

import java.util.Properties;{package}.common.constant.CommonConstants;

public class AppEntry extends EzyDefaultAppEntry {

    @Override
    protected void preConfig(EzyAppContext ctx) {
        logger.info("${symbol_escape}n=================== ${parentArtifactId} APP START CONFIG ================${symbol_escape}n");
    }

    @Override
    protected void postConfig(EzyAppContext ctx) {
        logger.info("${symbol_escape}n=================== ${parentArtifactId} APP END CONFIG ================${symbol_escape}n");
    }

    @Override
    protected void setupBeanContext(EzyAppContext context, EzyBeanContextBuilder builder) {
        EzyZoneContext zoneContext = context.getParent();
        Properties pluginProperties = zoneContext.getProperty(CommonConstants.PLUGIN_PROPERTIES);
        EzyAppSetting setting = context.getApp().getSetting();
        builder.addProperties("${parentArtifactId}-common-config.properties");
        builder.addProperties(pluginProperties);
        builder.addProperties(getConfigFile(setting));
    }

    protected String getConfigFile(EzyAppSetting setting) {
        return setting.getConfigFile();
    }

    @Override
    protected String[] getScanablePackages() {
        return new String[]{
            "${package}.common",
            "${package}.app"
        };
    }
}
