package net.scub.hubicc.batch;

import net.scub.hubicc.batch.services.RDFBiblio;
import net.scub.hubicc.batch.services.RDFFormation;
import net.scub.hubicc.batch.services.RDFLabs;
import net.scub.hubicc.batch.tools.thymeleaf.ThymeleafBuilder;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;

@SpringBootApplication
public class BatchApplication implements CommandLineRunner {

    private final RDFLabs rdfLabs;

    private final RDFFormation rdfFormation;

    private final RDFBiblio rdfBiblio;

    public BatchApplication(RDFLabs rdfLabs, RDFFormation rdfFormation, RDFBiblio rdfBiblio) {
        this.rdfLabs = rdfLabs;
        this.rdfFormation = rdfFormation;
        this.rdfBiblio = rdfBiblio;
    }

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final var model = ModelFactory.createDefaultModel();

        final var nsBiblio = rdfBiblio.getICCNamespace() + "biblio";
        final var nsLabs = rdfLabs.getICCNamespace() + "labs";
        final var nsFormation = rdfFormation.getICCNamespace() + "formation";

        final var resourceBiblio = model.createResource(nsBiblio);
        final var resourceLabs = model.createResource(nsLabs);
        final var resourceFormation = model.createResource(nsFormation);

        rdfLabs.export(model, resourceLabs);
        rdfBiblio.export(model, resourceBiblio);
        rdfFormation.export(model, resourceFormation);

        final var generatedFileName = "target/generated";

        model.write(new FileWriter(generatedFileName + ".rdf"));
        model.write(new FileWriter(generatedFileName + ".ttl"), "TURTLE");
        model.write(new FileWriter(generatedFileName + ".n3"), "N3");


    }
}
