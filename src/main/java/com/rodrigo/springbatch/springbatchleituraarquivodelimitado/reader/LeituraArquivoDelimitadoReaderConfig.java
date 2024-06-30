package com.rodrigo.springbatch.springbatchleituraarquivodelimitado.reader;

import com.rodrigo.springbatch.springbatchleituraarquivodelimitado.dominio.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraArquivoDelimitadoReaderConfig {

    @StepScope
    @Bean
    public FlatFileItemReader<Cliente> leituraArquivoDelimitadoReader(
            @Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes ) {

        return new FlatFileItemReaderBuilder<Cliente>()
                .name("leituraArquivoDelimitadorReader")
                .resource(arquivoClientes)
                .delimited()
                .names(new String [] {"nome", "sobrenome", "idade", "email"})
                .targetType(Cliente.class) // tipo de Objeto que sera convertido o arquivo
                .build();
    }
}
