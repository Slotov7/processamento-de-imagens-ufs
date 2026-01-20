@echo off
if "%~1"=="" (
    echo Uso: run.bat arquivo.pbm
    echo Exemplo: run.bat samples\teste.pbm
    exit /b 1
) else (
    java -cp bin inspector.Program "%~1"
)
