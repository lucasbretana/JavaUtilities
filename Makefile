JC = javac
JC_FLAG = 
JD = javadoc
JD_FLAG = 
JR = jar
JR_FLAG = v

RM = rm
RM_FLAG = -rf

TARGET = debug
VERSION = 2.1
MANIFEST = META-INF/MANIFEST.MF

CLASS = Library Main

.ONESHELL:
all: compile documentation jar
	echo "All"

compile: $(addprefix src/debug/, $(addsuffix .java, $(CLASS)))
	cd src/
	$(JC) $(JC_FLAG) $(addprefix debug/, $(addsuffix .java, $(CLASS))) -d ../bin/
	cd ../

documentation: $(addprefix src/debug/, $(addsuffix .java, $(CLASS)))
	cd src/
	$(JD) $(JD_FLAG) $(addprefix debug/, $(addsuffix .java, $(CLASS))) -d ../doc/
	cd ..

jar: $(addprefix bin/debug/, $(addsuffix .class, $(CLASS))) $(MANIFEST)
	$(JR) $(JR_FLAG)cfm $(TARGET)_$(VERSION).jar $(MANIFEST) -C bin/ . doc/*

clear:
	$(RM) $(TARGET)_$(VERSION).jar 
	$(RM) bin/debug/*.class
	$(RM) $(RM_FLAG) doc/*
