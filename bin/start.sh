#!/bin/sh

rm -f ../bin/tpid

nohup java -Dspring.profiles.active=prod -jar ../target/dldev-aiweb-0.1-SNAPSHOT.jar>../bin/aiweb.log 2>&1 &

echo $! > ../bin/tpid
