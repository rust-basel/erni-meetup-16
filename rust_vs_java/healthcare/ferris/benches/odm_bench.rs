use criterion::{Criterion, black_box, criterion_group, criterion_main};
use ferris::odm::Odm;

fn benchmark_deserialize(c: &mut Criterion) {
    let xml_data = include_str!("../test_files/xml/test.xml");

    c.bench_function("deserialize_odm", |b| {
        b.iter(|| {
            let _: Odm = serde_xml_rs::from_str(black_box(xml_data)).unwrap();
        })
    });
}

fn benchmark_serialize(c: &mut Criterion) {
    let xml_data = include_str!("../test_files/xml/test.xml");
    let odm: Odm = serde_xml_rs::from_str(xml_data).unwrap();

    c.bench_function("serialize_odm", |b| {
        b.iter(|| {
            let _ = serde_xml_rs::to_string(&black_box(&odm)).unwrap();
        })
    });
}

fn benchmark_deserialize_and_serialize(c: &mut Criterion) {
    let xml_data = include_str!("../test_files/xml/test.xml");

    c.bench_function("deserialize_then_serialize", |b| {
        b.iter(|| {
            let odm: Odm = serde_xml_rs::from_str(black_box(xml_data)).unwrap();
            let _ = serde_xml_rs::to_string(&black_box(odm)).unwrap();
        })
    });
}

criterion_group!(
    benches,
    benchmark_deserialize,
    benchmark_serialize,
    benchmark_deserialize_and_serialize
);

criterion_main!(benches);
