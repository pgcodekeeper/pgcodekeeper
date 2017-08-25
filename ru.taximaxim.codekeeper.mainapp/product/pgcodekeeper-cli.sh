#!/bin/bash
ARG=""
if [[ $(uname) == "Darwin" ]]; then
    ARG="-XstartOnFirstThread"
fi
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
java ${ARG} -jar "${DIR}"/plugins/org.eclipse.equinox.launcher_* "$@"
