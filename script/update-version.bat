@echo off
setlocal enabledelayedexpansion

set "DIR=%~dp0"
set "DIR=%DIR:~0,-1%"

pushd "%DIR%\.."

mvn org.eclipse.tycho:tycho-versions-plugin:4.0.13:set-version ^
-Dartifacts=ru.taximaxim.codekeeper.rcp.product,ru.taximaxim.codekeeper.ui,ru.taximaxim.codekeeper.mainapp,ru.taximaxim.codekeeper.feature ^
-DnewVersion=%1-SNAPSHOT ^
versions:set-property ^
-Dproperty=revision ^
-DgenerateBackupPoms=false

popd
endlocal