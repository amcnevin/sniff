#!/bin/bash
############################################################################
#
# CapturePulse
#
# records timestamp, scans iwlist and writes results to destination
#
# Exit Codes:
# 0 - Success
# 1 - SNIFF_INF env variable not set for wifi adapter
# 2 - SNIFF_DEST env variable not set for file destination
#
############################################################################


if [ -z "${SNIFF_INF}" ]; then 
	echo "SNIFF_INF needs to be set";
	exit 1;
fi

if [ ! -w "$SNIFF_DEST" ]; then
	echo "SNIFF_DEST needs to have write privileges";
	exit 2;
fi 


CAP_TIME=`date +"%m-%d-%yT%H:%M:%S%:z"`


iwlist ${SNIFF_INF} scan > ${SNIFF_DEST}sniff-${CAP_TIME}.txt

exit $?; 
