package biblioteca;

public class Livros {

	private String titulo;
    private String autor;
    private int numPaginas;
    private boolean disponivel;

    public Livros(String titulo, String autor, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestarLivro() {
        disponivel = false;
    }

    public void devolverLivro() {
        disponivel = true;
    }

    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
        sb.append("  Título: '").append(titulo).append("'\n");
        sb.append("  Autor: '").append(autor).append("'\n");
        sb.append("  Número de Páginas: ").append(numPaginas).append("\n");
        sb.append("  Disponível: ").append(disponivel ? "Sim" : "Não").append("\n");
        sb.append('}');
        return sb.toString();
    }
}

