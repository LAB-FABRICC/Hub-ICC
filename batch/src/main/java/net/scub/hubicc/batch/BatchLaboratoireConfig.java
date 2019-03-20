package net.scub.hubicc.batch;

import net.scub.hubicc.batch.model.Laboratoire;
import net.scub.hubicc.batch.model.LaboratoireRDFOld;
import net.scub.hubicc.batch.processor.LaboratoireItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class BatchLaboratoireConfig {
    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public FlatFileItemReader<Laboratoire> reader() {
        return new FlatFileItemReaderBuilder<Laboratoire>()
                .name("personItemReader")
                // TODO Rendre fichier paramétrable
                .resource(new ClassPathResource("files/INSECT-Répertoire des Laboratoires ICC.csv"))
                .linesToSkip(4) // TODO Adapter suivant les changements du CSV d'entrée
                .delimited()
                .delimiter(";")
                .names(Laboratoire.FIELDS)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Laboratoire.class);
                }})
                .build();
    }

    @Bean
    public LaboratoireItemProcessor processor() {
        return new LaboratoireItemProcessor();
    }

    @Bean
    public FlatFileItemWriter<LaboratoireRDFOld> writer() { // TODO replace with RDF writer
        return new FlatFileItemWriterBuilder<LaboratoireRDFOld>()
                .name("personItemWriter")
                .resource(new FileSystemResource("norme/0.1/laboratoire.csv")) // TODO Rendre fichier paramétrable
                .delimited()
                .delimiter(";")
                .names(LaboratoireRDFOld.FIELDS)
                .build();
    }

    @Bean
    public Job jobLaboratoire() {
        return jobs.get("jobLaboratoire")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return steps.get("step1")
                .<Laboratoire, LaboratoireRDFOld>chunk(10)
                .reader(reader())
                .processor(processor()) // TODO A voir si besoin
                .writer(writer())
                .build();
    }
}
