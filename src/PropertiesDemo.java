public class PropertiesDemo {
    public static void main(String[] args) {

    }

    static class Square {
        private float sideLength;

        enum InitMode { SIDE, PERIMITER, AREA }

        public Square(float arg, InitMode initMode) {
            if (initMode == InitMode.SIDE) {
                this.sideLength = arg;
            } else if (initMode == InitMode.PERIMITER) {
                setPerimeter(arg);
            } else if (initMode == InitMode.AREA) {
                setArea(arg);
            }
        }

        public float getSideLength() {
            return sideLength;
        }

        public void setSideLength(float sideLength) {
            this.sideLength = sideLength;
        }

        public float getArea() {
            return sideLength * sideLength;
        }

        public void setArea(float area) {
            sideLength = (float) Math.sqrt(area);
        }

        public float getPerimeter() {
            return 4 * sideLength;
        }

        public void setPerimeter(float perimeter) {
            sideLength = perimeter / 4;
        }
    }
}
