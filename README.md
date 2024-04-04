Projeto em Java feito na IDEA Intellij com possibilididade de uso em NetBeans.
Atividade para aprender sobre POO no curso de Ciências da Computação, 3º Período :)




Diagrama de classe a seguir utilizando a linguagem Java :
+------------------------------------------+
|                 LojaOnline               |
+------------------------------------------+
| - nome: String                           |
| - listaProdutos: List<Produto>           |
| - listaClientes: List<Cliente>           |
+------------------------------------------+
| + adicionarProduto(produto: Produto): void |
| + removerProduto(produto: Produto): void   |
| + adicionarCliente(cliente: Cliente): void |
| + removerCliente(cliente: Cliente): void   |
| + buscarProdutoPorNome(nome: String): Produto |
| + listarProdutos(): List<Produto>          |
| + buscarClientePorEmail(email: String): Cliente |
| + listarClientes(): List<Cliente>          |
| + realizarPedido(cliente: Cliente, produtos: List<Produto>): Pedido |
+------------------------------------------+

+------------------------------------------+
|                Produto                   |
+------------------------------------------+
| - id: int                                |
| - nome: String                           |
| - preco: double                          |
| - descricao: String                      |
+------------------------------------------+
| + getId(): int                           |
| + setId(id: int): void                   |
| + getNome(): String                      |
| + setNome(nome: String): void            |
| + getPreco(): double                     |
| + setPreco(preco: double): void          |
| + getDescricao(): String                 |
| + setDescricao(descricao: String): void  |
+------------------------------------------+

+------------------------------------------+
|                Cliente                   |
+------------------------------------------+
| - id: int                                |
| - nome: String                           |
| - email: String                          |
| - endereco: String                       |
+------------------------------------------+
| + getId(): int                           |
| + setId(id: int): void                   |
| + getNome(): String                      |
| + setNome(nome: String): void            |
| + getEmail(): String                     |
| + setEmail(email: String): void          |
| + getEndereco(): String                  |
| + setEndereco(endereco: String): void    |
+------------------------------------------+

+------------------------------------------+
|                 Pedido                   |
+------------------------------------------+
| - id: int                                |
| - cliente: Cliente                      |
| - produtos: List<Produto>                |
| - status: String                         |
+------------------------------------------+
| + getId(): int                           |
| + setId(id: int): void                   |
| + getCliente(): Cliente                  |
| + setCliente(cliente: Cliente): void     |
| + getProdutos(): List<Produto>           |
| + setProdutos(produtos: List<Produto>): void |
| + getStatus(): String                    |
| + setStatus(status: String): void        |
+------------------------------------------+
