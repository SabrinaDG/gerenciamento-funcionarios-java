import java.time.LocalDate;

// 1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).
public class Pessoa {
        private String nome;
        private LocalDate dataDeNascimento;

        public String getNome(){
            return nome;
        }
        public void setNome(String nome){
            this.nome = nome;
        }
        public LocalDate getDataDeNascimento(){
            return dataDeNascimento;
        }
        public void setDataDeNascimento(LocalDate dataDeNascimento){
            this.dataDeNascimento = dataDeNascimento;
        }
}
