#!/bin/sh
set -e

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
ROOT_DIR="$SCRIPT_DIR/.."
OUT_DIR="$ROOT_DIR/target/classes"
LIB_DIR="$ROOT_DIR/lib"

# Build first
"$SCRIPT_DIR/build.sh"

CP="$OUT_DIR"
for jar in "$LIB_DIR"/*.jar; do
    CP="$CP:$jar"
done

echo "Running JMH benchmarks ..."
java -cp "$CP" org.openjdk.jmh.Main "$@"
