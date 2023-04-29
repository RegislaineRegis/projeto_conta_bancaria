
abstract class Conta {

  private int numero;
  private String cpf;
  protected float saldo;
  boolean ativo;

  public Conta(int numero, String cpf, float saldo, boolean ativo) {
    this.numero = numero;
    this.cpf = cpf;
    this.saldo = saldo;
    this.ativo = ativo;
  }

  public int getNumero() {
    return numero; 
  }

  public void setNumero(int numero) {
    if(numero > 0) {
      this.numero = numero;
    }    
  }

  public void setAtivo(Boolean ativo) {
    this.ativo = ativo;      
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
   
}