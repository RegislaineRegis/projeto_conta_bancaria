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

  public static void menuContaEmprestimo(float valorEmprestimo) {
    System.out.println("Você topa um emprestimo? Você tem R$ " + valorEmprestimo + " liberado!! Deseja pegar? S/N: ");
  }
  

  public static void main(String[] args) {

    try (Scanner input = new Scanner(System.in)) {
      ContaPoupanca contaP = new ContaPoupanca(1236, "231.653.698-78", 1200, true, 13);
      ContaCorrente contaC = new ContaCorrente(2365, "362.659.789-03", 5600, true);
      ContaEspecial contaE = new ContaEspecial(6593, "236.654.369-89", 50.0f, true);
      ContaEmpresa contaEmpresa = new ContaEmpresa(9820, "230.639.987-23", 20000.36f, true);
      int opcao, dia, movimentoLoop = 10, qtdCheque;
      char movimento, continuar = 'S', solicitarCheque, pegarEmprestimo = 'S';
      float valor, auxLimite, valorEmprestimo;

      menu();
      opcao = input.nextInt();

      switch (opcao) {
        case 1:
          if (contaP.ativo) {
            while (continuar == 'S' || continuar == 's') {
              if(movimentoLoop != 0){
                if(contaP.saldo > -1){
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
                } else {
                  System.out.println("Sua conta esta negativa!!!");
                  break;
                }
              }
              else {
                System.out.println("Você atingiu as 10 movimentações disponíveis");
                break;
              }              
            }
          } else {
            System.out.println("sua conta não está ativa");
          }
          break;
        case 2:
          if (contaC.ativo) {
            while (continuar == 'S' || continuar == 's') {
              if(movimentoLoop != 0) {
               if(contaC.saldo > -1){
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
                } else {
                  System.out.println("Sua conta esta negativa!!!");
                  break; 
                }
              }
              else {
                System.out.println("Você atingiu as 10 movimentações disponíveis");
                break;
              }
            }
            System.out.println("Você deseja solicitar cheque S/N ? ");
            solicitarCheque = input.next().charAt(0);
            if(contaC.saldo > 0){
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
              System.out.println("Sua conta esta negativa!!!");
              break; 
            }
              
          } else {
            System.out.println("sua conta não está ativa");
          }
          break;
        case 3:
          if (contaE.ativo) {
            contaE.setLimite(1000);
            while (continuar == 'S' || continuar == 's') {
              if(movimentoLoop != 0) {
                menuDois(contaE.saldo, "ESPECIAL");
                movimento = input.next().charAt(0);
                System.out.println("Valor movimento: R$: ");
                valor = input.nextFloat();
                if (contaE.getLimite() != 0) {
                  if (movimento == 'D' || movimento == 'd') {
                    if (contaE.saldo == 0) {
                      contaE.usarLimite(valor);
                      contaE.saldo = 0;
                    }
                    if (contaE.saldo < valor && contaE.saldo != 0) {
                      valor = valor - contaE.saldo;
                      contaE.saldo = 0;
                      contaE.usarLimite(valor);
                    }
                    if (contaE.saldo >= valor) {
                      contaE.debito(valor);
                    }
                    System.out.println("Você ainda tem um total limite de:: " + contaE.getLimite());
                    System.out.println("Seu saldo da Conta Especial é de: " + contaE.saldo);
                  }
                  if (movimento == 'C' || movimento == 'c') {

                    if (contaE.getLimite() < 1000) {
                      auxLimite = 1000 - contaE.getLimite();
                      valor = valor - auxLimite;
                      contaE.saldo = valor;
                      contaE.setLimite(1000);
                    }
                    if (contaE.getLimite() == 1000) {
                      contaE.credito(valor);
                    }
                    System.out.println("Você ainda tem um total limite de:: " + contaE.getLimite());
                    System.out.println("Seu saldo da Conta Especial é de: " + contaE.saldo);
                        menuDois(contaE.saldo, "ESPECIAL");
                    }
                  } else {
                    System.out.println("Você usou todo seu limite");
                    break;
                  }
                  movimentoLoop -= 1;
                  System.out.println("Continuar S/N: ");
                  continuar = input.next().charAt(0);
              } 
              else {
                System.out.println("Você atingiu as 10 movimentações disponíveis");
                break;
              }
            }

          } else {
            System.out.println("sua conta não está ativa");
          }
          break;
        case 4:
       
        if (contaEmpresa.ativo) {
          contaEmpresa.setEmprestimoEmpresa(10000);
          while (continuar == 'S' || continuar == 's') {
            if(movimentoLoop != 0) {     
                if(contaEmpresa.saldo > -1) {
                  menuDois(contaEmpresa.saldo, "EMPRESA");
                  movimento = input.next().charAt(0);
                  System.out.println("Valor movimento: R$: ");
                  valor = input.nextFloat();
                  if (movimento == 'D' || movimento == 'd') {
                    contaEmpresa.debito(valor);
                  }
                  if (movimento == 'C' || movimento == 'c') {
                    contaEmpresa.credito(valor);
                  }
                  menuContaEmprestimo(contaEmpresa.getEmprestimoEmpresa());
                  pegarEmprestimo = input.next().charAt(0);
                  if(pegarEmprestimo == 'S' || pegarEmprestimo == 's') {
                    System.out.println("Valor Emprestimo: ");
                    valorEmprestimo = input.nextFloat();
                    contaEmpresa.pedriEmprestimo(valorEmprestimo);
                    contaEmpresa.saldo += valorEmprestimo;
                    System.out.println("Saldo Atual: R$ " + contaEmpresa.saldo);
                    System.out.println("Você ainda possui um limite de: R$ " + contaEmpresa.getEmprestimoEmpresa());
                  } 
                  movimentoLoop -= 1;
                  System.out.println("Continuar S/N: ");
                  continuar = input.next().charAt(0);         

                } 
                else {
                  System.out.println("Sua conta esta negativa!!!");
                  break; 
                }
            } else {
                if(movimentoLoop == 10) {
                  System.out.println("Valor Emprestimo: ");
                  valorEmprestimo = input.nextFloat();
                  contaEmpresa.pedriEmprestimo(valorEmprestimo);
                  System.out.println("Saldo Atual: R$ " + contaEmpresa.saldo);
                  System.out.println("Você ainda possui um limite de: R$ " + contaEmpresa.getEmprestimoEmpresa());
                }
                System.out.println("Você atingiu as 10 movimentações disponíveis");
                break;
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
