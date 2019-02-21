#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
( \
cd "${DIR}/../ru.taximaxim.codekeeper.mainapp/ru.taximaxim.codeKeeper/" \
&& \
mvn org.eclipse.tycho:tycho-versions-plugin:set-version \
-Dartifacts=\
ru.taximaxim.codekeeper.cli,\
ru.taximaxim.codekeeper.standalone.product,\
ru.taximaxim.codekeeper.updatesite,\
ru.taximaxim.codekeeper.mainapp,\
ru.taximaxim.codekeeper.feature \
-DnewVersion=$1"-SNAPSHOT" \
)

( \
cd "${DIR}/../ru.taximaxim.codekeeper.mainapp/ru.taximaxim.codeKeeper/" \
&& \
mvn org.codehaus.mojo:versions-maven-plugin:2.7:set-property \
-Dproperty=global.version \
-DnewVersion=$1 \
-DgenerateBackupPoms=false \
)
