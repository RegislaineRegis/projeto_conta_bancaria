public class ContaEmpresa extends Conta {

  private float emprestimoEmpresa;

  public ContaEmpresa(int numero, String cpf, float saldo, boolean ativo) {
    super(numero, cpf, saldo, ativo);   
  }

  public float getEmprestimoEmpresa() {
    return emprestimoEmpresa;
  }

  public void setEmprestimoEmpresa(float emprestimoEmpresa) {
    this.emprestimoEmpresa = emprestimoEmpresa;
  }
  
  public void pedriEmprestimo(float valor) {
    emprestimoEmpresa -= valor;
  }
}
