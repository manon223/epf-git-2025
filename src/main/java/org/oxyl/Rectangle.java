package org.oxyl;

public class Rectangle {
    private double centreX, centreY, longueur, largeur, angle;

    public Rectangle(double centreX, double centreY, double longueur, double largeur, double angle) {
        this.centreX = centreX;
        this.centreY = centreY;
        setLongueur(longueur);
        setLargeur(largeur);
        this.angle = angle;
    }
    public Rectangle(){
        this.centreX = 0.0;
        this.centreY = 0.0;
        this.longueur = 1.0;
        this.largeur = 1.0;
        this.angle = 0.0;

    }
    public Rectangle(Rectangle copieRectangle){
        this.centreX = copieRectangle.centreX;
        this.centreY = copieRectangle.centreY;
        setLongueur(copieRectangle.longueur);
        setLargeur(copieRectangle.largeur);
        this.angle = copieRectangle.angle;
    }
    public double getCentreX() {
        return centreX;
    }
    public void setCentreX(double centreX) {
        this.centreX = centreX;
    }
    public double getCentreY() {
        return centreY;
    }
    public void setCentreY(double centreY) {
        this.centreY = centreY;
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
        this.centreX += distanceX;
        this.centreY += distanceY;

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

