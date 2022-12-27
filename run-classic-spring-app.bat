echo off
set SL_TOKEN=eyJhbGciOiJSUzUxMiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwczovL0RFVi1pbnRlZy1mdHYyLmF1dGguc2VhbGlnaHRzLmlvLyIsImp3dGlkIjoiREVWLWludGVnLWZ0djIsaS0wMmQ3YjRhNzczMDAxMDk5NixBUElHVy0yMjZjYjZlOS0xNzdmLTRmZDEtYmE1OC00ZTgyNGFiYzdkZWYsMTY3MDk2MzIyNjI5MyIsInN1YmplY3QiOiJTZWFMaWdodHNAYWdlbnQiLCJhdWRpZW5jZSI6WyJhZ2VudHMiXSwieC1zbC1yb2xlIjoiYWdlbnQiLCJ4LXNsLXNlcnZlciI6Imh0dHBzOi8vZGV2LWludGVnLWZ0djItZ3cuZGV2LnNlYWxpZ2h0cy5jby9hcGkiLCJzbF9pbXBlcl9zdWJqZWN0IjoiIiwiaWF0IjoxNjcwOTYzMjI2fQ.GhSaEzmMvXkkGfCF1wNAMVDeM5PA13CBTl3zb58c_128P6TkbjtS2BLntxNciz-3AIQdGNxphM2f75X2f7JmZ02bmNwJG4t9UgnU_dm2wqn32FgTsp6XSnVF_0Wa9Sb6ipB7XdsNcyhzE87kn14jz8vZXcPzCJAf1Tai0bFTpohy2PDeipWroXW_yhUkdPxgk3yqdiETU1zQUoXet41RpKbvBawWUV79kkRR6PqbAYwxpcXrEJbwIk-gf8jFjGnqvHB3TOIuiwtRztL8NiF4ID8Q7g86aWkVoIlNrOGr63vH9_vQ0hE9FAK5jrOvjKnVRjIFmp2wu3g038S02hKVQZcmUG0075LW6YBVpvnsDWnLtLtbH_WlheomKh6rAVcD9XnA4ksQEl9W27BiOH7QQUx6Cf7rw5C1bKP1Pb9HjAIg3FLRZLZU9-p0a-q8RVrmFUK8VRj4jTAhT5pRpXTL2KELP15t_RQGffjyxW3CsL-q5S-ZFB2Bp0hKmbbOOkcfvE3SusXzQJXG8jpj_K2wkJDE6hGRaPZcmjYfoke72dEPbG43cIFeWdxS5gJaO-oX9Q9htNnHgGX4eAOapk8r5iq7Jl-88CBwqvF59FLPCdMkDYawLfRDduFrxjonZf50XTbSVVqjgQUr5l9lppf-WBSjoBBSr_-i7-uaNrX05Fk

set PACKAGES="i0.sealights.*"
set APPLICATION_JAR=.\tar-app\ftv-hello-app.jar
set WORKSPACE=-Dsl.workspace=tar-app

set SL_LABID=integ_classic_fe4a_helloclassicapp
set SL_APPNAME=hello-classic-app
set SL_BRANCH_NAME=classic

set BUILD_NAME=test-run-001
set BATCH_SIZE=500

rem # HTTP_ATTEMPT_INTERVAL=-Dsl.httpAttemptInterval=9000
set LOGGING=-Dsl.log.toConsole=true -Dsl.log.level=info
set LOGBACK=-Dlogback.configurationFile=logback.xml

rem set DEBUG=-agentlib:jdwp=transport=dt_socket,server=n,address=host.docker.internal:8000,suspend=y
set DEBUG=-Dsl.httpDebugLog=yes

set buildSessionId=bfe69862-3964-44cb-ba2b-383d57008b0e

echo on

rem java -jar sl-test-listener.jar start -token %SL_TOKEN% -buildsessionid 07d114d8-bc97-409e-ab12-f149030fb2d4 -testStage "Runner Stage" -labid integ_ftv_d580_helloftvapp

rem java %DEBUG% %LOGGING% %WORKSPACE% -Dsl.featuresData.enableLineCoverage=false -Dsl.ignoreAutoGeneratedMethods=false -Dsl.ignoreMethodsWithoutLineNumbers=false -Dsl.featuresData.ignoreMethodsWithoutLineNumbers=false -Dsl.featuresData.ignoreAutoGeneratedMethods=false -Dsl.buildMapBatchSize=%BATCH_SIZE% -Dsl.includes=%PACKAGES% -Dsl.tokenFile=dev-integ-ftv2.token.txt -Dsl.labId=%SL_LABID% -Dsl.buildName=%BUILD_NAME% -Dsl.branchName=%SL_BRANCH_NAME% -Dsl.appName=%SL_APPNAME% -javaagent:sl-test-listener.jar -Dsl.buildSessionIdFile=buildSessionId.txt -Dsl.tags=backend -jar %APPLICATION_JAR%


java -jar sl-test-listener.jar end -token %SL_TOKEN% -buildsessionid 07d114d8-bc97-409e-ab12-f149030fb2d4 -labid integ_ftv_d580_helloftvapp