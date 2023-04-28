
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
}