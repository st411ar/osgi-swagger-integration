:: generate osgi bundle project
call mvn archetype:generate ^
    -DarchetypeGroupId=org.apache.sling ^
    -DarchetypeArtifactId=sling-bundle-archetype ^
    -DgroupId=com.axamit.meetup.osgi ^
    -DartifactId=osgi-client ^
    -Dversion=1.0.0 ^
    -Dpackage=com.axamit.meetup.osgi ^
    -DappsFolderName=osgi-client ^
    -DartifactName="osgi-client-name" ^
    -DpackageGroup="osgi-client-group" ^
    -DinteractiveMode=false
