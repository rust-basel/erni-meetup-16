package bench;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import odm.Odm;
import odm.OdmMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class OdmExportJson {

    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = OdmMapper.create();
        String xmlData;
        try (var stream = OdmExportJson.class.getClassLoader().getResourceAsStream("test.xml")) {
            if (stream == null) {
                throw new IllegalStateException("test.xml not found on classpath");
            }
            xmlData = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        }

        Odm odm = xmlMapper.readValue(xmlData, Odm.class);

        ObjectMapper jsonMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);

        Path outDir = Path.of("target");
        Files.createDirectories(outDir);
        Path outFile = outDir.resolve("odm_java.json");
        jsonMapper.writeValue(outFile.toFile(), odm);

        System.out.println("Exported " + outFile);
    }
}
