@setlocal
set start=%time%


:: clean all
call clear


:: generate client
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
echo "setup has been started at %start%"
echo "setup has been finished at %end%"