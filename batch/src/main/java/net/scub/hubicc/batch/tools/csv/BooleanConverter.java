package net.scub.hubicc.batch.tools.csv;

import com.opencsv.bean.AbstractBeanField;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class BooleanConverter extends AbstractBeanField<Boolean> {
    @Override
    protected Object convert(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        value = value.trim();

        final List<String> trueBooleans = List.of("OUI");
        final List<String> falseBooleans = List.of("NON");

        if (trueBooleans.contains(value)) {
            return true;
        } else if (falseBooleans.contains(value)) {
            return false;
        } else {
            System.out.println("not managed boolean value " + value);
            return null;
        }
    }
}
