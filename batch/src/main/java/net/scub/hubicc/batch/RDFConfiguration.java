package net.scub.hubicc.batch;

import net.scub.hubicc.batch.services.RDFBiblio;
import net.scub.hubicc.batch.services.RDFFormation;
import net.scub.hubicc.batch.services.RDFLabs;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileWriter;
import java.io.IOException;

@Configuration
public class RDFConfiguration {

    private final RDFBiblio rdfBiblio;
    private final RDFLabs rdfLabs;
    private final RDFFormation rdfFormation;

    public RDFConfiguration(RDFBiblio rdfBiblio, RDFLabs rdfLabs, RDFFormation rdfFormation) {
        this.rdfBiblio = rdfBiblio;
        this.rdfLabs = rdfLabs;
        this.rdfFormation = rdfFormation;
    }

    @PostConstruct
    public void exports() throws IOException {
        var model = ModelFactory.createDefaultModel();


        final Resource resourceBiblio = model.createResource(this.rdfBiblio.getICCNamespace() + "ontology/biblio");

        final Resource resourceLabs = model.createResource(this.rdfLabs.getICCNamespace() + "ontology/labs");

        final Resource resourceFormation = model.createResource(this.rdfFormation.getICCNamespace() + "ontology/formation");


        this.rdfLabs.export(model, resourceLabs);
        this.rdfBiblio.export(model, resourceBiblio);
        this.rdfFormation.export(model, resourceFormation);

        model.write(new FileWriter("generatedOwl/generated.rdf"));
    }
}
