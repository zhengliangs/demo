package com.zhengl.designmode.composite.safety;

/**
 * 安全的组合模式
 * @author hero良
 */
public class CompanyCompositeClient {

    public static void main(String[] args) {
        CompanyComposite company = new CompanyComposite(1, "总公司", 1);

        CompanyComponent cw = new CompanyLeaf(4, "财务部", 2);
        CompanyComponent rs = new CompanyLeaf(5, "人事部", 2);

        CompanyComposite tj = new CompanyComposite(2, "天津分公司", 2);
        CompanyComponent tjcw = new CompanyLeaf(6, "天津财务部", 3);
        CompanyComponent tjrs = new CompanyLeaf(7, "天津人事部", 3);

        CompanyComposite bj = new CompanyComposite(3, "北京分公司", 2);
        CompanyComponent bjcw = new CompanyLeaf(6, "北京财务部", 3);
        CompanyComponent bjrs = new CompanyLeaf(7, "北京人事部", 3);

        company.add(cw);
        company.add(rs);
        company.add(tj);
        company.add(bj);

        tj.add(tjcw);
        tj.add(tjrs);

        bj.add(bjcw);
        bj.add(bjrs);

        company.print();
    }
}
