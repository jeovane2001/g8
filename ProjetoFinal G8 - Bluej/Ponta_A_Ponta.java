import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
//import org.junit.Test;
import static org.junit.Assert.*;
// tetando criar teste de PonmtaPonta
public class Ponta_A_Ponta
{
    //criar objeto de teste.
    String Resultado;
    String Referecia;;
    public Ponta_A_Ponta()
    {
        
        String databasePath = System.getProperty("user.dir") + "/pacientes.db";
        PacienteRepository pacienteRepository;
        ValoresReferencia valoresReferencia;
        Database db = new Database(databasePath);
        valoresReferencia = new ValoresReferencia();
       // pacienteRepository.create(db);
        Paciente paciente = new Paciente("Jeovane", 23,  'm');
        TextArea resultArea = new TextArea();
        Hemograma hemograma = new Hemograma();
         
            hemograma.adicionarValor("Hemoglobina", 15.8);
            hemograma.adicionarValor("Hematócrito", 49);
            hemograma.adicionarValor("Volume Celular Médio", 92);
            hemograma.adicionarValor("Hemoglobina Celular Média", 29);
            hemograma.adicionarValor("Concentração de Hemoglobina Celular", 35);
            hemograma.adicionarValor("Contagem de Glóbulos Vermelhos", 5.5);
            hemograma.adicionarValor("Amplitude de Distribuição dos Eritrócitos", 8);
            hemograma.adicionarValor("Contagem de Glóbulos Brancos", 8000);
            hemograma.adicionarValor("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Bastonetes", 720);
            hemograma.adicionarValor("Contagem Diferencial de Glóbulos Brancos - Neutrófilos Segmentados", 7900);
            hemograma.adicionarValor("Contagem Diferencial de Glóbulos Brancos - Linfócitos", 3500);
            hemograma.adicionarValor("Contagem Diferencial de Glóbulos Brancos - Monócitos", 756);
            hemograma.adicionarValor("Contagem Diferencial de Glóbulos Brancos - Eosinófilos", 475);
            hemograma.adicionarValor("Contagem Diferencial de Glóbulos Brancos - Basófilos", 156);
            hemograma.adicionarValor("Contagem de Plaquetas", 8000);
            // Comparação com os valores de referência 
               StringBuilder resultados = new StringBuilder();
                    Map<String, FaixaValores> valoresReferenciaUsuario = valoresReferencia.obterValores("Masculino Adulto (18 a 59 anos)");
                    if (valoresReferenciaUsuario == null) {
                        resultArea.setText("Erro: Categoria de referência não encontrada.");
                        return;
                    }
                    for (String parametro : hemograma.valores.keySet()) {
                        double valor = hemograma.obterValor(parametro);
                        FaixaValores faixaValores = valoresReferenciaUsuario.get(parametro);
                        if (faixaValores == null) {
                            resultados.append(parametro).append(": Valor de referência não encontrado.\n");
                        }  if (valor < faixaValores.getMin() ) {
                            resultados.append(parametro).append(" está abaixo do valor de referência: ").append(valor).append(" ")
                                .append(faixaValores.getUnidade()).append(" (Valor de referência: ")
                                .append(faixaValores.getMin()).append(" - ").append(faixaValores.getMax()).append(" ")
                                .append(faixaValores.getUnidade()).append(")\n");
                        } else if ( valor > faixaValores.getMax()) {
                            resultados.append(parametro).append(" acima do valor de referência: ").append(valor).append(" ")
                                .append(faixaValores.getUnidade()).append(" (Valor de referência: ")
                                .append(faixaValores.getMin()).append(" - ").append(faixaValores.getMax()).append(" ")
                                .append(faixaValores.getUnidade()).append(")\n");
                        }
                    }
                    
                    // Salvando os resultados no paciente
                    paciente.getResultados();

                    Resultado = ("Resultados armazenados:\n" + paciente.getResultados());
                    this.Resultado = Resultado;
                    
    }

    //  valor referência 
    //String Referecia;
    public void ResultadoReferexia( String Referencia){
        this.Referecia = Referencia; 
    }
    public String VerResultadoReferexia(String Referecia ){
     
     return Referecia;
    }
    public String VerResultado( ){
     
     return Resultado;
    }
     // Assertiva
      //  asserTrue(Referencia, resultados); // Verifica se o resultado
    
}
