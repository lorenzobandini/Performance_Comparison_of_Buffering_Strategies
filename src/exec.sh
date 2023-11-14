fileName="Channel_Comparison"

javac "${fileName}.java"

if [ $? -ne 0 ]; then
    echo "Compilazione fallita."
    exit $?
fi

java "${fileName}"

rm -f *.class

for file in *.txt; do
    lowercaseFile=$(echo "$file" | tr '[:upper:]' '[:lower:]')
    if [ "$lowercaseFile" != "fileinput.txt" ]; then
        if [ "$lowercaseFile" != "fileinputbig.txt" ]; then
            rm -f "$file"
        fi
    fi
done
