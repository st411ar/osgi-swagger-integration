java -jar swagger-codegen/modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate ^
-i https://app.swaggerhub.com/apiproxy/schema/file/st411ar/meetup-9/1.0.0/swagger.json ^
-l java ^
-o client ^
-c cfg.json
