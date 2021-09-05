package com.example.helper.common;

public class Constants {
//	public static final String LCHSDT_FILENET_OBJECTSTORE_NAME = "FS_QLSHPM";
//	public static final String LCHSDT_FILENET_STORAGEID = "";
//	public static final String LCHSDT_FILENET_SERVICE_URL = "http://10.53.252.190:9080/wsi/FNCEWS40MTOM/";
//	public static final String LCHSDT_FILENET_USER = "ecmadmin";
//	public static final String LCHSDT_FILENET_PASSWORD = "abc@123";
//	public static final String LCHSDT_FILENET_STANZA = "FileNetP8WSI";
//	public static final String LCHSDT_FILENET_STORAGEAREA ="{50347775-0000-C11A-A69B-1BFAA6EBB526}";
//	public static final String LCHSDT_FILENET_STORAGEPOLICIES = "{50347775-0000-CA48-B933-3F02FBB6B241}" ; 
//	
//	public static final String LCHSDT_ROOT_FOLDER_ID = "{91FFA631-8DC8-4FAB-8C8F-9D41AE021F3E}";
//	public static final String LCHSDT_ROOT_FOLDER_FN_NAME = "KHDN";

	//new
	public static final String LCHSDT_FILENET_OBJECTSTORE_NAME = "FS_ECMTempOS";
	public static final String LCHSDT_FILENET_PATHNAME_ECMTemp = "/NON_DIGITIZED_DOCUMENTS/TTKHDN";
	public static final String LCHSDT_FILENET_SERVICE_URL = "http://10.53.252.190:9080/wsi/FNCEWS40MTOM/";
	public static final String LCHSDT_FILENET_USER = "ecmadmin";
	public static final String LCHSDT_FILENET_PASSWORD = "abc@123";
	public static final String LCHSDT_FILENET_STANZA = "FileNetP8";
	public static final String LCHSDT_FILENET_SERVICE_URL_APPROVE="http://10.53.252.190:9080/api/approved";
	
	///
	
	
	public static final String LCHSDT_FOLDER_HOSO_KINH_DOANH_VON_KHTCS = "Hồ sơ kinh doanh vốn";
	public static final String LCHSDT_FOLDER_HOSO_KINH_DOANH_VON_CNKH = "Hồ sơ Kinh doanh vốn Chi nhánh - Khách hàng";
	
	public static final String LCHSDT_FOLDER_CHUNG_TU = "Chứng từ";
	
	public static final String RETURN_SUCESS = "Thành công";
	
	public static final Long REFUSE = 0L;
	public static final Long APPROVE = 1L;
	
	public static final Long USER_PENDING_APPROVE = 2L;
	public static final Long FINAL_USER_APPROVED = 6L;
	public static final Long REFUSE_STATUS = 3L;
	public static final Long FINAL_APPROVED = 4L;
	
	public static final String FONT_SIGN = "D:/test/bidv/resources/Muli-Bold.ttf";
	public static final String TICK_SIGN = "D:/test/bidv/resources/ticksign.png";
	
	public static final String PATH_SOURCE = "D:/test/file";
	
	public enum ChucNang {
		TT_QD_PCUQ(0, "Thông tin quy định PCUQ"),
		PCUQ(1, "Khai báo PCUQ tại ban KDV&TT"),
		KSV_LD_PHE_DUYET_GD(2, "KSV/Lãnh đạo phê duyệt GD"), 
		HD_KHUNG_HD_DAM_BAO(3, "Thông tin hợp đồng khung và hợp đông đảm bảo"),
		HAN_MUC_BO(4, "Hạn mức BO"), 
		NHOM_EMAIL(5, "Nhóm email"),
		QUY_CHUAN_CT(6, "Quy chuẩn chứng từ"),
		DM_TSDB_BIDV(7, "Danh mục TSĐB tại BIDV"), 
		DM_TSDB_BIDV_CC_TC(8, "Danh mục TSĐB BIDV cầm cố, thế cập tại đối tác"),
		CHUNG_TU_GD(9, "Chứng từ giao dịch"), 
		THONG_TIN_GD(10, "Thông tin giao dịch"), 
		THEO_DOI_CHUYEN_TRA(11, "Theo dõi chuyển trả"),
		THE0_DOI_GD_TSDB(12, "Theo dõi giao dịch TSĐB"),
		THEO_DOI_GD_VUOT_HM(13, "Theo dõi giao dịch vượt hạn mức"),
		KB_DOI_TAC_CAN_THEO_DOI(14, "Khai báo đối tác cần theo dõi"),
		THEO_DOI_HOP_DONG_GOC(15, "Theo dõi hợp đồng gốc"),
		BAO_CAO_TG_XU_LY_GD(16, "Báo cáo thời gian xử lý GD"),
		VAN_TIN(17,"Vấn tin"),
		BAO_CAO_HANG_NGAY(18,"Báo cáo hàng ngày"),
		DS_GD_CHUA_DU_CT(19,"Danh sách giao dịch chưa đủ CT"),
		KHAI_BAO_DOI_TAC_CTD(20, "Khai Báo Đối Tác Cần Theo Dõi"),
		CAP_NHAT_DU_LIEU_TINH(21, "Cập nhật thông tin dữ liệu tĩnh");
		
		private int funcode;
		private String funcname;
		
		private ChucNang(int funcode, String funcname) {
			this.funcode = funcode;
			this.funcname = funcname;
		}
		public int getFuncode() {
			return funcode;
		}
		public void setFuncode(int funcode) {
			this.funcode = funcode;
		}
		public String getFuncname() {
			return funcname;
		}
		public void setFuncname(String funcname) {
			this.funcname = funcname;
		}
	}
}
