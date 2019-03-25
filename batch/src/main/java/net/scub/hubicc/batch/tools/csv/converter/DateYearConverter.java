package net.scub.hubicc.batch.tools.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateYearConverter extends AbstractBeanField<Date> {

    @Override
    protected Object convert(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        value = value.trim().toLowerCase();

        try {
            return new SimpleDateFormat("YYYY").parse(value);
        } catch (ParseException e) {
            System.out.println("unsupported date with pattern YYYY : " + value);
        }

        return null;
    }
}
