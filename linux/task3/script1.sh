#!/bin/sh
SHORTOPTS="fl:a"
LONGOPTS="file,log:,append"
OPTS=$(getopt -o "SHORTOPTS" -l "$LONGOPTS" -- "$a")

eval set −−"$OPTS"
FILE=""
LOG=""
APPEND=""
while [ $# -gt 0 ]
 do 
  case $1 in
    -f|--file)echo $1; FILE=$1; shift;;
    -l|--log)echo $1; LOG=$1; shift;;
    -a|--a)echo $1;  APPEND=$1; shift;;
   --)shift;break;;
    *)echo fuck;shift;;
  esac
done

echo $FILE  $LOG $APPEND
