:: generate osgi consumer project
call mvn archetype:generate ^
    -DarchetypeGroupId=org.apache.sling ^
    -DarchetypeArtifactId=sling-bundle-archetype ^
    -DgroupId=com.axamit.meetup.osgi.consumer ^
    -DartifactId=osgi-consumer ^
    -Dversion=1.0.0-SNAPSHOT ^
    -Dpackage=com.axamit.meetup.osgi.consumer ^
    -DappsFolderName=osgi-consumer ^
    -DartifactName="osgi-consumer-name" ^
    -DpackageGroup="osgi-consumer-group" ^
    -DinteractiveMode=false
