package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemGroupDef {

    @JacksonXmlProperty(localName = "OID", isAttribute = true)
    public String oid;

    @JacksonXmlProperty(localName = "Domain", isAttribute = true)
    public String domain;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    public String name;

    @JacksonXmlProperty(localName = "Repeating", isAttribute = true)
    public String repeating;

    @JacksonXmlProperty(localName = "Purpose", isAttribute = true)
    public String purpose;

    @JacksonXmlProperty(localName = "IsReferenceData", isAttribute = true)
    public String isReferenceData;

    @JacksonXmlProperty(localName = "SASDatasetName", isAttribute = true)
    public String sasDatasetName;

    @JacksonXmlProperty(localName = "def:Structure", isAttribute = true)
    public String structure;

    @JacksonXmlProperty(localName = "def:Class", isAttribute = true)
    public String clazz;

    @JacksonXmlProperty(localName = "def:ArchiveLocationID", isAttribute = true)
    public String archiveLocationId;

    @JacksonXmlProperty(localName = "Description")
    public Description description;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ItemRef")
    public List<ItemGroupItemRef> itemRefs;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "def:leaf")
    public List<Leaf> leaves;
}
