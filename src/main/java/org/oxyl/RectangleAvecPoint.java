package org.oxyl;

public class RectangleAvecPoint {
    private Point centre;
    private double longueur, largeur, angle;

    public RectangleAvecPoint(Point centre, double longueur, double largeur, double angle) {
        this.centre= centre;
        setLongueur(longueur);
        setLargeur(largeur);
        this.angle = angle;
    }
    public RectangleAvecPoint(){
        this.centre=new Point(0.0,0.0);
        this.longueur = 1.0;
        this.largeur = 1.0;
        this.angle = 0.0;

    }
    public RectangleAvecPoint(RectangleAvecPoint copieRectangleAvecPoint){
        this.centre = copieRectangleAvecPoint.centre;
        setLongueur(copieRectangleAvecPoint.longueur);
        setLargeur(copieRectangleAvecPoint.largeur);
        this.angle = copieRectangleAvecPoint.angle;
    }
    public double getLongueur() {
        return longueur;
    }
    public void setLongueur(double longueur) {
        if(longueur>0.0){
            this.longueur = longueur;
        }
        else{
            this.longueur = 0.0;
        }
    }
    public double getLargeur() {
        return largeur;
    }
    public void setLargeur(double largeur) {
        if(largeur>0.0){
            this.largeur = largeur;
        }
        else{
            this.largeur = 0.0;
        }
    }
    public double getAngle() {
        return angle;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
    public void deplacer(double distanceX, double distanceY){
        double x=this.centre.getX();
        double y=this.centre.getY();
        this.centre.setX(x+distanceX);
        this.centre.setY(y+distanceY);

    }
    public boolean isCarre(){
        if (longueur==largeur){
            return true;
        }
        else{
            return false;
        }
    }
    public void redimensionner(double f){
        setLongueur(this.longueur*f);
        setLargeur(this.largeur*f);
    }
    public void tourner(double theta){
        this.angle += theta;
    }
}
