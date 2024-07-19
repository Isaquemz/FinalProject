import java.util.Scanner;

public class Main {

    public static double[] getSalario(int qtdFuncionarios) {

        Scanner input = new Scanner(System.in);
        double[] salarioBruto = new double[qtdFuncionarios];
        boolean numberIsValid;
        double valorDigitado;

        // Resgato os valores do usuario
        for (int i = 0; i < salarioBruto.length; i++) {

            // Enquanto não for digitado um valor valido, continua solicitando ao usuario.
            numberIsValid = false;
            while(!numberIsValid) {
                try {

                    System.out.println("Digite o valor do funcionario: " + (i+1));
                    valorDigitado = Double.parseDouble(input.nextLine());

                    // Evita valores zerados e negativos
                    if (valorDigitado > 0) {
                        salarioBruto[i] = valorDigitado;
                        numberIsValid = true;
                    } else {
                        System.out.println("Digite um numero maior que zero.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Este numero não é valido, tente novamente!");
                }
            }

        }

        return salarioBruto;
    }

    public static double calculateInss(double salario) {
        /*
            Regra aplicada:

            Salário: % Desconto INSS
            até 1.212,00: 7,5%
            de 1212,01 até 2.427,35: 9%
            de 2.427,36 até 3.641,03: 12%
            apartir de 3.641,04: 14%
         */

        double percentDesconto = 0;

        if (salario <= 1212) {
            percentDesconto = 7.5;
        } else if (salario >= 1212.01 && salario <= 2427.35) {
            percentDesconto = 9;
        } else if (salario >= 2427.36 && salario <= 3641.03) {
            percentDesconto = 12;
        } else if (salario >= 3641.04) {
            percentDesconto = 14;
        }

        return salario * (percentDesconto / 100);

    }

    public static double calculateImpostoRenda(double salario) {
        /*
            Regra aplicada:

            Salário: % Desconto Imposto de Renda
            até 1.903,98: 0%
            de 1.903,99 até 2.826,65: 7,5%
            de 2.826,66 até 3.751,05: 15%
            de 3.751,06 até 4.664,68: 22,50%
            Acima de 4.664,68: 27,50%
         */

        // Iniciando valor como zero, ja atingindo regra até 1903.98
        double percentDesconto = 0;

        if (salario >= 1903.99 && salario <= 2826.65) {
            percentDesconto = 7.5;
        } else if (salario >= 2826.66 && salario <= 3751.05) {
            percentDesconto = 15;
        } else if (salario >= 3751.06 && salario <= 4664.68) {
            percentDesconto = 22.5;
        } else if (salario > 4664.68) {
            percentDesconto = 27.5;
        }

        return salario * (percentDesconto / 100);

    }

    public static void main(String[] args) {
        /*
            Faça um programa que receba 5 salários brutos de funcionários,
            sabendo-se que são descontados Imposto de Renda e INSS, calcule
            e mostre o total do salário líquido no referido mês.

            Obs.: Salário Bruto - Descontos = Salário Líquido.

            A saída do programa deve fornecer as seguintes informações:

            Salário bruto.
            Quanto pagou ao INSS.
            Quanto pagou de Imposto de Renda.
            Salário líquido.

            Calcule os descontos e o salário líquido com base nas tabelas abaixo:

            Salário	% Desconto INSS
            até 1.212,00	7,5%
            de 1212,01 até 2.427,35	9%
            de 2.427,36 até 3.641,03	12%
            acima de 3.641,04	14%

            Salário	% Desconto Imposto de Renda
            até 1.903,98	0%
            de 1.903,99 até 2.826,65	7,5%
            de 2.826,66 até 3.751,05	15%
            de 3.751,06 até 4.664,68	22,50%
            Acima de 4.664,68	27,50%
         */

        // Link GitHub: https://github.com/Isaquemz/FinalProject

        int qtdFuncionarios = 5;
        double[] salarioBruto;
        double salarioLiquidoAtual;
        double totalDescontosAtual;
        double vrInssAtual;
        double vrImpostoRendaAtual;

        // Resgata atravez de função, os valores.
        salarioBruto = getSalario(qtdFuncionarios);

        // Itera sobre os salarios, realizando os calculos
        for (double salario: salarioBruto) {

            // Realiza calculos
            vrInssAtual = calculateInss(salario);
            vrImpostoRendaAtual = calculateImpostoRenda(salario);
            totalDescontosAtual = vrInssAtual + vrImpostoRendaAtual;
            salarioLiquidoAtual = salario - totalDescontosAtual;

            // Imprime resultado
            System.out.println("-----------------------------------------");
            System.out.println("--------- Holerite disponivel -----------");
            System.out.println("-----------------------------------------");
            System.out.println("Salario: R$ " + salario);
            System.out.println("Desconto Inss: R$ " + vrInssAtual);
            System.out.println("Desconto Imposto de Renda: R$ " + vrImpostoRendaAtual);
            System.out.println("-----------------------------------------");
            System.out.println("Total de Descontos: R$ " + totalDescontosAtual);
            System.out.println("Salario Liquido: R$ " + salarioLiquidoAtual);
            System.out.printf("-----------------------------------------%n%n");

        }

    }

}
