JC = javac
JC_FLAG = 
JD = javadoc
JD_FLAG = 
JR = jar
JR_FLAG = v

RM = rm
RM_FLAG = -rf

TARGET = debug
VERSION = v2.1
MANIFEST = META-INF/MANIFEST.MF

CLASS = Library Main

.ONESHELL:
all: clear compile documentation jar
	echo "All"

compile: $(addprefix src/debug/, $(addsuffix .java, $(CLASS)))
	cd src/
	$(JC) $(JC_FLAG) $(addprefix debug/, $(addsuffix .java, $(CLASS))) -d ../bin/
	cd ../

documentation: $(addprefix src/debug/, $(addsuffix .java, Library))
	cd src/
	$(JD) $(JD_FLAG) $(addprefix debug/, $(addsuffix .java, Library)) -d ../doc/
	cd ..

jar: $(addprefix bin/debug/, $(addsuffix .class, Library))
	$(JR) $(JR_FLAG)cf $(TARGET)_$(VERSION).jar -C bin/ debug/Library.class doc/* README.md

documentation_full: $(addprefix src/debug/, $(addsuffix .java, $(CLASS)))
	cd src/
	$(JD) $(JD_FLAG) $(addprefix debug/, $(addsuffix .java, $(CLASS))) -d ../doc/
	cd ..

jar_test: $(addprefix bin/debug/, $(addsuffix .class, $(CLASS))) $(MANIFEST)
	$(JR) $(JR_FLAG)cfm main_$(TARGET)_$(VERSION).jar $(MANIFEST) -C bin/ . doc/* README.md

clear:
	$(RM) $(TARGET)_$(VERSION).jar 
	$(RM) main_$(TARGET)_$(VERSION).jar 
	$(RM) bin/debug/*.class
	$(RM) $(RM_FLAG) doc/*
