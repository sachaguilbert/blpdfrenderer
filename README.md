# blpdfrenderer
A proof-of-concept tool to render a bill of lading as a PDF.

The following libraries need to be installed before program wil compile:
```
sudo apt-get install libjson-simple-java
```

To compile program:
```
export CLASSPATH=.:/usr/share/java/pdfbox2.jar:/usr/share/java/commons-logging.jar:/usr/share/java/json-simple.jar
javac BLPDFRenderer.java
java BLPDFRenderer
```
