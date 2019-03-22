package net.scub.hubicc.batch;

import net.scub.hubicc.batch.controller.RDFBiblio;
import net.scub.hubicc.batch.controller.RDFFormation;
import net.scub.hubicc.batch.controller.RDFLabs;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
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
        this.rdfLabs.export();
        this.rdfBiblio.export();
        this.rdfFormation.export();
    }
}
