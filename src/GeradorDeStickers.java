import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradorDeStickers {

    public void cria(InputStream inputStream, String nomeDoArquivo) throws Exception {
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        int width = imagemOriginal.getWidth();
        int height = imagemOriginal.getHeight();

        int novaAltura = height + 350;

        BufferedImage novaImagem = new BufferedImage(width, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D Graphics = (Graphics2D) novaImagem.getGraphics();
        Graphics.drawImage(imagemOriginal, 0, 0, null);

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 250);
        Graphics.setColor(Color.ORANGE);
        Graphics.setFont(fonte);

        Graphics.drawString("Precioso", 20, novaAltura - 50);

        ImageIO.write(novaImagem, "png", new File(nomeDoArquivo));
    }
}

