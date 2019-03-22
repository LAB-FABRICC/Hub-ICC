package net.scub.hubicc.batch.tools.csv;

import com.opencsv.bean.AbstractBeanField;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class IntegerConverter extends AbstractBeanField<Integer> {
    @Override
    protected Object convert(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        value = value.trim();

        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {

            System.out.println("unsupported number : " + value);
            return null;
        }

    }
}
