# Change in accordance in ../pkg/expath-pkg.xml !!!
ZIP.ver  := 0.7.0
ZIP.mod  := expath-zip-saxon
PKG.root := $(ZIP.mod)-$(ZIP.ver)
PKG.zip  := $(PKG.root)/content
PKG      := ../pkg
PRJ      := ../zip-saxon
DIST     := $(PRJ)/dist
SRC      := $(PRJ)/src
SAMPLE   := ../sample

JAVA.jar := $(PRJ)/lib/expath-zip-java.jar
TAGSOUP  := $(PRJ)/lib/tagsoup-1.2.jar

all: clean dist

pkg:
	( cd $(PRJ)/ && ant )
	mkdir    "$(PKG.root)"
	mkdir -p "$(PKG.zip)"
	mkdir    "$(PKG.zip)/jar"
	mkdir    "$(PKG.zip)/lib"
	cp "$(PKG)/expath-pkg.xml" "$(PKG.root)"
	cp "$(PKG)/saxon.xml"      "$(PKG.root)"
	cp "$(PKG)/cxan.xml"       "$(PKG.root)"
	cp "$(DIST)/zip-saxon.jar" "$(PKG.zip)/jar/$(ZIP.mod).jar"
	cp "$(JAVA.jar)"           "$(PKG.zip)/jar"
	cp "$(PKG)/wrapper.xsl"    "$(PKG.zip)/$(ZIP.mod).xsl"
	cp "$(PKG)/wrapper.xq"     "$(PKG.zip)/$(ZIP.mod).xql"
	cp "$(TAGSOUP)"            "$(PKG.zip)/lib"
	cd "$(PKG.root)" && zip -r "../$(PKG.root).xar" *
	rm -rf "$(PKG.root)"

dist: pkg
	mkdir "$(PKG.root)"
	echo "Version: $(ZIP.ver)" > "$(PKG.root)/VERSION"
	echo "Subversion revision:" `svnversion` >> "$(PKG.root)/VERSION"
	cp "$(PKG.root).xar" "$(PKG.root)"
	cp README "$(PKG.root)"
	cp -pPR "$(SRC)" "$(PKG.root)"
	find "$(PKG.root)/src" -type d \( -name .svn -o -name .~ \) \
	    -exec rm -rf {} \; 2>/dev/null || true
	mkdir "$(PKG.root)/sample"
	cp "$(SAMPLE)/entries.xq"  "$(PKG.root)/sample"
	cp "$(SAMPLE)/entries.xsl" "$(PKG.root)/sample"
	cp "$(SAMPLE)/sample.zip"  "$(PKG.root)/sample"
	zip -r "$(PKG.root).zip" "$(PKG.root)"
	rm -rf "$(PKG.root)"

clean:
	rm -rf "$(PKG.root)"
	rm -rf "$(PKG.root).zip"
	rm -rf "$(PKG.root).xar"

.PHONY: dist pkg clean
