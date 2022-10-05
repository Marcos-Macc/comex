<h1>Projeto COMEX</h1>

Criação do projeto 20/09/2022

>>> 21/09/2022
Adicionado novos packages categoria e produto no projeto

<h2>28/09/2022 - Validações ao criar uma Categoria</h2>
Adicionado Exceções <b>IllegalArgumentException</b> à classe Categoria.

<h2>28/09/2022 - Validações ao criar um Produto ou ProdutoIsento</h2>
Adicionado Exceções <b>IllegalArgumentException</b> às classes Produto e ProdutoIsento.

<h2>28/09/2022 - Adequando pacotes</h2>
Criado pacote br.com.comex.main, que contem as classes que definem o método `main`.

Criado pacote br.com.comex.modelo, que contem as classes `Categoria`, `Produto`, `ProdutoIsento`, `Cliente`, `Pedido` e `ItemPedido`.
Removido packages existentes e transferido fontes para as novas classes.

<h2>28/09/2022 - Validações ao criar um Cliente</h2>
Adicionado Exceções <b>IllegalArgumentException</b> à classe Cliente.

<h2>28/09/2022 - Definindo a ComexException</h2>
Definida uma <b>unchecked exception</b> chamada <b>ComexException</b>.

Utilizada no lugar de <b>IllegalArgumentException</b> na classe Cliente.

<h2>29/09/2022 - Definindo toString()</h2>
Definido método <b>toString()</b> para todas as classes.

<h2>29/09/2022 - Validações de padrões para texto</h2>
Categoria - <b>nome</b> não pode começar com números.

Produto e Produto Isento - <b>nome</b> não pode começar com números.

Cliente - <b>nome</b> não pode começar com números.

Cliente - <b>cpf:</b>  só pode conter números e pontuações de acordo com o padrão `000.000.000-00`; não pode conter espaços.

Cliente - <b>telefone</b> se tiver preenchido, só pode conter números, espaços e pontuações de acordo com o padrão `(00) 0 0000-0000`.

<h2>29/09/2022 - Enumerados em Categoria e Cliente</h2>
Categoria - O status da categoria só possa ser <b>ATIVA</b> e <b>INATIVA</b>.

Cliente - O estado do cliente só possa ser: AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO.

<h2>05/10/2022 - Leitura do arquivo pedidos.csv</h2>
Criação do pacote <b>br.com.bomex.csv</b>.
Criação das classes LeitorPedidosCsv e PedidoCsv.
Importação do arquivo pedidos.csv.

<h2>05/10/2022 - Calcular o total de produtos vendidos do pedidos.csv</h2>
Criado classe TotalProdutosVendidos.

