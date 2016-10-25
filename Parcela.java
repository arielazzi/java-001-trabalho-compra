/** Alunos: Ariel S. Azzi e Gabriel W. Hugenthobler Trabalho GA Lab 1 turma 71  2016/2 */
public class Parcela
{
    private Cliente cliente;
    private Data dataVencimento;
    private double valorOriginal;
    private double valorFinal;
    private char situacao;

    //Contrutor
    public Parcela(Cliente c, Data dtV, double vlrO)
    {
        cliente = c;
        dataVencimento = dtV;
        valorOriginal = vlrO;
        situacao = 'N';
    }

    public Data getDataVencimento()
    {
        return dataVencimento;
    }

    public void setDataVencimento(Data novaData)
    {
        dataVencimento = novaData;
    }

    public double getValorOriginal()
    {
        return valorOriginal;
    }

    public boolean registraAtraso()
    {//OK
        Data dataHoje = new Data();
        boolean alteracao = false;
        if (situacao == 'N' && dataHoje.obtemDataInvertida() > dataVencimento.obtemDataInvertida())
        {
            situacao = 'A';
            alteracao = true;
        }

        return alteracao;
    }

    public double paga(Data dtPgt)
    {
        double juros = 0;
        int qtd_dias = dtPgt.diasDeOutraData(dataVencimento);

        if (dtPgt.obtemDataInvertida() > dataVencimento.obtemDataInvertida())
            situacao = 'A';

        if (situacao == 'A')
        {
            if (qtd_dias <= 5)
                juros = 1;
            else if (qtd_dias > 5 && qtd_dias <= 15)
                juros = 1.5;
            else if(qtd_dias > 15)
                juros = 2.5;
        }
        valorFinal = valorOriginal+(valorOriginal*juros/100);
        cliente.pagaParcela(valorFinal);
        situacao = 'Q';
        return juros;
    }

    public String traduzSituacao()
    {
        String ret = "";
        if(situacao == 'N')
            ret = "Não venceu ainda";
        else if(situacao == 'A')
            ret = "Em atraso";
        else if(situacao == 'Q')
            ret = "Quitada";

        return ret;
    }

    public void exibeDados(int numParcela)
    {
        System.out.print("Parcela nº: "+numParcela+" - ");
        System.out.print("Nome: "+cliente.getNome()+" - ");
        System.out.print("Data Vencimento: "+dataVencimento.obtemDataPadraoComZeros()+" - ");
        System.out.print("Valor: "+valorOriginal+" - ");
        System.out.print("Situação: "+traduzSituacao());
    }
}