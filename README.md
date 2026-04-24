# Sistema de *match* imobiliário por similaridade

Linguagem: Java
Banco de dados: (arquivo? banco de dados relacional?)
Documentação: disponível no arquivo *documentacao.pdf*

## Descrição

O sistema de *match* imobiliário por similaridade realiza buscas por similaridade, identificando os imóveis com melhor compatibilidade com o perfil do comprador.

- Permite a criação personalizada de perfis de compra de imóveis por parte do
usuário.
- Lê dados de imóveis previamente cadastrados em um *banco de dados*.


### Variáveis de busca

As variáveis base para o cálculo da distância entre perfil de comprador e imóvel
são:
- Faixa de preço do imóvel
- Área aproximada do imóvel
- Número de quartos
- Cômodos no imóvel
