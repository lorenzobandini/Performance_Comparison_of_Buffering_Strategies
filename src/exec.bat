@echo off
setlocal

set fileName=Channel_Comparison

javac %fileName%.java

if %errorlevel% neq 0 (
    echo Compilazione fallita.
    exit /b %errorlevel%
)

java %fileName%

del *.class

for %%i in (*.txt) do (
    if /i not "%%i"=="FileInput.txt" if /i not "%%i"=="FileInputBig.txt" del "%%i"
)


:end
