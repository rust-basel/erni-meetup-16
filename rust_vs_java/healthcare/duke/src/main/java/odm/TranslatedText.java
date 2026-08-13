package odm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TranslatedText {

    @JacksonXmlProperty(localName = "xml:lang", isAttribute = true)
    public String lang;

    @JacksonXmlText
    public String text;
}
