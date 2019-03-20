package net.scub.hubicc.batch;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.scub.hubicc.batch.model.Laboratoire;
import net.scub.hubicc.batch.tools.csv.CsvBuilder;
import net.scub.hubicc.batch.tools.thymeleaf.ThymeleafBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BatchController {

    private final ThymeleafBuilder thymeleafBuilder;

    private final ObjectMapper objectMapper;

    /**
     * Constructor.
     *
     * @param thymeleafBuilder thymeleafBuilder
     */
    public BatchController(ThymeleafBuilder thymeleafBuilder) {
        this.thymeleafBuilder = thymeleafBuilder;
        this.objectMapper = new ObjectMapper();
    }


    @GetMapping("/export_lab")
    public ResponseEntity<String> laboratory() throws IOException {
        final String filePath = "files/INSECT-Répertoire des Laboratoires ICC.csv";
        final String templateName = "laboratoire";
        final String parentTemplateName = "laboratoires_rdf";

        final String finalTemplate = generateRdf(Laboratoire.class, filePath, templateName, parentTemplateName);

        return ResponseEntity.ok(finalTemplate);
    }

    private <T> String generateRdf(final Class<T> clazz, final String filePath, final String templateName, final String parentTemplateName) throws IOException {
        final List<String> templates = CsvBuilder
                .readCsvFile(filePath, 4, clazz)
                .stream()
                .map(item -> this.objectMapper.convertValue(item, Map.class))
                .peek(System.out::println)
                // TODO : add mapper for custom field
                .map(context -> thymeleafBuilder.buildTemplateWithParams(templateName, context))
                .collect(Collectors.toList());

        final HashMap<String, Object> params = new HashMap<>();
        params.put("contents", templates);

        return thymeleafBuilder.buildTemplateWithParams(parentTemplateName, params);
    }


}
