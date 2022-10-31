select livro.ISBN, livro.Titulo, livro.Ano, editora.Nome_editora, autor.Nome, categoria.TipoCategoria 
from livro,editora,categoria, autor, livroautor
where livro.fk_editora = editora.IdEditora 
and livro.fk_categoria = categoria.IdCategoria
and livroautor.fk_livro = livro.ISBN 
and livroautor.fk_autor = autor.IdAutor
and categoria.TipoCategoria like 'Literatura%'
order by livro.Ano;