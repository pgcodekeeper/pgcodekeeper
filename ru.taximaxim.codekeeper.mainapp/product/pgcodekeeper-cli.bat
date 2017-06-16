@echo off
for /f "Tokens=1* Delims=" %%F in ('dir /b plugins\org.eclipse.equinox.launcher_*') do set File=%%F
java -jar plugins/%File% %* 
