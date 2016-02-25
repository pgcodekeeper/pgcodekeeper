#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
java -cp "${DIR}/../apgdiff/lib/license3j/*" License3j encode --license-file="$1" --keyring-file="${HOME}/.gnupg/secring.gpg" --key="Technology, LLC (pgCodeKeeper) <ags@taximaxim.ru>" --password="" --output="$1.enc"

