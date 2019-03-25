package net.scub.hubicc.batch.tools.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DateDayMonthConverter extends AbstractBeanField<Date> {

    @Override
    protected Object convert(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        value = value.trim().toLowerCase();

        try {
            return new SimpleDateFormat("dd MMMM").parse(value);
        } catch (ParseException e) {
            System.out.println("unsupported date with pattern dd MMMM : " + value);
        }

        return null;
    }
}
