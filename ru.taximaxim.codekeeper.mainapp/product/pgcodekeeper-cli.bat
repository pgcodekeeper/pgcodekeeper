@echo off
SET DIR=%~dp0
for /f "Tokens=1* Delims=" %%F in ('dir /b %DIR%plugins\org.eclipse.equinox.launcher_*') do set File=%%F
java -Dosgi.logfile=%USERPROFILE%/.pgcodekeeper-cli.log -jar %DIR%plugins/%File% %* 
