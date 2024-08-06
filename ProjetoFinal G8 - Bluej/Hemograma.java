
 
import java.util.HashMap;
import java.util.Map;

// Classe para representar um hemograma
class Hemograma {
    Map<String, Double> valores;

    public Hemograma() {
        this.valores = new HashMap<>();
    }
    // valores referencia do hemograma
    String parametro;
    double valor;
    // Adicionar um valor ao hemograma
    public void adicionarValor(String parametro, double valor) {
        this.valores.put(parametro, valor);
        this.parametro = parametro;
        this.valor = valor;
    }
    // checar parametro
    public String getParametro(){
       return parametro; 
    }
    // checar o valor do parametro
    public double getValor(){
       return valor; 
    }
    // Obter um valor do hemograma
    public double obterValor(String parametro) {
        return this.valores.get(parametro);
    }
}

//
