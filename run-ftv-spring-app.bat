set SL_TOKEN=eyJhbGciOiJSUzUxMiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwczovL0RFVi1mdHYuYXV0aC5zZWFsaWdodHMuaW8vIiwiand0aWQiOiJERVYtZnR2LGktMGMxNjU4YjA0ZTljMDMwMzMsQVBJR1ctZGE0OGJmODAtOWNlOC00YmY1LThlNjQtNzg5YzI4ZGI4YTFkLDE2Njg0MzE2NjQ0MTMiLCJzdWJqZWN0IjoiU2VhTGlnaHRzQGFnZW50IiwiYXVkaWVuY2UiOlsiYWdlbnRzIl0sIngtc2wtcm9sZSI6ImFnZW50IiwieC1zbC1zZXJ2ZXIiOiJodHRwczovL2Rldi1mdHYtZ3cuZGV2LnNlYWxpZ2h0cy5jby9hcGkiLCJzbF9pbXBlcl9zdWJqZWN0IjoiIiwiaWF0IjoxNjY4NDMxNjY0fQ.GOhhhcA92yg0DcMtenuZZxY-QhF45uVJP01Fw6OPM0C6eDWkncxyg-9ZNgJeWKMjp5C3L_0ziEF0Xt0yzmldCDuBLkRHjOaEbtZy_-Q0IVS4Q4eXkiA4DCUajjYBIR6sTBP6A9YXOVQV3QC7Pa4DJP0g5WxtZpCwCmqD73AAz4hXPIPidGe6HlhFrliRlHU8HTugNEQ1mtz4MM0rzZY8yO3f3K4yeXQXRfjpNXGGO7UuyNDG9k4IJAqcaFivbIKfpbtYSUE_ZWznWUwJHRyxDzu8Vv7GgIzTbl_3_Qanw5ckb51GJ8Z6fFSo-5IwOaQRmCIz3yBPjFV3cbbxyI75T5axT0RFzuwv_JHkiIV29xe4Rhk87uFWkMGzLvq57kmTL7-OV890LdO5uxQih6oTYqkSRPD5fXYyz9sYvYsdFQrJb1TPLd1Ozzm3UWp54fbPsqvRqu75vJe_OyBBo66evUlc4BiI0A8LgdIjs1fP2X61wNJG5GAzZsG1-_Cv3P7Vq_N6MM-9Beaing9XmxceAcPl8FKB_IirZJqbec6HYpsqXkDfuGVv7Rxb71BBfpC_9kEZbYsFcoU6MbLsp_xvFwE1W5rr-6K1kP8ZPeveLLO4X1-q_fnoQkVVvg1JgHQJXLLE9XWyLh2i_htH6aIX4KbY_wbAqAUkcJ6pmyuWLjw

set PACKAGES=i0.sealights*
set SL_LABID=integ_puppet_038a_gfftvlab02
set SL_APPNAME=gf-ftv-lab02
set APPLICATION_JAR=ftv-hello-app-0.0.1-SNAPSHOT.jar
set BUILD_NAME=remoteBuildName002

del target\%APPLICATION_JAR%

copy build\libs\%APPLICATION_JAR% target\%APPLICATION_JAR%

java -Dsl.includes=%PACKAGES% -Dsl.token=%SL_TOKEN% -Dsl.labId=%SL_LABID% -Dsl.appName=%SL_APPNAME% -javaagent:java-agent-ftv-4.0.0-SNAPSHOT.jar=workspacepath=.,packagesincluded=%PACKAGES% -jar .\target\%APPLICATION_JAR%
