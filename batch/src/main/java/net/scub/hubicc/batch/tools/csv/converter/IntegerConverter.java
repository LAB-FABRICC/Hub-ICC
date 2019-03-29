package net.scub.hubicc.batch.tools.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class IntegerConverter extends AbstractBeanField<Integer> {
    @Override
    protected Object convert(String value) {
        return Optional.ofNullable(value)
                .filter(StringUtils::isNoneEmpty)
                .map(String::trim)
                .map(item -> {
                    try {
                        return Integer.valueOf(item);
                    } catch (NumberFormatException e) {
                        System.out.println("unsupported number : " + item);
                        return null;
                    }
                })
                .orElse(null);
    }
}
