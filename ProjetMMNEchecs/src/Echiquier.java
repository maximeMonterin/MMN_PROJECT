import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Echiquier extends JComponent {
    private List<List<Piece>> plateau;
    public Echiquier() {
        plateau = new ArrayList<>();
        for(int i=0;i<8;i++){
            List<Piece> tmp = new ArrayList<>();
            plateau.add(tmp);
        }
        setPions();
        setTours();
        setCavaliers();
        setFous();
        setReines();
        setRois();
        setVides();
    }
    public void setPions(){
        for(int i=0;i<8;i++){
            plateau.get(1).add(new Pion(0,1, (char) ('A' + i) ));
            plateau.get(6).add(new Pion(1,6, (char) ('A' + i)));
        }
    }
    public void setTours(){
        plateau.get(0).add(new Tour(0, 0, 'A'));
        plateau.get(0).add(new Tour(0, 0, 'H'));
        plateau.get(7).add(new Tour(1, 7, 'A'));
        plateau.get(7).add(new Tour(1, 7, 'H'));
    }
    public void setCavaliers(){
        plateau.get(0).add(new Cavalier(0, 0, 'B'));
        plateau.get(0).add(new Cavalier(0, 0, 'G'));
        plateau.get(7).add(new Cavalier(1, 7, 'B'));
        plateau.get(7).add(new Cavalier(1, 7, 'G'));
    }
    public void setFous(){
        plateau.get(0).add(new Fou(0, 0, 'C'));
        plateau.get(0).add(new Fou(0, 0, 'F'));
        plateau.get(7).add(new Fou(1, 7, 'C'));
        plateau.get(7).add(new Fou(1, 7, 'F'));
    }
    public void setRois(){
        plateau.get(0).add(new Roi(0,0, 'E'));
        plateau.get(7).add(new Roi(1,7, 'E'));
    }
    public void setReines(){
        plateau.get(0).add(new Reine(0,0, 'D'));
        plateau.get(7).add(new Reine(1,7, 'D'));
    }
    public void setVides(){
        for(int i=0;i<8;i++){
            for(int j=2;j<6;j++){
                if(j%2==0){
                    plateau.get(j).add(new Vide(j, (char) ('A'+ i)));
                }else{
                    plateau.get(j).add(new Vide(j, (char) ('A'+ i)));
                }
            }
        }
    }
    public void paintComponent(Graphics g){
        Graphics2D plateauReel= (Graphics2D) g;

        int tailleCase = 90;
        boolean couleur=true;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (couleur) {
                    plateauReel.setPaint(Color.WHITE);
                } else {
                    plateauReel.setPaint(Color.BLACK);
                }
                plateauReel.fill(new Rectangle2D.Double((j+1)*tailleCase, (i+1)*tailleCase,tailleCase,tailleCase));
                couleur=!couleur;
            }
            couleur=!couleur;
        }

        for(int i=1;i<9;i++){
            plateauReel.setPaint(Color.BLACK);
            plateauReel.drawString("" + i,tailleCase/2, (int) (tailleCase*(10-i-0.5)));
        }

        for(int j=0;j<8;j++){
            plateauReel.setPaint(Color.BLACK);
            plateauReel.drawString(String.valueOf((char)('A'+ j)), (int) (tailleCase*(j+1.5)), (int) (tailleCase * 9.5));
        }

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
//                if(plateau.get(i).get(j)== intanceOFPion){
//                  plateauReel.drawImage();
//                }else if(plateau.get(i).get(j)== Tour){
//
//                }else if(plateau.get(i).get(j)== Cavalier){
//
//                }else if(plateau.get(i).get(j)== Fou){
//
//                }else if(plateau.get(i).get(j)== Roi){
//
//                }else if(plateau.get(i).get(j)== Reine){
//
//                }
            }
        }

        plateauReel.setPaint(Color.BLUE);
        plateauReel.setStroke(new BasicStroke(2));
        plateauReel.draw(new Rectangle2D.Double(tailleCase,tailleCase,tailleCase*8,tailleCase*8));
        plateauReel.dispose();
    }

}























