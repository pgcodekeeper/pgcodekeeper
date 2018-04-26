#!/bin/bash
ARG=""
if [[ $(uname) == "Darwin" ]]; then
    ARG="-XstartOnFirstThread"
fi
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
LOG_DIR="${HOME}"/.pgcodekeeper-cli.log

java -Dosgi.logfile=${LOG_DIR} ${ARG} -jar "${DIR}"/plugins/org.eclipse.equinox.launcher_* "$@"
