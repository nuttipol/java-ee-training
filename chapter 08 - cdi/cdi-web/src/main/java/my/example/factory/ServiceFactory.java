package my.example.factory;

import my.example.service.NameServiceable;
//import my.example.service.impl.ConcatService;
//import my.example.service.impl.OperatorService;

public class ServiceFactory {

	public NameServiceable getService(String name) {
//		if (name == null) {
//			return null;
//		}else if (name.equalsIgnoreCase("concat")) {
//			return new ConcatService();
//		} else if (name.equalsIgnoreCase("operator")) {
//			return new OperatorService();
//		}else {
			return null;
//		}
	}
}
