@echo off
SET DIR=%~dp0
SET JARSEARCH=%DIR%plugins\org.eclipse.equinox.launcher_*
for /f "Tokens=1* Delims=" %%F in ('dir /b "%JARSEARCH%"') do set File=%%F

SET LOGFILE=%USERPROFILE%\.pgcodekeeper-cli.log
SET JARFILE=%DIR%plugins\%File%
java -Dosgi.logfile="%LOGFILE%" -jar "%JARFILE%" %* 
