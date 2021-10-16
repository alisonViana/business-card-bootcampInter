# Gerador de Cartões de Visita
Olá, este é o repositório do meu aplicativo Business Card, projeto desenvolvido para o Bootcamp Android Developer oferecido pela Digital Innovation One em parceria com o Inter!
O aplicativo consiste em um gerador de cartões de visita onde é possível inserir informações como nome, e-mail, telefone e empresa, além da possibilidade de escolher a cor de fundo destes cartões e compartilhá-los em aplicativos instalados no dispositivo.  O aplicativo faz uso do Room para persistência dos dados localmente e utiliza os princípios de MVVM.

[Imagens: ícone, tela inicial e tela de adição]

## Toque pessoal

A partir do projeto base desenvolvido durante o bootcamp, resolvi implementar algumas modificações. Elas agregam novas funcionalidades e tornam mais dinâmico o uso, alterando elementos do layout e as funções já existentes. Abaixo estão algumas delas.

### Color Picker

Desenvolvi e adicionei ao projeto um Color Picker, ele se apresenta como uma caixa de `alertDialog` e nele é possível selecionar, através da interação com 3 `seekBars` seguindo o padrão RGB, a cor de fundo do cartão. Optei por esse modelo por considerar mais intuitivo para o usuário, além da visualização prévia da cor, também é apresentada sua correspondência no formato hexadecimal.
[ imagem: color Picker]

### Seleção de múltiplos cartões

Foi inserida a função de selecionar múltiplos cartões através de um toque longo no item escolhido.
[imagem: exemplo de cartões selecionados]

### Barra de tarefas

Implementei uma espécie de toolbar dinâmica, ela só é apresentada quando algum item é selecionado, nela estão as funções de compartilhar, excluir e remover seleção.
[Imagem: destaque na barra e suas funções]

### Excluir

Outra função que optei por inserir, é a de exclusão dos cartões. Uma função simples, mas muito útil para o usuário em caso de erros ou modificações, mantendo a galeria limpa e prática
[Imagem: toast de exclusão de cartão]