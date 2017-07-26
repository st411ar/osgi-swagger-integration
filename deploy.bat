cd osgi-client
call mvn clean install -PautoInstallBundle

cd ../osgi-consumer
call mvn clean install -PautoInstallBundle
