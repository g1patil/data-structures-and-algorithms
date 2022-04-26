#!/bin/bash

# Small shell script that I wrote to check the availability of the dates at IND 
declare -a array=("amsterdam" "Haag" "Rotterdam" "Zwolle" "Bosch" "Harlem")
declare -a codes=("AM" "DH" "RO" "ZW" "DB" "fa24ccf0acbc76a7793765937eaee440")



print () {
    echo ${codes[$1]} 
    curl -s https://oap.ind.nl/oap/api/desks/${codes[$1]}/slots/\?productKey\=BIO\&persons\=1 | tail +2 > ${array[$1]}
    say "Date open for $(echo $(cat ${array[$1]} | jq '.data[0]' | jq  -r .date) | awk -v FS=- -v OFS=/ '{print $2,$3,$1}') for ${array[$1]}"
    rm ${array[$1]}
}

for i in {0..5}
    do
       print $i
done

