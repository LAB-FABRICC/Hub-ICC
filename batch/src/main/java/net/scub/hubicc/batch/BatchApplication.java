package net.scub.hubicc.batch;

import net.scub.hubicc.batch.services.RDFBiblio;
import net.scub.hubicc.batch.services.RDFFormation;
import net.scub.hubicc.batch.services.RDFLabs;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;

@SpringBootApplication
public class BatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        var model = ModelFactory.createDefaultModel();

        var rdfLabs = new RDFLabs();
        var rdfBiblio = new RDFBiblio();
        var rdfFormation = new RDFFormation();

        final Resource resourceBiblio = model.createResource(rdfBiblio.getICCNamespace() + "ontology/biblio");
        final Resource resourceLabs = model.createResource(rdfLabs.getICCNamespace() + "ontology/labs");
        final Resource resourceFormation = model.createResource(rdfFormation.getICCNamespace() + "ontology/formation");

        rdfLabs.export(model, resourceLabs);
        rdfBiblio.export(model, resourceBiblio);
        rdfFormation.export(model, resourceFormation);

        model.write(new FileWriter("target/generated.rdf"));
    }
}
