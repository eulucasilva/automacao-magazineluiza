#language: pt
@BuscarProdutoInexistente @End2End
Funcionalidade: Buscar produto inexistente

  Contexto:
    Dado que o usuario esteja na pagina principal do sistema

  Cenario:
    Quando o usuario clica no campo Buscar e coloca produto inexistente e dar ENTER
    Entao o sistema traz a lista de produtos vazia
