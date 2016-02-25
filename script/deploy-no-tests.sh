#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
(cd "${DIR}/../ru.taximaxim.codekeeper.mainapp/ru.taximaxim.codeKeeper/" && mvn clean deploy -P deploy-site,deploy-cli,deploy-site-public,deploy-cli-public -DskipTests)
