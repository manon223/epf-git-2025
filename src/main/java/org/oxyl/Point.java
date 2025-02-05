package org.oxyl;

public class Point {
    private double x, y;
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    public Point(){
        this.x=0.0;
        this.y=0.0;
    }
    public Point(Point copiePoint){
        this.x=copiePoint.x;
        this.y=copiePoint.y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }
    public boolean equals(Object o){
        if(o instanceof Point){
            Point p=(Point)o;
            if(p.x==x && p.y==y){
                return true;
            }
            return false;
        }
        else{
            return false;
        }
    }
    public double calculerDistance(Point p){
        double l = Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
        return l;
    }
    public void rotate(double centerX, double centerY, double cosTheta, double sinTheta) {
        // 1. Translation au centre
        double translatedX = x - centerX;
        double translatedY = y - centerY;

        // 2. Rotation
        double rotatedX = translatedX * cosTheta - translatedY * sinTheta;
        double rotatedY = translatedX * sinTheta + translatedY * cosTheta;

        // 3. Retour à la position originale + arrondi
        x = Math.round((rotatedX + centerX) * 100.0) / 100.0;
        y = Math.round((rotatedY + centerY) * 100.0) / 100.0;
    }


}
