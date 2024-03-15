# Makefile projet
JAVAC = javac
JAVADOC = javadoc
SRC = src
CLASSES = classes
DOCS = doc

all:deliverable2

classes: classSrc classSrc classesTest

classSrc:
	$(JAVAC) src/**/*.java -d $(CLASSES)

classesTest:
	#Test
	$(JAVAC) -classpath junit-console.jar:classes test/**/*.java -d $(CLASSES)

doc: classes
	$(JAVADOC) -sourcepath $(SRC) -subpackages zombicide -d $(DOCS)

deliverable1.jar: classSrc
	jar cvfe deliverable1.jar zombicide.map.deliverable1 -C classes zombicide -C classes grid

deliverable2.jar: classSrc
	jar cvfe deliverable2.jar zombicide.map.Livrable2 -C classes zombicide -C classes grid

test: classes
	java -jar junit-console.jar -classpath test:classes -scan-classpath

deliverable2: deliverable2.jar
	java -jar $<

deliverable1: deliverable1.jar
	java -jar deliverable1.jar

clean:
	rm -Rf ./classes
	rm -Rf ./docs
	rm *.jar

.PHONY : all clean