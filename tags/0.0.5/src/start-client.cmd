
cd .\target\vetcontrol-1.0-SNAPSHOT-vetcontrol-client.dir\vetcontrol-1.0-SNAPSHOT 

rem chcp 65001

"F:\Program Files\Java\jdk1.6.0_18\bin\java"  -cp ".\lib\*" -Djava.util.logging.config.file=logging.properties  org.vetcontrol.client.VetcontrolClient
