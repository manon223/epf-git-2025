package org.oxyl;

public class CercleAvecPoint {
        private Point centre;
        private double rayon;


        public CercleAvecPoint(Point centre, double rayon) {
            this.centre=centre;
            setRayon(rayon);
        }
        public CercleAvecPoint() {
            this(new Point(0.0,0.0),1.0);

        }
        public CercleAvecPoint(CercleAvecPoint copieCercle){
            this.centre=copieCercle.centre;
            setRayon(copieCercle.rayon);
        }

        public double getRayon() {
            return rayon;
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
            double x=this.centre.getX();
            double y=this.centre.getY();
            this.centre.setX(x+distanceX);
            this.centre.setY(y+distanceY);

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
