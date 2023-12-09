package assets.lib;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JTextArea;


public class Livro  {
    private String titulo;
    private String caminho;
    private String imagemBase64;


    public Livro(String titulo, String caminho, String imagemBase64) {
        this.titulo = titulo;
        this.caminho = caminho;
        this.imagemBase64 = imagemBase64;
    }
    //Sobrescrevi o método toString de forma a imprimir matricula e nome do aluno.
    @Override
    public String toString() {
        return "titulo = " + titulo +
                ", caminho = '" + caminho;
    }

    public String getTitulo() {
         return titulo;
     }

     public String getCaminho() {
         return caminho;
     }

     public String getImagemBase64() {
         return imagemBase64;
     }
     
    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public List<Livro> carregarLivros(String caminhoArquivo, String caminhoImagens) {
        List<Livro> livros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    String titulo = partes[1].trim();
                    String caminho = partes[0].trim();
                    String imagemBase64 = converterImagemBase64(caminhoImagens + File.separator + caminho);
                    System.out.println(imagemBase64);

                    Livro livro = new Livro(titulo, caminho, imagemBase64);
                    livros.add(livro);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return livros;
    }

    private String converterImagemBase64(String caminhoImagem) {
        try {
            BufferedImage imagem = ImageIO.read(new File(caminhoImagem));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(imagem, "jpg", baos);
            byte[] imageBytes = baos.toByteArray();
            return caminhoImagem;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

public static List<Livro> carregaLivros() {
    Livro livrosLoader = new Livro("","","");
    List<Livro> listaDeLivros = livrosLoader.carregarLivros("../TPA/assets/data/dirs.txt", "../TPA/assets/capas");

//    for (Livro livro : listaDeLivros) {
//        System.out.println("Título: " + livro.getTitulo());
//        System.out.println("Nome do Arquivo: " + livro.getCaminho());
//        System.out.println("Imagem em Base64: " + livro.getImagemBase64());
//    }
    return listaDeLivros;
}

}
