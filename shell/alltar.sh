#!/bin/sh

FILELIST=`ls ./*.tar.gz`

for file in $FILELIST
do
	echo $file
	tar -xzvf "$file"
done
