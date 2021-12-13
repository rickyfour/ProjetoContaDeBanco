import java.util.Random;
import java.util.Scanner;

public class ContaBanco {

    private String nomeBanco = "EX-Bancos";
    public int numConta;
    private int senha;
    public boolean senhaCorreta;
    protected String tipo;
    private boolean contaCorrente;
    private boolean contaPoupanca;
    private String cliente;
    private double saldo;
    private boolean status;
    private int operacao;
    private double manutencaoContaCorrente = 12;
    private double manutencaoContaPoupanca = 25;
    private int[] contas = new int[100];
    Scanner entrada = new Scanner(System.in);
    Random random = new Random();




    public void abrirConta() {
        if (this.status == false) {

            System.out.println("Olá, sou Robert, o atendende virtual da " + getNomeBanco() + " e vou lhe auxiliar a cria sua conta.");
            System.out.println("Primeiro passo:");

            System.out.println("Digite seu nome: ");
            setCliente(entrada.next());

            System.out.println("Seja Bem vindo " + this.cliente + " ao " + getNomeBanco() + "\nVamos ao Segundo passo:");

            while (this.contaCorrente == false && this.contaPoupanca == false) {
                System.out.println(" 1 - Você quer criar uma Conta Corrente ou 2 - Conta poupança?");
                setOperacao(entrada.nextInt());

                if (this.operacao == 1) {
                    System.out.println("Você escolheu Conta Corrente");
                    System.out.println("Te presenteamos com R$75 para começar a utilizar sua conta");
                    setTipo("Conta Corrente");
                    setContaCorrente(true);
                    setSaldo(75); // bonus de 75 reais por abrir conta corrente

                } else if (this.operacao == 2) {
                    System.out.println("Você escolheu Conta Poupança");
                    System.out.println("Te presenteamos com R$200 para começar a utilizar sua poupança");
                    setTipo("Conta Poupança");
                    setContaPoupanca(true);
                    setSaldo(200); // bonus de 200 reais por abrir conta poupança

                } else {
                    System.out.println("Comando inválido");
                }
            }

            for (int i = 0; i < 100; i++) {
                int valor = (random.nextInt(100) + 1);
                boolean temConta = false;
                for (int j = 0; j < 100; j++) {
                    if (contas[j] == valor) {
                        j = 100;
                        temConta = true;

                    }
                }
                if (temConta = false) {
                    contas[i] = valor;
                    setNumConta(valor);
                    break;
                }
            }

            System.out.println("Vamos ao Terceiro passo e último");
            do {
                int senhaReal;
                int senhaConfirmacao;

                System.out.println("Crie uma senha somente com números: ");
                senhaReal = entrada.nextInt();
                System.out.println("Digite novamente:");
                senhaConfirmacao = entrada.nextInt();
                if (senhaReal != senhaConfirmacao){
                    System.out.println("Você digitou senhas diferentes! Faça denovo :)");
                    senhaCorreta = false;
                } else if (senhaReal == senhaConfirmacao) {
                    senhaCorreta = true;
                    setSenha(senhaReal);
                }

            } while (senhaCorreta == false);
            setStatus(true);
            System.out.println("Parabéns " + this.cliente + ", você acabou de criar uma conta na " + getNomeBanco() + "\nEstamos muito felizes por você fazer parte do nosso negócio!\nEsperamos deixar você satisfeito com nosso serviço.");
        }else if(this.status == true){
            System.out.println("Olá " + cliente + ", você já possui uma conta.");
            System.out.println("---- Atendimento finalizado ----");
        }
    }

    public void fecharConta(){
        if (this.status == true) {
            System.out.println(this.cliente + " tem certeza que quer fechar sua conta? Todos seus dados serão deletados.");
            int certeza;
            System.out.println("1 - sim \n2 - não");
            certeza = entrada.nextInt();
            if (certeza == 1) {
                if (this.saldo == 0){

                    System.out.println("Estamos tristes com sua partida... \nSua conta foi fechada :'(");
                    setSaldo(0);
                    setNumConta(0);
                    setContaPoupanca(false);
                    setContaCorrente(false);
                    setTipo(null);
                    setCliente(null);
                    setSenha(0);
                    setStatus(false);
                    System.out.println("---- Atendimento finalizado ----");

                } else {
                    System.out.println("Verifique suas pendencias antes de fechar sua conta");
                    System.out.println("Você pode ter saldo em conta ou débito em aberto");
                    System.out.println("---- Atendimento finalizado ----");
                }

            }else if (certeza == 2) {
                return;
            }else {
                System.out.println("Opção inválida");
                System.out.println("---- Atendimento finalizado ----");
            }

        }else {
            System.out.println("Você não possui conta aberta");
            System.out.println("---- Atendimento finalizado ----");
        }

    }

    public void depositar(){
        setStatus(true);
        if (this.status == true) {
            double depositoAgora;
            System.out.println("Saldo total atual é de: R$" + getSaldo());
            System.out.println("Qual a quantia que você deseja depositar?");
            depositoAgora = entrada.nextDouble();
            setSaldo(this.saldo + depositoAgora);
            System.out.println("Seu depósito foi de: R$" + depositoAgora);
            System.out.println("Saldo total atual é de: R$" + getSaldo());
            System.out.println("\n\n---- Atendimento finalizado ----");

        }else {
            System.out.println("Conta inexistente");
            System.out.println("---- Atendimento finalizado ----");
        }

    }

    public void sacar() {
        if (this.status == true) {
            if (this.saldo > 0) {
                System.out.println("Saldo total atual é de: R$" + getSaldo());
                double sacarAgora;
                boolean verificacaoSaldo = false;
                do {
                    System.out.println("Por favor digite o valor que você deseja sacar?");
                    sacarAgora = entrada.nextDouble();
                    if (sacarAgora > 0 && sacarAgora < this.saldo) {
                        setSaldo(this.saldo - sacarAgora);
                        System.out.println("Você acabou de sacar R$" + sacarAgora);
                        verificacaoSaldo = true;
                        System.out.println("Seu saldo atual é de R$" + getSaldo());
                        System.out.println("---- Atendimento finalizado ----");
                    }

                } while (verificacaoSaldo == false);
            } else{
                System.out.println("Você não possui saldo na conta");
                System.out.println("---- Atendimento finalizado ----");
            }

        } else {
            System.out.println("Você não possui conta na " + getNomeBanco());
            System.out.println("---- Atendimento finalizado ----");

        }
    }
    public void pagarMensal(){
        if (this.isContaCorrente() == true) {
            boolean pagamentoMensalidade = false;
            System.out.println("Sua mensalidade é de: R$12,0");
            do {
                System.out.println("Deseja pagar? 1 - sim  2 - não");
                int verificacaoPagarMensal;
                verificacaoPagarMensal = entrada.nextInt();
                if (verificacaoPagarMensal == 1) {
                    setSaldo( this.saldo - this.manutencaoContaCorrente);
                    System.out.println("Pagamento realizado com sucesso.");
                    System.out.println("---- Atendimento finalizado ----");
                    pagamentoMensalidade = true;
                }else {
                    System.out.println("---- Atendimento finalizado ----");
                }
            } while (pagamentoMensalidade == false);


        }else if (this.isContaPoupanca() == true) {
            boolean pagamentoMensalidade = false;
            System.out.println("Sua mensalidade é de: R$25,0");
            do {
                System.out.println("Deseja pagar? 1 - sim  2 - não");
                int verificacaoPagarMensal;
                verificacaoPagarMensal = entrada.nextInt();
                if (verificacaoPagarMensal == 1) {
                    setSaldo( this.saldo - this.manutencaoContaPoupanca);
                    System.out.println("Pagamento realizado com sucesso.");
                    System.out.println("---- Atendimento finalizado ----");
                    pagamentoMensalidade = true;
                }else {
                    System.out.println("---- Atendimento finalizado ----");
                }
            } while (pagamentoMensalidade == false);
        }

    }

    public void statusConta() {
        System.out.println("------ Status da sua conta ------");
        System.out.println("\n\n");
        System.out.println("Nome: "+ getCliente());
        System.out.println("Número da conta: " + getNumConta());
        System.out.println("Tipo de conta: " + getTipo());
        System.out.println("Saldo disponível: " + getSaldo());
        System.out.println("Senha: " + getSenha());
        System.out.println("\n\n---- Atendimento finalizado ----");

    }


    //-----------------------------------------------------------------------------------------
    //---------------------- getters and setters ----------------------------------------------
    //-----------------------------------------------------------------------------------------


    public double getManutencaoContaPoupanca() {
        return manutencaoContaPoupanca;
    }

    public void setManutencaoContaPoupanca(double manutencaoContaPoupanca) {
        this.manutencaoContaPoupanca = manutencaoContaPoupanca;
    }

    public double getManutencaoMensalidade() {
        return manutencaoContaCorrente;
    }

    public void setManutencaoContaCorrente(double manutencaoContaCorrente) {
        this.manutencaoContaCorrente = manutencaoContaCorrente;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }


    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getOperacao() {
        return operacao;
    }

    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    public boolean isContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(boolean contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public boolean isContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(boolean contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }
}
