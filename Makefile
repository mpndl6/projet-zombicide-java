# Makefile projet
JAVAC = javac
JAVADOC = javadoc
SRC = src
CLASSES = classes
DOCS = doc

all = classes MainSecondDeliverable

classes:
	export CLASSPATH="$(SRC):$(CLASSPATH)"
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

	#Test
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/map/cell/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/map/util/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/map/cell/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/map/cell/room/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/item/utility/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/item/weapon/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/actor/survivor/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/actor/survivor/type/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/actor/zombie/*.java -d $(CLASSES)
	$(JAVAC) -classpath junit-console.jar:classes test/zombicide/actor/zombie/type/*.java -d $(CLASSES)

doc:
	$(JAVADOC) -sourcepath $(SRC) -subpackages zombicide -d $(DOCS)


MainFirstDeliverable.jar:
	jar cvfe $@ zombicide.map.MainFirstDeliverable -C classes zombicide

MainSecondDeliverable.jar:
	jar cvfe $@ zombicide.map.MainSecondDeliverable.jar -C classes zombicide

test:
	java -jar junit-console.jar -classpath test:classes -scan-classpath

MainSecondDeliverable: MainSecondDeliverable.jar
	java -jar MainSecondDeliverable.jar

clean:
	rm -Rf ./classes
	rm -Rf ./docs

.PHONY : all clean