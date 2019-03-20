package net.scub.hubicc.batch.processor;

import net.scub.hubicc.batch.model.Laboratoire;
import net.scub.hubicc.batch.model.LaboratoireRDFOld;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemProcessor;

public class LaboratoireItemProcessor implements ItemProcessor<Laboratoire, LaboratoireRDFOld> {
    @Override
    public LaboratoireRDFOld process(Laboratoire item) throws Exception {
        if(StringUtils.isEmpty(item.getUniversity())) {
            return null;
        }

        LaboratoireRDFOld laboratoireRDFOld = new LaboratoireRDFOld();
        laboratoireRDFOld.setStructureSuperieur(item.getUniversity());
        return laboratoireRDFOld;
    }
}
