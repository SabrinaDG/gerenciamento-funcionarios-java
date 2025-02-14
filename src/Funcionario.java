import java.math.BigDecimal;

//2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).
public class Funcionario extends Pessoa {
        private BigDecimal salario;
        private String funcao;

        public BigDecimal getSalario(){
            return salario;
        }
        public void setSalario(BigDecimal salario){
            this.salario = salario;
        }
        public String getFuncao(){
            return funcao;
        }
        public void setFuncao(String funcao){
            this.funcao = funcao;
        }

        @Override
        public String toString() {
            return "Nome: " + getNome() +
                ", Data de Nascimento: " + getDataDeNascimento() +
                ", Salário: " + salario +
                ", Função: " + funcao;
    }
}
