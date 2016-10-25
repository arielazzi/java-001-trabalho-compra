/** Alunos: Ariel S. Azzi e Gabriel W. Hugenthobler Trabalho GA Lab 1 turma 71  2016/2 */
public class TestaCompras
{
    public static void main(String[] args)
    {
        // Instanciar um cliente, para o qual serão instanciadas as 5 compras abaixo
        Data dataNasc = new Data(2,12,1995);

        Cliente c1 = new Cliente("Ariel Azzi",dataNasc);


        // Instanciar uma compra à vista (usar o primeiro construtor), com mês da
        // compra igual ao do aniversário do cliente, finalizar a compra e exibir
        // dados da compra.
        Data dataComp1 = new Data(10,12,2016);
        Compra comp1 = new Compra(c1, dataComp1, 100.0);
        comp1.setModalidade(1);
        comp1.finalizaCompra();
        comp1.exibeDados();


        System.out.println("\n \n");
        // Instanciar para o mesmo cliente uma segunda compra (usar o segundo
        // construtor), de valor mais alto que a primeira, para pagamento com
        // entrada e duas parcelas, finalizar a compra e exibir dados dela.
        Compra comp2 = new Compra(c1, 5, 10, 2016, 200.0);
        comp2.setModalidade(2);
        comp2.finalizaCompra();
        comp2.exibeDados();


        System.out.println("\n \n");
        // Instancia uma nova compra à vista, num mês diferente do de seu
        // aniversário e com valor maior que os das compras anteriores. Finalizar e
        // exibir dados da compra.
        Compra comp3 = new Compra(c1, 2, 9, 2016, 300.0);
        comp3.setModalidade(1);
        comp3.finalizaCompra();
        comp3.exibeDados();


        System.out.println("\n \n");
        // Instanciar uma compra à vista, fora do mês de aniversário, com valor
        // menor que o da compra anterior. Finalizar e exibir dados da compra.
        Compra comp4 = new Compra(c1, 2, 5, 2016, 250.0);
        comp4.setModalidade(1);
        comp4.finalizaCompra();
        comp4.exibeDados();


        System.out.println("\n \n");
        // Instanciar uma compra em 3 parcelas. Finalizar e exibir dados dela.
        Compra comp5 = new Compra(c1, 20, 7, 2016, 1000.0);
        comp5.setModalidade(3);
        comp5.finalizaCompra();
        comp5.exibeDados();


    }
}