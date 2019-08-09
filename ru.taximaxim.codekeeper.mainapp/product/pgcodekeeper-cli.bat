@echo off
setlocal enabledelayedexpansion
SET DIR=%~dp0
SET JARSEARCH=%DIR%plugins\org.eclipse.equinox.launcher_*
for /f "Tokens=1* Delims=" %%F in ('dir /b "%JARSEARCH%"') do set File=%%F

for %%X in (%*) do (
    IF "%%X" == "-vmargs" (
        set ISVM=y
    ) ELSE (
        IF DEFINED ISVM (
            set VMARG=!VMARG! %%X
        ) ELSE (
            set BASEARG=!BASEARG! %%X
        )
    )
)

SET LOGFILE=%USERPROFILE%\.pgcodekeeper-cli.log
SET JARFILE=%DIR%plugins\%File%
java -Dosgi.logfile="%LOGFILE%" %VMARG% -jar "%JARFILE%" %BASEARG%