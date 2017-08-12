@echo off
SET DIR=%~dp0
for /f "Tokens=1* Delims=" %%F in ('dir /b %DIR%plugins\org.eclipse.equinox.launcher_*') do set File=%%F
java -jar %DIR%plugins/%File% %* 
