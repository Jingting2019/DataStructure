#!/bin/bash
folder="tests"
class="$1"
javac $class.java
error=0
for t in `ls $folder|grep -v '\.a'`; do 
	res=`cat "$folder/$t.a"`
	output=`java $class < $folder/$t`
	if [ "$res" == "$output" ]; then
		echo "$t: Correct"
	else
		let "error++"
		echo -e "$t:\e[31mWRONG\e[0m, expected: $res, your answer: $output"
	
	fi
done

if [ $error == 0 ]; then
	echo -e "\e[92mCongras!, All Passed"
else 
	echo -e "\e[31mErrors: $error"
fi
