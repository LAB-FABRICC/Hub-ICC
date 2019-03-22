package net.scub.hubicc.batch;

import net.scub.hubicc.batch.controller.RDFBiblio;
import net.scub.hubicc.batch.controller.RDFLabs;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
public class RDFConfiguration {

    private final RDFBiblio rdfBiblio;
    private final RDFLabs rdfLabs;

    public RDFConfiguration(RDFBiblio rdfBiblio, RDFLabs rdfLabs) {
        this.rdfBiblio = rdfBiblio;
        this.rdfLabs = rdfLabs;
    }

    @PostConstruct
    public void exports() throws IOException {
        this.rdfLabs.export();
        this.rdfBiblio.export();
    }
}
