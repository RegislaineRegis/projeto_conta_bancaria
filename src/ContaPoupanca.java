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

  public void correcao(int diaAniversarioPoupanca) {
    if(this.diaAniversarioPoupanca == diaAniversarioPoupanca) {
      saldo = (float) ((saldo * 0.05) + saldo);
    }else {
      System.out.println("O dia do aniversario da poupanca, está inválido!");
    }
  }  
}
