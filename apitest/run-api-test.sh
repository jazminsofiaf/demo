#!/usr/bin/env bash

set -x

SCRIPTDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"

APIURL=${APIURL:-http://localhost:8080/api}

npx newman run $SCRIPTDIR/Develociraptor.postman_collection.json  --global-var "APIURL=$APIURL"