use serde::{Deserialize, Serialize};

#[allow(dead_code)]
// ========== ROOT & CORE ==========
#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "ODM")]
pub struct Odm {
    #[serde(rename = "@ODMVersion")]
    pub odm_version: Option<String>,
    #[serde(rename = "@FileOID")]
    pub file_oid: Option<String>,
    #[serde(rename = "@FileType")]
    pub file_type: Option<String>,
    #[serde(rename = "@CreationDateTime")]
    pub creation_date_time: Option<String>,
    #[serde(rename = "Study")]
    pub studies: Vec<Study>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "Study")]
pub struct Study {
    #[serde(rename = "@OID")]
    pub oid: Option<String>,
    #[serde(rename = "GlobalVariables")]
    pub global_variables: Option<GlobalVariables>,
    #[serde(rename = "MetaDataVersion")]
    pub meta_data_versions: Vec<MetaDataVersion>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "GlobalVariables")]
pub struct GlobalVariables {
    #[serde(rename = "StudyName")]
    pub study_name: Option<String>,
    #[serde(rename = "StudyDescription")]
    pub study_description: Option<String>,
    #[serde(rename = "ProtocolName")]
    pub protocol_name: Option<String>,
}

// ========== METADATA VERSION ==========
#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "MetaDataVersion")]
pub struct MetaDataVersion {
    #[serde(rename = "@OID")]
    pub oid: Option<String>,
    #[serde(rename = "@Name")]
    pub name: Option<String>,
    #[serde(rename = "@Description")]
    pub description: Option<String>,
    #[serde(rename = "@def:DefineVersion")]
    pub define_version: Option<String>,
    #[serde(rename = "@def:StandardName")]
    pub standard_name: Option<String>,
    #[serde(rename = "@def:StandardVersion")]
    pub standard_version: Option<String>,

    #[serde(rename = "def:AnnotatedCRF")]
    pub annotated_crf: Option<AnnotatedCrf>,
    #[serde(rename = "def:SupplementalDoc")]
    pub supplemental_docs: Vec<SupplementalDoc>,
    #[serde(rename = "def:ValueListDef")]
    pub value_list_defs: Vec<ValueListDef>,
    #[serde(rename = "def:WhereClauseDef")]
    pub where_clause_defs: Vec<WhereClauseDef>,
    #[serde(rename = "ItemGroupDef")]
    pub item_group_defs: Vec<ItemGroupDef>,
    #[serde(rename = "ItemDef")]
    pub item_defs: Vec<ItemDef>,
    #[serde(rename = "CodeList")]
    pub code_lists: Vec<CodeList>,
    #[serde(rename = "MethodDef")]
    pub method_defs: Vec<MethodDef>,
    #[serde(rename = "def:CommentDef")]
    pub comment_defs: Vec<CommentDef>,
    #[serde(rename = "def:leaf")]
    pub leaves: Vec<Leaf>,
}

// ========== VALUE LISTS & WHERE CLAUSES ==========
#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "def:AnnotatedCRF")]
pub struct AnnotatedCrf {
    #[serde(rename = "def:DocumentRef")]
    pub document_ref: Option<DocumentRef>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "def:SupplementalDoc")]
pub struct SupplementalDoc {
    #[serde(rename = "def:DocumentRef")]
    pub document_ref: Option<DocumentRef>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "def:DocumentRef")]
pub struct DocumentRef {
    #[serde(rename = "@leafID")]
    pub leaf_id: Option<String>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "def:ValueListDef")]
pub struct ValueListDef {
    #[serde(rename = "@OID")]
    pub oid: Option<String>,
    #[serde(rename = "ItemRef")]
    pub item_refs: Vec<ValueListItemRef>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "ItemRef")]
pub struct ValueListItemRef {
    #[serde(rename = "@ItemOID")]
    pub item_oid: Option<String>,
    #[serde(rename = "@OrderNumber")]
    pub order_number: Option<String>,
    #[serde(rename = "@Mandatory")]
    pub mandatory: Option<String>,
    #[serde(rename = "@MethodOID")]
    pub method_oid: Option<String>,
    #[serde(rename = "def:WhereClauseRef")]
    pub where_clause_ref: Option<WhereClauseRef>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "def:WhereClauseRef")]
pub struct WhereClauseRef {
    #[serde(rename = "@WhereClauseOID")]
    pub where_clause_oid: Option<String>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "def:WhereClauseDef")]
pub struct WhereClauseDef {
    #[serde(rename = "@OID")]
    pub oid: Option<String>,
    #[serde(rename = "RangeCheck")]
    pub range_checks: Vec<RangeCheck>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "RangeCheck")]
pub struct RangeCheck {
    #[serde(rename = "@SoftHard")]
    pub soft_hard: Option<String>,
    #[serde(rename = "@def:ItemOID")]
    pub item_oid: Option<String>,
    #[serde(rename = "@Comparator")]
    pub comparator: Option<String>,
    #[serde(rename = "CheckValue")]
    pub check_value: Option<String>,
}

// ========== ITEM GROUPS (Domains) ==========
#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "ItemGroupDef")]
pub struct ItemGroupDef {
    #[serde(rename = "@OID")]
    pub oid: Option<String>,
    #[serde(rename = "@Domain")]
    pub domain: Option<String>,
    #[serde(rename = "@Name")]
    pub name: Option<String>,
    #[serde(rename = "@Repeating")]
    pub repeating: Option<String>,
    #[serde(rename = "@Purpose")]
    pub purpose: Option<String>,
    #[serde(rename = "@IsReferenceData")]
    pub is_reference_data: Option<String>,
    #[serde(rename = "@SASDatasetName")]
    pub sas_dataset_name: Option<String>,
    #[serde(rename = "@def:Structure")]
    pub structure: Option<String>,
    #[serde(rename = "@def:Class")]
    pub class: Option<String>,
    #[serde(rename = "@def:ArchiveLocationID")]
    pub archive_location_id: Option<String>,
    #[serde(rename = "Description")]
    pub description: Option<Description>,
    #[serde(rename = "ItemRef")]
    pub item_refs: Vec<ItemGroupItemRef>,
    #[serde(rename = "def:leaf")]
    pub leaves: Vec<Leaf>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "Description")]
pub struct Description {
    #[serde(rename = "TranslatedText")]
    pub translated_text: Option<TranslatedText>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "TranslatedText")]
pub struct TranslatedText {
    #[serde(rename = "@xml:lang")]
    pub lang: Option<String>,
    #[serde(rename = "$text")]
    pub text: Option<String>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "ItemRef")]
pub struct ItemGroupItemRef {
    #[serde(rename = "@ItemOID")]
    pub item_oid: Option<String>,
    #[serde(rename = "@OrderNumber")]
    pub order_number: Option<String>,
    #[serde(rename = "@Mandatory")]
    pub mandatory: Option<String>,
    #[serde(rename = "@KeySequence")]
    pub key_sequence: Option<String>,
    #[serde(rename = "@Role")]
    pub role: Option<String>,
    #[serde(rename = "@RoleCodeListOID")]
    pub role_code_list_oid: Option<String>,
    #[serde(rename = "@MethodOID")]
    pub method_oid: Option<String>,
}

// ========== ITEM DEFINITIONS (Variables) ==========
#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "ItemDef")]
pub struct ItemDef {
    #[serde(rename = "@OID")]
    pub oid: Option<String>,
    #[serde(rename = "@Name")]
    pub name: Option<String>,
    #[serde(rename = "@SASFieldName")]
    pub sas_field_name: Option<String>,
    #[serde(rename = "@DataType")]
    pub data_type: Option<String>,
    #[serde(rename = "@Length")]
    pub length: Option<String>,
    #[serde(rename = "@def:DisplayFormat")]
    pub display_format: Option<String>,
    #[serde(rename = "@def:CommentOID")]
    pub comment_oid: Option<String>,
    #[serde(rename = "Description")]
    pub description: Option<Description>,
    #[serde(rename = "def:Origin")]
    pub origin: Option<Origin>,
    #[serde(rename = "CodeListRef")]
    pub code_list_ref: Option<CodeListRef>,
    #[serde(rename = "def:ValueListRef")]
    pub value_list_ref: Option<ValueListRef>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "def:Origin")]
pub struct Origin {
    #[serde(rename = "@Type")]
    pub origin_type: Option<String>,
    #[serde(rename = "def:DocumentRef")]
    pub document_ref: Option<DocumentRef>,
    #[serde(rename = "def:PDFPageRef")]
    pub pdf_page_ref: Option<PdfPageRef>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "def:PDFPageRef")]
pub struct PdfPageRef {
    #[serde(rename = "@PageRefs")]
    pub page_refs: Option<String>,
    #[serde(rename = "@Type")]
    pub page_ref_type: Option<String>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "CodeListRef")]
pub struct CodeListRef {
    #[serde(rename = "@CodeListOID")]
    pub code_list_oid: Option<String>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "def:ValueListRef")]
pub struct ValueListRef {
    #[serde(rename = "@ValueListOID")]
    pub value_list_oid: Option<String>,
}

// ========== CODE LISTS ==========
#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "CodeList")]
pub struct CodeList {
    #[serde(rename = "@OID")]
    pub oid: Option<String>,
    #[serde(rename = "@Name")]
    pub name: Option<String>,
    #[serde(rename = "@DataType")]
    pub data_type: Option<String>,
    #[serde(rename = "CodeListItem")]
    pub code_list_items: Option<Vec<CodeListItem>>,
    #[serde(rename = "ExternalCodeList")]
    pub external_code_list: Option<ExternalCodeList>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "CodeListItem")]
pub struct CodeListItem {
    #[serde(rename = "@CodedValue")]
    pub coded_value: Option<String>,
    #[serde(rename = "@Rank")]
    pub rank: Option<String>,
    #[serde(rename = "Decode")]
    pub decode: Option<Decode>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "Decode")]
pub struct Decode {
    #[serde(rename = "TranslatedText")]
    pub translated_text: Option<TranslatedText>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "ExternalCodeList")]
pub struct ExternalCodeList {
    #[serde(rename = "@Dictionary")]
    pub dictionary: Option<String>,
    #[serde(rename = "@Version")]
    pub version: Option<String>,
}

// ========== METHODS, COMMENTS, LEAVES ==========
#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "MethodDef")]
pub struct MethodDef {
    #[serde(rename = "@OID")]
    pub oid: Option<String>,
    #[serde(rename = "@Name")]
    pub name: Option<String>,
    #[serde(rename = "@Type")]
    pub method_type: Option<String>,
    #[serde(rename = "Description")]
    pub description: Option<Description>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "def:CommentDef")]
pub struct CommentDef {
    #[serde(rename = "@OID")]
    pub oid: Option<String>,
    #[serde(rename = "Description")]
    pub description: Option<Description>,
}

#[derive(Debug, Serialize, Deserialize, PartialEq)]
#[serde(rename = "def:leaf")]
pub struct Leaf {
    #[serde(rename = "@ID")]
    pub id: Option<String>,
    #[serde(rename = "@xlink:href")]
    pub href: Option<String>,
    #[serde(rename = "def:title")]
    pub title: Option<String>,
}
