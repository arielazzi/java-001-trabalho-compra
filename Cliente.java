/** Alunos: Ariel S. Azzi e Gabriel W. Hugenthobler Trabalho GA Lab 1 turma 71  2016/2 */
public class Cliente
{
    private String nome;
    private Data dataNascimento;
    private double valorPC;
    private double valorUC;
    private double saldoDevedor;

    //Contrutor
    public Cliente(String n, Data dtN)
    {
        nome = n;
        dataNascimento = dtN;
    }
    
    public String getNome()
    {
        return nome;
    }

    public double getValorPC()
    {
        return valorPC;
    }

    public double getValorUC()
    {
        return valorUC;
    }
    
    public Data getDataNascimento()
    {
        return dataNascimento;
    }
    
    public void fazCompra(double vlrF)
    {
        valorPC = valorUC;
        valorUC = vlrF;
    }

    public void fazCompra(double vlrF, double sldDev)
    {
        fazCompra(vlrF);
        saldoDevedor += sldDev;
    }

    public void pagaParcela(double valorOriginal)
    {
        saldoDevedor -= valorOriginal;
    }

    public void exibeDados()
    {
        System.out.println("Nome:"+nome);
        System.out.println("dataNascimento:"+dataNascimento.obtemDataPadraoComZeros());
        System.out.println("valorPC:"+valorPC);
        System.out.println("valorUC:"+valorUC);
        System.out.println("saldoDevedor:"+saldoDevedor);
    }

}