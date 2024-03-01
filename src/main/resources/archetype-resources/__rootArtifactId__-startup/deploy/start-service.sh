#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

${symbol_pound}!/bin/sh

EZYFOX_SERVER_HOME="${symbol_dollar}( cd "${symbol_dollar}( dirname "${symbol_dollar}{BASH_SOURCE[0]}" )" && pwd )"
PID_FILE=$EZYFOX_SERVER_HOME/.runtime/ezyfox_server_instance.pid

if [ $JAVA_HOME ]
then
	echo "JAVA_HOME found at $JAVA_HOME"
	RUN_JAVA=$JAVA_HOME/bin/java
else
	echo "JAVA_HOME environment variable not available."
    RUN_JAVA=`which java 2>/dev/null`
fi

if [ -z $RUN_JAVA ]
then
    echo "JAVA could not be found in your system."
    echo "please install Java 1.6 or higher!!!"
    exit 1
fi

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound} you can enable following variables by uncommenting them

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound} minimum heap size
${symbol_pound} MIN_HEAP_SIZE=1G

${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound} maximum heap size
${symbol_pound} MAX_HEAP_SIZE=1G


if [ "x$MIN_HEAP_SIZE" != "x" ]; then
	JAVA_OPTS="$JAVA_OPTS -Xms${symbol_dollar}{MIN_HEAP_SIZE}"
fi

if [ "x$MAX_HEAP_SIZE" != "x" ]; then
	JAVA_OPTS="$JAVA_OPTS -Xmx${symbol_dollar}{MAX_HEAP_SIZE}"
fi

CLASSPATH="lib/*:settings"

echo "${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}"
echo "${symbol_pound} RUN_JAVA=$RUN_JAVA"
echo "${symbol_pound} JAVA_OPTS=$JAVA_OPTS"
echo "${symbol_pound} CLASSPATH= $CLASSPATH"
echo "${symbol_pound} starting now...."
echo "${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}${symbol_pound}"

mkdir -p $EZYFOX_SERVER_HOME/.runtime

if [ -f ${symbol_dollar}{PID_FILE} ]; then
    PID=${symbol_dollar}(cat "${symbol_dollar}{PID_FILE}");
fi

if [ -z "${symbol_dollar}{PID}" ]; then
    echo "Process id for ezyfox server instance is written to file: $PID_FILE"
    java $1 -cp $CLASSPATH ${package}.ApplicationStartup > /dev/null 2>&1 &
    echo $! > ${symbol_dollar}{PID_FILE}
else
    echo "Another ezyfox server instance is already started in this folder. To start a new instance, please run in a new folder."
    exit 0
fi
