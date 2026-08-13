#!/bin/sh
set -e

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
LIB_DIR="$SCRIPT_DIR/../lib"

mkdir -p "$LIB_DIR"
cd "$LIB_DIR"

# JMH
download_jmh() {
    group="org.openjdk.jmh"
    artifact="$1"
    version="$2"
    file="${artifact}-${version}.jar"
    if [ ! -f "$file" ]; then
        echo "Downloading $file ..."
        curl -fsSL -o "$file" \
            "https://repo1.maven.org/maven2/org/openjdk/jmh/${artifact}/${version}/${file}"
    else
        echo "$file already exists, skipping"
    fi
}

download_jmh "jmh-core" "1.37"
download_jmh "jmh-generator-annprocess" "1.37"

# JMH transitive dependencies
download_dep() {
    group_path="$1"
    artifact="$2"
    version="$3"
    file="${artifact}-${version}.jar"
    if [ ! -f "$file" ]; then
        echo "Downloading $file ..."
        curl -fsSL -o "$file" \
            "https://repo1.maven.org/maven2/${group_path}/${artifact}/${version}/${file}"
    else
        echo "$file already exists, skipping"
    fi
}

download_dep "net/sf/jopt-simple" "jopt-simple" "5.0.4"
download_dep "org/apache/commons" "commons-math3" "3.6.1"

# Jackson XML
download_dep "com/fasterxml/jackson/dataformat" "jackson-dataformat-xml" "2.18.2"
download_dep "com/fasterxml/jackson/core" "jackson-databind" "2.18.2"
download_dep "com/fasterxml/jackson/core" "jackson-core" "2.18.2"
download_dep "com/fasterxml/jackson/core" "jackson-annotations" "2.18.2"
download_dep "com/fasterxml/woodstox" "woodstox-core" "7.1.0"
download_dep "org/codehaus/woodstox" "stax2-api" "4.2.2"

echo "All dependencies present in $LIB_DIR"
