package companyOA.Interview.intraLink;

class calculateAngle {
    //'07:30' hh:mm- find angle

    public static void main(String[] args) {
        System.out.println(calcAngle(7, 30) + "degree");
    }

    private static int calcAngle(int h, int m) {
        //validating invalid input
        if(h < 0 || m<0 || h>12||m>60) {
            System.out.println("Invalid");
        }

        if(h == 12) {
            h=0;
            if(m == 60) {
                m = 0;
                h += 1;
                if(h > 12) {
                    h -= 12;
                }
            }
        }

        //refernce to 12:00
        int hr_ang = (int)(0.5 * (h * 60 +m));
        int min_ang = 6*m;

        int angle = Math.abs(hr_ang - min_ang);

        angle = Math.min(360-angle, angle);

        return angle;
    }
}