#!/bin/bash
ARG=""
if [[ $(uname) == "Darwin" ]]; then
    ARG="-XstartOnFirstThread"
fi
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
LOG_DIR="${HOME}"/.pgcodekeeper-cli.log

number=0
for var in "$@"
do
    if [[ $var == "-vmargs" ]] ; then
        break
    fi
    (( number++ ))
done

java -Dosgi.logfile=${LOG_DIR} ${ARG} "${@:$number + 2}" -jar "${DIR}"/plugins/org.eclipse.equinox.launcher_* "${@:1:$number}"
