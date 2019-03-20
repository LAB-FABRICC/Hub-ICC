package net.scub.hubicc.batch.tools.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
     * @param <T>          object
     * @return an object list
     * @throws IOException exception
     */
    public static <T> List<T> readCsvFile(final String path, final int lineToSkip, Class<T> clazz) throws IOException {
        final ClassPathResource classPathResource = new ClassPathResource(path);

        final Reader reader = Files.newBufferedReader(Paths.get(classPathResource.getURI()));

        final CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                .withType(clazz)
                .withSkipLines(lineToSkip)
                .withSeparator(';')
                .withQuoteChar('"')
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return csvToBean.parse();
    }

    /**
     * Zip files.
     * @param zipName zip name
     * @param files files to zip (filename, file)
     * @return zip output stream
     * @throws IOException exception
     */
    public static File zipFiles(final String zipName, final ImmutablePair<String, File>... files) throws IOException {
        final String pathZipFolder = String.format("%s.zip", zipName);
        final File tmpZipFile = File.createTempFile("rdf-", pathZipFolder);
        final FileOutputStream zipWriter = new FileOutputStream(tmpZipFile);

        final ZipOutputStream zipOutputStream = new ZipOutputStream(zipWriter);

        for (ImmutablePair<String, File> file: files) {
            final int bytes = 1024;
            byte[] buf = new byte[bytes];
            int len;
            FileInputStream in = new FileInputStream(file.getValue().getAbsolutePath());
            zipOutputStream.putNextEntry(new ZipEntry(file.getKey()));
            while ((len = in.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, len);
            }
        }

        zipOutputStream.flush();
        zipOutputStream.close();

        return tmpZipFile;
    }

}
