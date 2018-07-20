#!/usr/bin/env bash

#
# Brandon Altvater, 2018-07-20
#
# cURL request script to hit RESTful Service /info actuator endpoint
#
# /info endpoint response contains:
#   - build date
#   - service name
#   - service version
#

declare -A arr=(
    [star-wars-service]=starwars
)

printf "\ncURL requests started:"

for i in "${!arr[@]}"
do
    printf "\n\n$i:\n"
    curl -s http://localhost:8080/${arr[$i]}/info -H 'rest-ts: 123456' -H 'rest-uid: curl-uid' -H 'rest-user: curl'
done

printf "\n\ncURL requests completed!\n"