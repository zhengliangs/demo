package com.zhengl.designmode.composite.transparent;

/**
 * 组合模式
 * @author hero良
 */
public class ClientComposite {

    public static void main(String[] args) {
        //创建菜单
        MenuComponent cd = new MenuComposite("菜单", " 本店菜单 ");
        //创建菜单
        MenuComponent hot = new MenuComposite("热菜", " 这是热菜菜单 ");
        MenuComponent cool = new MenuComposite("凉菜", " 这是凉菜菜单 ");

        //菜单项
        MenuComponent szy = new MenuItem("水煮鱼" , " 这是水煮鱼", false, 55);
        MenuComponent xr = new MenuItem("虾仁" , " 这是虾仁", false, 45);
        MenuComponent ybc = new MenuItem("酱爆洋白菜" , " 这是酱爆洋白菜", true, 23);

        MenuComponent phg = new MenuItem("拍黄瓜" , " 这是拍黄瓜", true, 12);
        MenuComponent qrg = new MenuItem("情人果" , " 这是情人果", true, 20);

        //将菜单项添加到菜单中
        hot.add(szy);
        hot.add(xr);
        hot.add(ybc);

        cool.add(phg);
        cool.add(qrg);

        cd.add(hot);
        cd.add(cool);

        cd.print();
    }
}
