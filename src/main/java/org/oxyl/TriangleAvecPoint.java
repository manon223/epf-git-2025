package org.oxyl;

public class TriangleAvecPoint {
    private Point point1,point2,point3;
    public TriangleAvecPoint() {
        this.point1=new Point(0.0,0.0);
        this.point2=new Point(0.0,1.0);
        this.point3=new Point(0.5,0.5);
    }
    public TriangleAvecPoint(Point point1, Point point2, Point point3) {
        this.point1=point1;
        this.point2 = point2;
        this.point3 = point3;
        //hihi
        //haha
        //hoho
    }
    public TriangleAvecPoint(TriangleAvecPoint copieTriangle) {
        this.point1=copieTriangle.point1;
        this.point2=copieTriangle.point2;
        this.point3=copieTriangle.point3;
    }

    public void deplacer(double distanceX, double distanceY) {
        this.point1.setX(this.point1.getX()+distanceX);
        this.point1.setY(this.point1.getY()+distanceY);
        this.point2.setX(this.point2.getX()+distanceX);
        this.point2.setY(this.point2.getY()+distanceY);
        this.point3.setX(this.point3.getX()+distanceX);
        this.point3.setY(this.point3.getY()+distanceY);
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
        double barycentreX=(point1.getX()+point2.getX()+point3.getX())/3.0;
        double barycentreY=(point1.getY()+point2.getY()+point3.getY())/3.0;

        //2. Conversion de l'angle en radians
        double thetaradians=Math.toRadians(theta);
        double cosTheta=Math.cos(thetaradians);
        double sinTheta=Math.sin(thetaradians);

        // 3. Rotation de chaque point autour du barycentre et mise à jour des coordonnées
        point1.rotate(barycentreX, barycentreY, cosTheta, sinTheta);
        point2.rotate(barycentreX, barycentreY, cosTheta, sinTheta);
        point3.rotate(barycentreX, barycentreY, cosTheta, sinTheta);
    }
    public boolean isEquilateral() {
        // 1. Calcul des longueurs des côtés
        double side1 = point1.calculerDistance(point2);
        double side2 = point2.calculerDistance(point3);
        double side3 = point3.calculerDistance(point1);

        // 2. Arrondi des longueurs
        double roundedSide1 = Math.round(side1 * 100.0) / 100.0;
        double roundedSide2 = Math.round(side2 * 100.0) / 100.0;
        double roundedSide3 = Math.round(side3 * 100.0) / 100.0;

        // 3. Vérification si les trois longueurs sont égales
        return roundedSide1 == roundedSide2 && roundedSide2 == roundedSide3;
    }
}
