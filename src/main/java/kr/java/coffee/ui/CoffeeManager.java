package kr.java.coffee.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kr.java.coffee.service.ProductService;
import kr.java.coffee.service.SaleService;
import kr.java.coffee.ui.content.ProductTablePanel;
import kr.java.coffee.ui.content.SaleDetailTablePanel;
import kr.java.coffee.ui.content.SaleTablePanel;

public class CoffeeManager extends JFrame {

	private JPanel contentPane;

	public CoffeeManager() {
		initComponent();
	}

	private void initComponent() {
		setTitle("프랜차이즈 커피전문점 관리 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel topTable = new JPanel();
		contentPane.add(topTable);
		topTable.setLayout(new GridLayout(0, 2, 0, 0));
		
		ProductTablePanel pdtTable = new ProductTablePanel();
		pdtTable.loadData(ProductService.getInstance().selectProductAll());
		pdtTable.setBorder(new TitledBorder(null, "\uC81C\uD488", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		topTable.add(pdtTable);
		
		SaleTablePanel  saleTable = new SaleTablePanel();
		saleTable.loadData(SaleService.getInstance().selectSaleByAll());
		topTable.add(saleTable);
					

		SaleDetailTablePanel  salePriceRankTable = new SaleDetailTablePanel(true);
		Map<String, Boolean> map = new HashMap<>();
		map.put("isSalePrice", true);
		salePriceRankTable.loadData(SaleService.getInstance().callSaleDetail(map));
		contentPane.add(salePriceRankTable);
					
		SaleDetailTablePanel  marginPriceRankTable = new SaleDetailTablePanel(false);
		map.put("isSalePrice", false);
		marginPriceRankTable.loadData(SaleService.getInstance().callSaleDetail(map));
		contentPane.add(marginPriceRankTable);
					

		/*
		JPanel saleTable = new JPanel();
		saleTable.setBorder(new TitledBorder(null, "\uD310\uB9E4\uD604\uD669", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		topTable.add(saleTable);

		JPanel salePriceRankTable = new JPanel();
		salePriceRankTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uD310\uB9E4\uAE08\uC561 \uC21C\uC704", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(salePriceRankTable);

		JPanel marginPriceRankTable = new JPanel();
		marginPriceRankTable.setBorder(new TitledBorder(null, "\uB9C8\uC9C4\uC561 \uC21C\uC704", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(marginPriceRankTable);
		*/
	}

}
