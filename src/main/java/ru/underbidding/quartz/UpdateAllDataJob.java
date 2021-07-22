package ru.underbidding.quartz;

import java.io.IOException;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import ru.underbidding.main.AnrexInfo;
import ru.underbidding.main.BelsosnaRu;
import ru.underbidding.main.EkatMebelRu;
import ru.underbidding.main.MebellinerRu;
import ru.underbidding.main.MebelluxeCom;
import ru.underbidding.main.SmebelSu;
import ru.underbidding.main.TechshopRu;
import ru.underbidding.model.AnrexProduct;
import ru.underbidding.model.OtherProduct;
import ru.underbidding.service.AnrexProductService;
import ru.underbidding.service.OtherProductService;

public class UpdateAllDataJob implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		AnrexInfo anrexInfo = new AnrexInfo();
		SmebelSu smebelSu = new SmebelSu();
		EkatMebelRu ekatMebelRu = new EkatMebelRu();
		AnrexProductService anrexProductService = new AnrexProductService();
		OtherProductService otherProductService = new OtherProductService();
		List<AnrexProduct> listAnrexInfos = anrexProductService.getAllAnrexProducts();
		List<OtherProduct> listSmebelSu = otherProductService.getOtherProductsBySiteName("smebel.su");
		List<OtherProduct> listOtherProducts = otherProductService.getOtherProductsBySiteName("ekat-mebel.ru");
		
		
		for (AnrexProduct product : listAnrexInfos) {
			try {
				anrexInfo.updateAnrexProduct(product);
			} catch (IOException e) {
				System.out.println("---Exception--- UpdateAllData  AnrexProduct ---");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		for (OtherProduct smebelSuProduct : listSmebelSu) {
			try {
				smebelSu.updateSmebelSuProduct(smebelSuProduct);
			} catch (IOException e) {
				System.out.println("---Exception--- UpdateAllData  smebelSuProduct ---");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		for (OtherProduct listProducts : listOtherProducts) {
			ekatMebelRu.updateProduct(listProducts);
		}
		
		listOtherProducts = otherProductService.getOtherProductsBySiteName("mebelliner.ru");
		MebellinerRu mebellinerRu = new MebellinerRu();
		for (OtherProduct listProducts : listOtherProducts) {
			mebellinerRu.updateProduct(listProducts);
		}
		
		listOtherProducts = otherProductService.getOtherProductsBySiteName("belsosna.ru");
		BelsosnaRu belsosnaRu = new BelsosnaRu();
		for (OtherProduct listProducts : listOtherProducts) {
			belsosnaRu.updateProduct(listProducts);
		}
		
		listOtherProducts = otherProductService.getOtherProductsBySiteName("mebelluxe.com");
		MebelluxeCom mebelluxeCom = new MebelluxeCom();
		for (OtherProduct listProducts : listOtherProducts) {
			mebelluxeCom.updateProduct(listProducts);
		}
		
		listOtherProducts = otherProductService.getOtherProductsBySiteName("techshop.ru");
		TechshopRu techshopRu = new TechshopRu();
		for (OtherProduct listProducts : listOtherProducts) {
			techshopRu.updateProduct(listProducts);
		}
		
		
		
		System.out.println("UpdateAllDataJob");
		
	}

}
