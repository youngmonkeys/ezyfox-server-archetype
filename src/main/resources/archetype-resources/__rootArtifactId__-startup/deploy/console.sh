#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

#!/bin/sh

EZYFOX_SERVER_HOME="${symbol_dollar}( cd "${symbol_dollar}( dirname "${symbol_dollar}{BASH_SOURCE[0]}" )" && pwd )"
echo 'current dir: ' $EZYFOX_SERVER_HOME
CLASSPATH="lib/*:common/*:apps/common/*:apps/resources/*"
echo 'classpath: ' $CLASSPATH
java $1 -cp $CLASSPATH ${package}.ApplicationStartup
