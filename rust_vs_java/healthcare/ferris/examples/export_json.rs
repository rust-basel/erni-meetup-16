use ferris::odm::Odm;
use std::fs;

fn main() {
    let xml = include_str!("../test_files/xml/test.xml");

    let odm_serde: Odm = serde_xml_rs::from_str(xml).unwrap();
    fs::write("target/odm_serde_xml_rs.json", serde_json::to_string_pretty(&odm_serde).unwrap()).unwrap();

    let odm_quick: Odm = quick_xml::de::from_str(xml).unwrap();
    fs::write("target/odm_quick_xml.json", serde_json::to_string_pretty(&odm_quick).unwrap()).unwrap();

    println!("Exported target/odm_serde_xml_rs.json");
    println!("Exported target/odm_quick_xml.json");
}
