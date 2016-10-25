/** Alunos: Ariel S. Azzi e Gabriel W. Hugenthobler Trabalho GA Lab 1 turma 71  2016/2 */
public class Compra
{
    private int modalidade;
    private Cliente cliente;
    private Data data;
    private double precoCompra;
    private double precoFinal;
    private Parcela parcela1;
    private Parcela parcela2;
    private Parcela parcela3;



    public Compra(Cliente cli, Data dtCompra, double precoCompra)
    {
    	this.cliente = cli;
    	this.data = dtCompra;
    	this.precoCompra = precoCompra;
    }

    public Compra(Cliente cli, int dd, int mm, int aaaa, double precoCompra)
    {
    	this.cliente = cli;
    	this.data = new Data(dd, mm, aaaa);
    	this.precoCompra = precoCompra;
    }


    public double getPrecoFinal()
    {
        return this.precoFinal;
    }

    public void setModalidade(int modalidade)
    {
        this.modalidade = modalidade;
    }

    public void escolheModalidade ()
    {
    	System.out.println("Indique a modalidade:");
    	System.out.println("1 – À vista.");
    	System.out.println("2 – Parcelada, com 50% de entrada e o restante em duas parcelas iguais.");
    	System.out.println("3 – Parcelada em três parcelas iguais, sem nenhuma entrada.");

    	Teclado t = new Teclado();
    	int mod = t.leInt("Digite o numero da modalidade: ");

    	if (mod == 1)
    		modalidade = mod;
    	else if (mod == 2)
    		modalidade = mod;
    	else if (mod == 3)
    		modalidade = mod;
    	else
    		modalidade = 1;
    }

    private boolean ultimasCrescente(double vlrUltimaCompra)
    {
        boolean ret = false;
        double penultimaCompra = cliente.getValorPC();
        double ultimaCompra = cliente.getValorUC();
        if (penultimaCompra < ultimaCompra && ultimaCompra < vlrUltimaCompra)
            ret = true;

        return ret;
    }

    public String finalizaCompra()
    {
    	double parc1 = 0;
		double parc2 = 0;
		double parc3 = 0;
        String msg = "";
    	if (modalidade == 1)
    	{
    		if (cliente.getDataNascimento().getMes() == data.getMes()){
    			precoFinal = precoCompra - (precoCompra*0.2);
                msg = "Compra à vista, ganhou 20% de desconto, pois cliente nasceu em "+cliente.getDataNascimento().obtemDataPadraoComZeros();
            }
            else if(ultimasCrescente(precoCompra)){
                precoFinal = precoCompra - (precoCompra*0.08);
                msg = "Compra à vista, ganhou 8% de desconto.";
            }
            else{
                precoFinal = precoCompra - (precoCompra*0.05);
                msg = "Compra à vista, ganhou só 5% de desconto.";
            }
        }
        else if(modalidade == 2)
        {
            precoFinal = precoCompra - (precoCompra*0.035);
            parc1 = precoFinal/2;
            parc2 = parc1/2;
            parc3 = parc1/2;
            msg = "Compra com entrada + 2 parcelas, ganhou desconto de 3,5%.";
        }
        else
        {
            precoFinal = precoCompra;
            parc1 = precoFinal/3;
            parc2 = precoFinal/3;
            parc3 = precoFinal/3;
            msg = "Compra em 3 parcelas, não ganhou desconto.";
        }

        if (modalidade != 1)
        {
        	Data dtVencParc1 = calcVencParcela(data);
            parcela1 = new Parcela(cliente, dtVencParc1, parc1);

        	Data dtVencParc2 = calcVencParcela(parcela1.getDataVencimento());
            parcela2 = new Parcela(cliente, dtVencParc2, parc2);

        	Data dtVencParc3 = calcVencParcela(parcela2.getDataVencimento());
            parcela3 = new Parcela(cliente, dtVencParc3, parc3);
        }

        cliente.fazCompra(precoCompra);
        return msg;
    }

    public Data calcVencParcela(Data dtCompra)
    {
        int diaComp = dtCompra.getDia();
        int mesComp = dtCompra.getMes();
        int anoComp = dtCompra.getAno();

        if(mesComp == 12){
            mesComp = 1;
            anoComp++;
        }else{
            mesComp++;
        }

        Data dt = new Data(28,mesComp,anoComp);

        return dt;
    }

    public void exibeDados()
    {
        System.out.println("modalidade: "+modalidade);
        System.out.println("cliente: "+cliente.getNome());
        System.out.println("data: "+data.obtemDataPadraoComZeros());
        System.out.println("precoCompra: "+precoCompra);
        System.out.println("precoFinal: "+precoFinal);

        if (modalidade != 1)
        {
            parcela1.exibeDados(1);
            System.out.println("\n");
            parcela2.exibeDados(2);
            System.out.println("\n");
            parcela3.exibeDados(3);
        }

    }
}