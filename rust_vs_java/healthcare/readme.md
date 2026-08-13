# Healthcare ODM Benchmark – Rust vs. Java

I took the example from the **defineR** R package: https://github.com/dbosak01/defineR.

* `ferris/` – Rust implementation
  * `serde-xml-rs` baseline
  * `quick-xml` faster alternative
  * Benchmarks with Criterion
* `duke/` – Java implementation
  * Jackson XML
  * Benchmarks with JMH
  * Cross-language comparison tools

## Benchmark inputs

Three input sizes are available, all generated from the same original define.xml by duplicating the `<Study>` block:

| File | Size | Study copies | Notes |
| ---- | ---- | ------------ | ----- |
| `test_small.xml` | ~128 KB | 1 | Original file, kept for reference. |
| `test.xml` | ~1 MB | 8 | Default benchmark input. |
| `test_10mb.xml` | ~10 MB | 80 | Large-file stress test. |

`scripts/expand_test_xml.py` regenerates the scaled files from `test_small.xml`:

```bash
# default: generate 1 MB test.xml
python3 scripts/expand_test_xml.py

# generate the 10 MB file
python3 scripts/expand_test_xml.py --copies 80 --name test_10mb
```

## 1 MB benchmark numbers

Measured with Criterion on the `bench` profile (release-optimized), 5 s warmup and 10 s measurement time, and JMH with 3 warmup / 3 measurement iterations of 5 s / 10 s:

| Operation                | Rust (serde-xml-rs) | Rust (quick-xml) | Java (Jackson XML) |
| ------------------------ | ------------------- | ---------------- | ------------------ |
| Deserialize              | ~27.0 ms/op         | ~4.72 ms/op      | ~3.63 ms/op        |
| Serialize                | ~2.98 ms/op         | ~2.52 ms/op      | ~1.68 ms/op        |
| Deserialize + Serialize  | ~30.3 ms/op         | ~7.18 ms/op      | ~5.62 ms/op        |

Switching the Rust implementation from `serde-xml-rs` to `quick-xml` makes deserialization about **5.7× faster** on this larger file, and the `quick-xml` implementation is within the same ballpark as the Java/Jackson parser.

## 10 MB benchmark numbers

Measured with Criterion on the `bench` profile, 5 s warmup and 30 s measurement time (50 samples), and JMH with 3 warmup / 3 measurement iterations of 5 s / 10 s:

| Operation                | Rust (serde-xml-rs) | Rust (quick-xml) | Java (Jackson XML) |
| ------------------------ | ------------------- | ---------------- | ------------------ |
| Deserialize              | ~260 ms/op          | ~47.5 ms/op      | ~37.2 ms/op        |
| Serialize                | ~34.4 ms/op         | ~27.9 ms/op      | ~28.4 ms/op        |
| Deserialize + Serialize  | ~298 ms/op          | ~73.0 ms/op      | ~61.5 ms/op        |

At 10 MB the advantage of `quick-xml` over `serde-xml-rs` is still large (~5.5× on deserialization), while Java/Jackson remains the fastest overall on this workload.

## Running the Rust benchmarks

1 MB run:

```bash
cd ferris
mise run bench
```

10 MB run:

```bash
cd ferris
mise run bench-10mb
```

## Running the Java benchmarks

1 MB run:

```bash
cd duke
mise trust .
mise run bench
```

10 MB run:

```bash
cd duke
mise run bench-10mb
```

## Proving Java and Rust parse the same model

From the Java directory:

```bash
cd duke
mise run compare
```

### Note on `serde-xml-rs`

`serde-xml-rs` does **not** correctly extract text content from `<TranslatedText>` elements in this file (it returns `null`), whereas `quick-xml` and the Java/Jackson parser both return the actual text. Therefore the cross-language proof is made against the `quick-xml` Rust output.
