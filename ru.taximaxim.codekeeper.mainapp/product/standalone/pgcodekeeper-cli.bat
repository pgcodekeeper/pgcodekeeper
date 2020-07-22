@echo off
setlocal enabledelayedexpansion
SET DIR=%~dp0
SET JARSEARCH=%DIR%plugins\org.eclipse.equinox.launcher_*
for /f "Tokens=1* Delims=" %%F in ('dir /b "%JARSEARCH%"') do set File=%%F

:argument_loop
IF NOT "%~1" == "" (
    IF "%~1" == "-vmargs" (
        set ISVM=y
    ) ELSE (
        IF DEFINED ISVM (
            set VMARG=!VMARG! "%~1"
        ) ELSE (
            set BASEARG=!BASEARG! "%~1"
        )
    )
    SHIFT
    GOTO argument_loop
)

SET LOGFILE=%USERPROFILE%\.pgcodekeeper-cli.log
SET JARFILE=%DIR%plugins\%File%
java -Dosgi.logfile="%LOGFILE%" %VMARG% -jar "%JARFILE%" %BASEARG%