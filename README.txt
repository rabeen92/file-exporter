PREREQUISITES
=============
- java should be installed. Please make sure javac and java commands are working.

HOW TO RUN THE PROGRAM ?
=========================

1) open terminal and navigate to the file-exporter folder
2) type the following commands in the terminal.

javac -d dist -classpath src/;lib/itext-1.3.jar src/fileexporter/Main.java
cd dist
java -classpath .;../lib/itext-1.3.jar fileexporter/Main

3) for ease of executing, I have provided a bat file with name executeProgram.bat
   that can be run in windows. run the file by the following command.

   start executeProgram.bat


INPUTS REQUIRED AT RUN TIME
============================
1) The code name of the alien needs to be given on prompt.
   Only String values are allowed.
2) Blood colour of the alien needs to be given on prompt.
   Only String values are allowed.
3) Number of antennas of the alien needs to be given on prompt.
   Only integer values are allowed.
4) Number of legs of the alien needs to be given on prompt.
   Only integer values are allowed.
5) Then name of the home planet needs to be given on prompt.
   Only String values are allowed.
6) Enter proper integer value representing export options as shown in the menu.
7) Enter path of the folder where the file has to be saved. The file will be saved in the location 
with the name codeName entered in step 1.

IMPLEMENTATION OVERVIEW
=======================

1) An interface is provided with name DataExportInterface.java
2) PdfExportOptions.java is the implementation of the above interface that
   handles the option of saving data to pdf file. I have used iText library
   for pdf generation.
3) TxtExporter.java is the implementation of the above interface that handles
   the option of saving data to text file.
4) OtherPlugins.java is the impementation of the above interface that handles the
  other plugins that may get added in the future. I have used java reflection for this purpose.
5) There is a config.txt file kept in dist folder which contains the file export menu options.



HOW TO ADD OTHER PLUGINS IN FUTURE WITHOUT EFFECTING THE CURRENT CODE
======================================================================

suppose the new plugin is supporting xls format and the class which handles the code is ExportXls.class
which is kept in some package package1.package2

1) Edit the config.txt file kept in the dist folder and add the following files
   Enter 4 for xls#package1.package2.ExportXls



