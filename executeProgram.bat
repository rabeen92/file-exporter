javac -d dist -classpath src/;lib/itext-1.3.jar src/fileexporter/Main.java
cd dist
java -classpath .;../lib/itext-1.3.jar fileexporter/Main