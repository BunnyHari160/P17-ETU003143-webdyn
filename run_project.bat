@echo off
set PROJET_INIT=%~dp0
set BUILD_PATH="%PROJET_INIT%build"
set WEBAPP_PATH="%PROJET_INIT%src/main/webapp"
set CATA_TOMCAT="C:\xampp\tomcat"
set LIB_PATH="%PROJET_INIT%lib"

:: supprimer buils si existe
if exist %BUILD_PATH% (
    echo \build en cours de suppression
    rmdir /s /q %BUILD_PATH%
)

:: structure de dossiers
echo Création de la structure des dossiers...
mkdir %BUILD_PATH%
mkdir %BUILD_PATH%\WEB-INF
mkdir %BUILD_PATH%\WEB-INF\classes

:: Compilation des fichiers .java et sortie dans le répertoire classes
echo Compilation des fichiers *.Java...
javac -d %BUILD_PATH%\WEB-INF\classes -classpath lib\servlet-api.jar;%LIB_PATH%\* "%PROJET_INIT%src\main\java\*.java"
@REM javac -d %BUILD_PATH%\WEB-INF\classes -classpath %LIB_PATH%\servlet-api.jar;%LIB_PATH%\*;%BUILD_PATH%\WEB-INF\classes "%%f"

:: Copier webapp/* dans build 
echo Copie récursive des fichiers webapp...
xcopy %WEBAPP_PATH%\*.xml %BUILD_PATH%\WEB-INF /S /Y
xcopy %WEBAPP_PATH% %BUILD_PATH%
:: Créer un fichier .war des \build\*
echo Creation du fichier WAR...
cd %BUILD_PATH%
jar -cvf ETU003143.war *

:: Deplacer le fichier .war dans webapps de Tomcat
echo Deployer le fichier WAR dans Tomcat...
move %BUILD_PATH%\ETU003143.war %CATA_TOMCAT%\webapps

echo Deploiement reussi ... 
pause

