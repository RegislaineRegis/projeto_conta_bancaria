public class ContaPoupanca extends Conta{
  
  private int diaAniversarioPoupanca;

  public ContaPoupanca(int numero, String cpf, float saldo, boolean ativo, int diaAniversarioPoupanca) {
    super(numero, cpf, saldo, ativo);
    this.diaAniversarioPoupanca = diaAniversarioPoupanca;
  }

  public int getDiaAniversarioPoupanca() {
    return diaAniversarioPoupanca;
  }

  public void setDiaAniversarioPoupanca(int diaAniversarioPoupanca) {
    this.diaAniversarioPoupanca = diaAniversarioPoupanca;
  }

  @Override
  public void correcao(int diaAniversarioPoupanca) {
    if(this.diaAniversarioPoupanca == diaAniversarioPoupanca) {
      this.saldo = (float) ((this.saldo * 0.05) + this.saldo);
    }else {
      System.out.println("O dia do aniversario da poupanca, está inválido!");
    }
  }  
}
