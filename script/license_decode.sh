#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
java -cp "${DIR}/../apgdiff/lib/license3j/*" License3j decode --license-file="$1" --keyring-file="${HOME}/.gnupg/pubring.gpg"
