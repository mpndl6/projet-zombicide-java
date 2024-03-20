# Makefile projet
JAVAC = javac
JAVADOC = javadoc
SRC = src
CLASSES = classes
DOCS = doc

all: classes deliverable2

classes: classSrc classesTest
	$(JAVAC) -sourcepath src src/zombicide/map/*.java -d $(CLASSES)

classSrc:
	$(JAVAC) -sourcepath src src/grid/*.java -d $(CLASSES)

classesTest:
	$(JAVAC) -sourcepath src:test -classpath junit-console.jar:classes test/zombicide/map/cell/*.java test/zombicide/map/util/*.java test/zombicide/item/utility/*.java test/zombicide/item/weapon/*.java test/zombicide/actor/survivor/*.java test/zombicide/actor/survivor/type/*.java test/zombicide/actor/zombie/type/*.java -d $(CLASSES)

doc: classes
	$(JAVADOC) -sourcepath $(SRC) -subpackages zombicide -d $(DOCS)

deliverable1.jar: classes
	jar cvfe deliverable1.jar zombicide.map.deliverable1 -C $(CLASSES) .

deliverable2.jar: classes
	jar cvfe deliverable2.jar zombicide.map.Livrable2 -C $(CLASSES) .

test: classesTest
	java -jar junit-console.jar -classpath $(SRC):$(CLASSES) -scan-classpath

deliverable2: deliverable2.jar
	java -jar $<

deliverable1: deliverable1.jar
	java -jar $<

clean:
	rm -rf $(CLASSES) $(DOCS)

.PHONY: all clean
