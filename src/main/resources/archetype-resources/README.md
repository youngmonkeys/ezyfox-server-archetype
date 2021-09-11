# ${artifactId}

# Require

1. Java 8 or higher
2. Apache Maven 3.3+

# Description

1. ${artifactId}-app-api: contains app's request controller, app's event handler and which components just related to app
2. ${artifactId}-app-entry: contains `AppEntryLoader` class, you should not add classes here
2.1 ${artifactId}-app-entry/config/config.properties: app's configuration file
3. ${artifactId}-common: contains components that use by both app and plugin
4. ${artifactId}-plugin: contains plugin's event handler, plugin's request controller and which components just related to plugin. You will need handle `USER_LOGIN` event here
4.1 ${artifactId}-plugin/config/config.properties: plugin's configuration file
5. ${artifactId}-startup: contains `ApplicationStartup` class to run on local, you should not add classes here
5.1 ${artifactId}-startup/src/main/resources/log4j.properties: log4j configuration file

# How to build?

You can build by:

1. Your IDE
2. Run `mvn clean install` on your terminal
3. Run `build.sh` file on your terminal

# How to run?

## Run on your IDE

You just move to `${artifactId}-startup` module and run `ApplicationStartup`

## Run by ezyfox-server

To run by `ezyfox-server` you need follow by steps:
1. Download [ezyfox-sever](https://resources.tvd12.com/)
2. Setup `EZYFOX_SERVER_HOME` environment variable: let's say you place `ezyfox-server` at `/Programs/ezyfox-server` so `EZYFOX_SERVER_HOME = /Programs/ezyfox-server`
3. Run `build.sh` file on your terminal
4. Open file `EZYFOX_SERVER_HOME/settings/ezy-settings.xml` and add to `<zones>` tag:
```xml
    <zone>
		<name>${artifactId}</name>
		<config-file>${artifactId}-zone-settings.xml</config-file>
		<active>true</active>
	</zone>
```
5. Run `console.sh` in `EZYFOX_SERVER_HOME` on your termial, if you want to run `ezyfox-server` in backgroud you will need run `start-server.sh` on your terminal

# Deploy mapping

Modules after will deploy to `ezyfox-server` will be mapped like this:

1. ${artifactId}-app-api => `ezyfox-server/apps/common/${artifactId}-app-api-${version}.jar`
2. ${artifactId}-app-entry => `ezyfox-server/apps/entries/${artifactId}-app`
3. ${artifactId}-common => `ezyfox-server/common/ ${artifactId}-common-${version}.jar`
4. ${artifactId}-plugin => `ezyfox-server/plugins/${artifactId}-plugin`

# How to test?

On your IDE, you need:

1. Move to `${artifactId}-startup` module 
2. Run `ApplicationStartup` in `src/main/java`
3. Run `ClientTest` in `src/test/java`

# Documentation

You can find a lot of documents on [youngmonkeys.org](https://youngmonkeys.org/ezyfox-sever/)

# Contact us

- Touch us on [Facebook](https://www.facebook.com/youngmonkeys.org)
- Ask us on [stackask.com](https://stackask.com)
