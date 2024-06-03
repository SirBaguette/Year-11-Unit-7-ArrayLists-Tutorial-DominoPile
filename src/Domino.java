public class Domino implements Comparable<Domino> {
    private int top;
    private int bottom;

    public Domino(int a, int b) {
        top = a;
        bottom = b;
    }

    public Domino() {
        top = 0;
        bottom = 0;
    }

    public void flip() {
        int temp = top;
        top = bottom;
        bottom = temp;
    }

    public void settle() {
        if (top > bottom) {
            flip();
        }
    }

    public int compareTo(Domino other) {
        int smT = Math.min(top, bottom);
        int smO = Math.min(other.top, other.bottom);

        if (smT < smO) {
            return -1;
        } else if (smT > smO) {
            return 1;
        } else {
            int XL = Math.max(top, bottom);
            int XXL = Math.max(other.top, other.bottom);

            if (XL < XXL) {
                return -1;
            } else if (XL > XXL) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int compareToWeight(Domino other) {
        int thisWeight = top + bottom;
        int otherWeight = other.top + other.bottom;

        if (thisWeight < otherWeight) {
            return -1;
        } else if (thisWeight > otherWeight) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setTop(int a) {
        top = a;
    }

    public void setBottom(int a) {
        bottom = a;
    }

    public boolean canConnect(Domino other) {
        return (top == other.top || bottom == other.bottom || top == other.bottom || bottom == other.top);
    }
}