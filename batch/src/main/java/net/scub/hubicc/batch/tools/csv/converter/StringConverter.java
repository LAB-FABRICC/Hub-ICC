package net.scub.hubicc.batch.tools.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class StringConverter extends AbstractBeanField<String> {
    @Override
    protected Object convert(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        value = value.trim();

        final List<String> stringExcluded = List.of("NC", "NON");

        if (stringExcluded.contains(value)) {
            return null;
        }

        return value;
    }
}
