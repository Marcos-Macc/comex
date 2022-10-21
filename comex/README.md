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
Criação das classes <b>LeitorPedidosCsv</b> e PedidoCsv</b>.
Importação do arquivo <b>pedidos.csv</b>.

<h2>05/10/2022 - Calcular total de produtos vendidos do pedidos.csv</h2>
Criado classe <b>TotalProdutosVendidos</b>.

<h2>05/10/2022 - Calcular total de categorias distintas do pedidos.csv</h2>
Criado Classe <b>TotalCategorias</b>.

<h2>05/10/2022 - Montante total de vendas do pedidos.csv</h2>
Criado Classe <b>MontanteTotalVendas</b>

<h2>06/10/2022 - Pedidos mais barato e mais caro do pedidos.csv</h2>
Criado classe <b>PedidoMaisBaratoEMaisCaro</b>

<h2>06/10/2022 - Formatação de Moedas</h2>
Atualizado classes PedidoMaisBaratoEMaisCaro e MontanteTotalVendas para mostrar os valores corretamente e em moeda Brasileira.

>>>BRX Semana 9 - JDBC e Design Patterns (10/10 - 15/10)

<h2>10/10/2022 - Criando a ConnectionFactory</h2>
Criado br.com.comex.modelo.ConnectionFactory.
Criado br.com.comex.main.MainTestaConexao.

<h2>10/10/2022 - Inserção de Categorias</h2>
Atualizado br.com.comex.modelo.ConnectionFactory e br.com.comex.main.MainTestaConexao.
Criado br.com.comex.main.MainInsercaoCategoria.

<h2>10/10/2022 - Listagem de Categorias</h2>
Atualizado br.com.comex.main.MainInsercaoCategoria para utilizar preparedStatement.
Criado br.com.comex.main.MainListagemCategoria.
Atualizado br.com.comex.modelo com um construtor sem parâmetros.

<h2>10/10/2022 - Atualização de Categorias</h2>
Criado br.com.comex.main.MainAtualizacaoCategoria.

<h2>11/10/2022 - Pool de conexões</h2>
Atualizado br.com.comex.modelo.ConnectionFactory para ter um pool de conexões.

<h2>13/10/2022 - Remoção de Categorias Inativas</h2>
Criado br.com.comex.main.MainRemocaoCategoria.

<h2>13/10/2022 - DAOs para as entidades</h2>
Criado br.com.comex.dao.CategoriasDAO, br.com.comex.dao.ClientesDAO, br.com.comex.dao.ItensPedidoDAO, br.com.comex.dao.PedidosDAO, br.com.comex.dao.ProdutosDAO.
Atualizado classes br.com.comex.modelo: Produto, Pedido, ItemPedido, Cliente, Categoria para funcionarem com as novas implementações de conexão com banco de dados.
Criado as relações com o banco de dados nas DAO. Atualizado modelos para funcionarem com os getters e setters necessários para a lógica das DAO.
Atualizado outros projetos para as lógicas corretas das DAO.

>>>BRX Semana 10 - Avançando nos Design Patterns e JAX-WS (17/10 - 21/10)

<h2>18/10/2022 - Criação do ComexWS com listagem de categorias e Publicação do ComexWS</h2>
Criação dos código-fonte br.com.comex.ws.ComexWS e br.com.comex.main.MainComexWS.
ComexWS anotado com @WebService. MainComexWS utilizando classe Endpoit para publicar o ComexWS no endereço http://localhost:8080/ComexWS.
Serviço no ar com url http://localhost:8080/ComexWS?wsdl.

<h2>18/10/2022 - Testando o ComexWS com o SOAP UI</h2>
Adicionado getCategorias.xml com o XML do resultado de getCategorias no SOAPUI utilizando o url http://localhost:8080/ComexWS?wsdl. 

<h2>18/10/2022 - Atualizando arquivo XML do projeto ComexWS com o SOAP UI</h2>
Deletado getCategorias.xml com o XML do resultado de getCategorias no SOAPUI utilizando o url http://localhost:8080/ComexWS?wsdl.
Adicionado ComexWS-soapui-project.xml com o XML do projeto.
Alterado nome da função getCategoria() para listarCategorias no código-fonte br.com.comex.ws.ComexWS.

<h2>19/10/2022 - Realizado mesmas atualizações da semana9</h2>
Atualizado todas as classes com as atualizações dos fontes da semana9.

<h2>21/10/2022 - Operação listarClientes no ComexWS</h2>
Adicionado método listarClientes no código-fonte br.com.comex.ws.ComexWS.

<h2>21/10/2022 - Operação de adicionarCliente no ComexWS</h2>
Adicionado método adicionarCliente no código-fonte br.com.comex.ws.ComexWS.
