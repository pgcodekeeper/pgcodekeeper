#!/bin/bash

DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
(cd "${DIR}/../ru.taximaxim.codeKeeper/ru.taximaxim.codekeeper.mainapp/" && mvn clean verify -P default,deploy-standalone)
