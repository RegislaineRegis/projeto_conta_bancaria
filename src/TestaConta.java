import java.util.Scanner;

public class TestaConta {

  public static void menu() {
    System.out.println("\n\n************************************************************");
    System.out.println("[Cem Saldo]");
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

  public static void menuPoupanca(float conta) {
    System.out.println("\n\n************************************************************");
    System.out.println("[Cem Saldo]");
    System.out.println("[Vem ficar Cem Saldo você Também!]");
    System.out.println("****************************************************************");
    System.out.println("CONTA [POUPANCA]");
    System.out.println("\nSaldo Atual: R$ " + conta);
    System.out.println("CONTA [POUPANCA]");
    System.out.println("MOVIMENTO - D- débito ou C-crédito: ");
  }

  public static void main(String[] args) {
  
    try (Scanner input = new Scanner(System.in)) {
      ContaPoupanca contaP = new ContaPoupanca(1236, "231.653.698-78", 1200, true, 13);
      int opcao, dia, movimentoLoop = 10;
      char movimento, continuar = 'S';
      float valor;
               
      menu();
      opcao = input.nextInt();
  
      switch(opcao) {
        case 1:
        while(continuar == 'S' || continuar == 's' || movimentoLoop < 0) {
          System.out.println("Digite o dia do aniversario da poupanca: ");
          dia = input.nextInt();
          contaP.correcao(dia);
          menuPoupanca(contaP.saldo);
          movimento = input.next().charAt(0);
          System.out.println("Valor movimento: R$: ");
          valor = input.nextFloat();
            if(movimento == 'D' || movimento == 'd' ) {
              contaP.debito(valor);
            }  
            if(movimento == 'C' || movimento == 'c') {
              contaP.credito(valor);
            }
          System.out.println("Continuar S/N: ");
          continuar = input.next().charAt(0);
        }             
        break;
        case 2:
        break;
      }
    }
  }
  
}
