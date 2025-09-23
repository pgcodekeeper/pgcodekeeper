#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
( \
cd "${DIR}/../" \
&& \
mvn org.eclipse.tycho:tycho-versions-plugin:4.0.13:set-version \
-Dartifacts=\
ru.taximaxim.codekeeper.rcp.product,\
ru.taximaxim.codekeeper.mainapp,\
ru.taximaxim.codekeeper.feature \
-DnewVersion=$1"-SNAPSHOT" \
versions:set-property \
-Dproperty=revision \
-DgenerateBackupPoms=false \
)
