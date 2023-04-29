import java.util.Scanner;

public class TestaConta {
  public static void main(String[] args) {
  
    Scanner input = new Scanner(System.in);
    Conta contaP = new ContaPoupanca(1236, "231.653.698-78", 1200, true, 13);
    int opcao, dia, movimentoLoop = 10;
    char movimento, continuar = 'S';
    float valor;
          
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
    opcao = input.nextInt();

   
    switch(opcao) {
      case 1:
      while(continuar == 'S' || continuar == 's' || movimentoLoop < 0) {
        System.out.println("Digite o dia do aniversario da poupanca: ");
        dia = input.nextInt();
        contaP.correcao(dia);
        System.out.println("\n\n************************************************************");
        System.out.println("[Cem Saldo]");
        System.out.println("[Vem ficar Cem Saldo você Também!]");
        System.out.println("****************************************************************");
        System.out.println("CONTA [POUPANCA]");
        System.out.println("\nSaldo Atual: R$ " + contaP.saldo);
        System.out.println("CONTA [POUPANCA]");
        System.out.println("MOVIMENTO - D- débito ou C-crédito: ");
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
    }
  }
  
}
