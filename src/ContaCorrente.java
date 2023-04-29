public class ContaCorrente extends Conta{
  
  private int contadorTalao;

  public ContaCorrente(int numero, String cpf, float saldo, boolean ativo) {
    super(numero, cpf, saldo, ativo);
  }

  public int getContadorTalao() {
    return contadorTalao;
  }

  public void pedirTalao(int contadorTalao) {
    this.contadorTalao = contadorTalao; 
  } 
}
