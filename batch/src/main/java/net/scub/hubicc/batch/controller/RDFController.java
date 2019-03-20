package net.scub.hubicc.batch.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.scub.hubicc.batch.model.Laboratoire;
import net.scub.hubicc.batch.tools.csv.CsvBuilder;
import net.scub.hubicc.batch.tools.thymeleaf.ThymeleafBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/rdf")
public class RDFController {

    private final ThymeleafBuilder thymeleafBuilder;

    private final ObjectMapper objectMapper;

    /**
     * Constructor.
     *
     * @param thymeleafBuilder thymeleafBuilder
     */
    public RDFController(ThymeleafBuilder thymeleafBuilder) {
        this.thymeleafBuilder = thymeleafBuilder;
        this.objectMapper = new ObjectMapper();
    }


    @GetMapping("/labs")
    public ResponseEntity<String> laboratory() throws IOException {
        final String csvFilePath = "files/INSECT-Répertoire des Laboratoires ICC.csv";
        final int csvLineToSkip = 4;
        final String templateName = "laboratoire";
        final String parentTemplateName = "laboratoires_rdf";
        final String finalTemplate = generateRdf(Laboratoire.class, csvFilePath, csvLineToSkip, templateName, parentTemplateName);

        return ResponseEntity.ok(finalTemplate);
    }

    /**
     * Generate rdf.
     * @param csvClazz cvs class
     * @param csvFilePath csv file path
     * @param csvLineToSkip csv line to skip
     * @param templateName thymeleaf template
     * @param parentTemplateName parent thymeleaf template
     * @param <T> object with csv annotation
     * @return string
     * @throws IOException
     */
    private <T> String generateRdf(final Class<T> csvClazz, final String csvFilePath, final int csvLineToSkip, final String templateName, final String parentTemplateName) throws IOException {

        final List<String> templates = CsvBuilder
                .readCsvFile(csvFilePath, csvLineToSkip, csvClazz)
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
