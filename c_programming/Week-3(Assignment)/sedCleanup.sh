#!/bin/bash

if [ $# -ne 1 ]
then	echo "file name not passed in command line arg"
	exit 1
fi

FILE=$1

sed -i 's/HTTP\/1\.0/HTTP\/1\.1/g' "$FILE"

sed -i '/^#/d' "$FILE"

sed -i	's/[0-9]\{4\}-\?[0-9]\{4\}-\?[0-9]\{4\}-\?[0-9]\{4\}/XXXX-XXXX-XXXX-XXXX/g' "$FILE"

echo "Cleanup Completed"
