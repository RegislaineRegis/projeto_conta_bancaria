public class ContaEspecial extends Conta {

  private float limite;

  public ContaEspecial(int numero, String cpf, float saldo, boolean ativo) {
    super(numero, cpf, saldo, ativo);
  }

  public float getLimite() {
    return limite;
  }

  public void setLimite(float valor) {
    this.limite += valor;
  }

  public void usarLimite(float valor) {
    this.limite -= valor;   
  }
}
