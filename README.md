# Gerador de Cartões de Visita   <img src="https://github.com/alisonViana/business-card-bootcampInter/blob/master/images/icon.png" alt="ícone" width="48" height="48" />
Olá, este é o repositório do meu aplicativo Business Card, projeto desenvolvido para o Bootcamp Android Developer oferecido pela Digital Innovation One em parceria com o Inter.
O aplicativo consiste em um gerador de cartões de visita onde é possível inserir informações como nome, e-mail, telefone e empresa, além da possibilidade de escolher a cor de fundo destes cartões e compartilhá-los em aplicativos instalados no dispositivo.  O aplicativo faz uso do Room para persistência dos dados localmente e utiliza os princípios de MVVM.



 <p align="center"> 
     <img src="https://github.com/alisonViana/business-card-bootcampInter/blob/master/images/main.png" alt="Tela inicial" width="240" height="520" />
     <img src="https://github.com/alisonViana/business-card-bootcampInter/blob/master/images/add_card.png" alt="Tela novo cartão" width="240" height="520" /> 
</p>

<p align="center">
     [ Imagens: tela inicial e tela de novo cartão ]
</p>

Logo abaixo, está um exemplo de um card gerado no aplicativo.

 <p align="center"> 
     <img src="https://github.com/alisonViana/business-card-bootcampInter/blob/master/images/card_example.png" alt="Card exemplo" width="333" height="141" />
     <img src="https://github.com/alisonViana/business-card-bootcampInter/blob/master/images/share_card.png" alt="Tela de compartilhamento" width="240" height="520" /> 
</p>

<p align="center">
     [ Imagens: Card gerado pelo aplicativo e tela de compartilhamento ]
</p>


## Toque pessoal

A partir do projeto base desenvolvido durante o bootcamp, resolvi implementar algumas modificações. Elas agregam novas funcionalidades e tornam o uso mais dinâmico, alterando elementos do layout e as funções já existentes. Abaixo estão algumas delas.

### Color Picker

Desenvolvi e adicionei ao projeto um Color Picker, ele se apresenta como uma caixa de `alertDialog` e nele é possível selecionar, através da interação com 3 `seekBars` seguindo o padrão RGB, a cor de fundo do cartão. Optei por esse modelo por considerar mais intuitivo para o usuário.	Além da visualização prévia da cor, também é apresentada sua correspondência no formato hexadecimal.

 <p align="center"> 
     <img src="https://github.com/alisonViana/business-card-bootcampInter/blob/master/images/color_picker.png" alt="Tela de seleção de cor" width="240" height="520" />
</p>

<p align="center">
     [ Imagem: color picker ]
</p>




### Seleção de múltiplos cartões

Aqui, trouxe a função de selecionar múltiplos cartões através de um toque longo no item escolhido.

 <p align="center"> 
     <img src="https://github.com/alisonViana/business-card-bootcampInter/blob/master/images/selected_cards.png" alt="tela com múltiplos cartões selecionados" width="240" height="520" />
</p>

<p align="center">
     [ Imagem: seleção de mais de um cartão ]
</p>



### Barra de tarefas

Implementei uma espécie de toolbar dinâmica, ela só é apresentada quando algum item é selecionado, nela estão as funções de compartilhar, excluir e remover seleção, além de apresentar a quantidade de itens selecionados.

 <p align="center"> 
     <img src="https://github.com/alisonViana/business-card-bootcampInter/blob/master/images/toolbar.png" alt="Destaque toolbar" width="720" height="108" />
</p>

<p align="center">
     [ Imagem: destaque da barra de tarefas e suas funções ]
</p>



### Excluir

Outra função que optei por inserir, é a de exclusão dos cartões. Uma função simples, mas muito útil para o usuário em caso de erros ou modificações, mantendo a galeria limpa e prática.

 <p align="center"> 
     <img src="https://github.com/alisonViana/business-card-bootcampInter/blob/master/images/delete_card.png" alt="Alerta de exclusão de um cartão" width="240" height="520" />
     <img src="https://github.com/alisonViana/business-card-bootcampInter/blob/master/images/delete_cards.png" alt="Alerta de exclusão de múltiplos cartões" width="240" height="520" />
</p>

<p align="center">
     [ Imagem: alerta de exclusão de um cartão e alerta de exclusão de múltiplos cartões ]
</p>