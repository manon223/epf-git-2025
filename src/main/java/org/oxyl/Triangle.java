package org.oxyl;

public class Triangle {
    private double x1,y1,x2,y2,x3,y3;
    public Triangle() {
        this.x1 = 0.00;
        this.y1 = 0.00;
        this.x2 = 0.00;
        this.y2 = 1.00;
        this.x3 = 0.50;
        this.y3 = 0.50;
    }
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }
    public Triangle(Triangle copieTriangle) {
        this.x1 = copieTriangle.x1;
        this.y1 = copieTriangle.y1;
        this.x2 = copieTriangle.x2;
        this.y2 = copieTriangle.y2;
        this.x3 = copieTriangle.x3;
        this.y3 = copieTriangle.y3;
    }
    public double getX1() {
        return x1;
    }
    public void setX1(double x1) {
        this.x1 = x1;
    }
    public double getY1() {
        return y1;
    }
    public void setY1(double y1) {
        this.y1 = y1;
    }
    public double getX2() {
        return x2;
    }
    public void setX2(double x2) {
        this.x2 = x2;
    }
    public double getY2() {
        return y2;
    }
    public void setY2(double y2) {
        this.y2 = y2;
    }
    public double getX3() {
        return x3;
    }
    public void setX3(double x3) {
        this.x3 = x3;
    }
    public double getY3() {
        return y3;
    }
    public void setY3(double y3) {
        this.y3 = y3;
    }
    public void deplacer(double distanceX, double distanceY) {
        this.x1 = this.x1 + distanceX;
        this.y1 = this.y1 + distanceY;
        this.x2 = this.x2 + distanceX;
        this.y2 = this.y2 + distanceY;
        this.x3 = this.x3 + distanceX;
        this.y3 = this.y3 + distanceY;
    }

    private double[] rotatePoint( double x,double y,double centreX, double centreY,double cosTheta, double sinTheta){
        //1. Translation au centre
        double translatedX=x-centreX;
        double translatedY=y-centreY;
        //2. Rotation
        double rotatedX=translatedX*cosTheta-translatedY*sinTheta;
        double rotatedY=translatedX*sinTheta+translatedY*cosTheta;
        //3. Retour à la position originale +arrondi
        double finalX=Math.round((rotatedX+centreX)*100.0)/100.0;
        double finalY=Math.round((rotatedY+centreY)*100.0)/100.0;
        return new double[]{finalX,finalY};
    }
    public void tourner(double theta){
        //1. calcul du barycentre:
        double barycentreX=(x1+x2+x3)/3.0;
        double barycentreY=(y1+y2+y3)/3.0;

        //2. Conversion de l'angle en radians
        double thetaradians=Math.toRadians(theta);
        double cosTheta=Math.cos(thetaradians);
        double sinTheta=Math.sin(thetaradians);

        //3. Rotation de chaque point autour du barycentre et mise à jour des coordonnées:
        double[] newCoords1=rotatePoint(x1,y1,barycentreX,barycentreY,cosTheta,sinTheta);
        x1=newCoords1[0];
        y1=newCoords1[1];
        double[] newCoords2=rotatePoint(x2,y2,barycentreX,barycentreY,cosTheta,sinTheta);
        x2=newCoords2[0];
        y2=newCoords2[1];
        double[] newCoords3=rotatePoint(x3,y3,barycentreX,barycentreY,cosTheta,sinTheta);
        x3=newCoords3[0];
        y3=newCoords3[1];
    }
    public boolean isEquilateral() {
        // Calcul des longueurs des côtés avec la distance euclidienne
        double l1 = Math.sqrt(Math.pow(this.x1 - this.x2, 2) + Math.pow(this.y1 - this.y2, 2));
        double l2 = Math.sqrt(Math.pow(this.x2 - this.x3, 2) + Math.pow(this.y2 - this.y3, 2));
        double l3 = Math.sqrt(Math.pow(this.x3 - this.x1, 2) + Math.pow(this.y3 - this.y1, 2));

        // Arrondir les longueurs à 2 décimales
        l1 = Math.round(l1 * 100.0) / 100.0;
        l2 = Math.round(l2 * 100.0) / 100.0;
        l3 = Math.round(l3 * 100.0) / 100.0;

        // Vérifier si les trois côtés sont égaux après l'arrondi
        return (l1 == l2) && (l2==l3);
    }


}

