@echo off
setlocal EnableDelayedExpansion

echo Compiling and packaging the Spring project...

:: Navigate to the project directory (assuming the script is in the project root)
cd %~dp0

:: Run Maven clean and package
call mvn clean package
if %ERRORLEVEL% neq 0 (
    echo Maven build failed!
    exit /b %ERRORLEVEL%
)

set "PROJECT_NAME=test-spring.war"
:: Locate the WAR file in the target directory
set "WAR_FILE=target\%PROJECT_NAME%"
if not exist "%WAR_FILE%" (
    echo WAR file not found at %WAR_FILE%!
    exit /b 1
)

:: Copy the WAR file to Tomcat webapps directory
echo Deploying WAR file to C:\apache-tomcat-10.1.28\webapps...
copy "%WAR_FILE%" "C:\apache-tomcat-10.1.28\webapps"
if %ERRORLEVEL% neq 0 (
    echo Failed to copy WAR file to D:\Tomcat\webapps!
    exit /b %ERRORLEVEL%
)

echo Deployment successful!
endlocal