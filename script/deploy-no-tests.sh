#!/bin/bash

DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
(cd "${DIR}/../ru.taximaxim.codeKeeper/ru.taximaxim.codekeeper.mainapp/" && mvn clean deploy -P default,deploy-standalone -DskipTests=true)
