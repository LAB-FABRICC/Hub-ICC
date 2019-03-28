package net.scub.hubicc.batch.tools.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;

public class BooleanConverter extends AbstractBeanField<Boolean> {
    @Override
    protected Object convert(String value) {
        return Optional.ofNullable(value)
                .filter(StringUtils::isNoneEmpty)
                .map(String::trim)
                .map(item -> {
                    final List<String> trueBooleans = List.of("OUI");
                    final List<String> falseBooleans = List.of("NON");

                    if (trueBooleans.contains(item)) {
                        return true;
                    } else if (falseBooleans.contains(item)) {
                        return false;
                    } else {
                        System.out.println("not managed boolean value : " + item);
                        return null;
                    }
                }).orElse(null);
    }
}
