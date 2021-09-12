#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

${symbol_pound} ${artifactId}

${symbol_pound} Require

1. Java 8 or higher
2. Apache Maven 3.3+

${symbol_pound} Description

1. ${artifactId}-app-api: contains app's request controller, app's event handler and which components just related to app
2. ${artifactId}-app-entry: contains `AppEntryLoader` class, you should not add classes here
3. ${artifactId}-app-entry/config/config.properties: app's configuration file
4. ${artifactId}-common: contains components that use by both app and plugin
5. ${artifactId}-plugin: contains plugin's event handler, plugin's request controller and which components just related to plugin. You will need handle `USER_LOGIN` event here
6. ${artifactId}-plugin/config/config.properties: plugin's configuration file
7. ${artifactId}-startup: contains `ApplicationStartup` class to run on local, you should not add classes here
8. ${artifactId}-startup/src/main/resources/log4j.properties: log4j configuration file

${symbol_pound} How to build?

You can build by:

1. Your IDE
2. Run `mvn clean install` on your terminal
3. Open `build.sh` file and set `EZYFOX_SERVER_HOME` by your `ezyfox-server` folder path and run `bash build.sh` file on your terminal

${symbol_pound} How to run?

${symbol_pound}${symbol_pound} Run on your IDE

You just move to `${artifactId}-startup` module and run `ApplicationStartup`

${symbol_pound}${symbol_pound} Run by ezyfox-server

To run by `ezyfox-server` you need follow by steps:
1. Download [ezyfox-sever](https://resources.tvd12.com/) (standard version for IoT and full version for normal server)
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

${symbol_pound}${symbol_pound} Run without ezyfox-server

To run without `ezyfox-server` you need follow by steps:

1. Run `bash export.sh` command
2. Move to `${artifactId}-startup/deploy` folder

${symbol_pound}${symbol_pound}${symbol_pound} On Windows

You just need run `console.bat`

${symbol_pound}${symbol_pound}${symbol_pound} On Linux

1. To run to debug, you just need run `bash console.sh` on your terminal
2. To run in background, you just need run `bash start-service.sh` on your terminal
3. To stop your service, you just need run `bash stop-service.sh` on your terminal

${symbol_pound}${symbol_pound} Run with specific configuration profile

You can [read this guide](https://youngmonkeys.org/ezyfox-server-project-configuration/) to know how to run `ezyfox-server` or your application with a specific profile

${symbol_pound} How to deploy?

${symbol_pound}${symbol_pound} Deploy mapping

Modules after will deploy to `ezyfox-server` will be mapped like this:

1. ${artifactId}-app-api => `ezyfox-server/apps/common/${artifactId}-app-api-${version}.jar`
2. ${artifactId}-app-entry => `ezyfox-server/apps/entries/${artifactId}-app`
3. ${artifactId}-common => `ezyfox-server/common/ ${artifactId}-common-${version}.jar`
4. ${artifactId}-plugin => `ezyfox-server/plugins/${artifactId}-plugin`

${symbol_pound}${symbol_pound} Deploy with tools

You can use bellow tools to copy jar files (follow by above mapping)

1. [filezilla](https://filezilla-project.org/)
2. [transmit](https://panic.com/transmit/)

${symbol_pound}${symbol_pound} Deploy with scp

We've already prepared for you `deploy.sh` file, you just need:

1. Open `deploy.sh` file
2. Set `ezyfoxServerLocal` by your `ezyfox-server` folder path on local
3. Set `ezyfoxRemote` by your `ezyfox-server` folder path on remote
4. Set `sshCredential` by your ssh credential, i.e `root@your_host.com`
5. Run `bash deploy.sh` command

${symbol_pound}${symbol_pound} Deploy without ezyfox-server

You just need use tool or `scp` to copy `${artifactId}-startup/deploy` to your server

${symbol_pound} How to test?

On your IDE, you need:

1. Move to `${artifactId}-startup` module 
2. Run `ApplicationStartup` in `src/main/java`
3. Run `ClientTest` in `src/test/java`

${symbol_pound} Documentation

You can find a lot of documents on [youngmonkeys.org](https://youngmonkeys.org/ezyfox-sever/)

${symbol_pound} Contact us

- Touch us on [Facebook](https://www.facebook.com/youngmonkeys.org)
- Ask us on [stackask.com](https://stackask.com)

${symbol_pound} Help us by donation

Currently, our operating budget is depending on our salary, every effort still based on voluntary contributions from a few members of the organization. But with a low budget like that, it causes many difficulties for us. With big plans and results being intellectual products for the community, we hope to receive your support to take further steps. Thank you very much.

[https://youngmonkeys.org/donate/](https://youngmonkeys.org/donate/)

${symbol_pound} License

- Apache License, Version 2.0
