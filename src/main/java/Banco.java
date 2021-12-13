import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
        int opcao;
        ContaBanco contaUm = new ContaBanco();
        Scanner digite = new Scanner(System.in);


        System.out.println("O que você deseja?");
        System.out.println("Opção 1 -Abrir Conta");
        System.out.println("Opção 2 - Sacar");
        System.out.println("Opção 3 - Depositar");
        System.out.println("Opção 4 - Pagar mensalidade");
        System.out.println("Opção 5 - Fechar Conta");


        opcao = digite.nextInt();

        switch (opcao) {
            case 1:
                contaUm.abrirConta();
                break;
            case 2:
                contaUm.sacar();
                break;
            case 3:
                contaUm.depositar();
                break;
            case 4:
                contaUm.pagarMensal();
                break;
            case 5:
                contaUm.fecharConta();
                break;
            default:
                System.out.println("Operação inválida!");
                System.out.println("---- Atendimento finalizado ----");


        }

    }



}
