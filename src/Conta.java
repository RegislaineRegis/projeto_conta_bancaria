
public class Conta {

  private int numero;
  private String cpf;
  protected float saldo;
  private boolean ativo;

  public Conta(int numero, String cpf) {
    this.numero = numero;
    this.cpf = cpf;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void debito(float valor) {
    if(this.ativo) {
      this.saldo -= valor; 
    }       
  }
    
  public void credito(float valor) {
    if(this.ativo) {
      this.saldo += valor;
    }    
  }
  
  public void visualizar() {
		
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
    System.out.println("\nDIGITE O CODIGO DA OPÇÃO SELECIONADA:");
  } 
}