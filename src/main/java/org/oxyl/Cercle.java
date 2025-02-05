package org.oxyl;

public class Cercle {
    //private Point centre;
    private double centreX;
    private double centreY;
    private double rayon;


    public Cercle(double centreX,double centreY, double rayon) {
        this.centreX=centreX;
        this.centreY=centreY;
        setRayon(rayon);
    }
    public Cercle(){
        this.centreX=0.0;
        this.centreY=0.0;
        this.rayon = 1.0;

    }
    public Cercle(Cercle copieCercle){
        this.centreX=copieCercle.centreX;
        this.centreY=copieCercle.centreY;
        setRayon(copieCercle.rayon);
    }

    public double getCentreX() {
        return centreX;
    }
    public double getCentreY() {
        return centreY;
    }
    public double getRayon() {
        return rayon;
    }
    public void setCentreX(double centreX) {
        this.centreX = centreX;
    }
    public void setCentreY(double centreY) {
        this.centreY = centreY;

    }
    public void setRayon(double rayon) {
        if(rayon>0.0){
            this.rayon = rayon;
        }
        else{
            this.rayon = 0.0;
        }
    }
    public void deplacer(double distanceX, double distanceY){
        this.centreX+=distanceX;
        this.centreY+=distanceY;
    }

    public boolean isGrand(){
        if (this.rayon>100){
            return true;
        }
        return false;
    }

    public void redimensionner(double f){
        setRayon(this.rayon*f);
    }
    public void tourner(double theta){
    }


}

