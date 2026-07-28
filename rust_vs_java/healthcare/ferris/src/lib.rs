pub mod odm;

pub fn add(left: u64, right: u64) -> u64 {
    left + right
}

#[cfg(test)]
mod tests {
    use super::*;
    const SAMPLE: &str = include_str!("./../test_files/xml/test.xml");

    #[test]
    fn deserialize() {
        let sample: odm::Odm = serde_xml_rs::from_str(SAMPLE).unwrap();
        assert_eq!(sample.odm_version, Some("1.3.2".to_string()));
    }
}
