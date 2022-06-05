package Model.backgroundInfo;

import java.util.ArrayList;

public class BackgroundInfoListImpl implements BackgroundInfoList {

	private ArrayList<BackgroundInfo> backgroundInformationList;
	
	public BackgroundInfoListImpl() {
		backgroundInformationList = new ArrayList<BackgroundInfo>();
	}

	public void finalize() throws Throwable {

	}
	
	@Override
	public boolean add(BackgroundInfo backgroundInformation) {
		// TODO Auto-generated method stub
		for(BackgroundInfo exInsuranceProductDevelopmentInformation : backgroundInformationList) {
			if(exInsuranceProductDevelopmentInformation.getInformationID().equals(backgroundInformation.getInformationID()))
				return false;
		}
		boolean result = backgroundInformationList.add(backgroundInformation);
		return result;
	}

	@Override
	public boolean delete(String insuranceProductDevelopmentInformationID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BackgroundInfo get(String insuranceProductDevelopmentInformationID) {
		// TODO Auto-generated method stub
		int index = indexOf(insuranceProductDevelopmentInformationID);
		if(index != -1) return backgroundInformationList.get(index);
		return null;
	}

	private int indexOf(String insuranceProductDevelopmentInformationID) {
		for(int i = 0; i < backgroundInformationList.size(); i++) {
			if(backgroundInformationList.get(i).getInformationID().equals(insuranceProductDevelopmentInformationID))
				return i;
		}
		return -1;
	}

}