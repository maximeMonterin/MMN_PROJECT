import java.util.List;

public class Roi extends Piece{
    private int couleur;
    private int posx;
    private char posy;

    public Roi(int couleur, int posx, char posy) {
        super(new Case(posx, posy));
        this.couleur = couleur;
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    public List<Case> mouvement(Case case_de_la_piece) {
        return null;
    }

    @Override
    public void manger() {

    }
}
