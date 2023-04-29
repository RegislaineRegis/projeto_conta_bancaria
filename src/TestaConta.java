import java.util.Scanner;

public class TestaConta {

  public static void menu() {
    System.out.println("\n\n************************************************************");
    System.out.println("[Cem Saldo] +G[6666]");
    System.out.println("[Vem ficar Cem Saldo você Também!]");
    System.out.println("****************************************************************");
    System.out.println("1-CONTA POUPANÇA");
    System.out.println("2-CONTA CORRENTE");
    System.out.println("3-CONTA ESPECIAL");
    System.out.println("4-CONTA EMPRESA");
    System.out.println("5-CONTA ESTUDANTIL");
    System.out.println("6-SAIR");
    System.out.print("\nDIGITE O CODIGO DA OPÇÃO SELECIONADA:");
  }

  public static void menuDois(float conta, String banco) {
    System.out.println("\n\n************************************************************");
    System.out.println("[Cem Saldo] +G[6666]");
    System.out.println("[Vem ficar Cem Saldo você Também!]");
    System.out.println("****************************************************************");
    System.out.println("CONTA" + "[" + banco + "]");
    System.out.println("\nSaldo Atual: R$ " + conta);
    System.out.println("CONTA" + "[" + banco + "]");
    System.out.println("MOVIMENTO - D- débito ou C-crédito: ");
  }

  public static void main(String[] args) {

    try (Scanner input = new Scanner(System.in)) {
      ContaPoupanca contaP = new ContaPoupanca(1236, "231.653.698-78", 1200, true, 13);
      ContaCorrente contaC = new ContaCorrente(2365, "362.659.789-03", 5600, true);
      int opcao, dia, movimentoLoop = 10, qtdCheque;
      char movimento, continuar = 'S', solicitarCheque;
      float valor;

      menu();
      opcao = input.nextInt();

      switch (opcao) {
        case 1:
          if (contaP.ativo) {
            while (continuar == 'S' || continuar == 's' || movimentoLoop < 0) {

              System.out.println("Digite o dia do aniversario da poupanca: ");
              dia = input.nextInt();
              contaP.correcao(dia);
              menuDois(contaP.saldo, "POUPANÇA");
              movimento = input.next().charAt(0);
              System.out.println("Valor movimento: R$: ");
              valor = input.nextFloat();
              if (movimento == 'D' || movimento == 'd') {
                contaP.debito(valor);
              }
              if (movimento == 'C' || movimento == 'c') {
                contaP.credito(valor);
              }
              movimentoLoop -= 1;
              System.out.println("Continuar S/N: ");
              continuar = input.next().charAt(0);
            }
          } else {
            System.out.println("sua conta não está ativa");
          }
          break;
        case 2:
          if (contaC.ativo) {
            while (continuar == 'S' || continuar == 's' || movimentoLoop < 0) {
              menuDois(contaC.saldo, "CORRENTE");
              movimento = input.next().charAt(0);
              System.out.println("Valor movimento: R$: ");
              valor = input.nextFloat();
              if (movimento == 'D' || movimento == 'd') {
                contaC.debito(valor);
              }
              if (movimento == 'C' || movimento == 'c') {
                contaC.credito(valor);
              }
              movimentoLoop -= 1;
              System.out.println("Continuar S/N: ");
              continuar = input.next().charAt(0);
            }
            System.out.println("Você deseja solicitar cheque S/N ? ");
            solicitarCheque = input.next().charAt(0);
            if (solicitarCheque == 'S' || solicitarCheque == 's') {
              System.out.println("Qual a quantidade de talão:  ");
              qtdCheque = input.nextInt();
              if (qtdCheque <= 3) {
                contaC.pedirTalao(qtdCheque);
                contaC.debito((qtdCheque * 30));
                menuDois(contaC.saldo, "CORRENTE");
              } else {
                System.out.println("Sua quantidade de talão é limitado até 3 unidades!");
              }
            }
          } else {
            System.out.println("sua conta não está ativa");
          }
          break;
      }
    }
  }

}
