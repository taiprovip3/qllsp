/**
 * PHAN TẤN TÀI - 19524791
 * Chứa thuộc tính của 1 phòng ban trong doanh nghiệp
 */
package entity;

public class PhongBan {
	private String maPhongBan;
	private String nghiepVu;
	private String nguoiDaiDien;
	private String viTri;
	private int soLuongNhanVien;
	public String getMaPhongBan() {
		return maPhongBan;
	}
	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}
	public String getNghiepVu() {
		return nghiepVu;
	}
	public void setNghiepVu(String nghiepVu) {
		this.nghiepVu = nghiepVu;
	}
	public String getNguoiDaiDien() {
		return nguoiDaiDien;
	}
	public void setNguoiDaiDien(String nguoiDaiDien) {
		this.nguoiDaiDien = nguoiDaiDien;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public int getSoLuongNhanVien() {
		return soLuongNhanVien;
	}
	public void setSoLuongNhanVien(int soLuongNhanVien) {
		this.soLuongNhanVien = soLuongNhanVien;
	}
	public PhongBan() {
		super();
	}
	public PhongBan(String maPhongBan, String nghiepVu, String nguoiDaiDien, String viTri, int soLuongNhanVien) {
		super();
		this.maPhongBan = maPhongBan;
		this.nghiepVu = nghiepVu;
		this.nguoiDaiDien = nguoiDaiDien;
		this.viTri = viTri;
		this.soLuongNhanVien = soLuongNhanVien;
	}
	@Override
	public String toString() {
		return "PhongBan [maPhongBan=" + maPhongBan + ", nghiepVu=" + nghiepVu + ", nguoiDaiDien=" + nguoiDaiDien
				+ ", viTri=" + viTri + ", soLuongNhanVien=" + soLuongNhanVien + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhongBan == null) ? 0 : maPhongBan.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongBan other = (PhongBan) obj;
		if (maPhongBan == null) {
			if (other.maPhongBan != null)
				return false;
		} else if (!maPhongBan.equals(other.maPhongBan))
			return false;
		return true;
	}
}
