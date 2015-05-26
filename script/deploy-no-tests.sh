#!/bin/bash

DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
(cd "${DIR}/../ru.taximaxim.codekeeper.mainapp/ru.taximaxim.codeKeeper/" && mvn clean deploy -P default,deploy-standalone -DskipTests=true)
