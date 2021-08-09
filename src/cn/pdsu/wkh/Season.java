package cn.pdsu.wkh;

/**
 * @author wkh
 * @create 2021-06-20 16:51
 */
public class Season{

    // 1.所要枚举对象的属性
    private final String seasonName;
    private final String seasonDesc;
    // 2.把构造方法私有化并赋初始值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    // 3.在枚举类内部造出所有的枚举对象
    public static final Season Spring = new Season("春天","春暖花开");
    public static final Season Summer = new Season("夏天","夏日炎炎");
    public static final Season Fall = new Season("秋天","秋高气爽");
    public static final Season Winter = new Season("冬天","冷");

    // 4.重写toString()方法，输出正常字符串
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
