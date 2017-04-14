#!/bin/sh

function print_help()
{
	echo "usage  : $0 <key word>"
	echo "------------------------------------------"
	echo "ex.:  $0 functionA"
	echo "------------------------------------------"
}

if [ "$#" -eq "1" ] ; then
	echo "1<$1>"
	find ./ \( -path "*out" -o -path "*ccache" -o -path "*\.git" \) -prune -o -print | xargs grep -n "$1" 2>>/dev/null
else
	print_help
fi
