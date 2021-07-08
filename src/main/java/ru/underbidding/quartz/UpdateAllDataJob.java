package ru.underbidding.quartz;

import java.io.IOException;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import ru.underbidding.main.AnrexInfo;
import ru.underbidding.main.SmebelSu;
import ru.underbidding.model.AnrexProduct;
import ru.underbidding.model.OtherProduct;
import ru.underbidding.service.AnrexProductService;
import ru.underbidding.service.OtherProductService;

public class UpdateAllDataJob implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		AnrexInfo anrexInfo = new AnrexInfo();
		SmebelSu smebelSu = new SmebelSu();
		AnrexProductService anrexProductService = new AnrexProductService();
		OtherProductService otherProductService = new OtherProductService();
		List<AnrexProduct> listAnrexInfos = anrexProductService.getAllAnrexProducts();
		List<OtherProduct> listSmebelSu = otherProductService.getOtherProductsBySiteName("smebel.su");
		
		
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
		
	}

}
