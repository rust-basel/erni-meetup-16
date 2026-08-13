use criterion::{Criterion, black_box, criterion_group, criterion_main};
use ferris::odm::Odm;

fn benchmark_deserialize(c: &mut Criterion) {
    let xml_data = include_str!("../test_files/xml/test.xml");

    c.bench_function("deserialize_odm_serde_xml_rs", |b| {
        b.iter(|| {
            let _: Odm = serde_xml_rs::from_str(black_box(xml_data)).unwrap();
        })
    });

    c.bench_function("deserialize_odm_quick_xml", |b| {
        b.iter(|| {
            let _: Odm = quick_xml::de::from_str(black_box(xml_data)).unwrap();
        })
    });
}

fn benchmark_serialize(c: &mut Criterion) {
    let xml_data = include_str!("../test_files/xml/test.xml");
    let odm_serde: Odm = serde_xml_rs::from_str(xml_data).unwrap();
    let odm_quick: Odm = quick_xml::de::from_str(xml_data).unwrap();

    c.bench_function("serialize_odm_serde_xml_rs", |b| {
        b.iter(|| {
            let _ = serde_xml_rs::to_string(&black_box(&odm_serde)).unwrap();
        })
    });

    c.bench_function("serialize_odm_quick_xml", |b| {
        b.iter(|| {
            let _ = quick_xml::se::to_string(&black_box(&odm_quick)).unwrap();
        })
    });
}

fn benchmark_deserialize_and_serialize(c: &mut Criterion) {
    let xml_data = include_str!("../test_files/xml/test.xml");

    c.bench_function("deserialize_then_serialize_serde_xml_rs", |b| {
        b.iter(|| {
            let odm: Odm = serde_xml_rs::from_str(black_box(xml_data)).unwrap();
            let _ = serde_xml_rs::to_string(&black_box(odm)).unwrap();
        })
    });

    c.bench_function("deserialize_then_serialize_quick_xml", |b| {
        b.iter(|| {
            let odm: Odm = quick_xml::de::from_str(black_box(xml_data)).unwrap();
            let _ = quick_xml::se::to_string(&black_box(odm)).unwrap();
        })
    });
}

fn benchmark_deserialize_10mb(c: &mut Criterion) {
    let xml_data = include_str!("../test_files/xml/test_10mb.xml");

    c.bench_function("deserialize_odm_10mb_serde_xml_rs", |b| {
        b.iter(|| {
            let _: Odm = serde_xml_rs::from_str(black_box(xml_data)).unwrap();
        })
    });

    c.bench_function("deserialize_odm_10mb_quick_xml", |b| {
        b.iter(|| {
            let _: Odm = quick_xml::de::from_str(black_box(xml_data)).unwrap();
        })
    });
}

fn benchmark_serialize_10mb(c: &mut Criterion) {
    let xml_data = include_str!("../test_files/xml/test_10mb.xml");
    let odm_serde: Odm = serde_xml_rs::from_str(xml_data).unwrap();
    let odm_quick: Odm = quick_xml::de::from_str(xml_data).unwrap();

    c.bench_function("serialize_odm_10mb_serde_xml_rs", |b| {
        b.iter(|| {
            let _ = serde_xml_rs::to_string(&black_box(&odm_serde)).unwrap();
        })
    });

    c.bench_function("serialize_odm_10mb_quick_xml", |b| {
        b.iter(|| {
            let _ = quick_xml::se::to_string(&black_box(&odm_quick)).unwrap();
        })
    });
}

fn benchmark_deserialize_and_serialize_10mb(c: &mut Criterion) {
    let xml_data = include_str!("../test_files/xml/test_10mb.xml");

    c.bench_function("deserialize_then_serialize_10mb_serde_xml_rs", |b| {
        b.iter(|| {
            let odm: Odm = serde_xml_rs::from_str(black_box(xml_data)).unwrap();
            let _ = serde_xml_rs::to_string(&black_box(odm)).unwrap();
        })
    });

    c.bench_function("deserialize_then_serialize_10mb_quick_xml", |b| {
        b.iter(|| {
            let odm: Odm = quick_xml::de::from_str(black_box(xml_data)).unwrap();
            let _ = quick_xml::se::to_string(&black_box(odm)).unwrap();
        })
    });
}

criterion_group!(
    benches,
    benchmark_deserialize,
    benchmark_serialize,
    benchmark_deserialize_and_serialize,
    benchmark_deserialize_10mb,
    benchmark_serialize_10mb,
    benchmark_deserialize_and_serialize_10mb
);

criterion_main!(benches);
