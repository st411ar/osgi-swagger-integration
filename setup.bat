@setlocal
set start=%time%


:: clean all
call clear-all

:: download swagger-codegen
git clone https://github.com/swagger-api/swagger-codegen.git

:: switch to release 2.2.3
cd swagger-codegen
git checkout -b release-2.2.3 v2.2.3

:: add retrofit2-custom library that contains fixes
cd ..
xcopy fixed\swagger-codegen swagger-codegen /S /I /Y

:: build swagger-codegen
cd swagger-codegen
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

:: add stub fixes
xcopy fixed\stub stub /S /I /Y

:: build stub
cd stub
call mvn install


:: show elapsed time
set end=%time%
echo "setup has been started at %start%"
echo "setup has been finished at %end%"