# Makefile projet
JAVAC = javac
JAVADOC = javadoc
SRC = src
CLASSES = classes
DOCS = doc
JAR = jar

all: doc jar/deliverable2.jar jar/deliverable1.jar jar/deliverable3.jar

classes: classesTest classSrc

doc : classes

classSrc:
	$(JAVAC) -sourcepath src src/zombicide/*.java -d $(CLASSES)

classesTest:
	$(JAVAC) -sourcepath src:test -classpath junit-console.jar:classes test/zombicide/map/cell/*.java test/zombicide/map/util/*.java test/zombicide/item/utility/*.java test/zombicide/item/weapon/*.java test/zombicide/actor/survivor/*.java test/zombicide/actor/survivor/type/*.java test/zombicide/actor/zombie/type/*.java -d $(CLASSES)

doc: classes
	$(JAVADOC) -sourcepath $(SRC) -subpackages zombicide -d $(DOCS)

jar/deliverable1.jar: classSrc
	jar cvfe jar/deliverable1.jar zombicide.Livrable1 -C $(CLASSES) .

jar/deliverable2.jar: classSrc
	jar cvfe jar/deliverable2.jar zombicide.Livrable2 -C $(CLASSES) .

jar/deliverable3.jar: classSrc
	jar cvfe jar/deliverable3.jar zombicide.Livrable3 -C $(CLASSES) .

test: classesTest
	java -jar junit-console.jar -classpath $(SRC):$(CLASSES) -scan-classpath

test-deliverable2: jar/deliverable2.jar
	java -jar $<

test-deliverable1: jar/deliverable1.jar
	java -jar $<

test-deliverable3: jar/deliverable3.jar
	java -jar $<

clean:
	rm -rf $(CLASSES)/* $(DOCS)/* $(JAR)/*

.PHONY: all clean deliverable2 deliverable1 test
