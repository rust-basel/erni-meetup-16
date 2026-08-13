#!/usr/bin/env python3
"""Generate scaled-up benchmark XML files by duplicating the <Study> block."""

import argparse
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
FERRIS_DIR = ROOT / "ferris" / "test_files" / "xml"
DUKE_DIR = ROOT / "duke" / "src" / "main" / "resources"
BASE_NAME = "test_small.xml"


def build(base: Path, copies: int) -> str:
    content = base.read_text(encoding="utf-8")
    start = re.search(r"<Study\b", content)
    end = re.search(r"</Study>\s*", content, re.S)
    if not start or not end:
        raise SystemExit(f"Could not locate <Study>...</Study> in {base}")

    header = content[: start.start()]
    study = content[start.start() : end.end()]
    footer = content[end.end() :]
    return header + "\n".join([study] * copies) + "\n" + footer


def main() -> None:
    parser = argparse.ArgumentParser(
        description="Duplicate the <Study> block to scale the benchmark XML."
    )
    parser.add_argument(
        "--copies",
        type=int,
        default=8,
        help="Number of times to duplicate the <Study> block (default: 8).",
    )
    parser.add_argument(
        "--name",
        default="test",
        help="Output base name, e.g. 'test' -> 'test.xml' (default: test).",
    )
    args = parser.parse_args()

    base = FERRIS_DIR / BASE_NAME
    if not base.exists():
        raise SystemExit(f"Base file not found: {base}")

    large = build(base, args.copies)
    ferris_out = FERRIS_DIR / f"{args.name}.xml"
    duke_out = DUKE_DIR / f"{args.name}.xml"

    ferris_out.write_text(large, encoding="utf-8")
    duke_out.write_text(large, encoding="utf-8")
    print(
        f"Generated {ferris_out} and {duke_out} "
        f"({len(large):,} bytes, {args.copies} Study copies)"
    )


if __name__ == "__main__":
    main()
