package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Origin {

    @JacksonXmlProperty(localName = "Type", isAttribute = true)
    public String originType;

    @JacksonXmlProperty(localName = "def:DocumentRef")
    public DocumentRef documentRef;

    @JacksonXmlProperty(localName = "def:PDFPageRef")
    public PdfPageRef pdfPageRef;
}
