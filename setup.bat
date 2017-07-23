@setlocal
set start=%time%


:: clean all
call clear

:: download swagger-codegen
git clone https://github.com/swagger-api/swagger-codegen.git

:: switch to release 2.2.3
cd swagger-codegen
git checkout -b release-2.2.3 v2.2.3

:: add retrofit2-custom library that contains fixes
xcopy ..\fixed\modules modules /S /I /Y

:: build swagger-codegen
call mvn install

:: generate client
cd ..
java -jar swagger-codegen/modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate ^
-i https://app.swaggerhub.com/apiproxy/schema/file/st411ar/meetup-9/1.0.0/swagger.json ^
-l java ^
-c cfg.json ^
-o client

:: build client
cd client
call mvn install

:: generate stub
cd ..
java -jar swagger-codegen/modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate ^
		-i https://app.swaggerhub.com/apiproxy/schema/file/st411ar/meetup-9/1.0.0/swagger.json ^
		-l jaxrs --library=jersey2-custom ^
		-o stub

:: build stub
cd stub
call mvn install


:: show elapsed time
set end=%time%
echo %start%
echo %end%