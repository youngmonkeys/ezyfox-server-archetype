#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

#!/bin/sh

EZYFOX_SERVER_HOME="${symbol_dollar}( cd "${symbol_dollar}( dirname "${symbol_dollar}{BASH_SOURCE[0]}" )" && pwd )"
PID_FILE=$EZYFOX_SERVER_HOME/.runtime/ezyfox_server_instance.pid

if [ ! -f "${symbol_dollar}{PID_FILE}" ]; then
    echo "No ezyfox server instance is running."
    exit 0
fi

PID=${symbol_dollar}(cat "${symbol_dollar}{PID_FILE}");
if [ -z "${symbol_dollar}{PID}" ]; then
    echo "No ezyfox server instance is running."
    exit 0
else
   kill -15 "${symbol_dollar}{PID}"
   rm "${symbol_dollar}{PID_FILE}"
   echo "Ezyfox server with PID ${symbol_dollar}{PID} shutdown."
   exit 0
fi
