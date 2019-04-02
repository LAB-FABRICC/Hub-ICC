package net.scub.hubicc.batch.tools.csv;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

/**
 * Csv builder.
 */
public final class CsvBuilder {

    /**
     * Default constructor.
     */
    private CsvBuilder() {

    }

    /**
     * Read csv file.
     *
     * @param path resource path
     * @param <T>  object
     * @return an object list
     * @throws IOException exception
     */
    public static <T> List<T> readCsvFile(final String path, final Optional<Character> maybeDelimiter, final int lineToSkip, Class<T> clazz) throws IOException {
        final var classPathResource = new ClassPathResource(path);
        final var reader = Files.newBufferedReader(Paths.get(classPathResource.getURI()));
        return new CsvToBeanBuilder(reader)
                .withType(clazz)
                .withSkipLines(lineToSkip)
                .withSeparator(maybeDelimiter.orElse(';'))
                .withQuoteChar('"')
                .withIgnoreLeadingWhiteSpace(true)
                .build().parse();
    }
}
