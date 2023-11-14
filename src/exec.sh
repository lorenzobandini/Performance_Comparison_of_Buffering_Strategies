#!/bin/bash

fileName="Channel_Comparison"

javac "${fileName}.java"

if [ $? -ne 0 ]; then
    echo "Compilazione fallita."
    exit $?
fi

java "${fileName}"

rm -f *.class

for file in *.txt; do
    if [ "${file,,}" != "FileInput.txt" ] && [ "${file,,}" != "FileInputBig.txt" ]; then
        rm -f "${file}"
    fi
done


