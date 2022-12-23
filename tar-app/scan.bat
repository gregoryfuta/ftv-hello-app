set LOGGING=-Dsl.log.toConsole=true -Dsl.log.level=info
set SL_TOKEN_FILE=..\dev-integ-ftv2.token.txt

java %LOGGING% -jar ..\sl-build-scanner.jar -scan -tokenfile %SL_TOKEN_FILE% -buildsessionidfile ..\buildSessionId.txt -workspacepath . -fi "*.jar" -appname build-scan-builder -branch master -build classic-001

java -jar ..\sl-build-scanner.jar -buildend  -ok -tokenfile %SL_TOKEN_FILE% -buildsessionidfile ..\buildSessionId.txt