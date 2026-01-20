#!/bin/bash
if [ -z "$1" ]
then
  echo "Uso: ./run.sh arquivo.pbm"
  echo "Exemplo: ./run.sh samples/teste.pbm"
  exit 1
else
  java -cp bin inspector.Program "$1"
fi
