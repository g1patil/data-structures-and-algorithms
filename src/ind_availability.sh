#!/bin/bash

# Small shell script that I wrote to check the availability of the dates at IND 
declare -a array=("amsterdam" "Haag" "Rotterdam" "Zwolle" "Bosch" "Harlem")
declare -a codes=("AM" "DH" "RO" "ZW" "DB" "fa24ccf0acbc76a7793765937eaee440")


print () {
    # echo ${codes[$1]} 
    result=$(curl -s https://oap.ind.nl/oap/api/desks/${codes[$1]}/slots/\?productKey\=DOC\&persons\=1 | tail +2 );
    avail=$(echo $(echo ${result} | jq '.data[0]' | jq  -r .date) |  { IFS=- read y m d && echo "$d/$m/$y"; } ) ;
    # echo $avail;
    # say "Date open for ${avail} for ${array[$1]}"

    d2="2022-05-31" d1=$(echo ${avail} | awk -v FS=/ -v OFS=- '{print $3,$2,$1}')
    if [ "$d1" = "$d2" ]; then
        echo "same day"
    elif expr "$d1" "<=" "$d2" >/dev/null; then
        echo "${d1} is earlier than ${d2}"
        say "Date open for ${avail} for ${array[$1]}"
    else
        echo "${d1} is later than ${d2}"
    fi
    # rm ${array[$1]}
}

while true
do 
    for i in {0..0}
    do
       print $i
    done
    sleep 2
done