public class Libro {
    private String titulo;
    private String autor;
    private int paginas;

    public Libro() {
    }

    // Getter&Setter
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setPaginas(int numero) {
        this.paginas = numero * 7;
    }
    public int getPaginas() {
        return paginas;
    }

        //Metodo
    public void imprimirDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Páginas: " + paginas);
    }
}
