@echo off
cd /d "%~dp0"
set JAVA_HOME=C:\Program Files\Java\jdk-25
set PATH=%JAVA_HOME%\bin;C:\Windows\System32\WindowsPowerShell\v1.0\;%PATH%

echo Using JAVA_HOME=%JAVA_HOME%
echo Starting Spring Boot Backend...
.\mvnw spring-boot:run -Dspring-boot.run.profiles=prod

pause
