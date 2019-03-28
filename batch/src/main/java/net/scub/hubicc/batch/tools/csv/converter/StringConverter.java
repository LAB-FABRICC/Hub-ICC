package net.scub.hubicc.batch.tools.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;

public class StringConverter extends AbstractBeanField<String> {
    @Override
    protected Object convert(String value) {
        return Optional.ofNullable(value)
                .filter(StringUtils::isNoneEmpty)
                .map(String::trim)
                .filter(item -> !List.of("NC", "NON").contains(item))
                .orElse(null);
    }
}
