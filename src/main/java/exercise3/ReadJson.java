package exercise3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadJson {

    private final String dataJsonLocation;
    private BillingDay[] billingDays;

    public ReadJson() {

        // Pega a localização relativa onde o software está sendo executado.
        var pathProgramLocation = System.getProperty("user.dir");

        // Pega a localização relativa do programa e concatena com a localização do arquivo json de dados.
        this.dataJsonLocation = pathProgramLocation + "/src/main/resources/dados.json";
    }

    public BillingDay[] readJsonBillingFile() {

        // Cria a classe que irá fazer o mapeamento do json para o objeto Java.
        ObjectMapper mapper = new ObjectMapper();

        // Bloco que trata a exceção caso ocorra um erro na abertura do arquivo.
        try {
            // Mapeia o arquivo json para a classe BillingDay.
            this.billingDays = mapper.readValue(new File(this.dataJsonLocation), BillingDay[].class);

        } catch (IOException exception) {
            System.out.println("Não foi possível abrir o arquivo");
        }

        return billingDays;

    }

    public BillingDay[] getBillingDays() {
        return billingDays;
    }

}
