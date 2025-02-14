import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.lang.invoke.StringConcatFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Funcionario> funcionarios = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat salarioFormatador = new DecimalFormat("#,##0.00");

        //3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
        for(int i = 0; i < 10; i++){
            System.out.println("Adicione os dados dos Funcionário:" + (i+1));
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite a data de nascimento (Formato: dd/mm/yyyy):");
            LocalDate dataDeNascimento = LocalDate.parse(scanner.nextLine(), formatter);
            System.out.print("Digite o salário:");
            BigDecimal salario = new BigDecimal(scanner.nextLine());
            System.out.print("Digite a funcao:");
            String funcao = scanner.nextLine();

            Funcionario funcionario = new Funcionario();
            funcionario.setNome(nome);
            funcionario.setDataDeNascimento(dataDeNascimento);
            funcionario.setSalario(salario);
            funcionario.setFuncao(funcao);

            funcionarios.add(funcionario);
        }

        int opcao;

        do{
            System.out.println("\n#############################################");
            System.out.println("MENU");
            System.out.println("1. Excluir funcionário JOÃO da lista");
            System.out.println("2. Imprimir todos os funcionários");
            System.out.println("3. Atualizar salários de funcionário com aumento de 10%");
            //System.out.println("4. Agrupamento de funcionários por função em um MAP");
            //System.out.println("5. Imprimir funcionários por função");
            System.out.println("6. Imprimir funcionários que fazem aniversário no mês 10 e 12");
            System.out.println("7. Impimir funcionários com a maior idade");
            System.out.println("8. Imprimir funcionários por ordem alfabética");
            System.out.println("9. Impimir total dos salários dos funcionários");
            System.out.println("10.Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.");
            System.out.println("11. Sair do MENU");
            System.out.println("\n#############################################");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){

                //3.2 – Remover o funcionário “João” da lista.
                case 1:
                    funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
                    System.out.println("Funcionário João removido.");
                    break;

                //3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
                //• informação de data deve ser exibido no formato dd/mm/aaaa;
                //• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
                case 2:
                    System.out.println("Funcionários cadastrados:");
                    for (Funcionario f : funcionarios) {
                        String dataNascimentoFormatada = f.getDataDeNascimento().format(formatter);
                        String salarioFormatado = salarioFormatador.format(f.getSalario());
                        System.out.println("Nome: " + f.getNome() + " - Data de nascimento: " + dataNascimentoFormatada + " - Salário: " + salarioFormatado + " - Função: " + f.getFuncao());
                    }
                    break;

                //3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
                case 3:
                    BigDecimal aumentoDezPorcento = new BigDecimal(1.10);
                    for(Funcionario f: funcionarios){
                        BigDecimal salarioAtualFuncionario = f.getSalario();
                        f.setSalario(salarioAtualFuncionario.multiply(aumentoDezPorcento));
                        String salarioFormatado = salarioFormatador.format(f.getSalario());
                        System.out.println("Nome: " + f.getNome() + " SalarioAtualizado: " + salarioFormatado);
                    }
                    System.out.println("Salários atualizados");
                    break;

                /*3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”
                case 4:
                    EU NÃO SEI COMO DESENVOLER ESSE REQUISITO UTILIZANDO MAP
                    break;*/

                /*3.6 – Imprimir os funcionários, agrupados por função.
                case 5:
                    COMO EU NÃO DESENVOLVI A FUNÇÃO EM UM MAP, LOGO NÃO CONSIGO DESENVOLVER ESTE REQUISITO SOLICITADO
                    break;O*/

                //3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
                case 6:
                    boolean funcionarioEncontrado = false;

                    for (Funcionario f : funcionarios) {
                        if (f.getDataDeNascimento().getMonthValue() == 10 || f.getDataDeNascimento().getMonthValue() == 12) {
                            LocalDate anoAtual = LocalDate.now();
                            int idade = anoAtual.getYear() - f.getDataDeNascimento().getYear();
                            System.out.println("Nome: " + f.getNome() + " Idade: " + idade);
                            funcionarioEncontrado = true;
                        }
                    }

                    if (!funcionarioEncontrado) {
                        System.out.println("Não foram encontrados funcionários que fazem aniversário nos meses 10 e 12.");
                    }
                    break;

                //3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
                case 7:
                    Funcionario funcionarioMaisVelho = funcionarios.get(0);
                    LocalDate anoAtual = LocalDate.now();
                    for(Funcionario f: funcionarios){

                        int idade = anoAtual.getYear() - f.getDataDeNascimento().getYear();

                        int idadeMaisVelho = anoAtual.getYear() - funcionarioMaisVelho.getDataDeNascimento().getYear();

                        if (idade > idadeMaisVelho) {
                            funcionarioMaisVelho = f;
                        }
                     }

                    System.out.println("O funcionário mais velho é- Nome: " + funcionarioMaisVelho.getNome() + " Idade: " + (anoAtual.getYear() - funcionarioMaisVelho.getDataDeNascimento().getYear()));
                    break;

                //3.10 – Imprimir a lista de funcionários por ordem alfabética.
                case 8:
                    funcionarios.sort(Comparator.comparing(Funcionario::getNome));

                    for (Funcionario f : funcionarios) {
                        String dataNascimentoFormatada = f.getDataDeNascimento().format(formatter);
                        String salarioFormatado = salarioFormatador.format(f.getSalario());
                        System.out.println("Nome: " + f.getNome() + " | Data de Nascimento: " + dataNascimentoFormatada + " | Salário: " + salarioFormatado + " | Função: " + f.getFuncao());
                    }
                    break;

                //3.11 – Imprimir o total dos salários dos funcionários.
                case 9:
                    BigDecimal totalDeSalariosDosFuncionarios = BigDecimal.ZERO;

                    for(Funcionario f: funcionarios){
                        totalDeSalariosDosFuncionarios = totalDeSalariosDosFuncionarios.add(f.getSalario());
                    }

                    String totalSalarioFormatado = salarioFormatador.format(totalDeSalariosDosFuncionarios);
                    System.out.println("Total salários: " + totalSalarioFormatado);

                    break;

                //3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
                case 10:
                    BigDecimal salarioMinimo = new BigDecimal(1212.00);

                    for(Funcionario f: funcionarios){
                        BigDecimal quantidadeSalariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
                        String quantidadeSalarioMinimoFormatado = salarioFormatador.format(quantidadeSalariosMinimos);
                        System.out.println("Funcionário: " + f.getNome() + " ganha " + quantidadeSalarioMinimoFormatado + " salários mínimos.");

                    }
                    break;

                case 11:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção selecionada não encontrada. Por favor, tente novamente");


            }
        } while (opcao != 11);

        scanner.close();

    }
}



