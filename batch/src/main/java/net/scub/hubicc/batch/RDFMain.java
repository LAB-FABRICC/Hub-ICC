package net.scub.hubicc.batch;

import net.scub.hubicc.batch.services.RDFBiblio;
import net.scub.hubicc.batch.services.RDFFormation;
import net.scub.hubicc.batch.services.RDFLabs;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;

public class RDFMain {

  public static final main(String args...) {
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

    model.write(new FileWriter("generatedOwl/generated.rdf"));
  
  }
}
