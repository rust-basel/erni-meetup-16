#!/bin/sh
set -e

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
ROOT_DIR="$SCRIPT_DIR/.."
SRC_DIR="$ROOT_DIR/src/main/java"
RES_DIR="$ROOT_DIR/src/main/resources"
OUT_DIR="$ROOT_DIR/target/classes"
LIB_DIR="$ROOT_DIR/lib"

mkdir -p "$OUT_DIR"

# Ensure dependencies are present
if [ ! -f "$LIB_DIR/jmh-core-1.37.jar" ]; then
    echo "Dependencies missing, running download-deps.sh ..."
    "$SCRIPT_DIR/download-deps.sh"
fi

# Build classpath from all jars in lib/
CP=""
for jar in "$LIB_DIR"/*.jar; do
    if [ -z "$CP" ]; then
        CP="$jar"
    else
        CP="$CP:$jar"
    fi
done

# Find all Java source files
SOURCES="$(find "$SRC_DIR" -name '*.java')"
if [ -z "$SOURCES" ]; then
    echo "No Java sources found in $SRC_DIR"
    exit 1
fi

echo "Compiling Java sources ..."
javac -cp "$CP" -processorpath "$CP" \
    -d "$OUT_DIR" \
    $SOURCES

# Copy resources
cp -r "$RES_DIR/"* "$OUT_DIR/" 2>/dev/null || true

echo "Build complete. Output: $OUT_DIR"
