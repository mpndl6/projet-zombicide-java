# Makefile projet
JAVAC = javac
JAVADOC = javadoc
SRC = src
CLASSES = classes
DOCS = doc

all:classes deliverable2

classes: classSrc classesTest

classSrc:
	export CLASSPATH="$(SRC):$(CLASSPATH)"
	$(JAVAC) src/grid/*.java -d $(CLASSES)
	$(JAVAC) src/zombicide/map/*.java -d $(CLASSES)
	$(JAVAC) src/zombicide/map/cell/*.java -d $(CLASSES)
	$(JAVAC) src/zombicide/map/util/*.java -d $(CLASSES)
	$(JAVAC) src/zombicide/map/cell/*.java -d $(CLASSES)
	$(JAVAC) src/zombicide/map/cell/room/*.java -d $(CLASSES)
	$(JAVAC) src/zombicide/item/*.java -d $(CLASSES)
	$(JAVAC) src/zombicide/item/utility/*.java -d $(CLASSES)
	$(JAVAC) src/zombicide/item/weapon/*.java -d $(CLASSES)
	$(JAVAC) src/zombicide/actor/survivor/*.java -d $(CLASSES)
	$(JAVAC) src/zombicide/actor/survivor/type/*.java -d $(CLASSES)
	$(JAVAC) src/zombicide/actor/zombie/*.java -d $(CLASSES)
	$(JAVAC) src/zombicide/actor/zombie/type/*.java -d $(CLASSES)

classesTest:
	#Test
	export CLASSPATH="$(SRC):$(CLASSPATH)"
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/map/cell/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/map/util/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/map/cell/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/map/cell/room/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/item/utility/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/item/weapon/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/actor/survivor/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/actor/survivor/type/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/actor/zombie/type/*.java -d $(CLASSES)

doc: classes
	$(JAVADOC) -sourcepath $(SRC) -subpackages zombicide -d $(DOCS)

deliverable1.jar: classSrc
	jar cvfe deliverable1.jar zombicide.map.deliverable1 -C classes zombicide -C classes grid

deliverable2.jar: classSrc
	jar cvfe deliverable2.jar zombicide.map.Livrable2 -C classes zombicide -C classes grid

test: classesTest
	java -jar junit-console.jar -classpath test:classes -scan-classpath

deliverable2: deliverable2.jar
	java -jar $<

deliverable1: deliverable1.jar
	java -jar $<

clean:
	rm -Rf ./classes
	rm -Rf ./docs

.PHONY : all clean