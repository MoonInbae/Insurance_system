package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.accident.Accident;
import Model.accident.AccidentListImpl;
import Model.application.Application;
import Model.application.ApplicationListImpl;
import Model.backgroundInfo.BackgroundInfo;
import Model.backgroundInfo.BackgroundInfoListImpl;
import Model.contract.Contract;
import Model.contract.ContractListImpl;
import Model.customer.Customer;
import Model.customer.CustomerListImpl;
import Model.insurance.BuildingFireInsurance;
import Model.insurance.ForestFireInsurance;
import Model.insurance.IndustryFireInsurance;
import Model.insurance.Insurance;
import Model.insurance.InsuranceListImpl;
import Model.insuranceDesign.InsuranceDesign;
import Model.insuranceDesign.InsuranceDesignListImpl;
import Model.userInfo.UserInfo;
import Model.userInfo.UserInfoListImpl;
import enumeration.EDesignForm;
import enumeration.EPlanningForm;
import enumeration.EProductSalesSupportDetails;

/**
 * @author dlsqo
 * @version 1.0
 * @created 16-5-2022 ���� 2:40:57
 */
public class Controller {

	private int customerID;
	private ArrayList<Customer> customerList;
	private ArrayList<Insurance> insuranceList;
	public CustomerListImpl m_CustomerListImpl;
	public InsuranceListImpl m_InsuranceListImpl;
	public AccidentListImpl m_AccidentListImpl;
	// public CompensationManagementListImpl m_CompensationManagementListImpl;
	// 삭제(22.06.03)
	public ContractListImpl m_ContractListImpl;
	public ApplicationListImpl m_ApplicationListImpl;
	private InsuranceDesign m_InsuranceDesign;
	private InsuranceDesignListImpl m_InsuranceDesignListImpl;
//	private BackgroundInformationListImpl m_InsuranceProductDevelopmentInformationListImpl;
	private BackgroundInfoListImpl m_BackgroundInfoListImpl;
	private UserInfoListImpl m_UserInfoListImpl;
	// 새로 만든 속성(22.06.03)

	// private ArrayList<ApplicationForMembership> passedCustomerList;
	// 새로 만든 속성 -> 삭제(22-05-31)
	// private ArrayList<Insurance> submitInsList;
	// 새로 만든 속성 -> 삭제(22.06.01)
	// private Insurance selectedIns;
	// 새로 만든 속성 -> 삭제(22.06.01)
	// Impl들 모두 private으로 바꿀 것
	// private ArrayList<Contract> extOneMonthList;
	// 삭제(22.06.01)

	public Controller() {
		this.m_CustomerListImpl = new CustomerListImpl();
		this.m_AccidentListImpl = new AccidentListImpl();
		this.m_ContractListImpl = new ContractListImpl();
		this.m_ApplicationListImpl = new ApplicationListImpl();
		this.m_InsuranceListImpl = new InsuranceListImpl();
		this.m_InsuranceDesignListImpl = new InsuranceDesignListImpl();
		this.m_UserInfoListImpl = new UserInfoListImpl();

		this.m_InsuranceListImpl.add(new BuildingFireInsurance("0", "건물 화재 보험"));
		this.m_InsuranceListImpl.getAll().get(m_InsuranceListImpl.getSize() - 1)
				.setId(m_InsuranceListImpl.getSize() + "");
		this.m_InsuranceListImpl.add(new ForestFireInsurance("1", "산악 화재 보험"));
		this.m_InsuranceListImpl.getAll().get(m_InsuranceListImpl.getSize() - 1)
				.setId(m_InsuranceListImpl.getSize() + "");
		this.m_InsuranceListImpl.add(new IndustryFireInsurance("2", "일반 화재 보험"));
		this.m_InsuranceListImpl.getAll().get(m_InsuranceListImpl.getSize() - 1)
				.setId(m_InsuranceListImpl.getSize() + "");
		this.m_CustomerListImpl.add(
				new Customer(24, 112233, true, "유민재", "010-3737-2855", "112233-4556677", "dbalsend", "Godyell713", "대학생"));
		this.m_CustomerListImpl.getAll().get(m_CustomerListImpl.getSize() - 1).setId(m_CustomerListImpl.getSize() + "");
		this.m_CustomerListImpl
				.add(new Customer(24, 123456, true, "이상원", "010-3737-2855", "123456-1234567", "tkddnjs", "Godyell99", "학생"));
		this.m_CustomerListImpl.getAll().get(m_CustomerListImpl.getSize() - 1).setId(m_CustomerListImpl.getSize() + "");
		this.m_CustomerListImpl
				.add(new Customer(24, 112234, true, "김일주", "010-3737-2855", "112234-5677889", "gPrud", "hk9126", "교수"));
		this.m_CustomerListImpl.getAll().get(m_CustomerListImpl.getSize() - 1).setId(m_CustomerListImpl.getSize() + "");
		this.m_CustomerListImpl
				.add(new Customer(24, 135799, true, "김정호", "010-3737-2855", "135799-2468024", "wjdgh", "2011", "교수"));
		this.m_CustomerListImpl.getAll().get(m_CustomerListImpl.getSize() - 1).setId(m_CustomerListImpl.getSize() + "");
		this.m_ApplicationListImpl.add(
				new Application("건물 화재 보험", "010-3737-2855", "24", true, "유민재", "대학생", "112233-4556677"));
		this.m_ApplicationListImpl.add(
				new Application("산악 화재 보험", "010-3737-2855", "24", true, "황혜경", "대학생", "112234-5677889"));
		this.m_ApplicationListImpl.add(
				new Application("일반 화재 보험", "010-3737-2855", "24", true, "유철민", "대학생", "123456-1234567"));
		this.m_ApplicationListImpl.add(
				new Application("산악 화재 보험", "010-3737-2855", "24", true, "유민재", "대학생", "112233-4556677"));
		this.m_ApplicationListImpl.add(
				new Application("일반 화재 보험", "010-3737-2855", "24", true, "유민재", "대학생", "112233-4556677"));
		this.m_ApplicationListImpl.get(0).setUWProceed(true);
		this.m_ApplicationListImpl.get(1).setUWProceed(true);
		this.m_ApplicationListImpl.get(4).setUWProceed(true);
		this.m_ApplicationListImpl.get(0).setUWResult(true);
		this.m_ApplicationListImpl.get(1).setUWResult(true);
		this.m_ApplicationListImpl.get(4).setUWResult(true);
		// 가입 신청 및 인수심사 합격 설정 경우 임시 생성
		this.m_UserInfoListImpl.add(new UserInfo("장민우", "alsdn", "6016", true));
		this.m_UserInfoListImpl.getAll().get(m_UserInfoListImpl.getSize() - 1)
				.setId(m_UserInfoListImpl.getSize() + "");
		this.m_UserInfoListImpl.add(new UserInfo("문인배", "dlsqo", "6020", true));
		this.m_UserInfoListImpl.getAll().get(m_UserInfoListImpl.getSize() - 1)
				.setId(m_UserInfoListImpl.getSize() + "");
		this.m_UserInfoListImpl.add(new UserInfo("임건영", "rjsdud", "6019", true));
		this.m_UserInfoListImpl.getAll().get(m_UserInfoListImpl.getSize() - 1)
				.setId(m_UserInfoListImpl.getSize() + "");
		this.m_UserInfoListImpl.add(new UserInfo("유민재", "dbalsend", "Godyell713", false));
		this.m_UserInfoListImpl.getAll().get(m_UserInfoListImpl.getSize() - 1)
				.setId(m_UserInfoListImpl.getSize() + "");
		this.m_UserInfoListImpl.add(new UserInfo("김정호", "wjdgh", "2011", false));
		this.m_UserInfoListImpl.getAll().get(m_UserInfoListImpl.getSize() - 1)
				.setId(m_UserInfoListImpl.getSize() + "");
		this.m_UserInfoListImpl.add(new UserInfo("유철민", "cjfals", "Godyell99", false));
		this.m_UserInfoListImpl.getAll().get(m_UserInfoListImpl.getSize() - 1)
				.setId(m_UserInfoListImpl.getSize() + "");
		this.m_UserInfoListImpl.add(new UserInfo("황혜경", "gPrud", "hk9126", false));
		this.m_UserInfoListImpl.getAll().get(m_UserInfoListImpl.getSize() - 1)
				.setId(m_UserInfoListImpl.getSize() + "");
		// 로그인 시 로그인 테이블 사용자 임시 생성
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param insurance
	 * @param phoneNum
	 * @param age
	 * @param gender
	 * @param name
	 * @param job
	 * @param SSN
	 */
	public boolean applyForMembership(String insurance, String phoneNum, String age, boolean gender, String name,
			String jop, String SSN) {
		// 가입 신청을 한다 - 가입 신청하기
		// 반환형 변경(void -> boolean)
		if (!checkInputInformation(insurance, phoneNum, age, SSN, name, jop))
			return false;
		boolean result = m_ApplicationListImpl
				.add(new Application(insurance, phoneNum, age, gender, name, jop, SSN));
		return result;
		// 입력 고객 정보 저장까지 포함
	}

	/**
	 * 
	 * @param id
	 * @param isOwnedBuilding
	 * @param isRemodeling
	 * @param buildingAgeScore
	 * @param fireEquipmentConditionScore
	 * @param buildingLocationScore
	 * @param buildingConditionScore
	 */
	public boolean automaticJudge(String id, boolean isOwnedBuilding, boolean isRemodeling,
			int buildingAgeScore, int fireEquipmentConditionScore, int buildingLocationScore,
			int buildingConditionScore) {
		// 자동 심사를 진행한다 - 인수심사 진행하기
		// id는 지워도 될 듯?? 가입 신청한 보험에 따라 인수심사 기준을 다르게 두려는 건데 우선 인수심사 기준이 70점 이상 하나라서 현재는
		// 의미 없음
		// 인수심사 기준이 여러개 생기면 가입신청 정보의 신청 보헝 이름에 따라 인수심사 기준을 다르게 두어야 함
		if (!isOwnedBuilding)
			return false;
		int remodelPoint = isOwnedBuilding ? 0 : 20; // 리모델 점수 다시 확인해 볼 것
		int totalPoint = remodelPoint + buildingAgeScore + fireEquipmentConditionScore + buildingLocationScore
				+ buildingConditionScore;
		if (totalPoint < 70)
			return false;
		return true;
	}

	public boolean checkAlreadyJudged(String id) {
		return m_ApplicationListImpl.get(id).isUWProceed();
	}

	public boolean checkInID(String id) {
		// 새로 만든 함수
		return m_ApplicationListImpl.checkInID(id);
	}

	public boolean checkPointInput(int buildingAgeScore, int fireEquipmentConditionScore,
			int buildingLocationScore, int buildingConditionScore) {
		// 새로 만든 함수
		if (!(buildingAgeScore >= 0 && buildingAgeScore <= 20))
			return false;
		if (!(fireEquipmentConditionScore >= 0 && fireEquipmentConditionScore <= 20))
			return false;
		if (!(buildingLocationScore >= 0 && buildingLocationScore <= 20))
			return false;
		if (!(buildingConditionScore >= 0 && buildingConditionScore <= 20))
			return false;
		return true;
	}

	/**
	 * 
	 * @param amountOfInsuranceFee
	 */
	// public boolean checkAmountOfInsuranceFee(int amountOfInsuranceFee, Contract
	// selectedContract){
	// // 납입 금액 이상 입력 유무 확인한다 - 보험료 납입하기
	// // 파라미터 변경 int -> int int
	// // 삭제(22.06.03)
	// return false;
	// }

	// public boolean checkAlreadyPay(int choice) {
	// // 새로 만든 함수 - 이미 납입했는지 확인 - 보험료 납입하기
	// // 삭제(22.06.03)
	// return false;
	// }

	/**
	 * 
	 * @param date
	 */
	public boolean checkInputDateFormat(String date) {
		// 입력 날짜형식을 확인하기(반환형 변경 String -> boolean)
		// private -> public
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			format.setLenient(false);
			format.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param insurance
	 * @param phoneNum
	 * @param age
	 * @param gender
	 * @param name
	 * @param job
	 */
	private boolean checkInputInformation(String insurance, String phoneNum, String age, String citizenNum, String name,
			String jop) {
		// 입력 정보를 확인한다 - 가입 신청하기
		// 파라미터(성별 -> 주민번호)
		// 이름 변경(Im -> In)
		if (!checkKoreanFormat(name)) return false;
		if (!checkKoreanFormat(insurance)) return false;
		if (!checkPhoneNumFormat(phoneNum)) return false;
		if (!(Integer.parseInt(age) > 0 && Integer.parseInt(age) < 120)) return false;
		if (!checkKoreanFormat(jop)) return false;
		if (!checkCitizenNumFormat(citizenNum)) return false;
		return true;
	}

	private boolean checkKoreanFormat(String input) {
		// 새로 만든 함수(한글만 존재하는지 확인)
		if (input.matches(".*[가-힣]+.*")
				&& !input.matches(".*[ㄱ-ㅎㅏ-ㅣ]+.*")
				&& !input.matches(".*[a-zA-Z]+.*")
				&& !input.matches(".*[0-9]+.*")
				&& !input.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*"))
			return true;
		return false;
	}

	public boolean checkPhoneNumFormat(String input) {
		// 새로 만든 함수(휴대폰 번호만 유효 ex010-3737-2855)
		// scope변경(private -> public)
		if (input.length() != 13) return false;
		if (input.charAt(3) != '-' || input.charAt(8) != '-') return false;
		if (!input.substring(0, 3).equals("010")) return false;
		if (input.substring(4, 8).matches(".*[가-힣]+.*")
				|| input.substring(4, 8).matches(".*[ㄱ-ㅎㅏ-ㅣ]+.*")
				|| input.substring(4, 8).matches(".*[a-zA-Z]+.*")
				|| input.substring(4, 8).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*"))
			return false;
		if (input.substring(9, 13).matches(".*[가-힣]+.*")
				|| input.substring(9, 13).matches(".*[ㄱ-ㅎㅏ-ㅣ]+.*")
				|| input.substring(9, 13).matches(".*[a-zA-Z]+.*")
				|| input.substring(9, 13).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*"))
			return false;
		return true;
	}

	public boolean checkCitizenNumFormat(String input) {
		// 새로 만든 함수 (private -> public)
		if (input.length() != 14) return false;
		if (input.charAt(6) != '-') return false;
		if (!(input.charAt(7) == '1'
				|| input.charAt(7) == '2'
				|| input.charAt(7) == '3'
				|| input.charAt(7) == '4')) return false;
		if (input.substring(0, 6).matches(".*[가-힣]+.*")
				|| input.substring(0, 6).matches(".*[ㄱ-ㅎㅏ-ㅣ]+.*")
				|| input.substring(0, 6).matches(".*[a-zA-Z]+.*")
				|| input.substring(0, 6).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*"))
			return false;
		if (input.substring(7, 14).matches(".*[가-힣]+.*")
				|| input.substring(7, 14).matches(".*[ㄱ-ㅎㅏ-ㅣ]+.*")
				|| input.substring(7, 14).matches(".*[a-zA-Z]+.*")
				|| input.substring(7, 14).matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*"))
			return false;
		return true;
	}

	public boolean checkNumFormat(String input) {
		// 새로 만든 함수 - 숫자 확인
		if (input.length() > 1 && input.charAt(0) == '0') return false;
		if (input.matches(".*[0-9]+.*")
				&& !input.matches(".*[ㄱ-ㅎㅏ-ㅣ]+.*")
				&& !input.matches(".*[a-zA-Z]+.*")
				&& !input.matches(".*[가-힣]+.*")
				&& !input.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]+.*"))
			return true;
		return false;
	}

	public boolean checkDateStrFormat(String input) {
		// 새로 만든 함수
		if (input.length() != 10) return false;
		if (input.charAt(0) == '0' || input.charAt(5) == '0' ||
				input.charAt(8) == '0') return false;
		if (input.charAt(4) != '-' || input.charAt(7) != '-') return false;
		if (!checkNumFormat(input.substring(0, 4))) return false;
		if (!checkNumFormat(input.substring(5, 7))) return false;
		if (!checkNumFormat(input.substring(8, 10))) return false;
		return true;
	}

	public boolean checkInputDateBeforeToday(String date, String today) throws ParseException {
		// 새로 만든 함수 - 입력 날짜가 오늘 날짜 이후인지 확인
		return checkDateDiff(date, today) <= 0;
	}

	private long checkDateDiff(String expirationDate, String currentDate) throws ParseException {
		// 새로 만든 함수 - 입력 계약 만료일이 1달 이내 남은 계약인지 확인
		Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(expirationDate);
		Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
		return (format1.getTime() - format2.getTime()) / 1000 / (24 * 60 * 60);
	}

	public boolean checkInputDateBefore(String expDate, String selectedId) {
		// 새로 만든 함수 - 기존 날짜와 입력 날짜 비교 -> 기존 날짜보다 이전 날짜라면 false
		return compareDate(expDate, m_ContractListImpl.get(selectedId).getExpirationDate());
	}

	// public boolean checkInSelectSize(String input) {
	// // 새로 만든 함수 - 선택 번호 내 입력 확인 - 보험료 납입하기
	// // 삭제(22.05.31)
	// return false;
	// }
	public int countInsuranceFeeNotPaid() {
		// 보험료 미납입 고객을 센다 - 납입 정보 관리하기
		int count = 0;
		for (Contract contract : m_ContractListImpl.getAll()) {
			if (!contract.isPayStatus()) count++;
		}
		return count;
	}

	public boolean checkInCustList(String name) {
		// 새로 만든 함수 - 입력 이름이 Customer리스트에 있는지 확인
		for (Customer customer : m_CustomerListImpl.getAll()) {
			if (customer.getCustomerName().equals(name)) return true;
		}
		return false;
	}

	public boolean checkInInsList(String name) {
		// 새로 만든 함수 - 입력 이름이 Insurance리스트에 있는지 확인
		for (Insurance insurance : m_InsuranceListImpl.getAll()) {
			if (insurance.getInsuranceName().equals(name)) return true;
		}
		return false;
	}

	public boolean checkInMenu(String selectInput) {
		// 새로 만든 함수 - 선택 메뉴내 번호 입력 확인 - 납입 정보 관리
		return selectInput.equals("0") ||
				selectInput.equals("1") ||
				selectInput.equals("2");
	}
	// public boolean checkInMenuIni(String selectInput) {
	// // 새로 만든 함수 - 선택 메뉴내 번호 입력 확인(초기화시)- 납입 정보 관리
	// // 삭제(22.06.01)
	// return false;
	// }

	public boolean deleteCustomerInformation(int index, String id) {
		// 고객 정보를 삭제한다
		boolean bDelete = false;
		if (this.customerList.get(index - 1).getId().equals(id)) {
			// 고객ID가 확인되었습니다. 메시지 출력 필요
			// String result = "고객ID가 확인되었습니다.";
			bDelete = this.m_CustomerListImpl.delete(id);
			if (bDelete) return true;
			// 삭제완료
			// result = result + "\n" + "삭제완료되었습니다.";
		}
		return false;
		// return "고객ID와 일치하지 않습니다. 다시 입력해주세요.";
	}

	// 사고 접수 시나리오 다시 구성해야 함
	public boolean checkCustContracted(String name, String phoneNum) {
		// 새로 만든 함수 - 해당 고객이 보험에 가입했는지 확인 - 사고 접수
		Customer customer;
		for (Contract contract : m_ContractListImpl.getAll()) {
			customer = m_CustomerListImpl.getById(contract.getCustomerID());
			if (customer.getCustomerName().equals(name) &&
					customer.getPhoneNum().equals(phoneNum)) return true;
		}
		return false;
	}

	public ArrayList<Contract> enquireCustomerContracted(String name) {
		// 새로 만든 함수 - 고객이 가입한 보험 가입 정보 출력, 선택 번호내 입력하게 하기 - 사고 접수
		// 반환형 변경(22.06.01) String->ArrayList
		ArrayList<Contract> contractList = new ArrayList<Contract>();
		for (Contract contract : m_ContractListImpl.getAll()) {
			if (getCustByCont(contract).getCustomerName().equals(name)) contractList.add(contract);
		}
		return contractList;
	}

	public boolean checkIdInContract(String id, String name) {
		// 새로 만든 함수 - 입력 아이디가 계약 리스트에 포함되었는지 확인
		// 파라미터 변경 (String -> String String)
		for (Contract contract : m_ContractListImpl.getAll()) {
			if (getCustByCont(contract).getCustomerName().equals(name) &&
					contract.getId().equals(id)) return true;
		}

		return false;
	}

	public void saveAccident(String selectedID, String accidentLocation, String accidentType) {
		// 새로 만든 함수
		// 사고 접수 내역 저장 - 사고 접수
		// 파라미터 변경 (AccidentReception -> String - > String 3개)
		m_AccidentListImpl.add(selectedID, accidentLocation, accidentType);
	}

	/**
	 * 
	 * @param customerName
	 * @param phoneNum
	 */
	// public AccidentReception enquireAccidentInformation(){
	// // 사고접수 정보를 조회한다 - 사고 접수
	// // 파라미터 삭제
	// // 반환형 변경(22.06.01) String->AccidentReception
	// 삭제(22.06.01)
	// return m_AccidentReceptionListImpl.getLast();
	// }

	public boolean checkInAccidentList(String name, String sSN, String accidentId) {
		// 새로 만든 함수 - 입력 사고 정보가 리스트에 있는지 확인 - 보험금 지급
		Accident selectedAccident = m_AccidentListImpl.get(accidentId);
		if (selectedAccident == null) return false;
		Customer customer = m_CustomerListImpl.getById(
				m_ContractListImpl.get(selectedAccident.getContractID()).getCustomerID());
		return customer.getCustomerName().equals(name) && customer.getSsn().equals(sSN);
	}

	public boolean checkInContractList(String choice) {
		// 새로 만든 함수 - 선택 번호가 계약 리스트에 있는지 확인
		if (!checkNumFormat(choice)) return false;
		return Integer.parseInt(choice) > 0 &&
				Integer.parseInt(choice) <= m_ContractListImpl.getSize();
	}

	public Accident enquireDetailAccidentInfo(String accidentId) {
		// 새로 만든 함수 - 사고 접수자의 이름, 나이, 사고 위치, 사고 유형, 상품명으로 바꿀 것
		// 반환형 변경(22.06.01) String->AccidentReception
		return m_AccidentListImpl.get(accidentId);
	}

	/**
	 * 
	 * @param type
	 * @param key
	 */
	public ArrayList<Customer> enquireCustomerInformation(int type, String key) {
		// 고객 정보를 조회한다
		switch (type) {
			case 1:
				this.customerList = this.m_CustomerListImpl.get(type, key);
				break;
			case 2:
			case 4:
				int keyInt = Integer.parseInt(key);
				this.customerList = this.m_CustomerListImpl.get(type, keyInt);
				break;
			case 3:
				if (key.equals("1")) this.customerList = this.m_CustomerListImpl.get(true);
				else if (key.equals("2"))
					this.customerList = this.m_CustomerListImpl.get(false);
				break;
		}
		return this.customerList;
		// String result = "";
		// int index = 1;
		// for (Customer customer : this.customerList) {
		// result = result + index + "." + customer.getName() + customer.getAge() +
		// customer.isGender() + customer.getBirthDate() + "\n";
		// index++;
		// }
		// return result;
	}

	public boolean compareBeforeDate(String date, String choice) {
		// 새로 만든 함수 - 입력 날짜가 기존 만기일 이후인지 확인 - 만기계약 관리하기
		return compareDate(date, m_ContractListImpl.get(Integer.parseInt(choice) - 1).getExpirationDate());
	}

	private boolean compareDate(String date, String currentDate) {
		// 새로 만든 함수 - 입력 날짜 비교
		int newYear = Integer.parseInt(date.substring(0, 4));
		int currentYear = Integer.parseInt(currentDate.substring(0, 4));
		if (newYear < currentYear) return false;
		else if (newYear > currentYear) return true;
		int newMonth = Integer.parseInt(date.substring(5, 7));
		int currentMonth = Integer.parseInt(currentDate.substring(5, 7));
		if (newMonth < currentMonth) return false;
		else if (newMonth > currentMonth) return true;
		int newDay = Integer.parseInt(date.substring(8, 10));
		int currentDay = Integer.parseInt(currentDate.substring(8, 10));
		if (newDay < currentDay) return false;
		else if (newDay > currentDay) return true;
		return false;
	}

	/**
	 * 
	 * @param choice
	 */
	// 일반화를 위해 새로 만듬
	public Customer getCustomer(int index) {
		return this.customerList.get(index - 1);
	}

	// public String enquireCustDetailInfoFromEnquirePassedList(int choice) {
	// // 고객 세부정보를 조회한다 - 보험 가입하기(choice : 선택 번호)(새로 만들어진 함수)
	// // 삭제(22.05.31) - 얘도 필요 없을듯해
	// return null;
	// }
	// 필요 없음
	// public Customer enquireCustomerDetailInformation(int choice) {
	// //변경 후
	// return this.customerList.get(choice-1);
	// Customer customer = this.customerList.get(choice-1);
	// String result = "";
	// result = result + "이름: " + customer.getName() + ", ";
	// result = result + "나이: " + customer.getAge() + ", ";
	// result = result + "성별: " + customer.isGender() + ", ";
	// result = result + "주민등록번호: " + customer.getSsn() + ", ";
	// result = result + "직업: " + ", ";
	// result = result + "전화번호: " + customer.getPhoneNum() + ", ";
	// result = result + "가입보험: (";
	// boolean isFirst = false;
	// for(String subscribedInsurance : customer.getSubscribedInsurance()) {
	// if(isFirst) {
	// result = result + ", ";
	// isFirst = true;
	// }
	// result = result + subscribedInsurance;
	// }
	// result = result + "), ";
	// result = result + "특이사항: " + customer.getUniqueness();
	// return result;
	// }

	// public Customer checkCustomerInformation(int index, int choice, String
	// newInformation) {
	// return this.customerList.get(index-1);

	// Customer customer = this.customerList.get(index-1);
	// String result = "";
	// result = result + "이름: " + customer.getName() + ", ";
	// result = result + "나이: " + customer.getAge() + ", ";
	// result = result + "직업: " + ", ";
	// result = result + "전화번호: " + customer.getPhoneNum();
	// result = result + " -> ";
	// switch(choice) {
	// case 1:
	// result = result + "이름: " + newInformation + ", ";
	// result = result + "나이: " + customer.getAge() + ", ";
	// result = result + "직업: " + ", ";
	// result = result + "전화번호: " + customer.getPhoneNum();
	// break;
	// case 2:
	// result = result + "이름: " + customer.getName() + ", ";
	// result = result + "나이: " + newInformation + ", ";
	// result = result + "직업: " + ", ";
	// result = result + "전화번호: " + customer.getPhoneNum();
	// break;
	// case 3:
	// result = result + "이름: " + customer.getName() + ", ";
	// result = result + "나이: " + customer.getAge() + ", ";
	// result = result + "직업: " + newInformation + ", ";
	// result = result + "전화번호: " + customer.getPhoneNum();
	// break;
	// case 4:
	// result = result + "이름: " + customer.getName() + ", ";
	// result = result + "나이: " + customer.getAge() + ", ";
	// result = result + "직업: " + ", ";
	// result = result + "전화번호: " + newInformation;
	// break;
	// }
	// return result;
	// }

	/**
	 * 
	 * @param choice
	 */
	// public String enquireEmergencyCustomerList(int choice){
	// // 긴급 고객 목록 조회하기
	// return "";
	// }

	/**
	 * 
	 * @param id
	 * @param accidentLocation
	 * @param accidentType
	 */

	// public String enquireEmployeeCallStatusInformation(String id, String
	// accidentLocation, String accidentType){
	// // 직원콜 정보를 출력한다 - 이거 필요 없음
	// AccidentReception accidentReception = m_AccidentReceptionListImpl.get(id);
	// return null;
	// }
	public ArrayList<Contract> enquireExpirationContractList() {
		// 만기 계약정보를 조회한다 - 만기 계약 관리하기
		// 반환형 변경(22.06.01) String->ArrayList
		// 이름 변경(22.06.01)
		// enquireExpirationContractInformation->enquireExpirationContractList
		// 이름 변경(22.06.06) enquireExpirationContractList->enquireContractList
		return m_ContractListImpl.getAll();
	}

	public ArrayList<Application> enquireApplicationList() {
		// 가입 신청 정보를 조회한다 - 인수심사 진행하기
		// 파라미터 변경(22.05.31) - String->ArrayList
		// 이름 변경(22.06.01)
		// enquireInformationAboutApplicationForMembership->enquireApplicationForMembershipList
		// 이름 변경(22.06.06) enquireApplicationForMembershipList->enquireApplicationList
		return m_ApplicationListImpl.getAll();
	}

	public ArrayList<Contract> enquireContractList() {
		// 보험료 납입 정보를 조회한다 - 보험금 납입하기
		// 반환형 변경(22.05.31) String->ArrayList
		// 이름 변경(22.06.01) enquireInsuranceFeePaymentStatus->enquireContractList
		return m_ContractListImpl.getAll();
	}

	// public ArrayList<Contract> enquireContractedInsList() {
	// // 새로 만든 함수 - 보험 가입자 보험 상품 가입 현황 조회 - 납입 정보 관리
	// // 반환형 변경(22.06.01) String->ArrayList
	// 삭제(22.06.01)
	// return m_ContractListImpl.getAll();
	// }
	public ArrayList<Accident> enquireAccidentList() {
		// 사고 목록 조회하기(고객 이름, 주민번호, 사건번호) - 보험급 지급
		// 반환형 변경(22.06.01) String->ArrayList
		return m_AccidentListImpl.getAll();
	}

	public ArrayList<Contract> enquireContractListBySubUser(UserInfo submitUser) {
		// 새로 만든 함수(22.06.03) - 로그인한 고객이 가입한 보험 내역 받아옴
		ArrayList<Contract> subUserContList = new ArrayList<Contract>();
		for (Contract contract : enquireContractList()) {
			Customer contractedCust = getCustByCont(contract);
			if (contractedCust.getUserId().equals(submitUser.getUserId()) &&
					contractedCust.getUserPw().equals(submitUser.getUserPw()))
				subUserContList.add(contract);
		}
		return subUserContList;
	}

	// private String enquirePaymentStatus(int i) {
	// // 새로 만든 함수
	// // 삭제(22.05.31)
	// return null;
	// }
	// public String enquirePaymentResult(int choice) {
	// // 삭제(22.06.01)
	// return null;
	// }
	public Customer getCustByCont(Contract contract) {
		// 새로 만든 함수(22.06.01)
		return m_CustomerListImpl.getById(contract.getCustomerID());
	}

	public Customer getCustBySsn(String sSN) {
		// 새로 만든 함수(22.06.01)
		return m_CustomerListImpl.getBySsn(sSN);
	}

	public Insurance getInsByCont(Contract contract) {
		// 새로 만든 함수(22.06.01)
		return m_InsuranceListImpl.get(contract.getInsuranceID());
	}

	public Contract getContByAccident(Accident accidentReception) {
		// 새로 만든 함수(22.06.01)
		return getContById(accidentReception.getContractID());
	}

	public Contract getContById(String selectedId) {
		// 반환형 변경(22.06.01) String->Contract
		// 이름 변경(22.06.01) enquireDetailExtCont->getContById
		return m_ContractListImpl.get(selectedId);
	}

	public Contract getContByCustInsId(String insuranceID, String custId) {
		// 새로 만든 함수(22.06.01)
		return m_ContractListImpl.getById(insuranceID, custId);
	}

	public UserInfo getSubmitUser(String userId, String userPw) {
		// 새로 만든 함수 - 입력 아이디, 비번에 해당하는 사용자 반환(22.06.03)
		for (UserInfo submitUser : m_UserInfoListImpl.getAll()) {
			if (submitUser.getUserId().equals(userId) &&
					submitUser.getUserPw().equals(userPw))
				return submitUser;
		}
		return null;
	}

	public Application enquireApplication(String id) {
		// 새로 만든 함수
		// 반환형 변경(2022-05-31)(String -> ArrayList)
		// 이름 변경(22.06.06) enquireApplicationForMembership -> enquireApplication
		return m_ApplicationListImpl.get(id);
	}

	public void payInsuranceMoney(String accidentId) {
		// 보험금 지급하기
		// 파라미터 추가 - String
		// 반환형 변경(22.06.01) String->void
		m_AccidentListImpl.get(accidentId).setPayed(true);
	}

	public Contract enquireNewContractInformation() {
		// 신규 계약정보를 출력한다 - 보험 가입하기(고객 세부정보 조회과정 포함)
		// 반환형 변경(22-05-31) - String->Contract
		return m_ContractListImpl.get(m_ContractListImpl.getSize() - 1);
	}

	// public String getCustNameFromContID(String id) {
	// // 새로 만든 함수 - 계약리스트 고객 아이디로부터 이름 반환
	// // 스코프 변경(22.05.31) private -> public
	// return m_CustomerListImpl.getById(id).getName();
	// }
	// public String getInsNameFromContID(String id) {
	// // 새로 만든 함수 - 계약리스트 보험 아이디로부터 이름 반환
	// // 스코프 변경(22.05.31) private -> public
	// return m_InsuranceListImpl.get(id).getInsuranceName();
	// }

	public ArrayList<Insurance> enquireInsuranceList() {
		// 보험 리스트 조회하기
		// 변경 후
		return this.m_InsuranceListImpl.getAll();
		// ArrayList<Insurance> insuranceList = this.m_InsuranceListImpl.getAll();
		// String result = "";
		// int i = 1;
		// for(Insurance insurance : insuranceList) {
		// result += i + "." + insurance.getInsuranceName() + "\n";
		// i++;
		// }
		// return result;
	}

	/**
	 * 
	 * @param choice
	 */
	public Insurance enquireInsuranceProductDetails(int choice) {
		// 보험 상품 세부 정보 조회하기
		// choice 예외 처리 필요
		// System.out.println("choice : "+choice);
		// System.out.println(this.m_InsuranceListImpl.get(String.valueOf(choice)).getInsuranceName());
		// System.out.println("id :
		// "+this.m_InsuranceListImpl.get(String.valueOf(choice)).getInsuranceID());

		// 변경 후
		return this.m_InsuranceListImpl.get(choice + "");
		/////////////////////////////////////////////////////////////////
		// Insurance insurance = this.m_InsuranceListImpl.get(String.valueOf(choice));
		// if(insurance == null) {
		// System.out.println("null");
		// }
		// ArrayList<String> result = new ArrayList<String>();
		// result.add(insurance.getSalesPerformance());
		// result.add(insurance.getAttribute());
		// result.add(insurance.getProfitAndLoss()+"");
		// return result;
	}

	public BackgroundInfo enquireBackgroundInformation() {
		// 보험 상품 개발 정보 조회하기
		// 보험상품개발정보(고객니즈분석 설문조사 결과, 최근 보험가입 빈도, 경쟁사의 동향 정보) 및 저장버튼을 반환한다
		// 보험
		// 수정 후
		return this.m_BackgroundInfoListImpl.get("0");
		///////////////////////////////////////////////////////////////////////
//		InsuranceProductDevelopmentInformation information = this.m_InsuranceProductDevelopmentInformationListImpl.get("0");
//		String result = "";
//		result += "고객니즈분석 설문조사 결과\n";
//		result += information.getCustomerNeedAnalysisSurveyResults() + "\n";
//		result += "\n최근 보험가입 빈도\n";
//		result += information.getFrequencyOfRecentInsurancePurchases() + "\n";
//		result += "\n경쟁사의 동향 정보\n";
//		result += information.getCompetitorTrendInformation() + "\n";
//		return result;
	}

	public ArrayList<Application> enquirePassedCustomerInUW() {
		// 인수심사 합격 고객을 출력한다 - 보험 가입하기
		// 반환형 변경(22-05-31) - String->ArrayList
		ArrayList<Application> passedCustomerList = new ArrayList<Application>();
		for (int i = 0; i < m_ApplicationListImpl.getSize(); i++) {
			if (m_ApplicationListImpl.get(i).isUWResult())
				passedCustomerList.add(m_ApplicationListImpl.get(i));
		}
		return passedCustomerList;
	}
	// public boolean checkInIDUW(int choice) {
	// // 삭제(22-05-31) - 민우형 얘는 지워줘
	// return false;
	// }

	public ArrayList<String> enquireProductSalesSupportDetails() {
		// 제품 판매 지원 세부정보 지원하기..?
		ArrayList<String> form = new ArrayList<String>();
		for (EProductSalesSupportDetails value : EProductSalesSupportDetails.values()) {
			form.add(value.getText());
		}
		return form;
	}

	/**
	 * 
	 * @param automaticExaminationResult
	 * @param diagnosticExaminationResult
	 * @param imageExaminationResult
	 * @param specialExaminationResult
	 * @param generalExaminationResult
	 */
	public boolean enquireUWResult(String id, boolean automaticExaminationResult, boolean diagnosticExaminationResult,
			boolean imageExaminationResult, boolean specialExaminationResult, boolean generalExaminationResult) {
		// 인수심사 결과를 확인한다 - 인수심사 진행하기
		// 인수심사 실행 여부 수정, 심사 결과 수정 포함 - 이후 문구 출력
		// 파라미터 추가(String id)
		// 반환형 변경(22.06.01) String->boolean
		m_ApplicationListImpl.get(id).setUWProceed(true);
		boolean result = automaticExaminationResult && diagnosticExaminationResult && imageExaminationResult &&
				specialExaminationResult && generalExaminationResult;
		if (result) m_ApplicationListImpl.get(id).setUWResult(true);
		return result;
	}

	public ArrayList<String> enqireInsuranceProductDesignForm() {
		// 보험 상품 설계 양식 조회하기
		ArrayList<String> form = new ArrayList<String>();
		for (EDesignForm value : EDesignForm.values()) {
			form.add(value.getText());
		}
		return form;
	}

	public ArrayList<Insurance> enquireCustInsurances(String name, String sSN) {
		// 새로 만든 함수 - 해당 고객이 가입한 보험 리스트 출력(재보험)
		// 반환형 변경(22.06.01) String->ArrayList
		ArrayList<Insurance> submitInsList = new ArrayList<Insurance>();
		String selCustId = "";
		for (Customer customer : m_CustomerListImpl.getAll()) {
			if (customer.getCustomerName().equals(name) && customer.getSsn().equals(sSN))
				selCustId = customer.getId();
		}
		for (Contract contract : m_ContractListImpl.getAll()) {
			if (contract.getCustomerID().equals(selCustId))
				submitInsList.add(getInsByCont(contract));
		}
		return submitInsList;
	}

	public boolean checkValidCustomer(String name, String sSN) {
		// 새로 만든 함수 - 해당 고객이 리스트에 있는지, 가입한 보험이 최소 하나이상 있는지 확인(재보험)
		for (Customer customer : m_CustomerListImpl.getAll()) {
			if (customer.getCustomerName().equals(name) && customer.getSsn().equals(sSN))
				return customer.getSubscribedInsurance().size() > 0;
		}
		return false;
	}

	// public String enquireReinsInfo() {
	// // 삭제(22.06.01)
	// return null;
	// }
	// public boolean checkValidReInsName(String selectInsNum) {
	// // 새로 만든 함수 - 입력 번호가 가입 보험 번호 내 있는지 확인(재보험)
	// // 삭제(22.06.01)
	// return false;
	// }
	// public String enquireSpecificReinsInfo(String name, String sSN, String
	// selectInsNum) {
	// // 새로 만든 함수 - 입력 번호 해당 재보험 정보 출력(재보험)
	// // 삭제(22.06.01)
	// return null;
	// }
	// public String reinsCommit(String name, String sSN) {
	// // DB 보상처리 테이블 이거 뭔소리임 도저히 모르것다
	// // 삭제(22.06.01)
	// return null;
	// }
	// public String enquireSpecificPayInfo(String name, String sSN, String
	// selectInsNum) {
	// // 새로 만든 함수 - 정산된 보험명 출력(재보험)
	// // 삭제(22.06.01)
	// return null;
	// }
	public ArrayList<Contract> enquireExpOneMonthList(String today) throws ParseException {
		// 새로 만든 함수 - 만료일 1달 남은 고객 조회 - 계약 유지 관리
		// 반환형 변경(22.06.01) String->ArrayList
		ArrayList<Contract> extOneMonthList = new ArrayList<Contract>();
		for (Contract contract : m_ContractListImpl.getAll()) {
			if (checkDateDiff(contract.getExpirationDate(), today) <= 30)
				extOneMonthList.add(contract);
		}
		return extOneMonthList;
	}

	// public boolean checkInIdExtList(String selectedId) {
	// // 새로 만든 함수 - 입력 아이디가 extList에 있는지 확인
	// // 삭제(22.06.01)
	// return false;
	// }
	// public boolean checkContAlreadyConsult(String selectedId) {
	// // 새로 만든 함수 - 선택 아이디가 상담 완료했는지 확인
	// // 삭제(22.06.01)
	// return false;
	// }
	/**
	 * 
	 * @param extendedExpirationDate
	 */
	// public String extendContract(String extendedExpirationDate){
	// // 계약 연장하기 - 이거 필요 없을 듯
	// return "";
	// }

	public void initializeInsuranceFeePaymentStatus() {
		// 보험료 납입여부를 초기화한다 - 납입 정보 관리하기
		// 반환형 변경(22.06.01) String->void
		for (Contract contract : m_ContractListImpl.getAll())
			contract.setPayStatus(false);
	}

	public void makeDecisionInsuranceProduct(boolean bConfirm) {
		// 보험 상품 확정...?
		this.m_InsuranceDesign.setConfirm(bConfirm);
	}

	/**
	 * 
	 * @param id
	 */
	public boolean makeInsuranceContract(Application passedCustomer, String expirationDate) {
		// 보험 계약을 한다(파라미터 변경 id->choice)
		// 파라미터 변경(2022-05-31)(choice -> passedCustomer) - 미안해 민우형 이거도 다시 바꾸자
		String[] ids = getIdsFromImpl(passedCustomer);
		if (ids[0] == null || ids[1] == null) return false;
		boolean result = m_ContractListImpl.add(new Contract(ids[0], expirationDate, ids[1]));
		if (!result) return result;
		String insuranceName = null;
		for (Insurance insurance : m_InsuranceListImpl.getAll()) {
			if (insurance.getId().equals(ids[1])) insuranceName = insurance.getInsuranceName();
		}
		for (Customer customer : m_CustomerListImpl.getAll()) {
			if (customer.getId().equals(ids[0])) customer.addInsurance(insuranceName);
		}
		m_ApplicationListImpl.delete(passedCustomer.getId());
		return result;
	}

	private String[] getIdsFromImpl(Application passedCustomer) {
		// 새로 만든 함수
		// 파라미터 변경(2022-05-31)(choice -> passedCustomer) - 미안해 민우형 이거도 다시 바꾸자
		String ids[] = new String[] { null, null };
		for (Customer customer : m_CustomerListImpl.getAll()) {
			if (passedCustomer.getCustomerName().equals(customer.getCustomerName()) &&
					passedCustomer.getSSN().equals(customer.getSsn()))
				ids[0] = customer.getId();
		}
		for (Insurance insurance : m_InsuranceListImpl.getAll()) {
			if (passedCustomer.getInsuranceName().equals(insurance.getInsuranceName()))
				ids[1] = insurance.getId();
		}
		return ids;
	}

	public boolean modifyCustomerInformation(int index, int type, String newInformation) {
		// 고객 정보 수정하기
		switch (type) {
			case 1:
				this.customerList.get(index - 1).setCustomerName(newInformation);
				break;
			case 2:
				this.customerList.get(index - 1).setAge(Integer.parseInt(newInformation));
				break;
			case 3:
				// this.customerList.get(index).setJob
				break;
			case 4:
				this.customerList.get(index - 1).setPhoneNum(newInformation);
				break;
		}
		// this.customerList.get(index).set
		return true;
	}

	// public boolean checkMoneyPayed(String accidentId) {
	// // 새로 만든 함수 - 보험금 지급 완료되었는지 확인
	// 삭제(22.06.01)
	// return m_AccidentReceptionListImpl.get(accidentId).isPayedMoney();
	// }
	/**
	 * 
	 * @param newExpirationDate
	 * @param id
	 */
	public void renewExpirationDate(String newExpirationDate, String choice) {
		// 만기일을 갱신한다 - 만기계약 관리하기, 계약 유지 활동을 진행하기
		// 파라미터 변경 (id -> choice)
		// 반환형 변경(22.06.01) String->void
		m_ContractListImpl.get(Integer.parseInt(choice) - 1).setExpirationDate(newExpirationDate);
	}

	public void renewExpirationDateById(String newExpirationDate, String id) {
		// 새로 만든 함수
		// 만기일 갱신 - 계약 유지
		// 반환형 변경(22.06.01) String->void
		renewExpirationDate(newExpirationDate, m_ContractListImpl.indexOf(id) + 1 + "");
	}

	public void changeRenewConsult(String id) {
		// 새로 만든 함수
		m_ContractListImpl.get(id).setRenewConsult(true);
	}

	public void requestAuthorizationOfCompany(boolean bCompany) {
		// 회사 승인 요청 받기
		this.m_InsuranceDesign.setCompany(bCompany);
	}

	public void requestAuthorizationOfFSS(boolean bFSS) {
		// FSS(금융감독원)에 관한 부여를 요청하기...?
		this.m_InsuranceDesign.setFSS(bFSS);
	}

	/**
	 * 
	 * @param selectedContract
	 * @param amountOfInsuranceFee
	 */
	public void saveAmountOfInsuranceFee(Contract selectedContract, int amountOfInsuranceFee) {
		// 입력 보험금액 저장하기 - 보험료 납입하기
		// 납입 정보 표시까지 포함
		// 파라미터 변경 (String id -> int choice)
		// 반환형 변경(22.06.01) String->void
		// 파라미터 변경(22.06.03) (int -> Contract int)
		m_ContractListImpl.addPayment(selectedContract, amountOfInsuranceFee);
	}

	/**
	 * 
	 * @param targetCustomer
	 * @param compensationDevelopmentPlan
	 * @param InsuranceProductName
	 * @param evaluation
	 */
	public void saveCompensationManagementInformation(String targetCustomer,
			String compensationDevelopmentPlan, String InsuranceProductName, String evaluation) {
		// 보상운용정보를 저장한다
	}

	public boolean saveInsuranceDesignContent(ArrayList<String> designContents) {
		// 보험 설계 내용 저장하기
		// this.m_InsuranceDesignListImpl.
		for (String content : designContents) {
			if (content == null) {
				return false;
			}
		}
		this.m_InsuranceDesign.setTarget(Integer.parseInt(designContents.get(0)));
		this.m_InsuranceDesign.setPremiumRate(Integer.parseInt(designContents.get(1)));
		this.m_InsuranceDesign.setTrialWorkHistory(designContents.get(2));
		this.m_InsuranceDesign.setExpectedProfitAndLossAnalysisPrice(designContents.get(3));
		this.m_InsuranceDesign.setBasicDocuments(designContents.get(4));
		return true;
	}

	/**
	 * 
	 * @param plannedContents
	 */
	public boolean savePlannedContents(ArrayList<String> planningContents) {
		// 계획 내용 저장하기
		for (String content : planningContents) {
			if (content == null) {
				return false;
			}
		}
		this.m_InsuranceDesign.setId(String.valueOf(this.m_InsuranceDesignListImpl.getAll().size()));
		this.m_InsuranceDesign.setInsuranceName(planningContents.get(0));
		this.m_InsuranceDesign.setInsuranceContent(planningContents.get(1));
		this.m_InsuranceDesign.setPlanningPurpose(planningContents.get(2));

		// 나머지 null처리
		this.m_InsuranceDesign.setTarget(-1);
		this.m_InsuranceDesign.setPremiumRate(-1);
		this.m_InsuranceDesign.setTrialWorkHistory(null);
		this.m_InsuranceDesign.setExpectedProfitAndLossAnalysisPrice(null);
		this.m_InsuranceDesign.setBasicDocuments(null);
		this.m_InsuranceDesign.setCompany(false);
		this.m_InsuranceDesign.setConfirm(false);
		this.m_InsuranceDesign.setFSS(false);
		this.m_InsuranceDesign.setSubscriptionDesign(null);
		this.m_InsuranceDesign.setSubscription(null);
		this.m_InsuranceDesign.setContractManagementRelatedSystem(null);
		this.m_InsuranceDesign.setSalesDepartmentData(null);
		this.m_InsuranceDesign.setProductEducationContent(null);
		this.m_InsuranceDesign.setGuideline(null);

		this.m_InsuranceDesignListImpl.add(m_InsuranceDesign);

		return true;
	}

	public boolean saveProductSalesSupportDetails(ArrayList<String> productSalesSupportDetailsContents) {
		// 제품 판매 지원 세부 정보 저장하기
		for (String content : productSalesSupportDetailsContents) {
			if (content == null) {
				return false;
			}
		}
		this.m_InsuranceDesign.setSubscriptionDesign(productSalesSupportDetailsContents.get(0));
		this.m_InsuranceDesign.setSubscription(productSalesSupportDetailsContents.get(1));
		this.m_InsuranceDesign.setContractManagementRelatedSystem(productSalesSupportDetailsContents.get(2));
		this.m_InsuranceDesign.setSalesDepartmentData(productSalesSupportDetailsContents.get(3));
		this.m_InsuranceDesign.setProductEducationContent(productSalesSupportDetailsContents.get(4));
		this.m_InsuranceDesign.setGuideline(productSalesSupportDetailsContents.get(5));
		return true;
	}

	public ArrayList<String> enquireInsuranceProductPlanningForm() {
		// 새로 만든 메소드
		// 보험 상품 기획양식 조회
		ArrayList<String> form = new ArrayList<String>();
		for (EPlanningForm value : EPlanningForm.values()) {
			form.add(value.getText());
		}
		return form;
	}

	public boolean addInsurance(int type) { // 0이 새로운 설계, 1이 이어서 설계
		// 새로 만든 메소드
		if (type == 0) {
			this.m_InsuranceDesignListImpl.add(this.m_InsuranceDesign);
		}
		Insurance insurance = new Insurance();
		// compensation
		insurance.setContent(this.m_InsuranceDesign.getInsuranceContent());
		insurance.setId(this.m_InsuranceListImpl.getSize() + "");
		insurance.setInsuranceName(this.m_InsuranceDesign.getInsuranceName());
		insurance.setPremiumRate(this.m_InsuranceDesign.getPremiumRate());
		insurance.setMonthlyPayAmount(0);
		insurance.setTarget(this.m_InsuranceDesign.getTarget());
		insurance.setTerm(0);
		insurance.setReInsuranceFee(0);
		insurance.setRenew(false);
		insurance.setSalesPerformance("aaaaa");
		insurance.setAttribute("bbbbbbbbb");
		insurance.setProfitAndLoss(0);

		return this.m_InsuranceListImpl.add(insurance);
	}

	public int checkInsuranceUnderDesign(String insuranceDesignName) {
		// 새로 만든 메소드
		this.m_InsuranceDesign = this.m_InsuranceDesignListImpl.get(insuranceDesignName, 2);
		if (m_InsuranceDesign == null) {
			return 0;
		}
		if (m_InsuranceDesign.getSubscriptionDesign() == null) {
			return 1;
		}

		// if(insuranceDesign.getTarget() == null) {
		// return 1;
		// }
		// if(insuranceDesign.isCompany() == false || insuranceDesign.isConfirm() ==
		// false || insuranceDesign.isFSS() == false) {
		// return 2;
		// }
		// if(insuranceDesign.getSubscriptionDesign() == null) {
		// return 3;
		// }
		return 2;
	}

	public boolean checkPlanningContents() {
		if (m_InsuranceDesign.getInsuranceName() != null || m_InsuranceDesign.getInsuranceContent() != null
				|| m_InsuranceDesign.getPlanningPurpose() != null)
			return true;
		return false;
	}

	public void designNewInsuranceProduct() {
		// TODO Auto-generated method stub
		this.m_InsuranceDesign = new InsuranceDesign();
	}

	public boolean checkDesignContents() {
		if (m_InsuranceDesign.getTarget() != -1
				|| m_InsuranceDesign.getPremiumRate() != -1
				|| m_InsuranceDesign.getTrialWorkHistory() != null
				|| m_InsuranceDesign.getExpectedProfitAndLossAnalysisPrice() != null
				|| m_InsuranceDesign.getBasicDocuments() != null)
			return true;
		return false;
	}

	public int checkAuthorization() {
		if (m_InsuranceDesign.isCompany() == false) {
			// System.out.println("1."+m_InsuranceDesign.isCompany());
			return 0;
		}
		if (m_InsuranceDesign.isConfirm() == false) {
			// System.out.println("2."+m_InsuranceDesign.isConfirm());
			return 1;
		}
		if (m_InsuranceDesign.isFSS() == false) {
			// System.out.println("3."+m_InsuranceDesign.isFSS());
			return 2;
		}
		// System.out.println("All pass");
		return 3;
	}

	public void setData() {
		BackgroundInfo information = new BackgroundInfo();
		information.setInformationID("0");
		information.setSurveyResults("iiii");
		information.setApplyFrequency("jjjj");
		information.setTrend("kkkk");
		this.m_BackgroundInfoListImpl.add(information);

		InsuranceDesign insuranceDesign = new InsuranceDesign();
		insuranceDesign.setId(String.valueOf(this.m_InsuranceDesignListImpl.getAll().size()));
		insuranceDesign.setInsuranceName("aaaa");
		insuranceDesign.setInsuranceContent("bbbb");
		insuranceDesign.setPlanningPurpose("cccc");

		// 나머지 null처리
		insuranceDesign.setTarget(-1);
		insuranceDesign.setPremiumRate(-1);
		insuranceDesign.setTrialWorkHistory("ffff");
		insuranceDesign.setExpectedProfitAndLossAnalysisPrice("gggg");
		insuranceDesign.setBasicDocuments("hhhh");
		insuranceDesign.setCompany(true);
		insuranceDesign.setConfirm(true);
		insuranceDesign.setFSS(false);
		insuranceDesign.setSubscriptionDesign(null);
		insuranceDesign.setSubscription(null);
		insuranceDesign.setContractManagementRelatedSystem(null);
		insuranceDesign.setSalesDepartmentData(null);
		insuranceDesign.setProductEducationContent(null);
		insuranceDesign.setGuideline(null);
		this.m_InsuranceDesignListImpl.add(insuranceDesign);
	}

	public boolean stopInsurance(int insuranceID) {
		// TODO Auto-generated method stub
		return this.m_InsuranceListImpl.delete(insuranceID + "");
	}
	// public boolean checkProductSalesSupportDetailsContents() {
	// if(m_InsuranceDesign.getSubscriptionDesign() != null
	// || m_InsuranceDesign.getSubscription() != null
	// || m_InsuranceDesign.getContractManagementRelatedSystem() != null
	// || m_InsuranceDesign.getSalesDepartmentData() != null
	// || m_InsuranceDesign.getProductEducationContent() != null
	// || m_InsuranceDesign.getGuideline() != null)
	// return true;
	// return false;
	// }
}