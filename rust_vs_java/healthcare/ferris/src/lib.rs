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

#[cfg(test)]
mod quick_tests {
    use crate::odm::Odm;
    const SAMPLE: &str = include_str!("./../test_files/xml/test.xml");

    #[test]
    fn deserialize_quick_xml() {
        let sample: Odm = quick_xml::de::from_str(SAMPLE).unwrap();
        assert_eq!(sample.odm_version, Some("1.3.2".to_string()));
    }

    #[test]
    fn serialize_quick_xml() {
        let sample: Odm = quick_xml::de::from_str(SAMPLE).unwrap();
        let _ = quick_xml::se::to_string(&sample).unwrap();
    }
}
