package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaDataVersion {

    @JacksonXmlProperty(localName = "OID", isAttribute = true)
    public String oid;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    public String name;

    @JacksonXmlProperty(localName = "Description", isAttribute = true)
    public String description;

    @JacksonXmlProperty(localName = "def:DefineVersion", isAttribute = true)
    public String defineVersion;

    @JacksonXmlProperty(localName = "def:StandardName", isAttribute = true)
    public String standardName;

    @JacksonXmlProperty(localName = "def:StandardVersion", isAttribute = true)
    public String standardVersion;

    @JacksonXmlProperty(localName = "def:AnnotatedCRF")
    public AnnotatedCrf annotatedCrf;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "def:SupplementalDoc")
    public List<SupplementalDoc> supplementalDocs;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "def:ValueListDef")
    public List<ValueListDef> valueListDefs;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "def:WhereClauseDef")
    public List<WhereClauseDef> whereClauseDefs;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ItemGroupDef")
    public List<ItemGroupDef> itemGroupDefs;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ItemDef")
    public List<ItemDef> itemDefs;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "CodeList")
    public List<CodeList> codeLists;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "MethodDef")
    public List<MethodDef> methodDefs;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "def:CommentDef")
    public List<CommentDef> commentDefs;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "def:leaf")
    public List<Leaf> leaves;
}
