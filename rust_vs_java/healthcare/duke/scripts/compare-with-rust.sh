#!/bin/sh
set -e

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
ROOT_DIR="$SCRIPT_DIR/.."
FERRIS_DIR="$ROOT_DIR/../ferris"
OUT_DIR="$ROOT_DIR/target"

mkdir -p "$OUT_DIR"

echo "== Building Java =="
"$ROOT_DIR/scripts/build.sh"

echo "== Exporting Java JSON =="
java -cp "$OUT_DIR/classes:$(echo "$ROOT_DIR"/lib/*.jar | tr ' ' ':')" bench.OdmExportJson

echo "== Exporting Rust JSON =="
cd "$FERRIS_DIR"
mise exec -- cargo run --example export_json

echo "== Comparing semantic summaries =="
cd "$ROOT_DIR"
python3 "$ROOT_DIR/scripts/compare-summary.py" "$OUT_DIR/odm_java.json" "$FERRIS_DIR/target/odm_quick_xml.json"

echo ""
echo "== Raw JSON diff (keys differ because Rust preserves XML names, Java uses field names) =="
cd "$OUT_DIR"
if command -v jq >/dev/null 2>&1; then
    jq -S . odm_java.json > odm_java.norm.json
    jq -S . "$FERRIS_DIR/target/odm_quick_xml.json" > odm_quick_xml.norm.json
    jq -S . "$FERRIS_DIR/target/odm_serde_xml_rs.json" > odm_serde_xml_rs.norm.json
    diff -u odm_quick_xml.norm.json odm_java.norm.json > comparison.diff || true
    diff -u odm_serde_xml_rs.norm.json odm_quick_xml.norm.json > serde_vs_quick.diff || true
    echo "Normalized JSON files written to target/*.norm.json and diffs to target/*.diff"
else
    echo "jq not installed; skipping normalized JSON diff"
fi
