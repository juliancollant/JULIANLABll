package POO;

import java.util.ArrayList;
import java.util.List;

class libro {
    private String Titulo;
    private String Autor;
    private int Publicacion;

    public libro(String Titulo, String Autor, int Publicacion) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Publicacion = Publicacion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public int getPublicacion() {
        return Publicacion;
    }

    public void setPublicacion(int Publicacion) {
        this.Publicacion = Publicacion;
    }

    @Override
    public String toString() {
        return "Título: " + Titulo + ", Autor: " + Autor + ", Publicación: " + Publicacion;
    }
}

class LibroFisico extends libro {
    private int Paginas;
    private String Ubicacion;
    private int Copias;

    public LibroFisico(int Paginas, String Ubicacion, int Copias, String Titulo, String Autor, int Publicacion) {
        super(Titulo, Autor, Publicacion);
        this.Paginas = Paginas;
        this.Ubicacion = Ubicacion;
        this.Copias = Copias;
    }

    public int getPaginas() {
        return Paginas;
    }

    public void setPaginas(int Paginas) {
        this.Paginas = Paginas;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public int getCopias() {
        return Copias;
    }

    public void setCopias(int Copias) {
        this.Copias = Copias;
    }

    @Override
    public String toString() {
        return super.toString() + ", Páginas=" + Paginas + ", Ubicación=" + Ubicacion + ", Copias=" + Copias + '}';
    }
      public void prestarLibro() {
        if (Copias > 0) {
            Copias--;
            System.out.println("Se ha prestado una copia del libro " + getTitulo());
        } else {
            System.out.println("No hay copias disponibles del libro " + getTitulo());
        }
    }
}

class LibroDigital extends libro {
    private String Formato;
    private int Tamaño;

    public LibroDigital(String Formato, int Tamaño, String Titulo, String Autor, int Publicacion) {
        super(Titulo, Autor, Publicacion);
        this.Formato = Formato;
        this.Tamaño = Tamaño;
    }

    public String getFormato() {
        return Formato;
    }

    public void setFormato(String Formato) {
        this.Formato = Formato;
    }

    public int getTamaño() {
        return Tamaño;
    }

    public void setTamaño(int Tamaño) {
        this.Tamaño = Tamaño;
    }

    @Override
    public String toString() {
        return super.toString() + ", Formato=" + Formato + ", Tamaño=" + Tamaño + '}';
    }
}

class Biblioteca {
    private List<libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado a la biblioteca: " + libro.toString());
    }

    public void eliminarLibro(libro libro) {
        libros.remove(libro);
        System.out.println("Libro eliminado de la biblioteca: " + libro.toString());
    }

    public void mostrarInformacionLibros() {
        System.out.println("Información de los libros en la biblioteca:");
        for (libro libro : libros) {
            System.out.println(libro.toString());
        }
    }

    public void buscarLibroPorTitulo(String titulo) {
        System.out.println("Búsqueda del libro por título: " + titulo);
        boolean encontrado = false;
        for (libro libro : libros) {
            if (libro instanceof LibroFisico && libro.toString().contains(titulo)) {
                System.out.println(libro.toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún libro con ese título.");
        }
    }
}

class Libros{
    public static void main(String[] args) {
    Biblioteca biblioteca = new Biblioteca();

    libro libro1 = new LibroFisico(200, "Estantería 1", 3, "El principito", "Antoine de Saint-Exupéry", 1943);
    libro libro2 = new LibroDigital("PDF", 1024, "Clean Code", "Robert C. Martin", 2008);
    libro libro3 = new LibroFisico(300, "Estantería 2", 2, "1984", "George Orwell", 1949);
    libro libro4 = new LibroDigital("EPUB", 512, "Cien años de soledad", "Gabriel García Márquez", 1967);

    biblioteca.agregarLibro(libro1);
    biblioteca.agregarLibro(libro2);
    biblioteca.agregarLibro(libro3);
    biblioteca.agregarLibro(libro4);

    biblioteca.mostrarInformacionLibros();
    biblioteca.buscarLibroPorTitulo("principito");

    ((LibroFisico) libro1).prestarLibro();

    biblioteca.eliminarLibro(libro1);

    biblioteca.mostrarInformacionLibros();
}

}
