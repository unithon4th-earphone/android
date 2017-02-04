package earphone.unithon4th.tripear.recyclerview;

/**
 * Created by android on 2017-02-04.
 */

public class ItemDatas {
    public int background;
    public String area;
    public String grade;

    public ItemDatas(int background, String area, String grade) {
        this.background = background;
        this.area = area;
        this.grade = grade;
    }

    public int getBackground() {
        return background;
    }

    public String getArea() {
        return area;
    }

    public String getGrade() {
        return grade;
    }
}
