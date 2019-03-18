package net.scub.hubicc.batch.processor;

import net.scub.hubicc.batch.model.Laboratoire;
import net.scub.hubicc.batch.model.LaboratoireRDF;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemProcessor;

import java.net.URI;

public class LaboratoireItemProcessor implements ItemProcessor<Laboratoire, LaboratoireRDF> {
    @Override
    public LaboratoireRDF process(Laboratoire item) throws Exception {
        if(StringUtils.isEmpty(item.getUniversity())) {
            return null;
        }

        LaboratoireRDF laboratoireRDF = new LaboratoireRDF();
        laboratoireRDF.setStructureSuperieur(item.getUniversity());
        return laboratoireRDF;
    }
}
