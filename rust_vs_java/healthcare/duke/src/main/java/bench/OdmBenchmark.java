package bench;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import odm.Odm;
import odm.OdmMapper;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 0)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 3, time = 1)
public class OdmBenchmark {

    private XmlMapper mapper;
    private String xmlData;
    private Odm odm;

    @Setup
    public void setup() throws IOException {
        mapper = OdmMapper.create();
        try (var stream = getClass().getClassLoader().getResourceAsStream("test.xml")) {
            if (stream == null) {
                throw new IllegalStateException("test.xml not found on classpath");
            }
            xmlData = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        }
        odm = mapper.readValue(xmlData, Odm.class);
    }

    @Benchmark
    public Odm benchmarkDeserialize() throws IOException {
        return mapper.readValue(xmlData, Odm.class);
    }

    @Benchmark
    public String benchmarkSerialize() throws IOException {
        return mapper.writeValueAsString(odm);
    }

    @Benchmark
    public String benchmarkDeserializeAndSerialize() throws IOException {
        Odm parsed = mapper.readValue(xmlData, Odm.class);
        return mapper.writeValueAsString(parsed);
    }
}
